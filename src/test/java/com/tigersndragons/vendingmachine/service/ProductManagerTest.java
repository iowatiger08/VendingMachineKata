package com.tigersndragons.vendingmachine.service;

import com.tigersndragons.vendingmachine.model.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.*;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by tdillon-hansen on 6/7/16.
 */
public class ProductManagerTest {

    private ProductManager productManager;

    @InjectMocks
    CoinManager coinManager;

    @Before
    public void setUp(){
        productManager = new ProductManager();
        coinManager = mock (CoinManager.class);
    }

    @Test
    public void testProductServiceReturnsProductCollection(){
        assertThat(productManager.getProducts(), instanceOf( ProductCollection.class) );
    }


    @Test
    public void ProductServiceGetsBagofChipsForChipPrice(){

        when (coinManager.coinCollectionForPurchaseValue()).thenReturn(50);
       // coinManager.receiveCoinsForPurchase(new Dime());
        /*
        Given coins = 5 dimes
        select chips
        and display thank you
         */
        assertThat(productManager.processChips(), is(ModelValues.THANKYOU));
    }
    @Test
    public void ProductServiceGetsCandyForCandyPrice(){

        when (coinManager.coinCollectionForPurchaseValue()).thenReturn(65);
        /*
        Given coins = 13 nickels
        user select candy
         */
        assertThat( productManager.processCandy(), is(ModelValues.THANKYOU));
    }
    @Test
    public void ProductServiceGetsColaForColaPrice(){

        when (coinManager.coinCollectionForPurchaseValue()).thenReturn(100);
        /*
        Given coins = 3 Quarters, 5 nickels
        user select cola
         */
        assertThat( productManager.processCola(), is(ModelValues.THANKYOU));
    }

    @Test
    public void ProductServiceGetsBagofChipsForLessChipPrice(){
        when (coinManager.coinCollectionForPurchaseValue()).thenReturn(40);
        /*
        Given coins = 4 dimes
        user select chips
         */
        assertThat( productManager.processChips(), is (ModelValues.NOTENOUGH));
    }
    @Test
    public void ProductServiceGetsCandyForLessCandyPrice(){
        when (coinManager.coinCollectionForPurchaseValue()).thenReturn(60);
        /*
        Given coins = 12 nickels
        user select candy
         */
        assertThat( productManager.processCandy(), is (ModelValues.NOTENOUGH));
    }
    @Test
    public void ProductServiceGetsColaForLessThanColaPrice(){
        when (coinManager.coinCollectionForPurchaseValue()).thenReturn(75);
        /*
        Given coins = 2 Quarters, 5 nickels
        user select cola
         */
        assertThat( productManager.processCola(), is (ModelValues.NOTENOUGH));
    }
/*

    public static final int CHIPS_PRICE =50;
    public static final int COLA_PRICE=100;
    public static final int CANDY_PRICE=65;
 */
    @Test
    public void ProductServiceGetsBagofChipsForChipPricewith5Left(){

        when (coinManager.coinCollectionForPurchaseValue()).thenReturn(75);
        getProductCollectionWith(6, ModelValues.CHIPS_TYPE);
        /*
        Given coins = 2 Quarters and 6 bags
        user select chips
        there are 5 bags of chips left in vending
         */
        //assertThat(  productManager.processChips(), is (ModelValues.THANKYOU));
        assertThat( productManager.getChipCount() , is (5));
    }

    private ProductCollection getProductCollectionWith(int amount, String productType) {

        ProductCollection productCollection = new ProductCollection();
        return productCollection;
    }

    @Test
    public void ProductServiceGetsCandyForCandyPrice5Left(){
                /*
        Given coins = 2 Quarters, 1 dime, 1 nickel and 6 candy
        user select candy
        there are 5 candy left in vending
         */
       // assertThat( productManager.processCandy(), is (ModelValues.THANKYOU);
        assertThat( productManager.getCandyCount() , is (5));
    }
    @Test
    public void ProductServiceGetsColaForColaPrice5Left(){
        /*
        Given coins = 2 Quarters, 5 dimes and 6 cola
        user select cola
        there are 5 cola left in vending
         */
        //assertThat( productManager.processCola() , is (ModelValues.THANKYOU);
         assertThat( productManager.getColaCount() , is (5));
    }
    @Test
    public void ProductServiceGetsBagofChipsForChipPriceWithExtraChange(){
        /*
        Given coins = 2 Quarters, 1 dimes
        user select chips
        and returns 1 dime
         */
        assertThat(  productManager.processChips(), is (ModelValues.CHANGERETURNED) );
    }
    @Test
    public void ProductServiceGetsCandyForCandyPriceWithExtraChange(){
        /*
        Given coins = 2 Quarters, 4 nickels
        user select candy
        and returns 1 nickel
         */
        assertThat( productManager.processCandy(), is (ModelValues.CHANGERETURNED));
    }
    @Test
    public void ProductServiceGetsColaForColaPriceWithExtraChange(){
        /*
        Given coins = 5 Quarters
        user select cola
        and returns 1 quarter
         */
        assertThat( productManager.processCola(), is (ModelValues.CHANGERETURNED));
    }
}
