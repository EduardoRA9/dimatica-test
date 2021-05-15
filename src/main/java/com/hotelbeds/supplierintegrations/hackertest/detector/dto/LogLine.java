package com.hotelbeds.supplierintegrations.hackertest.detector.dto;

import com.hotelbeds.supplierintegrations.hackertest.detector.enums.Action;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.Instant;

@Data
public class LogLine {

    public LogLine(String line) {
        String[] elements = line.split(",");
        this.ip = elements[0];
        this.date = Instant.ofEpochMilli(Long.parseLong(elements[1]));
        this.action = elements[2].equals("SIGNIN_SUCCESS") ? Action.SIGNIN_SUCCESS : Action.SIGNIN_FAILURE;
        this.username = elements[3];
    }

    @Setter(AccessLevel.NONE)
    private String ip;

    @Setter(AccessLevel.NONE)
    private Instant date;

    @Setter(AccessLevel.NONE)
    private Action action;

    @Setter(AccessLevel.NONE)
    private String username;
}
