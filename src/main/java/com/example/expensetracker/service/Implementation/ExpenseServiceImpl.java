package com.example.expensetracker.service.Implementation;

import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.repository.ExpenseRepository;
import com.example.expensetracker.service.ExpenseService;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        super();
        this.expenseRepository = expenseRepository;
    }

    @Override
    public List<Expense> getAllExpenses(String keyword) {
        if (keyword != null) {
            return expenseRepository.search(keyword);
        } else
            return expenseRepository.findAll();
    }

    @Override
    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).get();
    }

    @Override
    public Expense updateExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public void deleteStudentById(Long id) {
         expenseRepository.deleteById(id);
    }

   @Override
    public List<Expense> sortByCost() {
        return expenseRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));
    }

    @Override
    public List<Expense> sortByName() {
        return expenseRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }



}
