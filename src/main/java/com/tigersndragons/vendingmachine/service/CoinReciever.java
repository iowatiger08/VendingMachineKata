package com.tigersndragons.vendingmachine.service;

import com.sun.javaws.exceptions.InvalidArgumentException;
import com.tigersndragons.vendingmachine.model.*;

/**
 * Created by tdillon-hansen on 6/7/16.
 */
 public class CoinReciever {

    public Coin  recieve(long weight, long size){


        if (size== ModelValues.PENNY_WEIGHT
                || weight ==ModelValues.PENNY_WEIGHT){
            throw new IllegalArgumentException("Does not accept penny");
        }

        if (size == ModelValues.QUARTER_SIZE
                && weight == ModelValues.QUARTER_WEIGHT){
            return new Quarter();
        }

        if (size == ModelValues.NICKEL_SIZE
                && weight == ModelValues.NICKEL_WEIGHT){
            return new Nickel();
        }

        if (size == ModelValues.DIME_SIZE
                && weight == ModelValues.DIME_WEIGHT){
            return new Dime();
        }

        return null;
    }
}
