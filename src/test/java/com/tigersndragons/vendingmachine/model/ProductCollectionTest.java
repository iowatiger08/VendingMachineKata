package com.tigersndragons.vendingmachine.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by user on 6/8/16.
 */
public class ProductCollectionTest {

    ProductCollection productCollection;

    @Test
    public void ProductCollectionIsEmpty(){
        productCollection = new ProductCollection();
        assertThat(productCollection.isEmpty(), is (Boolean.TRUE));
    }
}
