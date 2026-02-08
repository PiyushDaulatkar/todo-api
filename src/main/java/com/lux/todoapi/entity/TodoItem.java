package com.lux.todoapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "todo_items")
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private boolean completed = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_list_id")
    private TodoList todoList;

    protected TodoItem() {
    };

    public TodoItem(String text, TodoList todoList) {
        this.text = text;
        this.todoList = todoList;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public boolean isCompleted() {
        return completed;
    }

    public TodoList getTodoList() {
        return todoList;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
