package com.georgeerol.demo.api.repository;

import com.georgeerol.demo.api.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository  extends JpaRepository<Expense,Long> {
}
