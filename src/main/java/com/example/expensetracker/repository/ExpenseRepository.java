package com.example.expensetracker.repository;

import com.example.expensetracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {


    @Query("SELECT expenses FROM Expense expenses WHERE CONCAT(expenses.name, ' ',expenses.date, ' ',expenses.price) LIKE %?1%")
    public List<Expense> search(String keyword);

}
