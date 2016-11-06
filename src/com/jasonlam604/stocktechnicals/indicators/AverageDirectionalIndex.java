package com.jasonlam604.stocktechnicals.indicators;

import com.jasonlam604.stocktechnicals.util.TrueRange;

public class AverageDirectionalIndex {

	private double[] high;
	private double[] low;
	private double[] close;
	private int range;
	
	private double[] trueRange;
	private double[] posDM1;
	private double[] negDM1;
	
	/**
	 * Calculate ADX (Average Directional Index)
	 * 
	 * @param high
	 * @param low
	 * @param close
	 * @param range
	 * @return
	 * @throws Exception
	 */
	public double[] execute(double[] high, double[] low, double[] close, int range) throws Exception {
	
		double result[] = new double[0];
		
		if(range >= high.length)
			throw new Exception("Given range is bigger then given data set");
		
		if(high.length != close.length && high.length != low.length)
			throw new Exception("High, Low and Close are not equal in size");
		
		this.high = high;
		this.low = low;
		this.close = close;
		this.range = range;
		
		this.trueRange = new double[this.high.length];
		this.posDM1 = new double[this.high.length];
		this.negDM1 = new double[this.high.length];
		
		for(int i=0; i<high.length; i++) {
			
			if(i>0) {
				// Calc True Range
				this.trueRange[i] = (new TrueRange()).execute(this.high[i], this.low[i], this.close[i-1]);
				
				// Calc +DM1
				this.posDM1[i] = this.positiveDirectionalMovement(high[i], high[i-1], low[i], low[i-1]);
				
				// Calc -DM1
				this.negDM1[i] = this.negativeDirectionalMovement(high[i], high[i-1], low[i], low[i-1]);
			}
			
			if(i>= range) {
				
			}
		}
		
		return result;
	}
	
	/**
	 * Calculate Positive Directional Movement
	 * 
	 * Directional movement is positive (plus) when the current high minus
	 * the prior high is greater than the prior low minus the current low.
	 * 
	 * @param high
	 * @param previousHigh
	 * @param low
	 * @param previousLow
	 * @return
	 */
	private double positiveDirectionalMovement(double high,double previousHigh,double low,double previousLow) {
		if( (high - previousHigh) > (previousLow - low)) {
			return Math.max((high - previousHigh),0);
		} else {
			return 0;
		}
	}
	
	/**
	 * Calculate Negative Directional Movement
	 * 
	 * Directional movement is negative (minus) when the prior low minus 
	 * the current low is greater than the current high minus the prior high. 
	 * 
	 * @param high
	 * @param previousHigh
	 * @param low
	 * @param previousLow
	 * @return
	 */
	public double negativeDirectionalMovement(double high,double previousHigh,double low,double previousLow) {
		if((previousLow-low) > (high-previousHigh)) {
			return Math.max((previousLow-low),0);
		} else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<high.length; i++) {
			sb.append(String.format("%02.2f",this.high[i]));
			sb.append(" ");
			sb.append(String.format("%02.2f",this.low[i]));
			sb.append(" "); 
			sb.append(String.format("%02.2f",this.close[i]));
			sb.append(" "); 
			sb.append(String.format("%02.2f",this.trueRange[i]));
			sb.append(" "); 
			sb.append(String.format("%02.2f",this.posDM1[i]));
			sb.append(" "); 
			sb.append(String.format("%02.2f",this.negDM1[i]));
			sb.append(" ");
			sb.append("\n");
		}
	
		return sb.toString();
	}
	

}
