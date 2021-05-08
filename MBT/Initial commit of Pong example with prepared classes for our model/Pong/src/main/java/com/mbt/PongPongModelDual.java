package com.mbt;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

@GraphWalker(value = "random(edge_coverage(100))", start = "e_Start")
public class PongPongModelDual extends ExecutionContext implements ExampleLoginDual {

    @Override
    public void e_Start() {
        System.out.println("Running: e_Start");
    }

    @Override
    public void v_Logout() {
        System.out.println("Running: v_Logout formally e_Logout");
    }

    @Override
    public void v_Select_Assignment() {
        System.out.println("Running: v_Select_Assignment formally e_Select_Assignment");
    }

    @Override
    public void e_1() {

    }

    @Override
    public void v_Logout_A() {
        System.out.println("Running: v_Logout_A formally e_Logout_A");
    }

    @Override
    public void e_3() {

    }

    @Override
    public void e_2() {

    }

    @Override
    public void e_5() {

    }

    @Override
    public void e_4() {

    }

    @Override
    public void v_Login() {
        System.out.println("Running: v_Login formally e_Login");
    }
}
