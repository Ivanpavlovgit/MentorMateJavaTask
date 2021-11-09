package com.example.mmatetask.service;

import com.example.mmatetask.model.ReportDefinition;
import com.example.mmatetask.model.dto.EmployeeSeedDto;
import com.example.mmatetask.model.entity.Employee;
import com.example.mmatetask.repository.EmployeeRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVWriter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private static final String REPORT_AS_CSV_FILE_PATH = "src/main/resources/files/report.csv";
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final CSVWriter csvWriter;

    public EmployeeService (EmployeeRepository employeeRepository) throws IOException {
        this.employeeRepository = employeeRepository;
        this.gson = new GsonBuilder ()
                .excludeFieldsWithoutExposeAnnotation ()
                .setPrettyPrinting ()
                .create ();
        this.modelMapper = new ModelMapper ();
        this.csvWriter = new CSVWriter (new FileWriter (REPORT_AS_CSV_FILE_PATH));
    }

    public void seedEmployees (String filePath) throws IOException {

        var employeeSeedDtoList = Arrays.stream (this.gson
                .fromJson (Files
                        .readString (Path.of (filePath)),EmployeeSeedDto[].class)).collect (Collectors.toUnmodifiableList ());

        var employeeList = employeeSeedDtoList.stream ().map (employeeSeedDto -> this.modelMapper.map (employeeSeedDto,Employee.class)).collect (Collectors.toUnmodifiableList ());
        this.employeeRepository.saveAll (employeeList);

        System.out.printf ("%d employee records saved.%n",employeeList.size ());
    }

    public ReportDefinition readReportDefinition (String reportDefinitionFilePath) throws IOException {
        var reportDefinition = this.gson
                .fromJson (Files
                        .readString (Path.of (reportDefinitionFilePath)),ReportDefinition.class);


        System.out.printf ("Imported Report Definition : %n - Top performers Threshold : %d%n - Use experience multiplier : %s%n - Period limit: %d%n"
                ,reportDefinition.getTopPerformersThreshold ()
                ,reportDefinition.getUseExprienceMultiplier ()
                ,reportDefinition.getPeriodLimit ());

        return reportDefinition;
    }

    public void generateReportAsCSV (ReportDefinition reportDefinition) throws IOException {
        var periodLimit                      = reportDefinition.getPeriodLimit ();
        var numberOfEmployeeRecordsForReport = (reportDefinition.getTopPerformersThreshold () * this.employeeRepository.count () / 100);
        var employeeListForReport                     = this.employeeRepository.findAllEligibleForReport (periodLimit);

        var reportContent = employeeListForReport.stream ()
                .map (employee -> {
                    var score = reportDefinition.getUseExprienceMultiplier ()
                            ?
                            employee.getTotalSales () / employee.getSalesPeriod () * employee.getExperienceMultiplier ()
                            :
                            employee.getTotalSales () / employee.getSalesPeriod ();

                    return new String[]{employee.getName (),String.format ("%.1f",score)};
                }).limit (numberOfEmployeeRecordsForReport)
                .collect (Collectors.toUnmodifiableList ());


        String[] header1 = {"Result"};
        csvWriter.writeNext (header1,false);

        String[] header2 = {"Name","Score"};
        csvWriter.writeNext (header2,false);

        csvWriter.writeAll (reportContent,false);

        csvWriter.close ();

        System.out.printf ("Successfully generated report containing %d records.%n",reportContent.size ());
        System.out.println ("You can find the report in \"src/main/resources/files/\" named \"report.csv\".");
    }
}
