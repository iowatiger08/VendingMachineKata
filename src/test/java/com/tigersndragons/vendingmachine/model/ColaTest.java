package com.tigersndragons.vendingmachine.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by tdillon-hansen
 */
public class ColaTest {
    Cola cola;
    @Before
    public void setUp() throws Exception {
        cola = new Cola();
    }

    @Test
    public void TestColaPrice(){
        assertThat (cola.price(), is (ModelValues.COLA_PRICE));
    }

    @Test
    public void TestColaType(){
        assertThat(cola.type(), is(ModelValues.COLA_TYPE));

    }
}