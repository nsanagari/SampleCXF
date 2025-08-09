package com.example.service;

import org.apache.cxf.version.Version;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class CXFVersionLogger {

    @PostConstruct
    public void logCXFVersion() {
    	System.out.println("Apache CXF Version: ######################" + Version.getCurrentVersion());
    }
}
