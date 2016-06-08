package com.tigersndragons.vendingmachine.model;

/**
 * Created by tdillon-hansen on 6/7/16.
 */
public class Quarter extends Coin {


    public final static String TYPE = "QUARTER";
    private final int value = 25;
    private final long weight = ModelValues.QUARTER_WEIGHT;
    private final long size = ModelValues.QUARTER_SIZE;

    @Override
    public String type() {
        return TYPE;
    }

    public Quarter() {
        super();
    }

    public int getValue() {
        return value;
    }

    public long size() {
        return ModelValues.QUARTER_SIZE;
    }

    @Override
    public int value() {
        return value;
    }

    public long weight() {
        return ModelValues.QUARTER_WEIGHT;
    }
}
