package com.tigersndragons.vendingmachine.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tdillon-hansen on 6/7/16.
 */
public class CoinCollection {

    private static final String NICKEL = "NICKEL";
    private static final String DIME = "DIME";
    private static final String QUARTER = "QUARTER";
    Map<String, Integer> mapOfCoins;//= new HashMap<Coin, Integer>();

    public CoinCollection() {
        init();
    }

    private void init() {
        mapOfCoins = new HashMap<>();
        mapOfCoins.put(DIME, 0);
        mapOfCoins.put(NICKEL, 0);
        mapOfCoins.put(QUARTER, 0);
    }

    public boolean isEmpty() {

        return mapOfCoins.isEmpty()
                || size() == 0;
    }

    public void addDime(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("can not add negative dimes");
        }

        Integer prevValue = getNumberOfDimes();
        mapOfCoins.put(DIME, prevValue + amount);

    }

    public void addNickel(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("can not add negative dimes");
        }

        Integer prevValue = getNumberOfNickels();
        mapOfCoins.put(NICKEL, prevValue + amount);

    }

    public int value() {
        int valueOfDimes = getNumberOfDimes() * 10;
        int valueOfNickels = getNumberOfNickels() * 5;
        int valueOfQuarters = getNumberOfQuarters() * 25;
        return valueOfDimes + valueOfNickels + valueOfQuarters;
    }

    public int size() {
        return getNumberOfDimes() + getNumberOfNickels() + getNumberOfQuarters();
    }

    public void addQuarter(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("can not add negative dimes");
        }

        Integer prevValue = getNumberOfQuarters();
        mapOfCoins.put(QUARTER, prevValue + amount);

    }

    public void removeDime(int amount) {

        if (amount < 0
                || getNumberOfDimes() == 0
                || getNumberOfDimes() < amount
                ) {
            throw new IllegalArgumentException("negative values not allowed");

        } else {
            Integer prevValue = getNumberOfDimes();
            mapOfCoins.put(DIME, prevValue - amount);
        }
    }

    public void removeQuarter(int amount) {
        if (amount < 0
                || getNumberOfQuarters() == 0
                || getNumberOfQuarters() < amount
                ) {
            throw new IllegalArgumentException("negative values not allowed");

        } else {
            Integer prevValue = getNumberOfQuarters();
            mapOfCoins.put(QUARTER, prevValue - amount);
        }
    }

    public void removeNickel(int amount) {
        if (amount < 0
                || getNumberOfNickels() == 0
                || getNumberOfNickels() < amount
                ) {
            throw new IllegalArgumentException("negative values not allowed");

        } else {
            Integer prevValue = getNumberOfNickels();
            mapOfCoins.put(NICKEL, prevValue - amount);
        }
    }

    public int getNumberOfNickels() {
        return mapOfCoins.get(NICKEL).intValue();
    }

    public int getNumberOfDimes() {
        return mapOfCoins.get(DIME).intValue();
    }

    public int getNumberOfQuarters() {
        return mapOfCoins.get(QUARTER).intValue();
    }

    public void clear() {
        mapOfCoins.clear();
        init();
    }
}
