package com.example.mmatetask.model.dto;


import com.google.gson.annotations.Expose;

public class EmployeeSeedDto {
    @Expose
    private String name;
    @Expose
    private Integer totalSales;
    @Expose
    private Double salesPeriod;
    @Expose
    private Double experienceMultiplier;

    public String getName () {
        return name;
    }

    public EmployeeSeedDto setName (String name) {
        this.name = name;
        return this;
    }

    public Integer getTotalSales () {
        return totalSales;
    }

    public EmployeeSeedDto setTotalSales (Integer totalSales) {
        this.totalSales = totalSales;
        return this;
    }

    public Double getSalesPeriod () {
        return salesPeriod;
    }

    public EmployeeSeedDto setSalesPeriod (Double salesPeriod) {
        this.salesPeriod = salesPeriod;
        return this;
    }

    public Double getExperienceMultiplier () {
        return experienceMultiplier;
    }

    public EmployeeSeedDto setExperienceMultiplier (Double experienceMultiplier) {
        this.experienceMultiplier = experienceMultiplier;
        return this;
    }

    public EmployeeSeedDto () {
    }
}
