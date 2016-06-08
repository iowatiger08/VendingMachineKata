package com.tigersndragons.vendingmachine.service;

import com.tigersndragons.vendingmachine.model.ProductCollection;
import com.tigersndragons.vendingmachine.service.ProductService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.isA;

/**
 * Created by tdillon-hansen on 6/7/16.
 */
public class ProductServiceTest {

    private ProductService productService;

    @Before
    public void setUp(){
        productService = new ProductService();
    }

    @Test
    public void testProductFactoryReturnsProductCollection(){
//        assertThat(productService.getProducts(), isA( ProductCollection.class) );
    }
}
