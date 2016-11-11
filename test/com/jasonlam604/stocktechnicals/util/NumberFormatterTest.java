package com.jasonlam604.stocktechnicals.util;

import org.junit.Assert;
import org.junit.Test;

public class NumberFormatterTest {

	@Test
	public void roundingTwoDecimals() {
		Assert.assertEquals(10, NumberFormatter.round(10), 0);
		Assert.assertEquals(1, NumberFormatter.round(1), 0);
		Assert.assertEquals(1.1, NumberFormatter.round(1.1), 0);
		Assert.assertEquals(1.14, NumberFormatter.round(1.144), 0);
		Assert.assertEquals(1.15, NumberFormatter.round(1.145), 0);
		Assert.assertEquals(1.20, NumberFormatter.round(1.19555555), 0);
	}

	@Test
	public void roundingWithIndicateDecimalPoints() {
		Assert.assertEquals(1, NumberFormatter.round(1.19555555, 0), 0);
		Assert.assertEquals(1.2, NumberFormatter.round(1.19555555, 1), 0);
		Assert.assertEquals(1.20, NumberFormatter.round(1.19555555, 2), 0);
		Assert.assertEquals(1.196, NumberFormatter.round(1.19555555, 3), 0);
	}
}
