package com.hotelbeds.supplierintegrations.hackertest.detector.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "hacker.detector")
@Data
public class HackerDetectorProperties {

    public Integer period;
    public Integer fails;
}
