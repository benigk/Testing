package com.mbt;

import org.graphwalker.core.condition.EdgeCoverage;
//import org.graphwalker.core.condition.TimeDuration;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.test.TestBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

@GraphWalker(value = "random(time_duration(1))", start = "e_Start")
public class PongPongModelAdvanced extends ExecutionContext implements ExampleLoginAdvanced {
    public final static Path MODEL_PATH = Paths.get("com/mbt/ExampleLoginAdvanced.graphml");
    private Adapter pongAdapter = new Adapter();
    private int fileCount = 0;

    @BeforeExecution
    public void setup() {
        System.out.println("Model: setup"); // http://graphwalker.github.io/fixtures/
        pongAdapter.init();
    }

    @AfterExecution
    public void teardown() {
        System.out.println("Model: teardown"); // http://graphwalker.github.io/fixtures/
        pongAdapter.reset();
    }

    @Override
    public void v_LoginPage_Submitted() {

    }

    @Override
    public void v_HomePage_Submitted() {

    }

    @Override
    public void v_HomePage_Open() {

    }

    @Override
    public void v_AssignmentPage_Submitted() {

    }

    @Override
    public void v_AssignmentPage_Open() {

    }

    @Override
    public void v_LoginPage_Open() {

    }


    @Override
    public void e_Start() {

        System.out.println("Running: e_Start");

        pongAdapter = new Adapter();
        fileCount = 0;
    }

    @Override
    public void e_Submit() {
        pongAdapter.submit();
    }

    @Override
    public void e_rmFile() {
        pongAdapter.rmFile();
        fileCount--;

        assertEquals(fileCount, pongAdapter.getFileCount());
    }

    @Override
    public void e_SelectAssignment() {
        pongAdapter.selectAssignment();
    }

    @Override
    public void e_Logout() {
        pongAdapter.logout();
    }

    @Override
    public void e_Withdraw() {
        pongAdapter.withdraw();
        fileCount = 0;

    }

    @Override
    public void e_addFile() {
        pongAdapter.addFile();
        fileCount++;
        assertEquals(fileCount, pongAdapter.getFileCount());
    }

    @Override
    public void e_Login() {
        pongAdapter.login();
    }

    @Test
    public void functionalTest() {
        new TestBuilder()
            .setModel(MODEL_PATH)
            .setContext(new PongPongModelAdvanced())
            .setPathGenerator(new RandomPath(new EdgeCoverage(100)))
            .setStart("e_Start")
            .execute();
    }

}
