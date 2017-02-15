package com.jasonlam604.stocktechnicals.util;

import org.junit.Assert;
import org.junit.Test;

public class HighestHighTest {

	@Test
	public void testHighestHighUsingRangeLimit() {

		double[] values = { 13.3, 19.9, 10, 21, 7.7 };

		int rangeLimit = 2; // Should be used because is less then size of
							// values

		HighestHigh highestHigh = new HighestHigh();
		highestHigh.find(values, rangeLimit);

		Assert.assertEquals(19.9, highestHigh.getValue(), 0);
		Assert.assertEquals(1, highestHigh.getIndex(), 0);
	}

	@Test
	public void testHighestHighUsingValueSize() {

		double[] values = { 13.3, 19.9, 10, 21, 7.7 };

		int rangeLimit = 20; // Should NOT be used because is more then size of
								// values

		HighestHigh highestHigh = new HighestHigh();
		highestHigh.find(values, rangeLimit);

		Assert.assertEquals(21, highestHigh.getValue(), 0);
		Assert.assertEquals(3, highestHigh.getIndex(), 0);
	}

}
