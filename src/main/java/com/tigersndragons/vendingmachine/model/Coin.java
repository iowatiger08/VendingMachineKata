package com.tigersndragons.vendingmachine.model;

/**
 * Created by tdillon-hansen
 */
public abstract class Coin {
    public abstract String type();
    private long weight;
    private long size;
    private int value;

    public Coin (){ }

    public abstract long weight() ;

    public abstract long size() ;

    public abstract int value() ;

}
