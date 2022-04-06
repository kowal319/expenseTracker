package com.example.expensetracker.controller;

import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.entity.PriceRange;
import com.example.expensetracker.service.ExpenseService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ExpenseController {

    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        super();
        this.expenseService = expenseService;
    }

    @GetMapping("/expenses")
    public String listExpenses(Model model, @Param("keyword") String keyword, Expense expense, PriceRange priceRange) {
        List<Expense> expenses = expenseService.getAllExpenses(keyword);
        model.addAttribute("expenses", expenses);
        model.addAttribute("keyword", keyword);
        return "expenses";
    }



    @GetMapping("/expenses/new")
    public String createExpenseForm(Model model) {
        Expense expense = new Expense();
        model.addAttribute("expense", expense);
        return "create_expense";
    }

    @PostMapping("/expenses")
    public String saveExpense(@ModelAttribute("expense") Expense expense) {
        expenseService.saveExpense(expense);
        return "redirect:/expenses";
    }

    @GetMapping("/expenses/edit/{id}")
    public String editExpenseForm(@PathVariable Long id, Model model) {
        model.addAttribute("expense", expenseService.getExpenseById(id));
        return "edit_expense";
    }

    @PostMapping("/expenses/{id}")
    public String updateExpense(@PathVariable Long id, @ModelAttribute("expense") Expense expense, Model model) {
        Expense existingExpense = expenseService.getExpenseById(id);
        existingExpense.setId(id);
        existingExpense.setQuantity(expense.getQuantity());
        existingExpense.setName(expense.getName());
        existingExpense.setDescription(expense.getDescription());
        existingExpense.setPrice(expense.getPrice());
        existingExpense.setDate(expense.getDate());
        expenseService.updateExpense(existingExpense);
        return "redirect:/expenses";
    }

    @GetMapping("/expenses/{id}")
    public String deleteExpense(@PathVariable Long id) {
        expenseService.deleteStudentById(id);
        return "redirect:/expenses";
    }

    @GetMapping("/expenses/sortByPrice")
    public String sortByPrice(Model model) {
        List<Expense> expenses = expenseService.sortByCost();
        model.addAttribute("expenses", expenses);
        return "expenses";
    }

    @GetMapping("expenses/sortByName")
    public String sortByName(Model model) {
        List<Expense> expenses = expenseService.sortByName();
        model.addAttribute("expenses", expenses);
        return "expenses";
    }

    @GetMapping("/expenses/description/{id}")
    public String listStudent(@PathVariable Long id, Model model) {
        model.addAttribute("expenses", expenseService.getExpenseById(id));
        return "expenseDesc";
    }
}