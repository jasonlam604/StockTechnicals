package com.jasonlam604.stocktechnicals.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class NumberFormatterTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
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
	
	@Test
	public void testPrivateConstructor()  {
		final Constructor<?>[] constructors = NumberFormatter.class.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            Assert.assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        }
	}
}
