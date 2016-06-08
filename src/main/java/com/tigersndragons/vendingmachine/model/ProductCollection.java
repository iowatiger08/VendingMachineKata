package com.tigersndragons.vendingmachine.model;

import java.util.HashMap;

/**
 * Created by tdillon-hansen on 6/7/16.
 */
public class ProductCollection {

    private HashMap<Coin, Integer> mapOfProducts;

    public   ProductCollection(){
        mapOfProducts= new HashMap<Coin, Integer>();
    }

    public HashMap<Coin, Integer> getMapOfProducts() {
        return mapOfProducts;
    }

    public void setMapOfProducts(HashMap<Coin, Integer> mapOfProducts) {
        this.mapOfProducts = mapOfProducts;
    }

    public boolean isEmpty() {
        return mapOfProducts.isEmpty();
    }
}
