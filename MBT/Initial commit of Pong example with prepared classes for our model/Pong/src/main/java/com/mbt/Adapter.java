package com.mbt;

import java.io.File;
import org.junit.Assert;

public class Adapter {
    private Pong pong = new Pong();
    private Student student = new Student();
    private Assignment assignment = new Assignment();

    public void login() {
        student = pong.login();
    }

    public void logout() {
        pong.logout();
    }

    public void selectAssignment() {
        student.selectAssignment(assignment);
    }

    public void addFile() {
        student.getAssignment().addFile(new File("/tmp/foo.txt"));
    }

    public void rmFile() {
        File firstFileInList = student.getAssignment().getFiles().get(0);
        student.getAssignment().rmFile(firstFileInList);
    }

    public void submit() {
        student.getAssignment().submit();
    }

    public void withdraw() {
        student.getAssignment().withdraw();
    }

    public void init() {
        System.out.println("Adapter: init SUT");
    }

    public void reset() {
        System.out.println("Adapter: reset SUT");
    }

    // additional
    public int getFileCount() {
        return student.getAssignment().getFiles().size();
    }
}