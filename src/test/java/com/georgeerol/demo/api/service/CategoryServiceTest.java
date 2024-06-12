package com.georgeerol.demo.api.service;

import com.georgeerol.demo.api.model.Category;
import com.georgeerol.demo.api.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    public void testFindAll() {
        Category category = new Category(1L, "Food");
        when(categoryRepository.findAll()).thenReturn(Arrays.asList(category));

        List<Category> categories = categoryService.findAll();
        assertEquals(1, categories.size());
        assertEquals("Food", categories.get(0).getName());
    }

    @Test
    public void testFindById() {
        Category category = new Category(1L, "Food");
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));

        Optional<Category> foundCategory = categoryService.findById(1L);
        assertTrue(foundCategory.isPresent());
        assertEquals("Food", foundCategory.get().getName());
    }

    @Test
    public void testSave() {
        Category category = new Category(1L, "Food");
        when(categoryRepository.save(category)).thenReturn(category);

        Category savedCategory = categoryService.save(category);
        assertEquals("Food", savedCategory.getName());
    }

    @Test
    public void testDeleteById() {
        categoryService.deleteById(1L);
        verify(categoryRepository, times(1)).deleteById(1L);
    }
}