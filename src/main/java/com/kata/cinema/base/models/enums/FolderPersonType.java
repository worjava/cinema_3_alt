package com.kata.cinema.base.models.enums;

public enum FolderPersonType {
    FAVOURITES("Избранное"),
    CUSTOM("Новая папка");

    private final String name;

    FolderPersonType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
