package com.jasonlam604.stocktechnicals.indicators;

import com.jasonlam604.stocktechnicals.indicators.SimpleMovingAverage;

import org.junit.Test;
import org.junit.Assert;

public class SimpleMovingAverageTest {

	@Test
	public void calcSimpleMovingAverage1() {
		SimpleMovingAverage sma = new SimpleMovingAverage();
		try {
			double[] results = sma.execute(new double[] { 17, 16, 15, 14, 13, 12, 11 }, 5);

			Assert.assertEquals(15.0, results[4], 0);
			Assert.assertEquals(14.0, results[5], 0);
			Assert.assertEquals(13.0, results[6], 0);

		} catch (Exception e) {

		}
	}

	@Test
	public void calcSimpleMovingAverage2() {
		SimpleMovingAverage sma = new SimpleMovingAverage();
		try {
			double[] results = sma.execute(new double[] { 22.27, 22.19, 22.08, 22.17, 22.18, 22.13, 22.23, 22.43, 22.24,
					22.29, 22.15, 22.39, 22.38, 22.61, 23.36, 24.05, 23.75, 23.83, 23.95, 23.63, 23.82, 23.87, 23.65,
					23.19, 23.10, 23.33, 22.68, 23.10, 22.40, 22.17 }, 10);

			Assert.assertEquals(22.22, results[9], 0);
			Assert.assertEquals(22.21, results[10], 0);
			Assert.assertEquals(22.23, results[11], 0);
			Assert.assertEquals(22.26, results[12], 0);
			Assert.assertEquals(22.30, results[13], 0);
			Assert.assertEquals(22.42, results[14], 0);
			Assert.assertEquals(22.61, results[15], 0);
			Assert.assertEquals(22.77, results[16], 0);
			Assert.assertEquals(22.90, results[17], 0);
			Assert.assertEquals(23.08, results[18], 0);
			Assert.assertEquals(23.21, results[19], 0);
			Assert.assertEquals(23.38, results[20], 0);
			Assert.assertEquals(23.52, results[21], 0);
			Assert.assertEquals(23.65, results[22], 0);
			Assert.assertEquals(23.71, results[23], 0);

		} catch (Exception e) {

		}
	}
}
