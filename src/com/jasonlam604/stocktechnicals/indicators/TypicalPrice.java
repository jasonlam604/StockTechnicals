package com.jasonlam604.stocktechnicals.indicators;

import com.jasonlam604.stocktechnicals.util.NumberFormatter;

/**
 * Typical Price
 */
public class TypicalPrice {

	public double[] executeSet(double[] high, double[] low, double[] close) throws Exception {

		double[] results = new double[high.length];

		if (high.length == low.length && high.length == close.length) {

			for (int i = 0; i < high.length; i++) {
				results[i] = this.execute(high[i], low[i], close[i]);
			}

		} else {
			throw new Exception("Size of high, low and close are not the same");
		}

		return results;

	}

	/**
	 * Typical Price
	 * 
	 * @param high
	 * @param low
	 * @param close
	 * @return
	 */
	public double execute(double high, double low, double close) {
		return NumberFormatter.round((high + low + close) / 3);
	}
}
