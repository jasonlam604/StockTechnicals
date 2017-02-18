package com.jasonlam604.stocktechnicals.util;

import org.junit.Assert;
import org.junit.Test;

public class LowestLowTest {

	@Test
	public void testLowestHighIndexZeroToTwo() {
		double[] values = { 13.3, 19.9, 10, 21, 7.7 };

		LowestLow lowestLow = new LowestLow();
		lowestLow.find(values, 0, 2);

		Assert.assertEquals(13.3, lowestLow.getValue(), 0);
		Assert.assertEquals(0, lowestLow.getIndex(), 0);
	}
	
	@Test
	public void testLowestHighIndexTwoToFour() {
		double[] values = { 13.3, 19.9, 10, 21, 7.7 };

		LowestLow lowestLow = new LowestLow();
		lowestLow.find(values, 2, 2);

		Assert.assertEquals(10.0, lowestLow.getValue(), 0);
		Assert.assertEquals(2, lowestLow.getIndex(), 0);
	}

	@Test
	public void testLowestHighUsingValueSize() {
		double[] values = { 13.3, 19.9, 10, 21, 7.7 };

		LowestLow lowestLow = new LowestLow();
		lowestLow.find(values, 0, 2);

		Assert.assertEquals(13.3, lowestLow.getValue(), 0);
		Assert.assertEquals(0, lowestLow.getIndex(), 0);
	}

}
