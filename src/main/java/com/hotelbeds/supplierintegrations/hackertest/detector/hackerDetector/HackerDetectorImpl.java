package com.hotelbeds.supplierintegrations.hackertest.detector.hackerDetector;

import com.hotelbeds.supplierintegrations.hackertest.detector.configuration.HackerDetectorProperties;
import com.hotelbeds.supplierintegrations.hackertest.detector.dto.LogLine;
import com.hotelbeds.supplierintegrations.hackertest.detector.enums.Action;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class HackerDetectorImpl implements HackerDetector {

    private final Map<String, List<LogLine>> logLineHashMap = new HashMap<>();

    private final HackerDetectorProperties hackerDetectorProperties;

    public HackerDetectorImpl(HackerDetectorProperties hackerDetectorProperties) {
        this.hackerDetectorProperties = hackerDetectorProperties;
    }

    @Override
    public String parseLine(String line) {
        LogLine logLine = new LogLine(line);
        List<LogLine> lines = logLineHashMap.computeIfAbsent(logLine.getIp(), k -> new ArrayList<>());
        Optional<LogLine> olderLineOpt = lines.stream().min(Comparator.comparing(LogLine::getDate));

        if (olderLineOpt.isPresent()) {
            LogLine olderLine = olderLineOpt.get();
            Instant timeLimit = olderLine.getDate().plus(hackerDetectorProperties.period, ChronoUnit.SECONDS);

            if (logLine.getAction().equals(Action.SIGNIN_FAILURE)
                    && !logLine.getDate().isBefore(timeLimit)) {
                lines.clear();
            }
        }

        if (logLine.getAction().equals(Action.SIGNIN_FAILURE)) {
            lines.add(logLine);
        }
        return lines.size() >= hackerDetectorProperties.fails ? logLine.getIp() : null;
    }
}
