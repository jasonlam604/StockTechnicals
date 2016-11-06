package com.jasonlam604.stocktechnicals.indicators;

import com.jasonlam604.stocktechnicals.util.NumberFormatter;
import com.jasonlam604.stocktechnicals.util.TrueRange;

/**
 * 
 * 
 * @author jasolam604@gmail.com
 */
public class AverageDirectionalIndex {

	private double[] high;
	private double[] low;
	private double[] close;
	private int period;

	private double[] tr;
	private double[] trPeriod;

	private double[] posDM1;
	private double[] negDM1;
	
	private double[] posDmPeriod;

	/**
	 * Calculate ADX (Average Directional Index)
	 * 
	 * @param high
	 * @param low
	 * @param close
	 * @param period
	 * @return
	 * @throws Exception
	 */
	public double[] execute(double[] high, double[] low, double[] close, int period) throws Exception {

		double result[] = new double[0];

		if (period >= high.length)
			throw new Exception("Given range is bigger then given data set");

		if (high.length != close.length && high.length != low.length)
			throw new Exception("High, Low and Close are not equal in size");

		this.high = high;
		this.low = low;
		this.close = close;
		this.period = period;

		this.tr = new double[this.high.length];
		this.posDM1 = new double[this.high.length];
		this.negDM1 = new double[this.high.length];

		this.trPeriod = new double[this.high.length];
		
		this.posDmPeriod = new double[this.high.length];

		for (int i = 0; i < high.length; i++) {

			if (i > 0) {
				// Calc True Range
				this.tr[i] = (new TrueRange()).execute(this.high[i], this.low[i], this.close[i - 1]);

				// Calc +DM1
				this.posDM1[i] = this.positiveDirectionalMovement(high[i], high[i - 1], low[i], low[i - 1]);

				// Calc -DM1
				this.negDM1[i] = this.negativeDirectionalMovement(high[i], high[i - 1], low[i], low[i - 1]);
			}

			// if(i>= period) {

			// if(i==period) {
			this.trueRangePeriod(i);
			this.positiveDirectionalMovementPeriod(i);
			// }

			// }
		}

		return result;
	}

	/**
	 * Calculate Positive Directional Movement
	 * 
	 * Directional movement is positive (plus) when the current high minus the
	 * prior high is greater than the prior low minus the current low.
	 * 
	 * @param high
	 * @param previousHigh
	 * @param low
	 * @param previousLow
	 * @return
	 */
	private double positiveDirectionalMovement(double high, double previousHigh, double low, double previousLow) {
		if ((high - previousHigh) > (previousLow - low)) {
			return NumberFormatter.roundTwoDecimals(Math.max((high - previousHigh), 0));
		} else {
			return 0;
		}
	}

	/**
	 * Calculate Negative Directional Movement
	 * 
	 * Directional movement is negative (minus) when the prior low minus the
	 * current low is greater than the current high minus the prior high.
	 * 
	 * @param high
	 * @param previousHigh
	 * @param low
	 * @param previousLow
	 * @return
	 */
	public double negativeDirectionalMovement(double high, double previousHigh, double low, double previousLow) {
		if ((previousLow - low) > (high - previousHigh)) {
			return NumberFormatter.roundTwoDecimals(Math.max((previousLow - low), 0));
		} else {
			return 0;
		}
	}

	public void trueRangePeriod(int idx) {

		if (idx == period) {

			// at Period, ie: typical ADX 14 right at 14 get determine initial
			// TR value
			double sum = 0;

			for (int i = 0; i < this.period; i++) {
				sum = sum + this.tr[idx - i];
			}

			this.trPeriod[idx] = NumberFormatter.roundTwoDecimals(sum);

		} else if (idx > period) {

			// Use previous TR Period to build on current TR Period
			double prevTrPeriod = this.trPeriod[idx - 1];
			this.trPeriod[idx] = NumberFormatter.roundTwoDecimals(prevTrPeriod - (prevTrPeriod / this.period) + this.tr[idx]);

		} else {

			// Before Period, no calc required set to 0
			this.trPeriod[idx] = 0;
		}

	}
	
	public void positiveDirectionalMovementPeriod(int idx) {
		
		if (idx == period) {
			double sum = 0;
			for(int i=0;i<this.period;i++) {
				sum = sum + this.posDM1[idx-i];
			}
			posDmPeriod[idx] = NumberFormatter.roundTwoDecimals(sum);
		} else if (idx > period) {
			
			// Todo
			
		} else {
			posDmPeriod[idx] = 0;
		}
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < high.length; i++) {
			sb.append(String.format("%02.2f", this.high[i]));
			sb.append(" ");
			sb.append(String.format("%02.2f", this.low[i]));
			sb.append(" ");
			sb.append(String.format("%02.2f", this.close[i]));
			sb.append(" ");
			sb.append(String.format("%02.2f", this.tr[i]));
			sb.append(" ");
			sb.append(String.format("%02.2f", this.posDM1[i]));
			sb.append(" ");
			sb.append(String.format("%02.2f", this.negDM1[i]));
			sb.append(" ");
			sb.append(String.format("%02.2f", this.trPeriod[i]));
			sb.append(" ");
			sb.append(String.format("%02.2f", this.posDmPeriod[i]));			
			
			sb.append("\n");
		}

		return sb.toString();
	}

}
