package com.jasonlam604.stocktechnicals.indicators;

import java.math.BigDecimal;

import com.jasonlam604.stocktechnicals.util.HighestHigh;
import com.jasonlam604.stocktechnicals.util.LowestLow;
import com.jasonlam604.stocktechnicals.util.NumberFormatter;

/**
 * Aroon is an indicator system that determines whether a stock is trending or
 * not and how strong the trend is.
 * 
 * More info on Aroon here
 * http://stockcharts.com/school/doku.php?id=chart_school:technical_indicators:aroon
 *
 */
public class Aroon {

	public double[] calculateAroonUp(double[] high, int range) {
		double[] aroonUp = new double[high.length];

		for (int i = range - 1; i < high.length; i++) {
			HighestHigh highestHigh = new HighestHigh();
			highestHigh.find(high, i - range + 1, range);
			aroonUp[i] = this.calcAroon(range, (i - highestHigh.getIndex()));
		}
		return aroonUp;
	}

	public double[] calculateAroonDown(double[] low, int range) {
		double[] aroonDown = new double[low.length];

		for (int i = range - 1; i < low.length; i++) {
			LowestLow lowestLow = new LowestLow();
			lowestLow.find(low, i - range + 1, range);
			aroonDown[i] = this.calcAroon(range, (i - lowestLow.getIndex()));
		}
		return aroonDown;
	}

	public double[] calculateAroonOscillator(double[] high, double[] low, int range) {
		double[] aroonUp = this.calculateAroonUp(high, range);
		double[] aroonDown = this.calculateAroonDown(low, range);
		double[] aroonOscillator = new double[high.length];

		for (int i = range - 1; i < high.length; i++) {
			aroonOscillator[i] = NumberFormatter.round(aroonUp[i] - aroonDown[i]);
		}

		return aroonOscillator;
	}

	private double calcAroon(int range, int marker) {
		return NumberFormatter.round(100 * (BigDecimal.valueOf((range - marker)).divide(BigDecimal.valueOf(range), 2,
				BigDecimal.ROUND_UNNECESSARY)).doubleValue());
	}

}
