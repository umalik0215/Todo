package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.test.model.TodoItem;
import com.test.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public TodoItem addTodo(@RequestBody TodoItem todoItem) {
        return todoService.createTask(todoItem);
    }

    @GetMapping
    public List<TodoItem> getTodos() {
        return todoService.getAllTasks();
    }

    @PutMapping("/{id}")
    public TodoItem updateTodo(@PathVariable Long id, @RequestBody TodoItem todoItem) {
        return todoService.updateTask(id, todoItem);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTask(id);
    }
}
