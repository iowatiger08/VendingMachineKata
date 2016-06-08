package com.tigersndragons.vendingmachine.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by tdillon-Hansen on 6/8/16.
 */
public class NickelTest {

    @Test
    public void testNickelType(){
        Nickel aNickel = new Nickel();
        assertThat(aNickel.type(), is("NICKEL"));
    }

    @Test
    public void testNickelSize(){
        Nickel aNickel = new Nickel();
        assertThat(aNickel.size(), is(ModelValues.NICKEL_SIZE));
    }

    @Test
    public void testNickelWeight(){
        Nickel aNickel = new Nickel();
        assertThat(aNickel.weight(), is(ModelValues.NICKEL_WEIGHT));
    }
}