package com.lux.todoapi.service;

import com.lux.todoapi.entity.TodoList;
import com.lux.todoapi.entity.User;
import com.lux.todoapi.repository.TodoListRepository;
import com.lux.todoapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListService {

    private final TodoListRepository todoListRepository;
    private final UserRepository userRepository;

    public TodoListService(TodoListRepository todoListRepository,
            UserRepository userRepository) {
        this.todoListRepository = todoListRepository;
        this.userRepository = userRepository;
    }

    public List<TodoList> getAllTodoLists() {
        return todoListRepository.findAll();
    }

    public TodoList createTodoList(Long userId, String title, String description, boolean isPublic) {
        User owner = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        TodoList todoList = new TodoList(title, description, owner);
        todoList.setPublic(isPublic);

        return todoListRepository.save(todoList);
    }
}
