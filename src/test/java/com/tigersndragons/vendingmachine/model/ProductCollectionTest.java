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

    @Test(expected = IllegalArgumentException.class)
    public void ProductCollectionThrowsErrorWithNegativeChips(){
        productCollection = new ProductCollection();
        productCollection     .addChips(-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void ProductCollectionThrowsErrorWithNegativeCola(){
        productCollection = new ProductCollection();
        productCollection     .addCola(-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void ProductCollectionThrowsErrorWithNegativeCandy(){
        productCollection = new ProductCollection();
        productCollection     .addCandy(-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void ProductCollectionThrowsErrorWithNegativeChipsRemove(){
        productCollection = new ProductCollection();
        productCollection     .removeChips(-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void ProductCollectionThrowsErrorWithNegativeColaRemove(){
        productCollection = new ProductCollection();
        productCollection     .removeCola(-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void ProductCollectionThrowsErrorWithNegativeCandyRemove(){
        productCollection = new ProductCollection();
        productCollection     .removeCandy(-1);
    }
    private ProductCollection fillCollection(int size, String type){

        productCollection = new ProductCollection();
       // if type.equals("ALL")
        productCollection.addChips(size);
        productCollection.addCola(size);
        productCollection.addCandy(size);

        return productCollection;

    }
    @Test
    public void ProductCollectionAddChips(){
        productCollection = new ProductCollection();
        productCollection.addChips(1);
        assertThat(productCollection.size(), is (1));
    }

    @Test
    public void ProductCollectionAddCola(){
        productCollection = new ProductCollection();
        productCollection.addCola(1);
        assertThat(productCollection.size(), is (1));
    }

    @Test
    public void ProductCollectionAddCandy(){
        productCollection = new ProductCollection();
        productCollection.addCandy(1);
        assertThat(productCollection.size(), is (1));
    }

    @Test
    public void ProductCollectionRemoveCandy(){
        productCollection = new ProductCollection();
        productCollection.addCandy(1);
        productCollection.removeCandy(1);
        assertThat(productCollection.size(), is (0));
    }

    @Test
    public void ProductCollectionRemoveCola(){
        productCollection = new ProductCollection();
        productCollection.addCola(1);
        productCollection.removeCola(1);
        assertThat(productCollection.size(), is (0));
    }
    @Test
    public void ProductCollectionRemoveChips(){
        productCollection = new ProductCollection();
        productCollection.addChips(1);
        productCollection.removeChips(1);
        assertThat(productCollection.size(), is (0));
    }


}
