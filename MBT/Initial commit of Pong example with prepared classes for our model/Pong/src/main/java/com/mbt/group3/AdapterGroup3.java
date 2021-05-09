package com.mbt.group3;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

public class AdapterGroup3 {

    // private Api ourApi;

    public void init() {
        System.out.println("Adapter: init SUT");
    }

    public void reset() {
        System.out.println("Adapter: reset SUT");
    }

    public void addToCart(){
        System.out.println("TEST!");
    }

    public void doSomething() throws IOException {
        System.out.println("Start doing something");

        URL url = new URL("http://localhost/A2/admin/api/2021-04/products/632910392.json");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("X-Shopify-Access-Token", "1d5e624c7f1d400c6e72a708f8268f6a");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestMethod("GET");

        System.out.println("Test!!!" + con.getContent());

        // Logger.getAnonymousLogger().log("DEBUG")
        // GET /admin/api/2021-04/products/632910392.json
        // ourApi.addToCart();
    }

    // Additional methods

    public int getShoppingCartItemCount() {
        return 0;
    }

}
