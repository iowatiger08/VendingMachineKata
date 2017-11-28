package com.tigersndragons.vendingmachine.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by tdillon-Hansen
 */
public class PennyTest {

    @Test
    public void testPennyType(){
        Penny aPenny = new Penny();
        assertThat(aPenny.type(), is("PENNY"));
    }

    @Test
    public void testPennySize(){
        Penny aPenny = new Penny();
        assertThat(aPenny.size(), is(ModelValues.PENNY_SIZE));
    }

    @Test
    public void testPennyWeight(){
        Penny aPenny = new Penny();
        assertThat(aPenny.weight(), is(ModelValues.PENNY_WEIGHT));
    }
}