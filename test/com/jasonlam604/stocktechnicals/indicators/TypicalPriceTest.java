package com.jasonlam604.stocktechnicals.indicators;

import com.jasonlam604.stocktechnicals.indicators.TypicalPrice;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;
import org.junit.Rule;

public class TypicalPriceTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testCalcTypicalPrice() {
		TypicalPrice tp = new TypicalPrice();
		Assert.assertEquals(23.98, tp.calculate(24.20, 23.85, 23.89).getTypicalPriceFrist(), 0);
	}

	@Test
	public void testCalcTypicalPriceArrayInputs() {

		double[] high = { 24.20, 24.07, 24.04, 23.87, 23.67 };
		double[] low = { 23.85, 23.72, 23.64, 23.37, 23.46 };
		double[] close = { 23.89, 23.95, 23.67, 23.78, 23.50 };

		TypicalPrice tp = new TypicalPrice();

		double[] results = null;

		try {
			results = tp.calculate(high, low, close).getTypicalPrice();
		} catch (Exception e) {

		}

		Assert.assertEquals(23.98, results[0], 0);
		Assert.assertEquals(23.91, results[1], 0);
		Assert.assertEquals(23.78, results[2], 0);
		Assert.assertEquals(23.67, results[3], 0);
		Assert.assertEquals(23.54, results[4], 0);
	}
	
	@Test
	public void testExpectWrongSizeException() throws Exception {
		
		thrown.expect(Exception.class);
		thrown.expectMessage("Size of high, low and close are not the same");
		
		double[] high = { 24.20, 24.07, 24.04, 23.87, 23.67 };
		double[] low = { 23.85, 23.72, 23.64, 23.37, 23.46 };
		double[] close = { 23.89, 23.95, 23.67 };

		TypicalPrice tp = new TypicalPrice();

		double[] results = tp.calculate(high, low, close).getTypicalPrice();

	}
}
