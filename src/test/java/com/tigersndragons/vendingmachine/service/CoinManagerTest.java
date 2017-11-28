package com.tigersndragons.vendingmachine.service;

import com.tigersndragons.vendingmachine.model.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsInstanceOf.any;
import static org.mockito.Matchers.isNull;

/**
 * Created by tdillon-hansen
 */
public class CoinManagerTest {

    private CoinManager coinManager;

    @Before
    public void setUp(){
        coinManager = new CoinManager();
    }
    @Test
    public void TestCoinAnalyerReturnsNullOnNegativeInput(){
        long weight=-1L;
        long size=-1L;
        assertThat (coinManager.recieve(weight,size), nullValue() );
    }
    @Test
    public void TestCoinManagerTakesACoinWithWeightandSize(){
        long weight=4L;
        long size=4L;
        assertThat (coinManager.recieve(weight,size), any(Coin.class));
    }

    @Test(expected=IllegalArgumentException.class)
    public void TestCoinAnalyzerRejectsPenny(){
        Penny aPenny = new Penny();
        coinManager.recieve(aPenny);
    }

    @Test
    public void TestCoinManagerAcceptsQuarter(){
        Quarter aCoin = new Quarter();
        assertThat (coinManager.recieve(aCoin).type(), is(aCoin.type()));
    }

    @Test
    public void TestCoinManagerAcceptsDime(){
        Dime aCoin = new Dime();
        assertThat (coinManager.recieve(aCoin).type(), is(aCoin.type()));
    }

    @Test
    public void TestCoinManagerAcceptsNickel(){
        Nickel aNickel = new Nickel();
        assertThat (coinManager.recieve(aNickel).type(), is(aNickel.type()));
    }

    @Test
    public void CoinManagerPutsOneCoinEachInCollection(){
        coinManager.recieve(new Dime());
        coinManager.recieve(new Nickel());
        coinManager.recieve(new Quarter());
        assertThat (coinManager.coinCollectionForPurchaseValue(), is (40));
    }

    @Test
    public void recieveCoinForPurchaseDime(){
        coinManager.recieve(new Dime());
        assertThat (coinManager.coinCollectionForPurchaseValue(), is (10));
    }

    @Test
    public void recieveCoinForPurchaseNickel(){
        coinManager.recieve(new Nickel());
        assertThat (coinManager.coinCollectionForPurchaseValue(), is (5));
    }
    @Test
    public void recieveCoinForPurchaseQuarter(){
        coinManager.recieve(new Quarter());
        assertThat (coinManager.coinCollectionForPurchaseValue(), is (25));
    }

    @Test
    public void clearCoinCollectionForPurchase(){
        coinManager.recieve(new Quarter());
        coinManager.recieve(new Nickel());
        coinManager.clearCoinCollectionForPurchase();
        assertThat (coinManager.coinCollectionForPurchaseValue(), is (0));
    }

    @Test
    public void resetCoinCollectionBagIsZeroValue(){
        coinManager.recieve(new Dime());
        coinManager.recieve(new Quarter());
        coinManager.recieve(new Nickel());
        coinManager.resetCoinCollectionBag();
        assertThat(coinManager.coinCollectionInBagValue(), is (0));
    }

    @Test
    public void emptyClearsBagValue(){
        coinManager.recieve(new Dime());
        coinManager.recieve(new Quarter());
        coinManager.recieve(new Nickel());
        coinManager.eject();
        assertThat(   coinManager.coinCollectionInBagValue()     , is (0));
    }

}
