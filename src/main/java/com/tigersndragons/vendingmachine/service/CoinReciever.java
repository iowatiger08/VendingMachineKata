package com.tigersndragons.vendingmachine.service;

import com.sun.javaws.exceptions.InvalidArgumentException;
import com.tigersndragons.vendingmachine.model.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tdillon-hansen on 6/7/16.
 */
 public class CoinReciever {
    @Autowired
    CoinCollection coinCollection;

    private CoinCollection coinCollectoionForPurchase;

    public Coin  recieve(long weight, long size){


        if (size== ModelValues.PENNY_WEIGHT
                || weight ==ModelValues.PENNY_WEIGHT){
            throw new IllegalArgumentException("Does not accept penny");
        }

        if (size == ModelValues.QUARTER_SIZE
                && weight == ModelValues.QUARTER_WEIGHT){
            coinCollection.addQuarter(1);
            return new Quarter();
        }

        if (size == ModelValues.NICKEL_SIZE
                && weight == ModelValues.NICKEL_WEIGHT){
            coinCollection.addNickel(1);
            return new Nickel();
        }

        if (size == ModelValues.DIME_SIZE
                && weight == ModelValues.DIME_WEIGHT){
            coinCollection.addDime(1);
            return new Dime();
        }

        return null;
    }
    private void initCoinCollectoionForPurchase(){
        if (coinCollectoionForPurchase == null){
            coinCollectoionForPurchase = new CoinCollection();
        }
    }

    public Coin recieve (Coin aCoin){
        return recieve(aCoin.weight(),aCoin.size());
    }

    public String receiveCoinsForPurchase(Coin aCoin){
  //      coinCollectionForPurchase
  //              = coinReciever.recieve(aCoin);

        return null;

    }

    public void clearCoinCollectionForPurchase() {
    }

    public int coinCollectionForPurchaseValue() {
        return 0;
    }
}
