package com.mbt.group3;

import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.condition.TimeDuration;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.graphwalker.java.test.TestBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

@GraphWalker(value = "random(time_duration(1))", start = "e_GoToPage")
public class ModelImplementationGroup3 extends ExecutionContext implements ModelGroup3 {

    public final static Path MODEL_PATH = Paths.get("com/mbt/group3/ModelGroup3.graphml");

    private final AdapterGroup3 adapter = new AdapterGroup3();
    private long productId;
    private long newProductId;
    private long productVariantId;

    @Test
    public void functionalityTest() {
        new TestBuilder()
                .setModel(MODEL_PATH)
                .setContext(new ModelImplementationGroup3())
                .setPathGenerator(new RandomPath(new EdgeCoverage(100)))
                .setStart("e_GoToPage")
                .execute();
    }

    @Test
    public void stabilityTest() {
        new TestBuilder()
                .setModel(MODEL_PATH)
                .setContext(new ModelImplementationGroup3())
                .setPathGenerator(new RandomPath(new TimeDuration(30, TimeUnit.SECONDS)))
                .setStart("e_GoToPage")
                .execute();
    }

    // TODO: Does not work for some reason => Do we just continue using the deprecated methods?
    /*@Test
    public void functionalityTest() {
        new TestBuilder()
                .addModel(MODEL_PATH, new RandomPath(new EdgeCoverage(100)), "e_GoToPage")
                .execute();
        Assert.assertTrue(graphWalkerWorks);
    }
    @Test
    public void stabilityTest() {
        new TestBuilder()
                .addModel(MODEL_PATH, new RandomPath(new TimeDuration(30, TimeUnit.SECONDS)), "e_GoToPage")
                .execute();
        Assert.assertTrue(graphWalkerWorks);
    }*/

    @BeforeExecution
    public void setup() {
        System.out.println("Model: setup"); // http://graphwalker.github.io/fixtures/
        adapter.init();
    }

    @AfterExecution
    public void teardown() {
        System.out.println("Model: teardown"); // http://graphwalker.github.io/fixtures/
        adapter.reset();
    }

    @Override
    public void e_AddNewProduct() {
        System.out.println("Model: e_AddNewProduct");
        try {
            JSONObject result = adapter.addProduct();
            newProductId = result.getJSONObject("product").getLong("id");
            System.out.println(result);
            JSONObject result2 = adapter.addProductVariant(newProductId);
            System.out.println(result2);
        } catch (IOException e) {
            Assert.fail("IOException occurred: " + e.getMessage());
        }
    }

    @Override
    public void e_GetListProducts() {
        System.out.println("Model: e_GetListProducts");
        try {
            JSONArray result = adapter.getAllProducts();

            productId = result.getJSONObject(0).getLong("id");
            System.out.println(productId);
            //productId = result.getJSONObject("product").getInt("id");
            /*Assert.assertEquals("Pepperoni pizza", result.getJSONObject(0).getString("title"));
            Assert.assertEquals("Shirt", result.getJSONObject(1).getString("title"));
            Assert.assertEquals("Shirt blue", result.getJSONObject(2).getString("title"));

            int shownProductsCount = adapter.getShownProductsCount();
            Assert.assertEquals(3, shownProductsCount);
            */
        } catch (IOException e) {
            Assert.fail("IOException occurred: " + e.getMessage());
        }
    }

    @Override
    public void e_SelectOneProduct() {
        System.out.println("Model: e_SelectOneProduct");
        try {
            JSONObject result = adapter.getProduct(productId);
            //Assert.assertEquals("Pepperoni pizza", result.getJSONObject("product").getString("title"));
        } catch (IOException e) {
            Assert.fail("IOException occurred: " + e.getMessage());
        }
    }

    @Override
    public void e_UpdatePrice() {
        //
        // TODO: Update price in api call
        //
        System.out.println("Model: e_UpdatePrice");

        try {
            JSONArray result = adapter.getAllProductVariants(productId);
            productVariantId = result.getJSONObject(0).getLong("id");
            JSONObject result2 = adapter.getProductVariant(productVariantId);

            System.out.println("PRICE BEFORE: " + result2.getJSONObject("variant").getDouble("price"));
            JSONObject result3 = adapter.updateProductVariantPrice(productVariantId);
            System.out.println("PRICE AFTER: " + result3.getJSONObject("variant").getDouble("price"));
            //Assert.assertEquals("Pepperoni pizza", result.getJSONObject("product").getString("title"));
        } catch (IOException e) {
            Assert.fail("IOException occurred: " + e.getMessage());
        }
    }

    @Override
    public void e_UpdateState() {
        //
        // TODO: Update state in api call
        //
        System.out.println("Model: e_UpdateState");
        try {
            JSONObject result = adapter.updateProductStatus(productId);
            //Assert.assertEquals("Pepperoni pizza", result.getJSONObject("product").getString("title"));
        } catch (IOException e) {
            Assert.fail("IOException occurred: " + e.getMessage());
        }
    }

    @Override
    public void e_RemoveProduct() {
        System.out.println("Model: e_RemoveProduct");
        try {
            JSONObject result = adapter.deleteProduct(productId);
        } catch (IOException e) {
            Assert.fail("IOException occurred: " + e.getMessage());
        }
    }

    @Override
    public void e_SelectOtherProduct() {
        System.out.println("Model: e_SelectOtherProduct");
    }

    @Override
    public void e_ReInitialize() {
        System.out.println("Model: e_ReInitialize");
    }

    @Override
    public void e_GoToPage() {
        System.out.println("Model: e_GoToPage");
    }

    @Override
    public void v_FirstPage() {
        // No implementation necessary
    }

    @Override
    public void v_ProductCreated() {
        // No implementation necessary
    }

    @Override
    public void v_ListOfProducts() {
        // No implementation necessary
    }

    @Override
    public void v_ProductShown() {
        // No implementation necessary
    }

    @Override
    public void v_PriceUpdated() {
        // No implementation necessary
    }

    @Override
    public void v_StateUpdated() {
        // No implementation necessary
    }

    @Override
    public void v_ProductRemoved() {
        // No implementation necessary
    }

}
