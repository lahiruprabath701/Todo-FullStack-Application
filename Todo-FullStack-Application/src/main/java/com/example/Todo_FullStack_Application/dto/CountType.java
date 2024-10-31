package com.example.Todo_FullStack_Application.dto;

public class CountType {
    private double percentage;
    private String type;

    public CountType(double percentage, String type) {
        this.percentage = percentage;
        this.type = type;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
