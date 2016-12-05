package com.jasonlam604.stocktechnicals.indicators;

import org.junit.Assert;
import org.junit.Test;

public class ParabolicSarTest {

	/**
	 * Test values from
	 * http://stockcharts.com/school/doku.php?id=chart_school:technical_indicators:parabolic_sar
	 * 
	 * See SAR Up Trend data points
	 * 
	 */
	@Test
	public void testPsarUpTrend() {

		double[] high = new double[] { 48.11, 48.30, 48.17, 48.60, 48.33, 48.40, 48.55, 48.45, 48.70, 48.72, 48.90,
				48.87, 48.82, 49.05, 49.20, 49.35 };
		double[] low = new double[] { 47.25, 47.77, 47.91, 47.90, 47.74, 48.10, 48.06, 48.07, 47.79, 48.14, 48.39,
				48.37, 48.24, 48.64, 48.94, 48.86 };

		ParabolicSar psar = new ParabolicSar();
		psar.calculate(high, low);

		double[] psarResults = psar.getPsars();
		double[] trendsResults = psar.getTrends();

		for (int i = 1; i < trendsResults.length; i++) {
			Assert.assertEquals(1, trendsResults[i], 0);
		}

		Assert.assertEquals(47.25, psarResults[1], 0);
		Assert.assertEquals(47.25, psarResults[2], 0);
		Assert.assertEquals(47.27, psarResults[3], 0);
		Assert.assertEquals(47.32, psarResults[4], 0);
		Assert.assertEquals(47.38, psarResults[5], 0);
		Assert.assertEquals(47.42, psarResults[6], 0);
		Assert.assertEquals(47.47, psarResults[7], 0);
		Assert.assertEquals(47.52, psarResults[8], 0);
		Assert.assertEquals(47.59, psarResults[9], 0);
		Assert.assertEquals(47.68, psarResults[10], 0);
		Assert.assertEquals(47.80, psarResults[11], 0);
		Assert.assertEquals(47.91, psarResults[12], 0);
		Assert.assertEquals(48.01, psarResults[13], 0);
		Assert.assertEquals(48.13, psarResults[14], 0);
		Assert.assertEquals(48.28, psarResults[15], 0);
	}

	/**
	 * Test values from
	 * http://stockcharts.com/school/doku.php?id=chart_school:technical_indicators:parabolic_sar
	 * 
	 * See SAR Down Trend data points
	 * 
	 */
	@Test
	public void testPsarDownTrend() {

		double[] high = new double[] { 46.59, 46.55, 46.30, 45.43, 44.55, 44.84, 44.80, 44.38, 43.97, 43.23, 43.73,
				43.92, 43.61, 42.97, 43.13, 43.46 };
		double[] low = new double[] { 45.90, 45.38, 45.25, 43.99, 44.07, 44.00, 43.96, 43.27, 42.58, 42.83, 42.98,
				43.37, 42.57, 42.07, 42.59, 42.71 };

		ParabolicSar psar = new ParabolicSar();
		psar.calculate(high, low);

		double[] psarResults = psar.getPsars();
		double[] trendsResults = psar.getTrends();

		for (int i = 1; i < trendsResults.length; i++) {
			Assert.assertEquals(-1, trendsResults[i], 0);
		}

		Assert.assertEquals(46.59, psarResults[1], 0);
		Assert.assertEquals(46.59, psarResults[2], 0);
		Assert.assertEquals(46.55, psarResults[3], 0);
		Assert.assertEquals(46.40, psarResults[4], 0);
		Assert.assertEquals(46.25, psarResults[5], 0);
		Assert.assertEquals(46.12, psarResults[6], 0);
		Assert.assertEquals(45.94, psarResults[7], 0);
		Assert.assertEquals(45.68, psarResults[8], 0);
		Assert.assertEquals(45.30, psarResults[9], 0);
		Assert.assertEquals(44.98, psarResults[10], 0);
		Assert.assertEquals(44.69, psarResults[11], 0);
		Assert.assertEquals(44.44, psarResults[12], 0);
		Assert.assertEquals(44.18, psarResults[13], 0);
		Assert.assertEquals(43.84, psarResults[14], 0);
		Assert.assertEquals(43.56, psarResults[15], 0);
	}

	/**
	 * Taho (THO on TSX), Trading days EOD data from Oct 19 2016 to Dec 02, 2016
	 * 
	 * Just quick test to see trend changes
	 */
	@Test
	public void testPsarUpAndDownTrend() {

		double[] high = new double[] { 16.14, 15.89, 16.14, 16.27, 16.59, 16.50, 16.15, 16.24, 16.24, 16.76, 16.91,
				16.17, 15.95, 14.89, 15.06, 15.37, 14.64, 14.5, 13.56, 13.62, 13.21, 13.49, 13.07, 13.16, 13.26, 12.63,
				12.59, 12.92, 12.9, 12.92, 12.91, 13.07, 13.46 };
		double[] low = new double[] { 15.62, 15.46, 15.79, 15.65, 15.95, 15.80, 15.61, 15.54, 15.65, 16.20, 15.65,
				15.58, 14.96, 14.18, 14.27, 14.3, 13.73, 13.12, 12.38, 12.9, 12.62, 12.82, 12.43, 12.75, 12.93, 11.95,
				12.39, 12.49, 12.53, 12.45, 12.51, 12.57, 12.73 };

		ParabolicSar psar = new ParabolicSar();
		psar.calculate(high, low);

		double[] trendsResults = psar.getTrends();

		Assert.assertEquals(1, trendsResults[9], 0);
		Assert.assertEquals(1, trendsResults[10], 0);
		Assert.assertEquals(-1, trendsResults[11], 0);
		Assert.assertEquals(-1, trendsResults[30], 0);
		Assert.assertEquals(1, trendsResults[32], 0);
		Assert.assertEquals(1, trendsResults[32], 0);

	}

}
