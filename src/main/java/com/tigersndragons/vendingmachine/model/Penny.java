package com.tigersndragons.vendingmachine.model;

import com.tigersndragons.vendingmachine.model.Coin;
import com.tigersndragons.vendingmachine.model.ModelValues;

import static com.tigersndragons.vendingmachine.model.ModelValues.PENNY_WEIGHT;

/**
 * Created by tdillon-hansen on 6/8/16.
 */
public class Penny extends Coin {

    public static final String TYPE ="PENNY";
    private final int value = 1;
    private final long weight = ModelValues.PENNY_WEIGHT;
    private final long size = ModelValues.PENNY_SIZE;


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
