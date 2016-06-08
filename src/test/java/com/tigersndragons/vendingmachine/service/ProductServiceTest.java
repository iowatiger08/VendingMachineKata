package com.tigersndragons.vendingmachine.service;

import com.tigersndragons.vendingmachine.NotEnoughToPurhaseException;
import com.tigersndragons.vendingmachine.model.ProductCollection;
import com.tigersndragons.vendingmachine.service.ProductService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.*;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.isA;

/**
 * Created by tdillon-hansen on 6/7/16.
 */
public class ProductServiceTest {

    private ProductService productService;

    @Before
    public void setUp(){
        productService = new ProductService();
    }

    @Test
    public void testProductServiceReturnsProductCollection(){
        assertThat(productService.getProducts(), instanceOf( ProductCollection.class) );
    }

    @Test
    public void ProductServiceGetsBagofChipsForChipPrice(){
        /*
        Given coins = 5 dimes
        select chips
        and display thank you
         */
        productService.getBagOfChips();
    }
    @Test
    public void ProductServiceGetsCandyForCandyPrice(){
        /*
        Given coins = 13 nickels
        user select candy
         */
        productService.getCandy();
    }
    @Test
    public void ProductServiceGetsColaForColaPrice(){
        /*
        Given coins = 3 Quarters, 5 nickels
        user select cola
         */
        productService.getCola();
    }

    @Test(expected = NotEnoughToPurhaseException.class)
    public void ProductServiceGetsBagofChipsForLessChipPrice(){
        /*
        Given coins = 4 dimes
        user select chips
         */
        productService.getBagOfChips();
    }
    @Test(expected = NotEnoughToPurhaseException.class)
    public void ProductServiceGetsCandyForLessCandyPrice(){
        /*
        Given coins = 12 nickels
        user select candy
         */
        productService.getCandy();
    }
    @Test(expected = NotEnoughToPurhaseException.class)
    public void ProductServiceGetsColaForLessThanColaPrice(){
        /*
        Given coins = 2 Quarters, 5 nickels
        user select cola
         */
        productService.getCola();
    }
/*

    public static final int CHIPS_PRICE =50;
    public static final int COLA_PRICE=100;
    public static final int CANDY_PRICE=65;
 */
    @Test
    public void ProductServiceGetsBagofChipsForChipPricewith5Left(){
        /*
        Given coins = 2 Quarters
        user select chips
        there are 5 bags of chips left in vending
         */
        productService.getBagOfChips();
    }
    @Test
    public void ProductServiceGetsCandyForCandyPrice5Left(){
                /*
        Given coins = 2 Quarters, 1 dime, 1 nickel
        user select candy
        there are 5 candy left in vending
         */
        productService.getCandy();
    }
    @Test
    public void ProductServiceGetsColaForColaPrice5Left(){
        /*
        Given coins = 2 Quarters, 5 dimes
        user select cola
        there are 5 cola left in vending
         */
        productService.getCola();
    }
    @Test
    public void ProductServiceGetsBagofChipsForChipPriceWithExtraChange(){
        /*
        Given coins = 2 Quarters, 1 dimes
        user select chips
        and returns 1 dime
         */
        productService.getBagOfChips();
    }
    @Test
    public void ProductServiceGetsCandyForCandyPriceWithExtraChange(){
        /*
        Given coins = 2 Quarters, 4 nickels
        user select candy
        and returns 1 nickel
         */
        productService.getCandy();
    }
    @Test
    public void ProductServiceGetsColaForColaPriceWithExtraChange(){
        /*
        Given coins = 5 Quarters
        user select cola
        and returns 1 quarter
         */
        productService.getCola();
    }
}
