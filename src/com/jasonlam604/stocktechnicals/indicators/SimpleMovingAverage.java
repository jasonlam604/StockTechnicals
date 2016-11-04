package com.jasonlam604.stocktechnicals.indicators;

import java.util.Arrays;

import com.jasonlam604.stocktechnicals.util.NumberHelper;

/**
 * Simple Moving Average
 *
 * A simple moving average (SMA) is an arithmetic moving average calculated
 * by adding the closing price of the security for a number of time periods
 * and then dividing this total by the number of time periods. --Investopedia.com
 *
 */
public class SimpleMovingAverage {

	/**
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
			results[(i + period - 1)] = NumberHelper
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
