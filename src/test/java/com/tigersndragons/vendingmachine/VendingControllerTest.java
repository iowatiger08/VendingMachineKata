package com.tigersndragons.vendingmachine;

import com.tigersndragons.vendingmachine.DataTransfers.VendingRequest;
import com.tigersndragons.vendingmachine.DataTransfers.VendingResponse;
import com.tigersndragons.vendingmachine.model.*;
import com.tigersndragons.vendingmachine.service.CoinManager;
import com.tigersndragons.vendingmachine.service.ProductManager;
import org.hamcrest.core.Is;
import org.junit.Assert;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
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
     *
    @Test
    public void testUserEntersCoinsSeesValueReturnedwithEject(){
        // mock coinManager.coinCollectionForPurchaseValue() ==25
        MoneyRequest moneyRequest = new MoneyRequest (Quarter);
        IResult result =vendingController.Post(moneyRequest);
        assertThat(result.getTenderValue(), is (25).toString());

    }
    /**
     * as a user I enter not enough coins for purchase get warning result
     *
    @Test
    public void testUserEntersNotEnoughCoinsToShowProductsAvailable(){

        MoneyRequest moneyRequest = new MoneyRequest (Quarter);
        // mock productManager.GetProductsForValue(25) == Result.Message =NotEnoughToPurchase
        IResult result =vendingController.Post(moneyRequest);

        assertThat(result.getMessage(), Is.is(NotEnoughToPurchase));
    }
     */
    /**
     * as a user I see insert coins
     */
    @Test
    public void TestUserSeesInsertCoin()
    {
        ArrayList<Coin> aBagOfCoins = new ArrayList<Coin>();
        VendingRequest request = new VendingRequest();
        request.BagOfCoins = aBagOfCoins;
        VendingResponse result = vendingController.Post(request);
        assertThat(result.Message, Is.is(ModelValues.INSERT_COIN));

    }
    /**
     * as a user I enter coins and coin manger shows value
     */
    @Test
    public void TestUserEntersCoinsSeesValueReturnedwithEject()
    {
        ArrayList<Coin> aBagOfCoins = new ArrayList<Coin>();
        aBagOfCoins.add(new Quarter());
        VendingRequest request = new VendingRequest();
        request.BagOfCoins = aBagOfCoins;

        VendingResponse result = vendingController.Post(request);
        assertThat(result.TenderValue, Is.is(25));

    }

    @Test
    public void TestEjectRequestReturnsCoinsEntered()
    {
        ArrayList<Coin> aBagOfCoins = new ArrayList<Coin>();
        aBagOfCoins.add(new Quarter());

        VendingRequest request = new VendingRequest();
        request.BagOfCoins = aBagOfCoins;

        VendingResponse deposited = vendingController.Post(request);

        VendingRequest secondrequest = new VendingRequest();
        request.BagOfCoins = aBagOfCoins;
        VendingResponse result = vendingController.Post(secondrequest);

        assertThat(result.TenderValue, Is.is(0));
    }

    /**
     * as a user I enter coins for Chips and  select
     */
    @Test
    public void TestUserEntersEnoughForChipsTenderisZero()
    {
        ArrayList<Coin> aBagOfCoins = new ArrayList<Coin>();
        aBagOfCoins.add(new Quarter());
        aBagOfCoins.add(new Quarter());
        //productManager.(m => m.GetProductCount(It.IsAny<Chips>())).Returns(1);

        Map<Coin, Integer> coinBank = new HashMap<Coin, Integer>();
        coinBank.put(new Quarter(), 2);
        //coinManager.Setup(m => m.GetBankOfCoins()).Returns(coinBank);

        VendingRequest request = new VendingRequest();
        request.BagOfCoins = aBagOfCoins;

        VendingResponse deposited = vendingController.Post(request);

        VendingRequest secondrequest = new VendingRequest();
        secondrequest.IsEmpty= false;
        secondrequest.Selection = new Chips().type();

        VendingResponse result = vendingController.Post(secondrequest);

        assertThat(result.TenderValue, Is.is(0));
    }

    /**
     * as a customer I select chips when not available shows sold out
     */
    @Test
    public void TestUserChipsSoldOut()
    {
        List<Coin> aBagOfCoins = new ArrayList<Coin>();
        aBagOfCoins.add(new Quarter());
        aBagOfCoins.add(new Quarter());
        /*productManager.Setup( m => m.GetProductCount(It.IsAny<Chips>())).Returns(0);
        var deposited = vendingController.Post(new VendingRequest()
        {
            BagOfCoins = aBagOfCoins,
        });
        var result = vendingController.Post(new VendingRequest()
        {
            Empty = false,
            Selection = new Chips().Type(),
        });*/
        VendingResponse result = new VendingResponse();
        assertThat(result.Message, Is.is(ModelValues.SOLD_OUT));
    }
    /**
     * as a customer I select chips when not available shows sold out
     */
    @Test
    public void TestUserCandySoldOut()
    {
        List<Coin> aBagOfCoins = new ArrayList<Coin>();
        aBagOfCoins.add(new Quarter());
        aBagOfCoins.add(new Quarter());
        aBagOfCoins.add(new Dime());
        aBagOfCoins.add(new Nickel());
        /*productManager.Setup(m => m.GetProductCount(It.IsAny<Candy>())).Returns(0);
        var deposited = vendingController.Post(new VendingRequest()
        {
            BagOfCoins = aBagOfCoins,
        });
        var result = vendingController.Post(new VendingRequest()
        {
            Empty = false,
            Selection = new Candy().Type(),
        });*/

        VendingResponse result = new VendingResponse();
        assertThat(result.Message, Is.is(ModelValues.SOLD_OUT));
    }
    /**
     * as a customer I select cola when not available shows sold out
     */
    @Test
    public void TestUserColaSoldOut()
    {
        List<Coin> aBagOfCoins = new ArrayList<Coin>();
        aBagOfCoins.add(new Quarter());
        aBagOfCoins.add(new Quarter());
        aBagOfCoins.add(new Quarter());
        aBagOfCoins.add(new Quarter());
        /*productManager.Setup(m => m.GetProductCount(It.IsAny<Cola>())).Returns(0);
        var deposited = vendingController.Post(new VendingRequest()
        {
            BagOfCoins = aBagOfCoins,
        });
        var result = vendingController.Post(new VendingRequest()
        {
            Empty = false,
            Selection = new Cola().Type(),
        });*/

        VendingResponse result = new VendingResponse();
        assertThat(result.Message, Is.is(ModelValues.SOLD_OUT));
    }
    /**
     * as a user I enter coins for Chips and is delivered
     */
    @Test
    public void TestUserEntersEnoughForChips()
    {
        List<Coin> aBagOfCoins = new ArrayList<Coin>();
        aBagOfCoins.add(new Quarter());
        aBagOfCoins.add(new Quarter());
        //productManager.Setup(m => m.GetProductCount(It.IsAny<Chips>())).Returns(1);

        Map<Coin, Integer> coinBank = new HashMap<Coin, Integer>();
        coinBank.put(new Quarter(), 2);
        coinBank.put(new Dime(), 2);
        coinBank.put(new Nickel(), 1);
        /*coinManager.Setup(m => m.GetBankOfCoins()).Returns(coinBank);

        var deposited = vendingController.Post(new VendingRequest()
        {
            BagOfCoins = aBagOfCoins,
        });
        var result = vendingController.Post(new VendingRequest()
        {
            Empty = false,
            Selection = new Chips().Type(),
        });*/
        VendingResponse result = new VendingResponse();
        assertThat(result.Delivery.type(), Is.is(new Chips().type()));
    }
    /**
     * as a user I enter coins for candy and is delivered
     */
    @Test
    public void TestUserEntersEnoughForCandy()
    {
        List<Coin> aBagOfCoins = new ArrayList<Coin>();
        aBagOfCoins.add(new Quarter());
        aBagOfCoins.add(new Quarter());
        aBagOfCoins.add(new Dime());
        aBagOfCoins.add(new Dime());
        aBagOfCoins.add(new Nickel());
        //productManager.Setup(m => m.GetProductCount(It.IsAny<Candy>())).Returns(1);

        Map<Coin, Integer> coinBank = new HashMap<Coin, Integer>();
        coinBank.put(new Quarter(), 2);
        coinBank.put(new Dime(), 2);
        coinBank.put(new Nickel(), 1);
        /*coinManager.Setup(m => m.GetBankOfCoins()).Returns(coinBank);

        var deposited = vendingController.Post(new VendingRequest()
        {
            BagOfCoins = aBagOfCoins,
        });
        var result = vendingController.Post(new VendingRequest()
        {
            Empty = false,
            Selection = new Candy().Type(),
        });*/
        VendingResponse result = new VendingResponse();
        assertThat(result.Delivery.type(), Is.is(new Candy().type()));
    }
    /**
     * as a user I enter coins for drink
     */
    @Test
    public void TestUserEntersEnoughForDrink()
    {
        List<Coin> aBagOfCoins = new ArrayList<Coin>();
        aBagOfCoins.add(new Quarter());
        aBagOfCoins.add(new Quarter());
        aBagOfCoins.add(new Quarter());
        aBagOfCoins.add(new Quarter());
        //productManager.Setup(m => m.GetProductCount(It.IsAny<Cola>())).Returns(1);

        Map<Coin, Integer> coinBank = new HashMap<Coin, Integer>();
        coinBank.put(new Quarter(), 4);
        /*coinManager.Setup(m => m.GetBankOfCoins()).Returns(coinBank);

        var deposited = vendingController.Post(new VendingRequest()
        {
            BagOfCoins = aBagOfCoins,
        });
        var result = vendingController.Post(new VendingRequest()
        {
            Empty = false,
            Selection = new Cola().Type(),
        });*/
        VendingResponse result = new VendingResponse();
        assertThat(result.Delivery.type(), Is.is(new Cola().type()));

    }
    /**
     * as a user I enter coins , select chips tender a nickel back
     */
    @Test
    public void TestUserSelectsChipsHasChange()
    {
        List<Coin> aBagOfCoins = new ArrayList<Coin>();
        aBagOfCoins.add(new Quarter());
        aBagOfCoins.add(new Quarter());
        aBagOfCoins.add(new Nickel());
        //productManager.Setup(m => m.GetProductCount(It.IsAny<Chips>())).Returns(1);

        Map<Coin, Integer> coinBank = new HashMap<Coin, Integer>();
        coinBank.put(new Quarter(), 2);
        coinBank.put(new Nickel(), 1);
        /*coinManager.Setup(m => m.GetBankOfCoins()).Returns(coinBank);

        var deposited = vendingController.Post(new VendingRequest()
        {
            BagOfCoins = aBagOfCoins,
        });
        var result = vendingController.Post(new VendingRequest()
        {
            Empty = false,
            Selection = new Chips().Type(),
        });*/
        VendingResponse result = new VendingResponse();
        assertThat(result.TenderValue, Is.is(new Nickel().value()));
    }
    /**
     * as a user I enter coins , select candy tender dime back
     */
    @Test
    public void TestUserSelectsCandyHasChange()
    {
        List<Coin> aBagOfCoins = new ArrayList<Coin>();
        aBagOfCoins.add(new Quarter());
        aBagOfCoins.add(new Quarter());
        aBagOfCoins.add(new Dime());
        aBagOfCoins.add(new Dime());
        aBagOfCoins.add(new Nickel());
        //productManager.Setup(m => m.GetProductCount(It.IsAny<Candy>())).Returns(1);

        Map<Coin, Integer> coinBank = new HashMap<Coin, Integer>();
        coinBank.put(new Quarter(), 2);
        coinBank.put(new Dime(), 2);
        coinBank.put(new Nickel(),1);
        //coinManager.Setup(m => m.GetBankOfCoins()).Returns(coinBank);
/*
        var deposited = vendingController.Post(new VendingRequest()
        {
            BagOfCoins = aBagOfCoins,
        });
        var result = vendingController.Post(new VendingRequest()
        {
            Empty = false,
            Selection = new Candy().Type(),
        });
        */
        VendingResponse result = new VendingResponse();
        assertThat(result.TenderValue, Is.is(new Dime().value()));
    }
    /**
     * as a user I enter coins , select Cola tender quarter back
     */
    @Test
    public void TestUserSelectsDrinkHasChange()
    {
        List<Coin> aBagOfCoins = new ArrayList<Coin>();
        aBagOfCoins.add(new Quarter());
        aBagOfCoins.add(new Quarter());
        aBagOfCoins.add(new Quarter());
        aBagOfCoins.add(new Quarter());
        aBagOfCoins.add(new Quarter());
        //productManager.Setup(m => m.GetProductCount(It.IsAny<Cola>())).Returns(1);

        Map<Coin, Integer> coinBank = new HashMap<Coin, Integer>();
        coinBank.put(new Quarter(), 5);
        /*coinManager.Setup(m => m.GetBankOfCoins()).Returns(coinBank);

        var deposited = vendingController.Post(new VendingRequest()
        {
            BagOfCoins = aBagOfCoins,
        });
        var result = vendingController.Post(new VendingRequest()
        {
            Empty = false,
            Selection = new Cola().Type(),
        });*/
        VendingResponse result = new VendingResponse();
        assertThat(result.TenderValue, Is.is(new Quarter().value()));
    }
}
