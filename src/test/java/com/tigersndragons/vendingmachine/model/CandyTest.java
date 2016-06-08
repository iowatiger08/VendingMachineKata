package com.tigersndragons.vendingmachine.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by tdillon-hansen on 6/8/16.
 */
public class CandyTest {
    Candy candy;
    @Before
    public void setUp() throws Exception {
    candy = new Candy();
    }

    @Test
    public void TestCandyPrice(){
        assertThat (candy.price(), is (ModelValues.CANDY_PRICE));
    }

    @Test
    public void TestCandyType(){
        assertThat(candy.type(), is(ModelValues.CANDY_TYPE));

    }


}