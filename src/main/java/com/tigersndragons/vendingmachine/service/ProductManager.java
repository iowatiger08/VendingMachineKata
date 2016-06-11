package com.tigersndragons.vendingmachine.service;

import com.tigersndragons.vendingmachine.model.ModelValues;
import com.tigersndragons.vendingmachine.model.ProductCollection;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tdillon-hansen on 6/7/16.
 */
public class ProductManager {

    @Autowired
    CoinManager coinManager;
    private ProductCollection productCollection;

    public ProductManager(){
        productCollection = new ProductCollection();
    }

    public void setCoinManager(CoinManager aCoinManager){
        coinManager = aCoinManager;
    }

    public ProductCollection getProducts() {
        return productCollection;
    }

    public String processCola() {
        if (coinManager.coinCollectionForPurchaseValue()< ModelValues.COLA_PRICE){
            return ModelValues.NOTENOUGH;
        }else if (coinManager.coinCollectionForPurchaseValue() == ModelValues.COLA_PRICE){
            productCollection.removeCola(1);
            return ModelValues.THANKYOU;
        }else{
            return ModelValues.CHANGERETURNED;
        }
    }

    public String processChips() {
        if (coinManager.coinCollectionForPurchaseValue()< ModelValues.CHIPS_PRICE){
            return ModelValues.NOTENOUGH;
        }else if (coinManager.coinCollectionForPurchaseValue() == ModelValues.CHIPS_PRICE){
            productCollection.removeChips(1);
            return ModelValues.THANKYOU;
        }else{
            return ModelValues.CHANGERETURNED;
        }
    }

    public String processCandy() {
        System.out.println("coinManager.coinCollectionForPurchaseValue() "+coinManager.coinCollectionForPurchaseValue());
        if (coinManager.coinCollectionForPurchaseValue()< ModelValues.CANDY_PRICE){
            return ModelValues.NOTENOUGH;
        }else if (coinManager.coinCollectionForPurchaseValue() == ModelValues.CANDY_PRICE){
            productCollection.removeCandy(1);
            return ModelValues.THANKYOU;
        }else{
            return ModelValues.CHANGERETURNED;
        }
    }

    public int getChipCount() {
        return productCollection.getChipsCount();
    }

    public int getCandyCount() {
        return productCollection.getCandyCount();
    }

    public int getColaCount() {
        return productCollection.getColaCount();
    }

    public void addToProductCollectionWith(int amount, String productType) {
        if (productCollection == null){

             productCollection = new ProductCollection();
        }
        if (productType.equals(ModelValues.CANDY_TYPE)){
            productCollection.addCandy(amount);

        }else if (productType.equals(ModelValues.CHIPS_TYPE)) {
            productCollection.addChips(amount);
        }else if (productType.equals(ModelValues.COLA_TYPE)) {
            productCollection.addCola(amount);
        }
    }

    public void clearProducts() {
        productCollection.clear();
    }
}
