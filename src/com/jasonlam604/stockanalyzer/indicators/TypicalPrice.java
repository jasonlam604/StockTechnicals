package com.jasonlam604.stockanalyzer.indicators;

import com.jasonlam604.stockanalyzer.util.NumberHelper;

/**
 * 
 * Typical Price
 *
 * The Typical Price indicator is simply an average of each day's price. 
 * The Median Price and Weighted Close are similar indicators. The Typical Price 
 * indicator provides a simple, single-line plot of the day's average price. 
 * Some investors use the Typical Price rather than the closing price when 
 * creating moving average penetration systems. 
 *
 *  TP= (high+low+close) / 3
 *
 */
public class TypicalPrice implements Indicator {

	public double[] executeSet(double[] high, double[] low, double[] close) throws Exception {
		
		double[] results = new double[high.length];
		
		if(high.length == low.length && high.length == close.length) {
			
			for(int i=0; i<high.length; i++) {
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
		//return (high + low + close)/3;
		return NumberHelper.roundTwoDecimals((high + low + close)/3);
		//return Math.round(  ((high + low + close)/3.0)*100   ) / 100;
	}
}

