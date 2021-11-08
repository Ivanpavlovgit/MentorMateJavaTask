package com.example.mmatetask;


import com.example.mmatetask.model.ReportDefinition;
import com.example.mmatetask.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final BufferedReader reader;
    private final EmployeeService employeeService;

    public CommandLineRunnerImpl (EmployeeService employeeService) {
        this.employeeService = employeeService;
        this.reader = new BufferedReader (new InputStreamReader (System.in));
    }


    @Override
    public void run (String... args) throws Exception {
        System.out.println ("Hello !");
        System.out.println ("Please enter the path to Employee data JSON file");
        var jsonFilePath = reader.readLine ().trim ();
        seedEmployees (jsonFilePath);
        System.out.println ("Please enter the path to report definition JSON file");
        var reportDefinitionFilePath = reader.readLine ().trim ();

        writeReportAsCSV (readReportDefinition (reportDefinitionFilePath));


    }

    private void writeReportAsCSV (ReportDefinition reportDefinition) throws IOException {
        this.employeeService.generateReportAsCSV (reportDefinition);
    }

    private ReportDefinition readReportDefinition (String reportDefinitionFilePath) throws IOException {
        return this.employeeService.readReportDefinition (reportDefinitionFilePath);
    }

    private void seedEmployees (String filePath) throws IOException {
        this.employeeService.seedEmployees (filePath);
    }
}
