package com.lux.todoapi.repository;

import com.lux.todoapi.entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoListRepository extends JpaRepository<TodoList, Long> {}
