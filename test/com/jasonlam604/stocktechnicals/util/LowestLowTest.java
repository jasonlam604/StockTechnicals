package com.jasonlam604.stocktechnicals.util;

import org.junit.Assert;
import org.junit.Test;

public class LowestLowTest {

	@Test
	public void testLowestHighUsingRangeLimit() {

		double[] values = { 13.3, 19.9, 10, 21, 7.7 };

		int rangeLimit = 2; // Should be used because is less then size of
							// values

		LowestLow lowestLow = new LowestLow();
		lowestLow.find(values, rangeLimit);

		Assert.assertEquals(13.3, lowestLow.getValue(), 0);
		Assert.assertEquals(0, lowestLow.getIndex(), 0);
	}

	@Test
	public void testLowestHighUsingValueSize() {

		double[] values = { 13.3, 19.9, 10, 21, 7.7 };

		int rangeLimit = 20; // Should NOT be used because is more then size of
								// values

		LowestLow lowestLow = new LowestLow();
		lowestLow.find(values, rangeLimit);

		Assert.assertEquals(10, lowestLow.getValue(), 0);
		Assert.assertEquals(2, lowestLow.getIndex(), 0);
	}

}
