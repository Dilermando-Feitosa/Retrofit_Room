package com.example.retrofit_room.model;

public class DepartmentPost {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Departamento{" +
               "Nome=" + name + '\'' +
               '}';
    }

}
