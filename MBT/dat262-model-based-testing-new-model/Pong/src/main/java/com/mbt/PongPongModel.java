package com.mbt;

import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
//import org.graphwalker.core.condition.EdgeCoverage;
//import org.graphwalker.core.condition.ReachedVertex;
import org.graphwalker.core.condition.TimeDuration;
import org.graphwalker.core.generator.RandomPath;
//import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.test.TestBuilder;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;


@GraphWalker(value = "random(edge_coverage(100))", start = "e_Start")
public class PongPongModel extends ExecutionContext implements ExampleLogin {
    public final static Path MODEL_PATH = Paths.get("com/mbt/ExampleLogin.graphml");
    private Adapter pongAdapter;

    @Override
    public void e_Start() {
        System.out.println("Running: e_Start");

        // set up your environment -- start application, initialize variables, initialize Adapter
        pongAdapter = new Adapter();
    }

    @Override
    public void e_SelectAssignment() {
        System.out.println("Running: e_SelectAssignment");
    }

    @Override
    public void e_Logout() {
        System.out.println("Running: e_Logout");
    }

    @Override
    public void e_Login() {
        System.out.println("Running: e_Login");
        pongAdapter.login();
    }

    @Override
    public void v_AssignmentPage() {
        System.out.println("Running: v_AssignmentPage");
    }

    @Override
    public void v_HomePage() {
        System.out.println("Running: v_HomePage");
    }

    @Override
    public void v_LoginPage() {
        System.out.println("Running: v_LoginPage");
    }


    @Test
    public void functionalTest() {
        new TestBuilder()
                .addModel(MODEL_PATH, new RandomPath(new EdgeCoverage(100)), "e_Start")
                .execute();
    }

    @Test
    public void stabilityTest() {
        new TestBuilder()
                .addModel(MODEL_PATH, new RandomPath(new TimeDuration(30, TimeUnit.SECONDS)), "e_Start")
                .execute();
    }
}
