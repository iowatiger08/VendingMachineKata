package com.tigersndragons.vendingmachine.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tdillon-hansen on 6/7/16.
 */
public class CoinCollection {

    private static final String NICKEL = "NICKEL";
    private static final String DIME ="DIME";
    private static final String QUARTER = "QUARTER";
    Map<String, Integer> mapOfCoins ;//= new HashMap<Coin, Integer>();

    public CoinCollection(){
        mapOfCoins = new HashMap<>();
    }


    public boolean isEmpty() {

        return mapOfCoins.isEmpty()
                || size()==0;
    }
    public void addDime(int amount) {
        if (amount <0){
            throw new IllegalArgumentException("can not add negative dimes");
        }
        if (mapOfCoins.get(DIME)==null) {
            mapOfCoins.put(DIME, amount);
        }else {
            Integer prevValue =mapOfCoins.get(DIME);
            mapOfCoins.put(DIME,prevValue+amount);
        }
    }

    public void addNickel(int amount) {
        if (amount <0){
            throw new IllegalArgumentException("can not add negative dimes");
        }
        if (mapOfCoins.get(NICKEL)==null) {
            mapOfCoins.put(NICKEL, amount);
        }else {
            Integer prevValue =mapOfCoins.get(NICKEL);
            mapOfCoins.put(NICKEL,prevValue+amount);
        }
    }

    public int value() {
        int valueOfDimes=mapOfCoins.get(DIME)==null?0:mapOfCoins.get(DIME)*10;
        int valueOfNickels =mapOfCoins.get(NICKEL)==null?0:mapOfCoins.get(NICKEL)*5;
        int valueOfQuarters=mapOfCoins.get(QUARTER)==null?0:mapOfCoins.get(QUARTER)*25;
        return valueOfDimes+valueOfNickels+valueOfQuarters;
    }

    public int size() {
        int numOfDimes=mapOfCoins.get(DIME)==null?0:mapOfCoins.get(DIME);
        int numOfNickels =mapOfCoins.get(NICKEL)==null?0:mapOfCoins.get(NICKEL);
        int numOfQuarters=mapOfCoins.get(QUARTER)==null?0:mapOfCoins.get(QUARTER);
        return numOfDimes+numOfNickels+numOfQuarters;
    }

    public void addQuarter(int amount) {
        if (amount <0){
            throw new IllegalArgumentException("can not add negative dimes");
        }
        if (mapOfCoins.get(QUARTER)==null) {
            mapOfCoins.put(QUARTER, amount);
        }else {
            Integer prevValue =mapOfCoins.get(QUARTER);
            mapOfCoins.put(QUARTER,prevValue+amount);
        }
    }

    public void removeDime(int amount) {

        if (amount<0
                || mapOfCoins.get(DIME)== null
                || mapOfCoins.get(DIME).intValue()==0
                ||  mapOfCoins.get(DIME).intValue()<amount
                ){
            throw new IllegalArgumentException("negative values not allowed");

        }else {
            Integer prevValue = mapOfCoins.get(DIME);
            mapOfCoins.put(DIME, prevValue - amount);
        }
    }

    public void removeQuarter(int amount) {
        if (amount<0
                || mapOfCoins.get(QUARTER)== null
                || mapOfCoins.get(QUARTER).intValue()==0
                ||  mapOfCoins.get(QUARTER).intValue()<amount
                ){
            throw new IllegalArgumentException("negative values not allowed");

        }else {
            Integer prevValue = mapOfCoins.get(QUARTER);
            mapOfCoins.put(QUARTER, prevValue - amount);
        }
    }

    public void removeNickel(int amount) {
        if (amount<0
                || mapOfCoins.get(NICKEL)== null
                || mapOfCoins.get(NICKEL).intValue()==0
                ||  mapOfCoins.get(NICKEL).intValue()<amount
                ){
            throw new IllegalArgumentException("negative values not allowed");

        }else {
            Integer prevValue = mapOfCoins.get(NICKEL);
            mapOfCoins.put(NICKEL, prevValue - amount);
        }
    }


}
