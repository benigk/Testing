package com.mbt;

public class Student {
    private Assignment assignment;

    public void selectAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public Assignment getAssignment() {
        return assignment;
    }
}