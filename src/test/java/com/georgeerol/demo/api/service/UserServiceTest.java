package com.georgeerol.demo.api.service;

import com.georgeerol.demo.api.model.User;
import com.georgeerol.demo.api.repository.UserRepository;
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
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testFindAll() {
        User user = new User(1L, "John Doe", "john@example.com");
        when(userRepository.findAll()).thenReturn(Arrays.asList(user));

        List<User> users = userService.findAll();
        assertEquals(1, users.size());
        assertEquals("John Doe", users.get(0).getName());
    }

    @Test
    public void testFindById() {
        User user = new User(1L, "John Doe", "john@example.com");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<User> foundUser = userService.findById(1L);
        assertTrue(foundUser.isPresent());
        assertEquals("John Doe", foundUser.get().getName());
    }

    @Test
    public void testSave() {
        User user = new User(1L, "John Doe", "john@example.com");
        when(userRepository.save(user)).thenReturn(user);

        User savedUser = userService.save(user);
        assertEquals("John Doe", savedUser.getName());
    }

    @Test
    public void testDeleteById() {
        userService.deleteById(1L);
        verify(userRepository, times(1)).deleteById(1L);
    }
}