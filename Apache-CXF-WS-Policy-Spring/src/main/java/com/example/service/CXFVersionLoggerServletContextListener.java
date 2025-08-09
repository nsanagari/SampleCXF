package com.example.service;

import org.apache.cxf.version.Version;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class CXFVersionLoggerServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Apache CXF Version: ######################" + Version.getCurrentVersion());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Optional cleanup
    }
}
