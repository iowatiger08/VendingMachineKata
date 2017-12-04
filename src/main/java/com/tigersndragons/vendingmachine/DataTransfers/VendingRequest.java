package com.tigersndragons.vendingmachine.DataTransfers;

import com.tigersndragons.vendingmachine.model.Coin;

import java.util.ArrayList;

public class VendingRequest
{
    public boolean         IsEmpty ;
    public ArrayList<Coin> BagOfCoins  ;
    public String           Selection  ;
}
