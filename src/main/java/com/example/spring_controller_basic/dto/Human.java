package com.example.spring_controller_basic.dto;

public class Human {
    String name;
    int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age; 
    }

    @Override
    public String toString() {
        return "Human [name=" + name + ", age=" + age + "]";
    }
}
