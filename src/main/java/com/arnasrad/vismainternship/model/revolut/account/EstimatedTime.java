package com.arnasrad.vismainternship.model.revolut.account;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstimatedTime {

    private String unit;
    private Double min;
    private Double max;

    public EstimatedTime() {
    }

    public EstimatedTime(String unit, Double min, Double max) {
        this.unit = unit;
        this.min = min;
        this.max = max;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }
}
