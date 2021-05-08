package com.mbt;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Assignment {
    private List<File> files = new ArrayList<File>();
    private boolean submitted = false;

    public void addFile(File f) {
        files.add(f); // inject fault
    }
    public void rmFile(File f) {

        files.remove(f);
    }

    public void submit() {

        submitted = true;
    }
    public void withdraw() {

        submitted = false;
        files = new ArrayList<File>();
    }

    public List<File> getFiles() {

        return files;
    }
}