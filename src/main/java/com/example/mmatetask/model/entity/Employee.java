package com.example.mmatetask.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Entity
@Table(name="employees")
public class Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name="name")
    private String name;
    @Positive
    @Column(name="total_sales")
    private Integer totalSales;
    @Positive
    @Column(name="sales_period")
    private Integer salesPeriod;
    @Positive
    @Column(name="experience_multiplier")
    private Double experienceMultiplier;

    //Constraints are not give in the task description and are added to avoid invalid or incomplete records

    public Employee () {
    }

    public String getName () {
        return name;
    }

    public Employee setName (String name) {
        this.name = name;
        return this;
    }

    public Integer getTotalSales () {
        return totalSales;
    }

    public Employee setTotalSales (Integer totalSales) {
        this.totalSales = totalSales;
        return this;
    }

    public Integer getSalesPeriod () {
        return salesPeriod;
    }

    public Employee setSalesPeriod (Integer salesPeriod) {
        this.salesPeriod = salesPeriod;
        return this;
    }

    public Double getExperienceMultiplier () {
        return experienceMultiplier;
    }

    public Employee setExperienceMultiplier (Double experienceMultiplier) {
        this.experienceMultiplier = experienceMultiplier;
        return this;
    }
}
