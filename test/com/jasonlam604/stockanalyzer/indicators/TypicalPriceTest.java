package com.jasonlam604.stockanalyzer.indicators;

import com.jasonlam604.stockanalyzer.indicators.TypicalPrice;

import org.junit.Test;
import org.junit.Assert;


public class TypicalPriceTest {
	
    @Test
    public void calcTypicalPrice() {
    	TypicalPrice tp = new TypicalPrice();
    	System.out.println(tp.execute(24.20, 23.85, 23.98));
    	Assert.assertEquals(23.98,tp.execute(24.20, 23.85, 23.89),0);
    }
}
