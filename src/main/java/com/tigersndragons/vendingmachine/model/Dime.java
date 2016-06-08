package com.tigersndragons.vendingmachine.model;

/**
 * Created by user on 6/8/16.
 */
public class Dime extends Coin {
    public static final String TYPE="DIME";
    private final int value = 10;
    private final long weight = ModelValues.DIME_WEIGHT;
    private final long size = ModelValues.DIME_SIZE;
    @Override
    public String type() {
        return TYPE;
    }

    @Override
    public long weight() {
        return weight;
    }

    @Override
    public long size() {
        return size;
    }

    @Override
    public int value() {
        return value;
    }


}
