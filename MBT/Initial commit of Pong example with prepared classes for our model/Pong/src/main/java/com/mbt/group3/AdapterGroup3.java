package com.mbt.group3;

public class AdapterGroup3 {

    // private Api ourApi;

    public void init() {
        System.out.println("Adapter: init SUT");
    }

    public void reset() {
        System.out.println("Adapter: reset SUT");
    }

    public void addToCart() {
        // ourApi.addToCart();
    }

    // Additional methods

    public int getShoppingCartItemCount() {
        return 0;
    }

}
