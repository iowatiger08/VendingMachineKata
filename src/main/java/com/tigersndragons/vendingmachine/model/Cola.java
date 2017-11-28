package com.tigersndragons.vendingmachine.model;

/**
 * Created by tdillon-hansen
 */
public class Cola extends Product{

    private static final String TYPE="COLA";
    private static final int PRICE = ModelValues.COLA_PRICE;
    @Override
    public int price() {
        return PRICE;
    }

    @Override
    public String type() {
        return TYPE;
    }
}
