package com.tigersndragons.vendingmachine.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tdillon-hansen on 6/7/16.
 */
public class ProductCollection {

    private final Map<String, Integer> mapOfProducts;

    public ProductCollection(){
        mapOfProducts= new HashMap<>();
    }

    public Map<String, Integer> getMapOfProducts() {
        return mapOfProducts;
    }

//    public void setMapOfProducts(Map<String, Integer> mapOfProducts) {
//        this.mapOfProducts = mapOfProducts;
//    }

    public boolean isEmpty() {
        return mapOfProducts.isEmpty()
                || size()==0;
    }

    public void addChips(int size) {
        if (size <=0 ){
            throw new IllegalArgumentException("cannot add none or negative values");
        }
        if (mapOfProducts.get(ModelValues.CHIPS_TYPE)== null
                || mapOfProducts.get(ModelValues.CHIPS_TYPE).intValue() ==0){
            mapOfProducts.put(ModelValues.CHIPS_TYPE, new Integer(size));

        }else {
            Integer prevValue = mapOfProducts.get(ModelValues.CHIPS_TYPE);
            mapOfProducts.put(ModelValues.CHIPS_TYPE, prevValue + size);
            // java 8 mapOfProducts.compute(ModelValues.CHIPS_TYPE, ( ModelValues.CHIPS_TYPE, prevValue ) ->
            //        prevValue == null ? size : prevValue + size);

        }

    }

    public void addCola(int size) {
        if (size <=0 ){
            throw new IllegalArgumentException("cannot add none or negative values");
        }
        if (mapOfProducts.get(ModelValues.COLA_TYPE)== null
                || mapOfProducts.get(ModelValues.COLA_TYPE).intValue()==0){
            mapOfProducts.put(ModelValues.COLA_TYPE, new Integer(size));

        }else {
            Integer prevValue = mapOfProducts.get(ModelValues.COLA_TYPE);
            mapOfProducts.put(ModelValues.COLA_TYPE, prevValue + size);
        }
    }

    public void addCandy(int size) {
        if (size <=0 ){
            throw new IllegalArgumentException("cannot add none or negative values");
        }
        if (mapOfProducts.get(ModelValues.CANDY_TYPE)== null
                || mapOfProducts.get(ModelValues.CANDY_TYPE).intValue()==0){
            mapOfProducts.put(ModelValues.CANDY_TYPE, new Integer(size));

        }else {
            Integer prevValue = mapOfProducts.get(ModelValues.CANDY_TYPE);
            mapOfProducts.put(ModelValues.CANDY_TYPE, prevValue + size);
        }
    }

    public int size(){
        int numOfCandy = mapOfProducts.get(ModelValues.CANDY_TYPE) ==null? 0:mapOfProducts.get(ModelValues.CANDY_TYPE);
        int numOfCola = mapOfProducts.get(ModelValues.COLA_TYPE) ==null? 0:mapOfProducts.get(ModelValues.COLA_TYPE);
        int numOfChips =mapOfProducts.get(ModelValues.CHIPS_TYPE) ==null? 0:mapOfProducts.get(ModelValues.CHIPS_TYPE);
        return numOfCandy +numOfCola +numOfChips;
    }


    public void removeCandy(int size) {
        if (size <=0 ){
            throw new IllegalArgumentException("zero or negative values not allowed");
        }
        if (mapOfProducts.get(ModelValues.CANDY_TYPE)== null
                || mapOfProducts.get(ModelValues.CANDY_TYPE).intValue()==0
                ||  mapOfProducts.get(ModelValues.CANDY_TYPE).intValue()<size
                ){
            throw new IllegalArgumentException("negative values not allowed");

        }else {
            Integer prevValue = mapOfProducts.get(ModelValues.CANDY_TYPE);
            mapOfProducts.put(ModelValues.CANDY_TYPE, prevValue - size);
        }
    }

    public void removeCola(int size) {
        if (size <=0 ){
            throw new IllegalArgumentException("zero or negative values not allowed");
        }
        if (mapOfProducts.get(ModelValues.COLA_TYPE)== null
                || mapOfProducts.get(ModelValues.COLA_TYPE).intValue()==0
                ||  mapOfProducts.get(ModelValues.COLA_TYPE).intValue()<size
                ){
            throw new IllegalArgumentException("negative values not allowed");

        }else {
            Integer prevValue = mapOfProducts.get(ModelValues.COLA_TYPE);
            mapOfProducts.put(ModelValues.COLA_TYPE, prevValue - size);
        }
    }

    public void removeChips(int size) {
        if (size <=0 ){
            throw new IllegalArgumentException("zero or negative values not allowed");
        }
        if (mapOfProducts.get(ModelValues.CHIPS_TYPE)== null
                || mapOfProducts.get(ModelValues.CHIPS_TYPE).intValue()==0
                ||  mapOfProducts.get(ModelValues.CHIPS_TYPE).intValue()<size
                ){
            throw new IllegalArgumentException("negative values not allowed");

        }else {
            Integer prevValue = mapOfProducts.get(ModelValues.CHIPS_TYPE);
            mapOfProducts.put(ModelValues.CHIPS_TYPE, prevValue - size);
        }
    }
}
