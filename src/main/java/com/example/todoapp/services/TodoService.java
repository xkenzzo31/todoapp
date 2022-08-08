package com.example.todoapp.services;

import com.example.todoapp.entity.Todo;
import com.example.todoapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    TodoRepository todoRepositiory;

    @Autowired
    TodoService(TodoRepository todoRepositiory) {
        this.todoRepositiory = todoRepositiory;
    }

    public List<Todo> getTodos() {
        return (List<Todo>) this.todoRepositiory.findAll();
    }

    public Todo findTodoById(Long id) {
        return todoRepositiory.findById(id).orElse(null);
    }

    public Todo createTodo(Todo todo) {
        return todoRepositiory.save(todo);
    }

    public Todo updateTodo(Todo todo) {
        return todoRepositiory.save(todo);
    }

    public void deleteTodo(Long id) {
        todoRepositiory.deleteById(id);
    }


}
