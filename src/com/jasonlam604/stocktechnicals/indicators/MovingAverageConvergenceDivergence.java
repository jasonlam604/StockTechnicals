package com.jasonlam604.stocktechnicals.indicators;

/**
 * Moving Average Convergence/Divergence Oscillator
 */
public class MovingAverageConvergenceDivergence {

	private double[] prices;
	private double[] macd;
	private double[] signal;

	public MovingAverageConvergenceDivergence calculate(double[] prices, int fastPeriod, int slowPeriod,
			int signalPeriod) throws Exception {

		this.prices = prices;
		this.macd = new double[prices.length];
		this.signal = new double[prices.length];

		ExponentialMovingAverage emaShort = new ExponentialMovingAverage();
		emaShort.calculate(prices, fastPeriod).getEMA();

		ExponentialMovingAverage emaLong = new ExponentialMovingAverage();
		emaLong.calculate(prices, slowPeriod).getEMA();

		for (int i = slowPeriod - 1; i < this.prices.length; i++) {
			this.macd[i] = emaShort.getEMA()[i] - emaLong.getEMA()[i];
		}

		ExponentialMovingAverage signalEma = new ExponentialMovingAverage();
		this.signal = signalEma.calculate(this.macd, signalPeriod).getEMA();

		return this;
	}

	public double[] getMACD() {
		return this.macd;
	}

	public double[] getSignal() {
		return this.signal;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < this.prices.length; i++) {
			sb.append(String.format("%02.2f", this.prices[i]));
			sb.append(" ");
			sb.append(String.format("%02.2f", this.macd[i]));
			sb.append(" ");
			sb.append(String.format("%02.2f", this.signal[i]));
			sb.append(" ");
			sb.append("\n");
		}

		return sb.toString();
	}
}
