package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.TodoItem;

public interface TodoRepository extends JpaRepository<TodoItem, Long> {
}
