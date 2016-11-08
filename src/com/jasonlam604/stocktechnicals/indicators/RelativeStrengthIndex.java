package com.jasonlam604.stocktechnicals.indicators;

import java.util.Arrays;

import com.jasonlam604.stocktechnicals.util.NumberFormatter;

/**
 * Relative Strength Index
 */
public class RelativeStrengthIndex {

	private double[] prices;
	private int period;
	
	private double[] change;
	
	private double[] gain;
	private double[] loss;
	
	private double[] rs;
	private double[] rsi;
	
	private double[] avgGain;
	private double[] avgLoss;

	
	public double[] execute(double[] prices, int period) throws Exception {
		
		if (period >= prices.length)
			throw new Exception("Given period is larger then given data set");
		
		this.prices = prices;
		this.period = period;
		
		this.change = new double[prices.length];
		
		this.gain = new double[prices.length];
		this.loss = new double[prices.length];
		
		this.avgGain = new double[prices.length];
		this.avgLoss = new double[prices.length];
		
		this.rs = new double[prices.length];
		this.rsi = new double[prices.length];
		
		for(int i=0; i<this.prices.length; i++) {
			
			if(i>0) {
				this.change[i] = this.prices[i] - this.prices[i-1];
				if(this.change[i] > 0) {
					this.gain[i] = this.change[i];
				} else if(this.change[i] < 0) {
					this.loss[i] = Math.abs(this.change[i]);
				}
			}
			
			if(i==this.period) {
				this.avgGain[i] = Arrays.stream(Arrays.copyOfRange(this.gain, 0, this.period)).sum() / period;
				this.avgLoss[i] = Arrays.stream(Arrays.copyOfRange(this.loss, 0, this.period)).sum() / period;
			} else if(i>=this.period) {
				this.avgGain[i] = (this.avgGain[i-1] * 13 + this.gain[i]) / this.period;
				this.avgLoss[i] = (this.avgLoss[i-1] * 13 + this.loss[i]) / this.period;
			}
			
			if(i>=this.period) {
				
				// RS = Average Gain / Average Loss
				this.rs[i] = (this.avgGain[i] / this.avgLoss[i]);
				
				//               100
			    // RSI = 100 - --------
		        //              1 + RS
				this.rsi[i] = NumberFormatter.round(100 - ( 100 / (1+this.rs[i])));
			}
			
		}
		
		return rsi;
	}
	
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < this.prices.length; i++) {
			sb.append(String.format("%02.2f", this.prices[i]));
			sb.append(" ");
			sb.append(String.format("%02.2f", this.change[i]));
			sb.append(" ");
			sb.append(String.format("%02.2f", this.gain[i]));
			sb.append(" ");
			sb.append(String.format("%02.2f", this.loss[i]));	
			sb.append(" ");
			sb.append(String.format("%02.2f", this.avgGain[i]));	
			sb.append(" ");
			sb.append(String.format("%02.2f", this.avgLoss[i]));
			sb.append(" ");
			sb.append(String.format("%02.2f", this.rs[i]));
			sb.append(" ");
			sb.append(String.format("%02.2f", this.rsi[i]));	
			sb.append("\n");
		}

		return sb.toString();
	}
}
