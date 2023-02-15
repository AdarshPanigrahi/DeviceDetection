package com.example.DeviceDetection;

import nl.basjes.parse.useragent.UserAgent;
import nl.basjes.parse.useragent.UserAgentAnalyzer;
import org.springframework.stereotype.Component;

@Component
public class UAnalyzer {

    private final UserAgentAnalyzer userAgentAnalyzer;


    public UAnalyzer() {
        userAgentAnalyzer = UserAgentAnalyzer
                .newBuilder()
                .hideMatcherLoadStats()
                .withCache(10000)
                .build();
    }

    public UserAgent analyze(String userAgentString) {
        return userAgentAnalyzer.parse(userAgentString);
    }

}
