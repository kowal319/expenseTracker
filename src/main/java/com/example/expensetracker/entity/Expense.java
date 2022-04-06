package com.example.expensetracker.entity;


import com.example.expensetracker.repository.ExpenseRepository;
import com.example.expensetracker.service.ExpenseService;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "quantity", nullable = false)
    private double quantity;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "date", nullable = false)
    private Date date;

    public Expense(String name, double quantity , double price, String description, Date date) {
        super();
        this.name = name;
        this.quantity = quantity ;
        this.price = price;
        this.description = description;
        this.date = date;
    }

    public Expense(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        if ( quantity >=2 ){
            return quantity * price; }
        else return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice(Expense expense) {
        if ( quantity >=2 ){
            return quantity * price; }
        else return price;
    }

}

