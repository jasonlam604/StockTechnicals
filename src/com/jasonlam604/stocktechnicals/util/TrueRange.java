package com.jasonlam604.stocktechnicals.util;

public class TrueRange {

	public double execute(double high,double low,double previousClose) {
		double value1 = high - low;
		double value2 = Math.abs(high - previousClose);
		double value3 = Math.abs(low - previousClose);
		return NumberFormatter.round(Math.max(value1, Math.max(value2, value3)));
	}
}
