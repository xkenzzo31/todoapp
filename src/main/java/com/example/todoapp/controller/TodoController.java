package com.example.todoapp.controller;

import com.example.todoapp.entity.Todo;
import com.example.todoapp.entity.User;
import com.example.todoapp.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {
    /**
     * Implement all fonctionality of TodoService
     */
    TodoService todoService;

    @Autowired
    TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("")
    public List<Todo> getTodos() {
        return this.todoService.getTodos();
    }

    @RequestMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        return this.todoService.findTodoById(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Todo> createTodo(Todo todo) {
        System.out.println(todo.getDescription()+" "+todo.getName());
        return new ResponseEntity<Todo>(this.todoService.createTodo(todo), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Todo> updateTodo(Todo todo) {
        return ResponseEntity.ok(this.todoService.updateTodo(todo));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteTodo(Long id) {
        this.todoService.deleteTodo(id);
    }


}
