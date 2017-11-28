package com.tigersndragons.vendingmachine.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tdillon-hansen
 */
public class ProductCollection {

    private Map<String, Integer> mapOfProducts;

    public ProductCollection(){
        init();
    }

    private void init(){
        mapOfProducts = new HashMap<>();
        mapOfProducts.put(ModelValues.CHIPS_TYPE,0);
        mapOfProducts.put(ModelValues.COLA_TYPE,0);
        mapOfProducts.put(ModelValues.CANDY_TYPE,0);
    }

    public boolean isEmpty() {
        return mapOfProducts.isEmpty()
                || size()==0;
    }

    public void addChips(int size) {
        if (size <=0 ){
            throw new IllegalArgumentException("cannot add none or negative values");
        }
        if (getChipsCount() ==0){
            mapOfProducts.put(ModelValues.CHIPS_TYPE, new Integer(size));

        }else {
            Integer prevValue = getChipsCount();
            mapOfProducts.put(ModelValues.CHIPS_TYPE, prevValue + size);
            // java 8 mapOfProducts.compute(ModelValues.CHIPS_TYPE, ( ModelValues.CHIPS_TYPE, prevValue ) ->
            //        prevValue == null ? size : prevValue + size);

        }

    }

    public void addCola(int size) {
        if (size <=0 ){
            throw new IllegalArgumentException("cannot add none or negative values");
        }
        if (getColaCount() ==0){
            mapOfProducts.put(ModelValues.COLA_TYPE, new Integer(size));

        }else {
            Integer prevValue = getColaCount();
            mapOfProducts.put(ModelValues.COLA_TYPE, prevValue + size);
        }
    }

    public void addCandy(int size) {
        if (size <=0 ){
            throw new IllegalArgumentException("cannot add none or negative values");
        }
        if (getCandyCount()==0){
            mapOfProducts.put(ModelValues.CANDY_TYPE, new Integer(size));

        }else {
            Integer prevValue = getCandyCount();
            mapOfProducts.put(ModelValues.CANDY_TYPE, prevValue + size);
        }
    }

    public int size(){
        return getCandyCount() +getColaCount() +getChipsCount();
    }


    public void removeCandy(int size) {
        if (size <=0 ){
            throw new IllegalArgumentException("zero or negative values not allowed");
        }
        if (getCandyCount()==0
                ||  getCandyCount()<size){
            throw new IllegalArgumentException("negative values not allowed");

        }else {
            Integer prevValue = getCandyCount();
            mapOfProducts.put(ModelValues.CANDY_TYPE, prevValue - size);
        }
    }

    public void removeCola(int size) {
        if (size <=0 ){
            throw new IllegalArgumentException("zero or negative values not allowed");
        }
        if (getColaCount()==0
                || getColaCount()<size ){
            throw new IllegalArgumentException("negative values not allowed");

        }else {
            Integer prevValue = getColaCount();
            mapOfProducts.put(ModelValues.COLA_TYPE, prevValue - size);
        }
    }

    public void removeChips(int size) {
        if (size <=0 ){
            throw new IllegalArgumentException("zero or negative values not allowed");
        }
        if (getChipsCount()==0
                || getChipsCount()<size ){
            throw new IllegalArgumentException("negative values not allowed");

        }else {
            Integer prevValue = getChipsCount();
            mapOfProducts.put(ModelValues.CHIPS_TYPE, prevValue - size);
        }
    }

    public int getChipsCount() {
        return mapOfProducts.get(ModelValues.CHIPS_TYPE);
    }
    public int getCandyCount(){
        return mapOfProducts.get(ModelValues.CANDY_TYPE);
    }
    public int getColaCount(){
        return mapOfProducts.get(ModelValues.COLA_TYPE);
    }

    public void clear() {
        init();
    }
}
