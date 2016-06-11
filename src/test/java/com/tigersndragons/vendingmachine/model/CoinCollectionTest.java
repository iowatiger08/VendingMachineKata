package com.tigersndragons.vendingmachine.model;

import com.tigersndragons.vendingmachine.model.CoinCollection;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by tdillon-hansen on 6/7/16.
 */
public class CoinCollectionTest {

    CoinCollection coinCollection;

    @Test
    public void CoinCollectorIsEmpty(){
        coinCollection = new CoinCollection();
        assertThat(coinCollection.isEmpty(), is (Boolean.TRUE));
    }

    @Test
    public void CoinCollectorAddQuarter(){
        coinCollection = new CoinCollection();
        coinCollection.addQuarter(2);
        assertThat(coinCollection.size(), is (2));
        assertThat(coinCollection.getNumberOfQuarters(), is (2));
    }
    @Test
    public void CoinCollectorRemoveAQuarter(){
        coinCollection = new CoinCollection();
        coinCollection.addQuarter(2);
        coinCollection.removeQuarter(1);
        assertThat(coinCollection.size(), is (1));
    }
    @Test
    public void CoinCollectorRemoveAQuarterValue(){
        coinCollection = new CoinCollection();
        coinCollection.addQuarter(2);
        coinCollection.removeQuarter(1);
        assertThat(coinCollection.value(), is (25));
    }
    @Test
    public void CoinCollectorAddQuarterValue(){
        coinCollection = new CoinCollection();
        coinCollection.addQuarter(2);
        assertThat(coinCollection.value(), is (50));
    }
    @Test(expected = IllegalArgumentException.class)
    public void CoinCollectorAddQuarterNegativeThrowsError(){
        coinCollection = new CoinCollection();
        coinCollection.addQuarter(-1);
    }
    @Test
    public void CoinCollectorAddDime(){
        coinCollection = new CoinCollection();
        coinCollection.addDime(2);
        assertThat(coinCollection.size(), is (2));
        assertThat(coinCollection.getNumberOfDimes(), is (2));
    }
    @Test(expected = IllegalArgumentException.class)
    public void CoinCollectorAddDimeNegativeThrowsError(){
        coinCollection = new CoinCollection();
        coinCollection.addDime(-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void CoinCollectorAddNickelNegativeThrowsError(){
        coinCollection = new CoinCollection();
        coinCollection.addNickel(-1);
    }
    @Test
    public void CoinCollectionInitDimeSizeZero(){
        coinCollection = new CoinCollection();
        assertThat(coinCollection.getNumberOfDimes(), is (0));
    }
    @Test
    public void CoinCollectionInitNickelSizeZero(){
        coinCollection = new CoinCollection();
        assertThat(coinCollection.getNumberOfNickels(), is (0));
    }
    @Test
    public void CoinCollectionInitQuarterSizeZero(){
        coinCollection = new CoinCollection();
        assertThat(coinCollection.getNumberOfQuarters(), is (0));
    }
    @Test
    public void CoinCollectorAddDimeValue(){
        coinCollection = new CoinCollection();
        coinCollection.addDime(2);
        assertThat(coinCollection.value(), is (20));
    }
    @Test
    public void CoinCollectorRemoveADime(){
        coinCollection = new CoinCollection();
        coinCollection.addDime(2);
        coinCollection.removeDime(1);
        assertThat(coinCollection.size(), is (1));
    }
    @Test
    public void CoinCollectorRemoveADimeValue(){
        coinCollection = new CoinCollection();
        coinCollection.addDime(2);
        coinCollection.removeDime(1);
        assertThat(coinCollection.value(), is (10));
    }
    @Test
    public void CoinCollectorAddNickel(){
        coinCollection = new CoinCollection();
        coinCollection.addNickel(2);
        assertThat(coinCollection.size(), is (2));
        assertThat(coinCollection.getNumberOfNickels(), is (2));
    }
    @Test
    public void CoinCollectorAddNickelValue(){
        coinCollection = new CoinCollection();
        coinCollection.addNickel(2);
        assertThat(coinCollection.value(), is (10));
    }
    @Test
    public void CoinCollectorRemoveANickel(){
        coinCollection = new CoinCollection();
        coinCollection.addDime(2);
        coinCollection.removeDime(1);
        assertThat(coinCollection.size(), is (1));
    }
    @Test
    public void CoinCollectorRemoveANickelValue(){
        coinCollection = new CoinCollection();
        coinCollection.addNickel(2);
        coinCollection.removeNickel(1);
        assertThat(coinCollection.value(), is (5));
    }
    @Test
    public void CoinCollectorIsEmptySize(){
        coinCollection = new CoinCollection();
        coinCollection.addQuarter(2);
        coinCollection.removeQuarter(2);
        assertThat(coinCollection.isEmpty(), is (Boolean.TRUE));
    }
    @Test(expected = IllegalArgumentException.class)
    public void CoinCollectorRemovetoomanyDimesThrowsError(){
        coinCollection = new CoinCollection();
        coinCollection.addDime(2);
        coinCollection.removeDime(3);
    }
    @Test(expected = IllegalArgumentException.class)
    public void CoinCollectorRemovetoomanyNickelThrowsError(){
        coinCollection = new CoinCollection();
        coinCollection.addNickel(2);
        coinCollection.removeNickel(3);
    }
    @Test(expected = IllegalArgumentException.class)
    public void CoinCollectorRemovetoomanyQuartersThrowsError(){
        coinCollection = new CoinCollection();
        coinCollection.addQuarter(2);
        coinCollection.removeQuarter(3);
    }
    @Test
    public void CoinCollectionClearSizeIsZero(){
        coinCollection = new CoinCollection();
        coinCollection.addNickel(2);
        coinCollection.addQuarter(5);
        coinCollection.clear();
        assertThat(coinCollection.size(), is (0));
    }
}
