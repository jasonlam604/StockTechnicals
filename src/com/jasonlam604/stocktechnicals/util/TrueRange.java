package com.jasonlam604.stocktechnicals.util;

public class TrueRange {

	private double result;
	
	public TrueRange calculate(double high,double low,double previousClose) {
		double value1 = high - low;
		double value2 = Math.abs(high - previousClose);
		double value3 = Math.abs(low - previousClose);
		result =  NumberFormatter.round(Math.max(value1, Math.max(value2, value3)));
		return this;
	}
	
	public double getTrueRange() {
		return this.result;
	}
}
