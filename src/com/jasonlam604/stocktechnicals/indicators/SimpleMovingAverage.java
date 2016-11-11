package com.jasonlam604.stocktechnicals.indicators;

import java.util.Arrays;

import com.jasonlam604.stocktechnicals.util.NumberFormatter;

/**
 * Simple Moving Average
 */
public class SimpleMovingAverage {
	
	private double[] results;

	public SimpleMovingAverage calculate(double[] price, int period) throws Exception {

		// ie: if you want 50 SMA then you need 50 data points
		if (price.length < period)
			throw new Exception("Not enough data point, given data size less then the indicated period");

		this.results = new double[price.length];

		int maxLength = price.length - period;

		for (int i = 0; i <= maxLength; i++) {
			this.results[(i + period - 1)] = NumberFormatter
					.round((Arrays.stream(Arrays.copyOfRange(price, i, (i + period))).sum()) / period);
		}

		return this;
	}

	/**
	 * 
	 * SMA 50
	 * 
	 * @param price
	 * @return
	 * @throws Exception
	 */
	public SimpleMovingAverage getSMA50(double[] price) throws Exception {
		return this.calculate(price, 50);
	}

	/**
	 * SMA 200
	 * 
	 * @param price
	 * @return
	 * @throws Exception
	 */
	public SimpleMovingAverage getSMA200(double[] price) throws Exception {
		return this.calculate(price, 200);
	}

	public double[] getSMA() {
		return this.results;
	}
}
