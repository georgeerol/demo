package com.georgeerol.demo.api.repository;

import com.georgeerol.demo.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
