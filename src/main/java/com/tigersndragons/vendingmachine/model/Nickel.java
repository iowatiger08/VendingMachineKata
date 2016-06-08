package com.tigersndragons.vendingmachine.model;

/**
 * Created by user on 6/8/16.
 */
public class Nickel extends Coin {
    public static final String TYPE= "NICKEL";
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

    private final int value = 25;
    private final long weight = ModelValues.NICKEL_WEIGHT ;
    private final long size = ModelValues.NICKEL_SIZE;

}
