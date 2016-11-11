package com.jasonlam604.stocktechnicals.indicators;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;
import org.apache.commons.lang3.ArrayUtils;

public class CommodityChannelIndexTest {

	@Test
	public void calcCCI() {

		double[] high = { 24.20, 24.07, 24.04, 23.87, 23.67, 23.59, 23.80, 23.80, 24.30, 24.15, 24.05, 24.06, 23.88,
				25.14, 25.20, 25.07, 25.22, 25.37, 25.36, 25.26, 24.82, 24.44, 24.65, 24.84, 24.75, 24.51, 24.68, 24.67,
				23.84, 24.30 };

		double[] low = { 23.85, 23.72, 23.64, 23.37, 23.46, 23.18, 23.40, 23.57, 24.05, 23.77, 23.60, 23.84, 23.64,
				23.94, 24.74, 24.77, 24.90, 24.93, 24.96, 24.93, 24.21, 24.21, 24.43, 24.44, 24.20, 24.25, 24.21, 24.15,
				23.63, 23.76 };

		double[] close = { 23.89, 23.95, 23.67, 23.78, 23.50, 23.32, 23.75, 23.79, 24.14, 23.81, 23.78, 23.86, 23.70,
				24.96, 24.88, 24.96, 25.18, 25.07, 25.27, 25.00, 24.46, 24.28, 24.62, 24.58, 24.53, 24.35, 24.34, 24.23,
				23.76, 24.20 };

		CommodityChannelIndex commodityChannelIndex = new CommodityChannelIndex();

		try {
			double results[] = commodityChannelIndex.calculate(high, low, close, 20).getCCI();

			Assert.assertEquals(101.74, results[19], 0);
			Assert.assertEquals(31.91, results[20], 0);
			Assert.assertEquals(6.01, results[21], 0);
			Assert.assertEquals(34.16, results[22], 0);
			Assert.assertEquals(35.22, results[23], 0);
			Assert.assertEquals(13.54, results[24], 0);
			Assert.assertEquals(-10.68, results[25], 0);
			Assert.assertEquals(-11.81, results[26], 0);
			Assert.assertEquals(-29.34, results[27], 0);
			Assert.assertEquals(-130.38, results[28], 0);
			Assert.assertEquals(-72.99, results[29], 0);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
