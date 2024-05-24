package com.xdracon.auditservice.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.FileWriter;
import java.io.IOException;

import static com.xdracon.auditservice.AuditServiceApplication.fileLog;

public class LogController {
    @PostMapping("/log")
    public void AddAuditLog(@RequestBody String str) throws IOException {
        FileWriter FileWriter = new FileWriter(fileLog, true);
        FileWriter.write(str + "\n");
        FileWriter.close();
    }
}
