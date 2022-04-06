package com.example.expensetracker.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class PriceRange {

    private double min;
    private double max;

    public PriceRange(double min, double max) {
        this.min = min;
        this.max = max;
    }
    public PriceRange (){
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }
}