package com.jasonlam604.stocktechnicals.indicators;

import com.jasonlam604.stocktechnicals.util.NumberFormatter;

/**
 * Typical Price
 */
public class TypicalPrice {
	
	private double[] typicalPrice;

	public TypicalPrice calculate(double[] high, double[] low, double[] close) throws Exception {

		this.typicalPrice = new double[high.length];

		if (high.length == low.length && high.length == close.length) {

			for (int i = 0; i < high.length; i++) {
				this.typicalPrice[i] = NumberFormatter.round((high[i] + low[i] + close[i]) / 3);
			}

		} else {
			throw new Exception("Size of high, low and close are not the same");
		}

		return this;
	}

	public TypicalPrice calculate(double high, double low, double close) {
		this.typicalPrice = new double[1];
		this.typicalPrice[0] = NumberFormatter.round((high + low + close) / 3);
		return this;
	}
	
	public double[] getTypicalPrice() {
		return this.typicalPrice;
	}
	
	public double getTypicalPriceFrist() {
		return this.getTypicalPrice()[0];
	}
}
