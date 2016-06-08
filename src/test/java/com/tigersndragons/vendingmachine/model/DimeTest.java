package com.tigersndragons.vendingmachine.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by tdillon-Hansen on 6/8/16.
 */
public class DimeTest {

    @Test
    public void testDimeType(){
        Dime aDime = new Dime();
        assertThat(aDime.type(), is("DIME"));
    }

    @Test
    public void testDimeSize(){
        Dime aDime = new Dime();
        assertThat(aDime.size(), is(ModelValues.DIME_SIZE));
    }

    @Test
    public void testDimeWeight(){
        Dime aDime = new Dime();
        assertThat(aDime.weight(), is(ModelValues.DIME_WEIGHT));
    }
}