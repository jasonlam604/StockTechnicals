package com.jasonlam604.stocktechnicals.indicators;

import java.util.Arrays;

import com.jasonlam604.stocktechnicals.util.NumberFormatter;
import com.jasonlam604.stocktechnicals.util.TrueRange;

/**
 * Average Directional Index
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
	private double[] negDmPeriod;

	private double[] posDiPeriod;
	private double[] negDiPeriod;

	private double[] diDiffPeriod;
	private double[] diSumPeriod;

	private double[] dx;
	private double[] adx;

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

		if (period >= high.length)
			throw new Exception("Given period is larger then given data set");

		if (high.length != close.length || high.length != low.length)
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
		this.negDmPeriod = new double[this.high.length];

		this.posDiPeriod = new double[this.high.length];
		this.negDiPeriod = new double[this.high.length];

		this.diDiffPeriod = new double[this.high.length];
		this.diSumPeriod = new double[this.high.length];

		this.dx = new double[this.high.length];
		this.adx = new double[this.high.length];

		for (int i = 0; i < high.length; i++) {

			if (i > 0) {
				// Calc True Range
				this.tr[i] = (new TrueRange()).execute(this.high[i], this.low[i], this.close[i - 1]);

				// Calc +DM1
				this.posDM1[i] = this.positiveDirectionalMovement(high[i], high[i - 1], low[i], low[i - 1]);

				// Calc -DM1
				this.negDM1[i] = this.negativeDirectionalMovement(high[i], high[i - 1], low[i], low[i - 1]);
			}

			this.trueRangePeriod(i);

			this.positiveDirectionalMovementPeriod(i);
			this.negativeDirectionalMovementPeriod(i);

			this.positiveDirectionalIndicator(i);
			this.negativeDirectionalIndicator(i);

			this.directionalDiffPeriod(i);
			this.directionalSumPeriod(i);
			
			this.directionalIndex(i);
			this.averageDirectionalIndex(i);

		}

		return this.adx;
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
			return NumberFormatter.round(Math.max((high - previousHigh), 0));
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
	private double negativeDirectionalMovement(double high, double previousHigh, double low, double previousLow) {
		if ((previousLow - low) > (high - previousHigh)) {
			return NumberFormatter.round(Math.max((previousLow - low), 0));
		} else {
			return 0;
		}
	}

	private void trueRangePeriod(int idx) {

		if (idx == period) {

			// at Period, ie: typical ADX 14 right at 14 get determine initial
			// TR value
			double sum = 0;

			for (int i = 0; i < this.period; i++) {
				sum = sum + this.tr[idx - i];
			}

			this.trPeriod[idx] = NumberFormatter.round(sum);

		} else if (idx > period) {

			// Use previous TR Period to build on current TR Period
			double prevTrPeriod = this.trPeriod[idx - 1];
			this.trPeriod[idx] = NumberFormatter
					.round(prevTrPeriod - (prevTrPeriod / this.period) + this.tr[idx]);

		} else {

			// Before Period, no calc required set to 0
			this.trPeriod[idx] = 0;
		}

	}

	private void positiveDirectionalMovementPeriod(int idx) {

		if (idx == this.period) {
			// Determine First value of the given period
			this.posDmPeriod[idx] = NumberFormatter
					.round(Arrays.stream(Arrays.copyOfRange(this.posDM1, 0, this.period + 1)).sum());
		} else if (idx > this.period) {
			// Determine remaining values beyond the first value
			double prevPosDmPeriod = this.posDmPeriod[idx - 1];
			this.posDmPeriod[idx] = NumberFormatter
					.round(prevPosDmPeriod - (prevPosDmPeriod / this.period) + this.posDM1[idx]);

		} else {
			// values for less then the given period
			posDmPeriod[idx] = 0;
		}

	}

	private void negativeDirectionalMovementPeriod(int idx) {

		if (idx == this.period) {
			this.negDmPeriod[idx] = NumberFormatter
					.round(Arrays.stream(Arrays.copyOfRange(this.negDM1, 0, this.period + 1)).sum());
		} else if (idx > this.period) {
			double prevNegDmPeriod = this.negDmPeriod[idx - 1];
			this.negDmPeriod[idx] = NumberFormatter
					.round(prevNegDmPeriod - (prevNegDmPeriod / this.period) + this.negDM1[idx]);
		} else {
			this.negDmPeriod[idx] = 0;
		}

	}

	private void positiveDirectionalIndicator(int idx) {

		double posDmPeriod = this.posDmPeriod[idx];
		double trPeriod = this.trPeriod[idx];

		if (trPeriod > 0)
			this.posDiPeriod[idx] = NumberFormatter.round(100 * (posDmPeriod / trPeriod));
		else
			this.posDiPeriod[idx] = 0;
	}

	private void negativeDirectionalIndicator(int idx) {
		double negDmPeriod = this.negDmPeriod[idx];
		double trPeriod = this.trPeriod[idx];

		if (trPeriod > 0)
			this.negDiPeriod[idx] = NumberFormatter.round(100 * (negDmPeriod / trPeriod));
		else
			this.negDiPeriod[idx] = 0;
	}

	private void directionalDiffPeriod(int idx) {
		this.diDiffPeriod[idx] = NumberFormatter
				.round(Math.abs(this.posDiPeriod[idx] - this.negDiPeriod[idx]));
	}

	private void directionalSumPeriod(int idx) {
		this.diSumPeriod[idx] = NumberFormatter
				.round(Math.abs(this.posDiPeriod[idx] + this.negDiPeriod[idx]));
	}

	private void directionalIndex(int idx) {
		double diDiffPeriod = this.diDiffPeriod[idx];
		double diSumPeriod = this.diSumPeriod[idx];

		if (diSumPeriod > 0)
			this.dx[idx] = NumberFormatter.round(100 * (diDiffPeriod / diSumPeriod));
		else
			this.dx[idx] = 0;
	}
	
	private void averageDirectionalIndex(int idx) {
		  
		if(idx == (this.period + 13)) {
	
		  	double[] data = new double[this.period];
			for(int i=0;i<this.period;i++) {
				int currentIdx = idx - i;
				data[i] = this.dx[currentIdx];
			}
			
			adx[idx] = NumberFormatter.round(Arrays.stream(data).average().getAsDouble());
		} else if( idx > (this.period + 13)) {
			adx[idx] = NumberFormatter.round(  ((this.adx[idx-1] * 13) + this.dx[idx]) / this.period);
		} else {
			adx[idx] = 0;
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
			sb.append(" ");
			sb.append(String.format("%02.2f", this.negDmPeriod[i]));
			sb.append(" ");
			sb.append(String.format("%02.2f", this.posDiPeriod[i]));
			sb.append(" ");
			sb.append(String.format("%02.2f", this.negDiPeriod[i]));
			sb.append(" ");
			sb.append(String.format("%02.2f", this.diDiffPeriod[i]));
			sb.append(" ");
			sb.append(String.format("%02.2f", this.diSumPeriod[i]));
			sb.append(" ");
			sb.append(String.format("%02.2f", this.dx[i]));			
			sb.append(" ");
			sb.append(String.format("%02.2f", this.adx[i]));	
			sb.append("\n");
		}

		return sb.toString();
	}

}
