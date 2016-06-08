package com.tigersndragons.vendingmachine.model;

import com.tigersndragons.vendingmachine.model.CoinCollection;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by tdillon-hansen on 6/7/16.
 */
public class CoinCollectionTest {

    CoinCollection coinCollection;

    @Test
    public void CoinCollectorIsEmpty(){
        coinCollection = new CoinCollection();
        assertThat(coinCollection.isEmpty(), is (Boolean.TRUE));
    }
}
