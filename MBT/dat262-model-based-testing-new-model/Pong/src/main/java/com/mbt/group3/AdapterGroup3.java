package com.mbt.group3;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class AdapterGroup3 {

    private static final int HTTP_CODE_OK = 200;
    private static final int HTTP_CODE_CREATED = 201;

    public void init() {
        System.out.println("Adapter: init SUT");
    }

    public void reset() {
        System.out.println("Adapter: reset SUT");
    }

    public JSONObject addProduct() throws IOException {
        int randInt = new Random().nextInt(1000);
        String jsonData = "{" +
                "\"product\": {" +
                "\"title\": \"Burton Custom Freestyle " + randInt + "\"," +
                "\"body_html\": \"<strong>Good snowboard!</strong>\"," +
                "\"vendor\": \"Burton\"," +
                "\"product_type\": \"Snowboard\"," +
                "\"published\": false" +
                "}\n" +
                "}";

        JSONObject result = callShopify("products.json", "POST", jsonData);
        return result;
    }

    public JSONObject addProductVariant(long productId) throws IOException {
        String jsonData = "{" +
                "\"variant\": {" +
                "\"option1\": \"Yellow\"," +
                "\"price\": \"1.00\"" +
                "}\n" +
                "}";

        JSONObject result = callShopify("products/" + productId + "/variants.json", "POST", jsonData);
        return result;
    }

    public JSONArray getAllProductVariants(long productId) throws IOException {
        JSONObject result = callShopify("products/" + productId + "/variants.json", "GET", null);
        JSONArray allVariants = result.getJSONArray("variants");
        return allVariants;
    }
    public JSONObject getProductVariant(long variantId) throws IOException {
        JSONObject result = callShopify("variants/" + variantId + ".json", "GET", null);
        return result;
    }

    public JSONArray getAllProducts() throws IOException {
        JSONObject result = callShopify("products.json", "GET", null);
        JSONArray allProducts = result.getJSONArray("products");
        return allProducts;
    }

    public JSONObject getProduct(long productId) throws IOException {
        JSONObject result = callShopify("products/" + productId + ".json", "GET", null);
        return result;
    }

    public JSONObject updateProductVariantPrice(long variantId) throws IOException {
        double leftLimit = 0.00;
        double rightLimit = 5000.00;
        double randomPrice = leftLimit + new Random().nextDouble() * (rightLimit - leftLimit);
        String jsonData = "{" +
                "\"variant\": {" +
                "\"id\": " + variantId + "," +
                "\"price\": " +  randomPrice +
                "}" +
                "}";
        JSONObject result = callShopify("variants/" + variantId + ".json", "PUT", jsonData);
        return result;
    }

    public JSONObject updateProductStatus(long productId) throws IOException {
        String jsonData = "{" +
                "\"product\": {" +
                "\"id\": " + productId + "," +
                "\"status\": \"active\"" +
                "}" +
                "}";
        JSONObject result = callShopify("products/" + productId + ".json", "PUT", jsonData);
        return result;
    }

    public JSONObject deleteProduct(long productId) throws IOException {
        JSONObject result = callShopify("products/" + productId + ".json", "DELETE", null);
        return result;
    }

    public JSONObject callShopify(String resource, String requestMethod, String jsonData) throws IOException {
        String urlShopify = "https://8d75ac96e6a801d1ff6169dbd8883f45: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@dat262-a2.myshopify.com/admin/api/2021-04/";
        URL url = new URL(urlShopify + resource);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod(requestMethod);
        con.setRequestProperty("X-Shopify-Access-Token", "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");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");

        if (jsonData != null) {
            con.setDoOutput(true);
            try(OutputStream os = con.getOutputStream()) {
                byte[] input = jsonData.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }
        }

        if (requestMethod.equals("POST")) {
            Assert.assertEquals(HTTP_CODE_CREATED, con.getResponseCode());
        } else {
            Assert.assertEquals(HTTP_CODE_OK, con.getResponseCode());
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        con.disconnect();

        return new JSONObject(content.toString());
    }

}
