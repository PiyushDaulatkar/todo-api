package com.lux.todoapi.resolver;

import com.lux.todoapi.entity.TodoList;
import com.lux.todoapi.service.TodoListService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TodoListResolver {

    private final TodoListService todoListService;

    public TodoListResolver(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @QueryMapping
    public List<TodoList> todoLists() {
        return todoListService.getAllTodoLists();
    }
}
