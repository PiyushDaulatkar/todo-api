package com.lux.todoapi.resolver;

import com.lux.todoapi.entity.TodoList;
import com.lux.todoapi.service.TodoListService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
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

    @MutationMapping
    public TodoList createTodoList(
            @Argument Long userId,
            @Argument String title,
            @Argument String description,
            @Argument boolean isPublic) {

        return todoListService.createTodoList(userId, title, description, isPublic);
    }
}
