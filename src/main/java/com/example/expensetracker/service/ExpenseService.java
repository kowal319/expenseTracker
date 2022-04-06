package com.example.expensetracker.service;

import com.example.expensetracker.entity.Expense;

import java.util.Date;
import java.util.List;

public interface ExpenseService {

    List<Expense> getAllExpenses(String keyword);
    Expense saveExpense(Expense expense);
    Expense getExpenseById(Long id);
    Expense updateExpense(Expense expense);
    void deleteStudentById(Long id);
    List<Expense> sortByCost();
    List<Expense> sortByName();
//    List<Expense> getAllExpenses(double min, double max);
}
