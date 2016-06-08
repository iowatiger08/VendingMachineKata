package com.tigersndragons.vendingmachine.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by tdillon-Hansen on 6/8/16.
 */
public class QuarterTest {

    @Test
    public void testQuarterType(){
        Quarter aQuarter = new Quarter();
        assertThat(aQuarter.type(), is("QUARTER"));
    }

    @Test
    public void testQuarterSize(){
        Quarter aQuarter = new Quarter();
        assertThat(aQuarter.size(), is(ModelValues.QUARTER_SIZE));
    }

    @Test
    public void testQuarterWeight(){
        Quarter aQuarter = new Quarter();
        assertThat(aQuarter.weight(), is(ModelValues.QUARTER_WEIGHT));
    }
}