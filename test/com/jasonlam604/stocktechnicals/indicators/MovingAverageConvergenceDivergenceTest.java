package com.jasonlam604.stocktechnicals.indicators;

import org.junit.Assert;
import org.junit.Test;

public class MovingAverageConvergenceDivergenceTest {

	@Test
	public void testCalcMacd() {

		double[] prices = new double[] { 459.99, 448.85, 446.06, 450.81, 442.8, 448.97, 444.57, 441.4, 430.47, 420.05,
				431.14, 425.66, 430.58, 431.72, 437.87, 428.43, 428.35, 432.5, 443.66, 455.72, 454.49, 452.08, 452.73,
				461.91, 463.58, 461.14, 452.08, 442.66, 428.91, 429.79, 431.99, 427.72, 423.2, 426.21, 426.98, 435.69,
				434.33, 429.8, 419.85, 426.24, 402.8, 392.05, 390.53, 398.67, 406.13, 405.46, 408.38, 417.2, 430.12,
				442.78, 439.29, 445.52, 449.98, 460.71, 458.66, 463.84, 456.77, 452.97, 454.74, 443.86, 428.85, 434.58,
				433.26, 442.93, 439.66, 441.35 };

		MovingAverageConvergenceDivergence macd = new MovingAverageConvergenceDivergence();
		try {
			macd.calculate(prices, 12, 26, 9);
			double[] results = macd.getMACD();

			// Test the first few
			Assert.assertEquals(8.27, results[25], 0);
			Assert.assertEquals(7.70, results[26], 0);
			Assert.assertEquals(6.41, results[27], 0);
			Assert.assertEquals(4.24, results[28], 0);
			Assert.assertEquals(2.56, results[29], 0);

			double[] signals = macd.getSignal();

			Assert.assertEquals(1.65, signals[25], 0);
			Assert.assertEquals(2.86, signals[26], 0);
			Assert.assertEquals(3.57, signals[27], 0);
			Assert.assertEquals(3.70, signals[28], 0);
			Assert.assertEquals(3.47, signals[29], 0);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testToStringHasValue() {
		double[] prices = new double[] { 459.99, 448.85, 446.06, 450.81, 442.8, 448.97, 444.57, 441.4, 430.47, 420.05,
				431.14, 425.66, 430.58, 431.72, 437.87, 428.43, 428.35, 432.5, 443.66, 455.72, 454.49, 452.08, 452.73,
				461.91, 463.58, 461.14, 452.08, 442.66, 428.91, 429.79, 431.99, 427.72, 423.2, 426.21, 426.98, 435.69,
				434.33, 429.8, 419.85, 426.24, 402.8, 392.05, 390.53, 398.67, 406.13, 405.46, 408.38, 417.2, 430.12,
				442.78, 439.29, 445.52, 449.98, 460.71, 458.66, 463.84, 456.77, 452.97, 454.74, 443.86, 428.85, 434.58,
				433.26, 442.93, 439.66, 441.35 };

		MovingAverageConvergenceDivergence macd = new MovingAverageConvergenceDivergence();
		try {
			macd.calculate(prices, 12, 26, 9);
			double[] results = macd.getMACD();

			Assert.assertTrue(!macd.toString().isEmpty());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
