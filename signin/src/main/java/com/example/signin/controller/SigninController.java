package com.example.signin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SigninController {
    public static final Logger logger = LoggerFactory.getLogger(SigninController.class);

    @RequestMapping("/api")
    public String message() {
        logger.info("INFO Enabled");
        logger.error("Error Enabled");
        logger.debug("Debug Enabled");
        return "Test Logging";
    }

}