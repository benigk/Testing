package com.mbt;

public class Pong {

    private final Student student = new Student();
    private Student currentStudent = null;

    public Student login() {
        currentStudent = student;
        return currentStudent;
    }

    public void logout() {
        currentStudent = null;
    }
}
