package com.lux.todoapi.service;

import com.lux.todoapi.entity.TodoList;
import com.lux.todoapi.repository.TodoListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListService {

    private final TodoListRepository todoListRepository;

    public TodoListService(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    public List<TodoList> getAllTodoLists() {
        return todoListRepository.findAll();
    }
}
