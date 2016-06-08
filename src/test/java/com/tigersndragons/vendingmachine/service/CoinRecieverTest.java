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
 * Created by tdillon-hansen on 6/7/16.
 */
public class CoinRecieverTest {


    private CoinReciever coinReciever;

    @Before
    public void setUp(){
        coinReciever = new CoinReciever();
    }
    @Test
    public void TestCoinAnalyerReturnsNullOnNegativeInput(){
        long weight=-1L;
        long size=-1L;
        assertThat (coinReciever.recieve(weight,size), nullValue() );
    }
    @Test
    public void TestCoinAnalyerTakesACoinWithWeightandSize(){
        long weight=4L;
        long size=4L;
        assertThat (coinReciever.recieve(weight,size), any(Coin.class));
    }

    @Test(expected=IllegalArgumentException.class)
    public void TestCoinAnalyzerRejectsPenny(){
        Penny aPenny = new Penny();
        coinReciever.recieve(aPenny);
    }

    @Test
    public void TestCoinAnalyzerAcceptsQuarter(){
        Quarter aCoin = new Quarter();
        assertThat (coinReciever.recieve(aCoin).type(), is(aCoin.type()));
    }

    @Test
    public void TestCoinAnalyzerAcceptsDime(){
        Dime aCoin = new Dime();
        assertThat (coinReciever.recieve(aCoin).type(), is(aCoin.type()));
    }

    @Test
    public void TestCoinAnalyzerAcceptsNickel(){

        Nickel aNickel = new Nickel();
        assertThat (coinReciever.recieve(aNickel).type(), is(aNickel.type()));
    }

    @Test
    public void CoinRecieverPutsOneCoinEachInCollection(){

    }
}
