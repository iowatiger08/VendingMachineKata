package com.tigersndragons.vendingmachine.service;

import com.tigersndragons.vendingmachine.model.Coin;
import com.tigersndragons.vendingmachine.model.CoinCollection;
import com.tigersndragons.vendingmachine.model.ProductCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tdillon-hansen on 6/7/16.
 */
public class ProductService {
    @Autowired
    CoinReciever coinReciever;

    public ProductCollection getProducts() {
        ProductCollection productCollection = new ProductCollection();
        return productCollection;
    }


    public String processCola() {
        return null;
    }

    public String processChips() {
        return null;
    }

    public String processCandy() {
        return null;
    }

    public int getChipCount() {
        return 0;
    }

    public int getCandyCount() {
        return 0;
    }

    public int getColaCount() {
        return 0;
    }
}
