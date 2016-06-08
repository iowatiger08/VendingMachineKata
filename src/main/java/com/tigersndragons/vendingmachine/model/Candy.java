package com.tigersndragons.vendingmachine.model;

/**
 * Created by tdillon-hansen on 6/8/16.
 */
public class Candy extends Product {

    private static final String TYPE="CANDY";
    private static final int PRICE = ModelValues.CANDY_PRICE;
    @Override
    public int price() {
        return PRICE;
    }

    @Override
    public String type() {
        return TYPE;
    }
}
