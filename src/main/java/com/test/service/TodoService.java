package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.TodoItem;
import com.test.repository.TodoRepository;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public TodoItem createTask(TodoItem todoItem) {
        return repository.save(todoItem);
    }

    public List<TodoItem> getAllTasks() {
        return repository.findAll();
    }

    public TodoItem updateTask(Long id, TodoItem updatedItem) {
        TodoItem item = repository.findById(id).orElseThrow();
        item.setTask(updatedItem.getTask());
        item.setCompleted(updatedItem.isCompleted());
        return repository.save(item);
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
