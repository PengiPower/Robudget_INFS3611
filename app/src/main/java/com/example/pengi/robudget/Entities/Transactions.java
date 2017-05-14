package com.example.pengi.robudget.Entities;

import java.util.Date;

/**
 * Created by Pengi on 13/05/2017.
 */

public class Transactions {
    private String category;
    private String description;
    private double amount;
    private java.util.Date date;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
