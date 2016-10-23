package com.jasonlam604.stocktechnicals.indicators;

public interface Indicator {

	public double execute(double high, double low, double close);
	public double[] executeSet(double[] high, double[] low, double[] close) throws Exception;
}
