package com.jasonlam604.stocktechnicals.indicators;

import com.jasonlam604.stocktechnicals.util.NumberFormatter;

/**
 * Commodity Channel Index
 * 
 * Commodity Channel Index (CCI) is a versatile indicator that can be used
 * to identify a new trend or warn of extreme conditions. -- StockCharts.com
 * 
 */
public class CommodityChannelIndex {

	public double[] execute(double[] high, double[] low, double[] close, int range) throws Exception {

		TypicalPrice typicalPrice = new TypicalPrice();
		double[] tp = typicalPrice.executeSet(high, low, close);

		SimpleMovingAverage simpleMovingAverage = new SimpleMovingAverage();
		double[] sma = simpleMovingAverage.execute(tp, range);

		double[] cci = new double[high.length];

		double[] meanDev = new double[high.length];

		double sum = 0;
		double meanDeviation = 0;

		for (int i = (range - 1); i < close.length; i++) {

			sum = 0;
			meanDeviation = 0;

			for (int j = (i - range + 1); j < (i + 1); j++) {
				sum += Math.abs(tp[j] - sma[i]);
			}

			meanDeviation = sum / range;

			meanDev[i] = meanDeviation;

			if (meanDeviation == 0) {
				cci[i] = 0;
			} else {
				cci[i] = NumberFormatter.roundTwoDecimals((tp[i] - sma[i]) / (0.015 * meanDeviation));
			}

		}

		return cci;
	}

}
