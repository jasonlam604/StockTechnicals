package com.jasonlam604.stocktechnicals.indicators;

import java.util.Arrays;

import com.jasonlam604.stocktechnicals.util.NumberHelper;

public class SimpleMovingAverage {

	/**
	 * Simple Moving Average is formed by computing the average price of a
	 * security over a specific number of periods.
	 * 
	 * Calculation starts from index 0 to index n assuming there is enough
	 * periods
	 * 
	 * @param price
	 *            double array of values
	 * @param period
	 *            SMA period to be calculated over
	 * @throws Exception
	 */
	public double[] execute(double[] price, int period) throws Exception {

		// ie: if you want 50 SMA then you need 50 data points
		if (price.length < period)
			throw new Exception("Not enough data point, given data size less then the indicated period");

		double[] results = new double[price.length];

		int maxLength = price.length - period;
		
		for (int i = 0; i <= maxLength; i++) {
			results[ (i+period-1)  ] = NumberHelper
					.roundTwoDecimals((Arrays.stream(Arrays.copyOfRange(price, i, (i + period))).sum()) / period);
		}

		return results;
	}

	/**
	 * 
	 * SMA 50
	 * 
	 * @param price
	 * @return
	 * @throws Exception
	 */
	public double[] sma50(double[] price) throws Exception {
		return this.execute(price, 50);
	}

	/**
	 * SMA 200
	 * 
	 * @param price
	 * @return
	 * @throws Exception
	 */
	public double[] sma200(double[] price) throws Exception {
		return this.execute(price, 200);
	}
}
