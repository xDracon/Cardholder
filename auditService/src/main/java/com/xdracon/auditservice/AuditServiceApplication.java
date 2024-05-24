package com.xdracon.auditservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class AuditServiceApplication {

    public static File fileAudit;
    public static File fileLog;



    public static void logGateway(){
        try {
            File file = new File("logGateway.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
                try(FileWriter writer = new FileWriter("log.txt", true))
                {
                    writer.write(line+"\n");
                    writer.flush();
                }
                catch(IOException ex){
                    System.out.println(ex.getMessage());
                }
            }
            Path path = Paths.get("logGateway.txt");
            Files.writeString(path,"");
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logAuthenticationService(){
        try {
            File file1 = new File("logAuthenticationService.txt");
            FileReader fr1 = new FileReader(file1);
            BufferedReader br1 = new BufferedReader(fr1);
            String line;
            while((line = br1.readLine()) != null){
                try(FileWriter writer = new FileWriter("log.txt", true))
                {
                    writer.write(line+"\n");
                    writer.flush();
                }
                catch(IOException ex){
                    System.out.println(ex.getMessage());
                }
            }
            Path path1 = Paths.get("logAuthenticationService.txt");
            Files.writeString(path1,"");
            br1.close();
            fr1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logCardService(){
        try {
            File file2 = new File("logCardService.txt");
            FileReader fr2 = new FileReader(file2);
            BufferedReader br2 = new BufferedReader(fr2);
            String line;
            while((line = br2.readLine()) != null){
                try(FileWriter writer = new FileWriter("log.txt", true))
                {
                    writer.write(line+"\n");
                    writer.flush();
                }
                catch(IOException ex){
                    System.out.println(ex.getMessage());
                }
            }
            Path path1 = Paths.get("logCardService.txt");
            Files.writeString(path1,"");
            br2.close();
            fr2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            fileAudit = new File("audit.txt");
            fileLog = new File("log.txt");
            if (fileAudit.createNewFile()) {
                System.out.println("Файл создан");
            } else {
                System.out.println("Файл уже существует");
            }
            if (fileLog.createNewFile()) {
                System.out.println("Файл создан");
            } else {
                System.out.println("Файл уже существует");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла");
            e.printStackTrace();
        }
        SpringApplication.run(AuditServiceApplication.class, args);
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(() -> logGateway(), 0, 10, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(() -> logAuthenticationService(), 0, 10, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(() -> logCardService(), 0, 10, TimeUnit.SECONDS);
    }
}
