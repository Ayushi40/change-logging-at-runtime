package com.ayushi.controller;

import com.ayushi.service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoggingController {

    @Autowired
    LoggingService loggingService;

    @PostMapping("/patient/add/{patientId}")
    public String addPatient(@PathVariable String patientId)
    {
        return loggingService.addPatient(patientId);
    }
    @GetMapping("/patient/fetch")
    public String fetchPatient()
    {
        return loggingService.fetchPatient();
    }
    @GetMapping("/patient/get")
    public String getPatient()
    {
        return loggingService.getPatient();
    }
}
