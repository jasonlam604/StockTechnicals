package com.jasonlam604.stocktechnicals.indicators;

import com.jasonlam604.stocktechnicals.util.NumberFormatter;

/**
 * ParabolicSar
 * 
 */
public class ParabolicSar {

	private double[] parabolicSars;

	private double[] trends;

	public void calculate(double[] high, double[] low) {
		this.calculate(high, low, 0.02, 0.20);
	}

	public void calculate(double[] high, double[] low, double acceleration, double accelerationMax) {

		this.parabolicSars = new double[high.length];
		this.trends = new double[high.length];

		int trend = (high[1] >= high[0] || low[0] <= low[1]) ? +1 : -1;

		double parabolicSar = (trend > 0) ? low[0] : high[0];

		double extremePoint = (trend > 0) ? high[0] : low[0];

		double accelerationFactor = 0;

		// Init first Parabolic Sar and Trend values
		this.parabolicSars[1] = parabolicSar; // SAR Results
		this.trends[1] = trend; // Trend Directions

		int ct = this.parabolicSars.length - 1;

		for (int i = 1; i < ct; i++) {

			double nextSar;

			// Up Trend if trend is bigger then 0 else it's a down trend
			if (trend > 0) {

				// Higher highs, accelerate
				if (high[i] > extremePoint) {
					extremePoint = high[i];
					accelerationFactor = Math.min(accelerationMax, accelerationFactor + acceleration);
				}

				// Next Parabolic SAR based on today's close/price value
				nextSar = parabolicSar + accelerationFactor * (extremePoint - parabolicSar);

				// Rule: Parabolic SAR can not be above prior period's low or
				// the current low.
				nextSar = (i > 0) ? Math.min(Math.min(low[i], low[i - 1]), nextSar) : Math.min(low[i], nextSar);

				// Rule: If Parabolic SAR crosses tomorrow's price range, the
				// trend switches.
				if (nextSar > low[i + 1]) {
					trend = -1;
					nextSar = extremePoint;
					extremePoint = low[i + 1];
					accelerationFactor = acceleration;
				}

			} else {

				// Making lower lows: accelerate
				if (low[i] < extremePoint) {
					extremePoint = low[i];
					accelerationFactor = Math.min(accelerationMax, accelerationFactor + acceleration);
				}

				// Next Parabolic SAR based on today's close/price value
				nextSar = parabolicSar + accelerationFactor * (extremePoint - parabolicSar);

				// Rule: Parabolic SAR can not be below prior period's high or
				// the current high.
				nextSar = (i > 0) ? Math.max(Math.max(high[i], high[i - 1]), nextSar) : Math.max(high[i], nextSar);

				// Rule: If Parabolic SAR crosses tomorrow's price range, the
				// trend switches.
				if (nextSar < high[i + 1]) {
					trend = +1;
					nextSar = extremePoint;
					extremePoint = high[i + 1];
					accelerationFactor = acceleration;
				}
			}

			// System.out.println(extremePoint + " " + accelerationFactor);

			this.parabolicSars[i + 1] = NumberFormatter.round(nextSar);
			this.trends[i + 1] = trend;

			parabolicSar = nextSar;
		}

	}

	public double[] getPsars() {
		return this.parabolicSars;
	}

	public double[] getTrends() {
		return this.trends;
	}
}
