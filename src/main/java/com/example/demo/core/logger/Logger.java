package com.example.demo.core.logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Logger {
    public static void save(Object line) {
        org.slf4j.Logger logger = LoggerFactory.getLogger(line.getClass());
        logger.info(line.toString());
    }
}
