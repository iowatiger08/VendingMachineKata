package com.tigersndragons.vendingmachine.service;

import com.tigersndragons.vendingmachine.model.*;

/**
 * Created by tdillon-hansen 
 */
 public class CoinManager {
    //@Autowired
    private CoinCollection coinCollectionInBag;

    private CoinCollection coinCollectionForPurchase;

    public CoinManager(){
        initCoinCollectionForBag();
        initCoinCollectionForPurchase();
    }


    public Coin  recieve(long weight, long size){
        if (size== ModelValues.PENNY_WEIGHT
                || weight ==ModelValues.PENNY_WEIGHT){
            throw new IllegalArgumentException("Does not accept penny");
        }

        if (size == ModelValues.QUARTER_SIZE
                && weight == ModelValues.QUARTER_WEIGHT){
            coinCollectionInBag.addQuarter(1);
            coinCollectionForPurchase.addQuarter(1);
            return new Quarter();
        }

        if (size == ModelValues.NICKEL_SIZE
                && weight == ModelValues.NICKEL_WEIGHT){
            coinCollectionInBag.addNickel(1);
            coinCollectionForPurchase.addNickel(1);
            return new Nickel();
        }

        if (size == ModelValues.DIME_SIZE
                && weight == ModelValues.DIME_WEIGHT){
            coinCollectionInBag.addDime(1);
            coinCollectionForPurchase.addDime(1);
            return new Dime();
        }

        return null;
    }
    private void initCoinCollectionForPurchase(){
        if (coinCollectionForPurchase == null){
            coinCollectionForPurchase = new CoinCollection();
        }
    }
    private void initCoinCollectionForBag(){
        if (coinCollectionInBag == null){
            coinCollectionInBag = new CoinCollection();
        }
    }

    public Coin recieve (Coin aCoin){
        if (coinCollectionInBag == null){
            initCoinCollectionForBag();
            initCoinCollectionForPurchase();
        }
        return recieve(aCoin.weight(),aCoin.size());
    }

    public void resetCoinCollectionBag(){
        coinCollectionInBag.clear();
    }

    public void clearCoinCollectionForPurchase() {

        coinCollectionForPurchase.clear();
    }

    public int coinCollectionForPurchaseValue() {
        return  coinCollectionForPurchase.value();
    }

    public int coinCollectionInBagValue() {
        return coinCollectionInBag.value();
    }

    public void eject() {
        clearCoinCollectionForPurchase();
    }
}
