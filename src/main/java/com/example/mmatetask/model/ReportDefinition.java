package com.example.mmatetask.model;

import com.google.gson.annotations.Expose;

public class ReportDefinition {
    @Expose
    private Integer topPerformersThreshold;
    //TODO this typo error in the field is copied from the file and left,
    // because I believe it will be the same in the tests or the imported file
    @Expose
    private Boolean useExprienceMultiplier;
    @Expose
    private Integer periodLimit;

    public Integer getTopPerformersThreshold () {
        return topPerformersThreshold;
    }

    public ReportDefinition setTopPerformersThreshold (Integer topPerformersThreshold) {
        this.topPerformersThreshold = topPerformersThreshold;
        return this;
    }

    public Boolean getUseExprienceMultiplier () {
        return useExprienceMultiplier;
    }

    public ReportDefinition setUseExprienceMultiplier (Boolean useExprienceMultiplier) {
        this.useExprienceMultiplier = useExprienceMultiplier;
        return this;
    }

    public Integer getPeriodLimit () {
        return periodLimit;
    }

    public ReportDefinition setPeriodLimit (Integer periodLimit) {
        this.periodLimit = periodLimit;
        return this;
    }

    public ReportDefinition () {
    }
}
