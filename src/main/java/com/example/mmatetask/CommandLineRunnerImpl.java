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
        System.out.println ("hello");
        //make file path appear here as arguments
        seedEmployees();
        readReportDefinition();
        writeReportAsCSV();
        System.out.println ("Please enter the path to Employee data JSON file");
        var jsonFilePath = reader.readLine ();

        System.out.println ("Please enter the path to report definition JSON file");
        var reportDefinitionFilePath = reader.readLine ();
    }

    private void writeReportAsCSV () throws IOException {
    this.employeeService.generateReportAsCSV (readReportDefinition ());
    }

    private ReportDefinition readReportDefinition () throws IOException {
     return   this.employeeService.readReportDefinition ();
    }

    private void seedEmployees () throws IOException {
        this.employeeService.seedEmployees();
    }
}
