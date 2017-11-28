package com.tigersndragons.vendingmachine;

import com.tigersndragons.vendingmachine.service.CoinManager;
import com.tigersndragons.vendingmachine.service.ProductManager;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.Errors;

//import java.util.Optional;

import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by tdillon-hansen
 */
public class VendingControllerTest {

    @InjectMocks
    VendingController vendingController;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    MockMvc mockMvc;

    @Before
    public void setUpMockMvc() {
        mockMvc = standaloneSetup(vendingController).build();
    }
    @InjectMocks
    CoinManager coinManager;
    @InjectMocks
    ProductManager productManager;

    @Before
    public void setUp(){

        coinManager = mock (CoinManager.class);
        productManager = mock(ProductManager.class);
    }
    /**
     * as a user I enter coins and coin manger shows value
     */
    @Test
    public void testUserEntersCoinsSeesValueReturnedwithEject(){
        // mock coinManager.coinCollectionForPurchaseValue() ==25
        MoneyRequest moneyRequest = new MoneyRequest (Quarter);
        IResult result =vendingController.Post(moneyRequest);
        assertThat(result.getTenderValue(), is (25).toString());

    }
    /**
     * as a user I enter not enough coins for purchase get warning result
     */
    @Test
    public void testUserEntersNotEnoughCoinsToShowProductsAvailable(){

        MoneyRequest moneyRequest = new MoneyRequest (Quarter);
        // mock productManager.GetProductsForValue(25) == Result.Message =NotEnoughToPurchase
        IResult result =vendingController.Post(moneyRequest);

        assertThat(result.getMessage(), Is.is(NotEnoughToPurchase));
    }
    /**
     * as a user I enter coins for Chips and  select
     */
    @Test
    public void testUserEntersEnoughForChips(){

    }
    /**
     * as a user I enter coins for candy
     */
    @Test
    public void testUserEntersEnoughForCandy(){

    }
    /**
     * as a user I enter coins for drink
     */
    @Test
    public void testUserEntersEnoughForDrink(){

    }
    /**
     * as a user I enter coins , select product but have remainder
     */
    @Test
    public void testUserSelectsChipsHasRemainder(){

    }
    /**
     * as a user I enter coins , select product but have remainder
     */
    @Test
    public void testUserSelectsCandyHasRemainder(){

    }
    /**
     * as a user I enter coins , select product but have remainder
     */
    @Test
    public void testUserSelectsDrinkHasRemainder(){

    }
}
