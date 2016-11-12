package com.jasonlam604.stocktechnicals.indicators;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RelativeStrengthIndexTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testCalcRsi() {
		
		double[] prices = new double[]{44.34,44.09,44.15,43.61,44.33,44.83,45.10,45.42,45.84,46.08,45.89,46.03,45.61,46.28,46.28,46.00,46.03,46.41,46.22,45.64,46.21,46.25,45.71,46.45,45.78,45.35,44.03,44.18,44.22,44.57,43.42,42.66,43.13};
	
		RelativeStrengthIndex rsi = new RelativeStrengthIndex();
		try {
			double[] results = rsi.calculate(prices, 14).getRSI();

			Assert.assertEquals(37.79, results[results.length - 1], 0);
			Assert.assertEquals(33.09, results[results.length - 2], 0);
			Assert.assertEquals(37.32, results[results.length - 3], 0);
			Assert.assertEquals(45.50, results[results.length - 4], 0);
			Assert.assertEquals(41.90, results[results.length - 5], 0);
			
		} catch (Exception e) {

		}
	}
	
	@Test
	public void testExpectWrongSizeException() throws Exception {
		double[] prices = new double[]{44.34,44.09,44.15,43.61,44.33,44.83,45.10,45.42,45.84,46.08,45.89,46.03,45.61,46.28,46.28,46.00,46.03,46.41,46.22,45.64,46.21,46.25,45.71,46.45,45.78,45.35,44.03,44.18,44.22,44.57,43.42,42.66,43.13};
		
		thrown.expect(Exception.class);
		thrown.expectMessage("Given period is larger then given data set");
		
		RelativeStrengthIndex rsi = new RelativeStrengthIndex();
		double[] results = rsi.calculate(prices, 100).getRSI();
	}
	
	@Test
	public void testToStringHasValue() {
		
		double[] prices = new double[]{44.34,44.09,44.15,43.61,44.33,44.83,45.10,45.42,45.84,46.08,45.89,46.03,45.61,46.28,46.28,46.00,46.03,46.41,46.22,45.64,46.21,46.25,45.71,46.45,45.78,45.35,44.03,44.18,44.22,44.57,43.42,42.66,43.13};
		
		RelativeStrengthIndex rsi = new RelativeStrengthIndex();
		try {
			double[] results = rsi.calculate(prices, 14).getRSI();

			Assert.assertTrue(!rsi.toString().isEmpty());
			
		} catch (Exception e) {

		}
		
	}
}
