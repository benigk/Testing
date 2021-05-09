package com.mbt.group3;

import com.mbt.PongPongModelAdvanced;
import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.condition.TimeDuration;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.graphwalker.java.test.TestBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@GraphWalker(value = "random(time_duration(1))", start = "e_GoToPage")
public class ModelImplementationGroup3 extends ExecutionContext implements ModelGroup3 {

    public final static Path MODEL_PATH = Paths.get("com/mbt/group3/ModelGroup3.graphml");
    private AdapterGroup3 adapter = new AdapterGroup3();

    // private static final Logger logger = LoggerFactory.getLogger(ModelImplementationGroup3.class);

    @Test
    public void functionalityTest() {
        new TestBuilder()
                .setModel(MODEL_PATH)
                .setContext(new ModelImplementationGroup3())
                .setPathGenerator(new RandomPath(new EdgeCoverage(100)))
                .setStart("e_GoToPage")
                .execute();
    }

    /*@Test
    public void functionalityTest() {
        System.out.println("testing!!!!!!!!!!!!");
        logger.info("Setup happens here");
        new TestBuilder()
                .addModel(MODEL_PATH, new RandomPath(new EdgeCoverage(100)), "e_GoToPage")
                .execute();

        System.out.println("****************** AFTER ***************** ");
    }*/

    /*
    @Test
    public void stabilityTest() {
        new TestBuilder()
                .addModel(MODEL_PATH, new RandomPath(new TimeDuration(30, TimeUnit.SECONDS)), "e_GoToPage")
                .execute();
    }*/

    @BeforeExecution
    public void setup() {
        System.out.println("Model: setup"); // http://graphwalker.github.io/fixtures/
        // logger.debug("SETUP!!!");
        adapter.init();
    }

    @AfterExecution
    public void teardown() {
        System.out.println("Model: teardown"); // http://graphwalker.github.io/fixtures/
        adapter.reset();
    }

    @Override
    public void v_AddedIntoCart() {

    }

    @Override
    public void v_ResultShown() {

    }

    @Override
    public void e_MakeWrongPayment() {

    }

    @Override
    public void e_ReInitialize() {

    }

    @Override
    public void v_SpecificProductSelected() {

    }

    @Override
    public void e_CancelPayment() {

    }

    @Override
    public void v_OrderReserved() {

    }

    @Override
    public void e_AddToCart() {
        /*try {
            adapter.doSomething();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        adapter.addToCart();

    }

    @Override
    public void e_SelectProduct() {

    }

    @Override
    public void e_GoToPage() {

    }

    @Override
    public void e_ReserveAnOrder() {

    }

    @Override
    public void e_SearchForProduct() {

    }

    @Override
    public void e_MakeSuccessfulPayment() {

    }

    @Override
    public void e_CancelReservation() {

    }

    @Override
    public void v_PaymentSuccessful() {

    }

    @Override
    public void v_PaymentNotSuccessful() {

    }

    @Override
    public void v_FirstPage() {

    }

    @Override
    public void e_AddMoreProducts() {

    }

}
