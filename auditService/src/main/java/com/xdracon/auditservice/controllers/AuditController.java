package com.xdracon.auditservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.xdracon.auditservice.AuditServiceApplication.fileAudit;

@Controller
public class AuditController {

    @PostMapping ("/audit")
    public void AddAuditLog(@RequestBody String str) throws IOException {
        java.util.Date date = new java.util.Date();
        FileWriter FileWriter = new FileWriter(fileAudit, true);
        FileWriter.write(date + "\t" + str + "\n");
        FileWriter.close();
    }
}