package com.tigersndragons.vendingmachine.model;

/**
 * Created by user on 6/8/16.
 */
public class Chips extends Product {
    private static final String TYPE="CHIPS";
    private static final int PRICE = ModelValues.CHIPS_PRICE;
    @Override
    public int price() {
        return PRICE;
    }

    @Override
    public String type() {
        return TYPE;
    }
}
