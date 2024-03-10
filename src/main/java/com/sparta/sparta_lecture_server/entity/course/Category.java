package com.sparta.sparta_lecture_server.entity.course;

public enum Category {
    SPRING("Spring"),
    REACT("React"),
    NODE("Node");

    private final String categoryName;

    Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
