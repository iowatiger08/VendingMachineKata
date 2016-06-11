package com.tigersndragons.vendingmachine.service;

import com.tigersndragons.vendingmachine.model.ModelValues;
import com.tigersndragons.vendingmachine.model.ProductCollection;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static com.tigersndragons.vendingmachine.model.ModelValues.CANDY_PRICE;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
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
        coinManager = mock (CoinManager.class);
        productManager = new ProductManager();
        productManager.setCoinManager(coinManager);
    }

    @Test
    public void testProductServiceReturnsProductCollection(){
        assertThat(productManager.getProducts(), instanceOf( ProductCollection.class) );
    }

    @Test
    public void AddChipsToProductCollection(){
        productManager.addToProductCollectionWith(2,ModelValues.CHIPS_TYPE);
        assertThat(productManager.getChipCount(), is (2));
    }
    @Test
    public void AddColaToProductCollection(){
        productManager.addToProductCollectionWith(3,ModelValues.COLA_TYPE);
        assertThat(productManager.getColaCount(), is (3));
    }
    @Test
    public void AddCandyToProductCollection(){
        productManager.addToProductCollectionWith(4,ModelValues.CANDY_TYPE);
        assertThat(productManager.getCandyCount(), is (4));
    }

    @Test
    public void ClearProductCollectionisZeroCount(){
        productManager.addToProductCollectionWith(3,ModelValues.CANDY_TYPE);
        productManager.addToProductCollectionWith(3,ModelValues.COLA_TYPE);
        productManager.addToProductCollectionWith(3,ModelValues.CHIPS_TYPE);
        productManager.clearProducts();
        assertThat(productManager.getCandyCount(), is (0));
        assertThat(productManager.getColaCount(), is (0));
        assertThat(productManager.getChipCount(), is (0));
    }

    @Test
    public void ProductServiceGetsBagofChipsForChipPrice(){
        /*
        Given coins = 5 dimes
        select chips
        and display thank you
         */
        productManager.addToProductCollectionWith(1, ModelValues.CHIPS_TYPE);
        when (coinManager.coinCollectionForPurchaseValue()).thenReturn(ModelValues.CHIPS_PRICE);
        assertThat(productManager.processChips(), is(ModelValues.THANKYOU));
    }
    @Test
    public void ProductServiceGetsCandyForCandyPrice(){
        /*
        Given coins = 13 nickels
        user select candy
         */
        productManager.addToProductCollectionWith(1, ModelValues.CANDY_TYPE);

        when (coinManager.coinCollectionForPurchaseValue()).thenReturn(CANDY_PRICE);
        assertThat( productManager.processCandy(), is(ModelValues.THANKYOU));
    }
    @Test
    public void ProductServiceGetsColaForColaPrice(){
        /*
        Given coins = 3 Quarters, 5 nickels
        user select cola
         */
        productManager.addToProductCollectionWith(6, ModelValues.COLA_TYPE);

        when (coinManager.coinCollectionForPurchaseValue()).thenReturn(ModelValues.COLA_PRICE);
        assertThat( productManager.processCola(), is(ModelValues.THANKYOU));
    }

    @Test
    public void ProductServiceGetsBagofChipsForLessChipPrice(){
        /*
        Given coins = 4 dimes
        user select chips
         */
        when (coinManager.coinCollectionForPurchaseValue()).thenReturn(40);
        assertThat( productManager.processChips(), is (ModelValues.NOTENOUGH));
    }
    @Test
    public void ProductServiceGetsCandyForLessCandyPrice(){
        /*
        Given coins = 12 nickels
        user select candy
         */
        when (coinManager.coinCollectionForPurchaseValue()).thenReturn(60);
        assertThat( productManager.processCandy(), is (ModelValues.NOTENOUGH));
    }
    @Test
    public void ProductServiceGetsColaForLessThanColaPrice(){
        /*
        Given coins = 2 Quarters, 5 nickels
        user select cola
         */
        when (coinManager.coinCollectionForPurchaseValue()).thenReturn(75);
        assertThat( productManager.processCola(), is (ModelValues.NOTENOUGH));
    }
/*

    public static final int CHIPS_PRICE =50;
    public static final int COLA_PRICE=100;
    public static final int CANDY_PRICE=65;
 */
    @Test
    public void ProductServiceGetsBagofChipsForChipPricewith5Left(){
        /*
        Given coins = 2 Quarters and 6 bags
        user select chips
        there are 5 bags of chips left in vending
         */
        when (coinManager.coinCollectionForPurchaseValue()).thenReturn(ModelValues.CHIPS_PRICE);
        productManager.addToProductCollectionWith(6, ModelValues.CHIPS_TYPE);
        productManager.processChips();
        assertThat( productManager.getChipCount() , is (5));
    }



    @Test
    public void ProductServiceGetsCandyForCandyPrice5Left(){
                /*
        Given coins = 2 Quarters, 1 dime, 1 nickel and 6 candy
        user select candy
        there are 5 candy left in vending
         */
        when (coinManager.coinCollectionForPurchaseValue()).thenReturn(CANDY_PRICE);
        productManager.addToProductCollectionWith(6, ModelValues.CANDY_TYPE);
        productManager.processCandy();
        assertThat( productManager.getCandyCount() , is (5));
    }
    @Test
    public void ProductServiceGetsColaForColaPrice5Left(){

        /*
        Given coins = 2 Quarters, 5 dimes and 6 cola
        user select cola
        there are 5 cola left in vending
         */
        when (coinManager.coinCollectionForPurchaseValue()).thenReturn(ModelValues.COLA_PRICE);
        productManager.addToProductCollectionWith(6, ModelValues.COLA_TYPE);
        productManager.processCola();
        assertThat( productManager.getColaCount() , is (5));
    }
    @Test
    public void ProductServiceGetsBagofChipsForChipPriceWithExtraChange(){

        /*
        Given coins = 2 Quarters, 1 dimes
        user select chips
        and returns 1 dime
         */
        when (coinManager.coinCollectionForPurchaseValue()).thenReturn(ModelValues.CHIPS_PRICE+10);
        productManager.addToProductCollectionWith(6, ModelValues.CHIPS_TYPE);
        assertThat(  productManager.processChips(), is (ModelValues.CHANGERETURNED) );
    }
    @Test
    public void ProductServiceGetsCandyForCandyPriceWithExtraChange(){
        /*
        Given coins = 2 Quarters, 4 nickels
        user select candy
        and returns 1 nickel
         */
        when (coinManager.coinCollectionForPurchaseValue()).thenReturn(CANDY_PRICE+20);
        productManager.addToProductCollectionWith(6, ModelValues.CANDY_TYPE);
        assertThat( productManager.processCandy(), is (ModelValues.CHANGERETURNED));
    }
    @Test
    public void ProductServiceGetsColaForColaPriceWithExtraChange(){
        /*
        Given coins = 5 Quarters
        user select cola
        and returns 1 quarter
         */
        when (coinManager.coinCollectionForPurchaseValue()).thenReturn(ModelValues.COLA_PRICE+25);
        productManager.addToProductCollectionWith(6, ModelValues.COLA_TYPE);
        assertThat( productManager.processCola(), is (ModelValues.CHANGERETURNED));
    }
}
