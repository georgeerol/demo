package com.georgeerol.demo.api.service;

import com.georgeerol.demo.api.model.Expense;
import com.georgeerol.demo.api.model.User;
import com.georgeerol.demo.api.model.Category;
import com.georgeerol.demo.api.repository.ExpenseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExpenseServiceTest {

    @Mock
    private ExpenseRepository expenseRepository;

    @InjectMocks
    private ExpenseService expenseService;

    @Test
    public void testFindAll() {
        User user = new User(1L, "John Doe", "john@example.com");
        Category category = new Category(1L, "Food");
        Expense expense = new Expense(1L, "Lunch", 15.00, LocalDate.now(), user, category);
        when(expenseRepository.findAll()).thenReturn(Arrays.asList(expense));

        List<Expense> expenses = expenseService.findAll();
        assertEquals(1, expenses.size());
        assertEquals("Lunch", expenses.get(0).getDescription());
    }

    @Test
    public void testFindById() {
        User user = new User(1L, "John Doe", "john@example.com");
        Category category = new Category(1L, "Food");
        Expense expense = new Expense(1L, "Lunch", 15.00, LocalDate.now(), user, category);
        when(expenseRepository.findById(1L)).thenReturn(Optional.of(expense));

        Optional<Expense> foundExpense = expenseService.findById(1L);
        assertTrue(foundExpense.isPresent());
        assertEquals("Lunch", foundExpense.get().getDescription());
    }

    @Test
    public void testSave() {
        User user = new User(1L, "John Doe", "john@example.com");
        Category category = new Category(1L, "Food");
        Expense expense = new Expense(1L, "Lunch", 15.00, LocalDate.now(), user, category);
        when(expenseRepository.save(expense)).thenReturn(expense);

        Expense savedExpense = expenseService.save(expense);
        assertEquals("Lunch", savedExpense.getDescription());
    }

    @Test
    public void testDeleteById() {
        expenseService.deleteById(1L);
        verify(expenseRepository, times(1)).deleteById(1L);
    }
}