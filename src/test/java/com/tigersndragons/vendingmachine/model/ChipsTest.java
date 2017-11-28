package com.tigersndragons.vendingmachine.model;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 */
public class ChipsTest {

    @Test
    public void TestChipsType(){
        Chips chips = new Chips();
        assertThat(chips.type(), is (ModelValues.CHIPS_TYPE));
    }

    @Test
    public void TestChipsPrice(){
        Chips chips = new Chips();
        assertThat(chips.price(), is(ModelValues.CHIPS_PRICE));
    }
}