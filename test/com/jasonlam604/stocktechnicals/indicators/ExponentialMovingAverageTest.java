package com.jasonlam604.stocktechnicals.indicators;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class ExponentialMovingAverageTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testCalcEMA() {

		double[] prices = { 22.27, 22.19, 22.08, 22.17, 22.18, 22.13, 22.23, 22.43, 22.24, 22.29, 22.15, 22.39, 22.38,
				22.61, 23.36, 24.05, 23.75, 23.83, 23.95, 23.63, 23.82, 23.87, 23.65, 23.19, 23.10, 23.33, 22.68, 23.10,
				22.40, 22.17 };

		ExponentialMovingAverage ema = new ExponentialMovingAverage();
		try {
			double[] results = ema.calculate(prices, 10).getEMA();

			Assert.assertEquals(22.92, results[results.length - 1], 0);
			Assert.assertEquals(23.09, results[results.length - 2], 0);
			Assert.assertEquals(23.24, results[results.length - 3], 0);
			Assert.assertEquals(23.27, results[results.length - 4], 0);
			Assert.assertEquals(23.40, results[results.length - 5], 0);

		} catch (Exception e) {

		}
	}

	@Test
	public void testExpectWrongPeriodException() throws Exception {
		double[] prices = { 22.27, 22.19, 22.08, 22.17, 22.18, 22.13, 22.23, 22.43, 22.24, 22.29, 22.15, 22.39, 22.38,
				22.61, 23.36, 24.05, 23.75, 23.83, 23.95, 23.63, 23.82, 23.87, 23.65, 23.19, 23.10, 23.33, 22.68, 23.10,
				22.40, 22.17 };

		thrown.expect(Exception.class);
		thrown.expectMessage("Given period is bigger then given set of prices");

		ExponentialMovingAverage ema = new ExponentialMovingAverage();
		double[] results = ema.calculate(prices, 100).getEMA();
	}

	@Test
	public void testToStringHasValue() {
		double[] prices = { 22.27, 22.19, 22.08, 22.17, 22.18, 22.13, 22.23, 22.43, 22.24, 22.29, 22.15, 22.39, 22.38,
				22.61, 23.36, 24.05, 23.75, 23.83, 23.95, 23.63, 23.82, 23.87, 23.65, 23.19, 23.10, 23.33, 22.68, 23.10,
				22.40, 22.17 };

		ExponentialMovingAverage ema = new ExponentialMovingAverage();
		try {
			double[] results = ema.calculate(prices, 10).getEMA();

			Assert.assertTrue(!ema.toString().isEmpty());

		} catch (Exception e) {

		}
	}
}
