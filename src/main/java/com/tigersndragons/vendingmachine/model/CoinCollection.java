package com.tigersndragons.vendingmachine.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by tdillon-hansen on 6/7/16.
 */
public class CoinCollection {

    HashMap<Coin, Integer> mapOfCoins ;//= new HashMap<Coin, Integer>();

    public CoinCollection(){
        mapOfCoins = new HashMap<Coin, Integer>();
    }

    public boolean isEmpty() {
        return mapOfCoins.isEmpty();
    }
}
