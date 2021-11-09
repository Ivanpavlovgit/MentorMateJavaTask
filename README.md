# MentorMateJavaTask

Assignment 2: Practical Task
Create a Java console application that generates monthly performance reports. The application
should :
● Receive a command-line argument that is path to JSON data file (format provided
below):
Data:
[
{
"name": "John Smith",
"totalSales": 250,
"salesPeriod": 10,
"experienceMultiplier": 0.5
},
{
"name": "David Prowless",
"totalSales": 250,
"salesPeriod": 10,
"experienceMultiplier": 0.5
}
]
● Receive a command-line argument that is path to JSON report definition file (format
provided below):
Report definition:
{
"topPerformersThreshold": 10,
"useExprienceMultiplier": false,
"periodLimit": 10
}
● Generate CSV (comma separated value) file containing the report results (example
below);
Result
Name , Score
John Smith, 12.5
David Prowess, 12.5
MentorMate, Inc. © 2021 All Rights Reserved & Confidential
The generated report should contain the following columns:
● Name - Name of the employee;
● Score - result of the evaluation;
Resulting report file should contain only employees that:
● have sales period that is equal or less than the periodLimit property;
● have score that is within the top X percent of the results, where X is defined by the
topPerformersThreshold property of the report definition.
The score is calculated based on the following rules:
If useExprienceMultiplier is set to true:
Score = totalSales/salesPeriod*experienceMultiplier
If useExprienceMultiplier is set to false:
Score = totalSales/salesPeriod
Please upload the code for this project to GitHub and insert the link to your repository in
the relevant field in the application form.
