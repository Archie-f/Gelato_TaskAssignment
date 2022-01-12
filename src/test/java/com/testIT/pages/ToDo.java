package com.testIT.pages;

public class ToDo {

    private int userId;
    private String title;
    private boolean completed;
    private int id;

    public ToDo() {}

    public ToDo(int userId, String title, boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public int getId() {
        return id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void isCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                ", id=" + id +
                '}';
    }
}
