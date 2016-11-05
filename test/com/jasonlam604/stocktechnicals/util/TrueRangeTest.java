package com.jasonlam604.stocktechnicals.util;

import com.jasonlam604.stocktechnicals.util.TrueRange;

import org.junit.Test;
import org.junit.Assert;

public class TrueRangeTest {

	@Test
	public void calcTrueRange() {
		TrueRange trueRange = new TrueRange();
	
		Assert.assertEquals(0.57, trueRange.execute(44.93, 44.36, 44.52), 0);
	    Assert.assertEquals(0.95, trueRange.execute(45.39, 44.70, 45.65), 0);
		Assert.assertEquals(0.57, trueRange.execute(45.70, 45.13, 45.22), 0);
		Assert.assertEquals(0.74, trueRange.execute(45.63, 44.89, 45.45), 0);
		Assert.assertEquals(1.32, trueRange.execute(45.52, 44.20, 45.49), 0);
	}


}
