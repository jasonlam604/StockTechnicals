package com.jasonlam604.stocktechnicals.util;

import org.junit.Assert;
import org.junit.Test;

public class HighestHighTest {

	@Test
	public void testHighestHighIndexZeroToTwo() {
		double[] values = { 13.3, 19.9, 10, 21, 7.7 };

		HighestHigh highestHigh = new HighestHigh();
		highestHigh.find(values,0, 2);
		Assert.assertEquals(19.9, highestHigh.getValue(), 0);
		Assert.assertEquals(1, highestHigh.getIndex(), 0);
	}
	
	@Test
	public void testHighestHighIndexTwoToFour() {
		double[] values = { 13.3, 19.9, 10, 21, 7.7,9.9,12.4 };
		
		HighestHigh highestHigh = new HighestHigh();
		highestHigh = new HighestHigh();
		highestHigh.find(values, 2, 4);
		Assert.assertEquals(21, highestHigh.getValue(), 0);
		Assert.assertEquals(3, highestHigh.getIndex(), 0);
	}

	@Test
	public void testHighestHighUsingValueSize() {
		double[] values = { 13.3, 19.9, 10, 21, 7.7,9.9,12.4 };

		HighestHigh highestHigh = new HighestHigh();
		highestHigh.find(values, 0, 5);
		Assert.assertEquals(21, highestHigh.getValue(), 0);
		Assert.assertEquals(3, highestHigh.getIndex(), 0);
	}

}
