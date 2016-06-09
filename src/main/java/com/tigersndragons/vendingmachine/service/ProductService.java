package com.tigersndragons.vendingmachine.service;

import com.tigersndragons.vendingmachine.model.Coin;
import com.tigersndragons.vendingmachine.model.ProductCollection;

/**
 * Created by tdillon-hansen on 6/7/16.
 */
public class ProductService {
    public ProductCollection getProducts() {
        ProductCollection productCollection = new ProductCollection();
        return productCollection;
    }

    public String receiveCoinsForPurchase(Coin aCoin){

    }

    public void processCola() {
    }

    public void processChips() {
    }

    public void processCandy() {
    }
}
