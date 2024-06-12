package com.georgeerol.demo.api.repository;

import com.georgeerol.demo.api.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}