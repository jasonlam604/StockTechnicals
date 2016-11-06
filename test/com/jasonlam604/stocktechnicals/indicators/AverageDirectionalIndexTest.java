package com.jasonlam604.stocktechnicals.indicators;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AverageDirectionalIndexTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private double high[];
	private double low[];
	private double close[];

	@Test
	public void calcAdx() {
		high = new double[] { 30.20, 30.28, 30.45, 29.35, 29.35, 29.29, 28.83, 28.73, 28.67, 28.85, 28.64, 27.68, 27.21,
				26.87, 27.41, 26.94, 26.52, 26.52, 27.09, 27.69, 28.45, 28.53, 28.67, 29.01, 29.87, 29.80, 29.75, 30.65,
				30.60, 30.76, 31.17, 30.89, 30.04, 30.66 };
		low = new double[] { 29.41, 29.32, 29.96, 28.74, 28.56, 28.41, 28.08, 27.43, 27.66, 27.83, 27.40, 27.09, 26.18,
				26.13, 26.63, 26.13, 25.43, 25.35, 25.88, 26.96, 27.14, 28.01, 27.88, 27.99, 28.76, 29.14, 28.71, 28.93,
				30.03, 29.39, 30.14, 30.43, 29.35, 29.99 };
		close = new double[] { 29.87, 30.24, 30.10, 28.90, 28.92, 28.48, 28.56, 27.56, 28.47, 28.28, 27.49, 27.23,
				26.35, 26.33, 27.03, 26.22, 26.01, 25.46, 27.03, 27.45, 28.36, 28.43, 27.95, 29.01, 29.38, 29.36, 28.91,
				30.61, 30.05, 30.19, 31.12, 30.54, 29.78, 30.04 };

		AverageDirectionalIndex adx = new AverageDirectionalIndex();
		try {
			double[] results = adx.execute(high, low, close, 14);

			Assert.assertEquals(24.06, results[results.length - 1], 0);
			Assert.assertEquals(25.91, results[results.length - 2], 0);
			Assert.assertEquals(27.06, results[results.length - 3], 0);
			Assert.assertEquals(28.52, results[results.length - 4], 0);
			Assert.assertEquals(30.08, results[results.length - 5], 0);
			Assert.assertEquals(32.30, results[results.length - 6], 0);
			Assert.assertEquals(33.73, results[results.length - 7], 0);

		} catch (Exception e) {

		}
	}

	@Test
	public void expectWrongSizeException() throws Exception {

		high = new double[] { 30.20, 30.28, 30.45, 29.35, 29.35, 29.29, 28.83, 28.73, 28.67, 28.85, 28.64, 27.68, 27.21,
				26.87, 27.41, 26.94, 26.52, 26.52, 27.09, 27.69, 28.45, 28.53, 28.67, 29.01, 29.87, 29.80, 29.75, 30.65,
				30.60, 30.76, 31.17, 30.89, 30.04, 30.66 };
		low = new double[] { 29.41, 29.32, 29.96, 28.74, 28.56, 28.41, 28.08, 27.43, 27.66, 27.83, 27.40, 27.09, 26.18,
				26.13, 26.63, 26.13, 25.43, 25.35, 25.88, 26.96, 27.14, 28.01, 27.88, 27.99, 28.76, 29.14, 28.71, 28.93,
				30.03, 29.39, 30.14, 30.43, 29.35, 29.99 };
		close = new double[] { 30.19, 31.12, 30.54, 29.78, 30.04 };

		thrown.expect(Exception.class);
		thrown.expectMessage("High, Low and Close are not equal in size");

		AverageDirectionalIndex adx = new AverageDirectionalIndex();
		adx.execute(high, low, close, 14);
	}

	
	@Test
	public void expectPeriodLargerThenDataException() throws Exception {

		high = new double[] { 30.20, 30.28, 30.45, 29.35, 29.35, 29.29, 28.83, 28.73, 28.67, 28.85, 28.64, 27.68, 27.21,
				26.87, 27.41, 26.94, 26.52, 26.52, 27.09, 27.69, 28.45, 28.53, 28.67, 29.01, 29.87, 29.80, 29.75, 30.65,
				30.60, 30.76, 31.17, 30.89, 30.04, 30.66 };
		low = new double[] { 29.41, 29.32, 29.96, 28.74, 28.56, 28.41, 28.08, 27.43, 27.66, 27.83, 27.40, 27.09, 26.18,
				26.13, 26.63, 26.13, 25.43, 25.35, 25.88, 26.96, 27.14, 28.01, 27.88, 27.99, 28.76, 29.14, 28.71, 28.93,
				30.03, 29.39, 30.14, 30.43, 29.35, 29.99 };
		close = new double[] { 30.19, 31.12, 30.54, 29.78, 30.04 };

		thrown.expect(Exception.class);
		thrown.expectMessage("Given range is bigger then given data set");

		AverageDirectionalIndex adx = new AverageDirectionalIndex();
		adx.execute(high, low, close, 1000);
	}
}
