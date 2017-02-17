package com.jasonlam604.stocktechnicals.util;

import java.util.stream.IntStream;

import org.apache.commons.lang3.ArrayUtils;

public class HighestHigh {

	private Double[] doubles;

	private int index;

	private double value;

	/**
	 * Finds the highest high from index 0 and to the indicated give range index
	 * 
	 * @param high
	 *            array of high values
	 * @param range
	 */
	public void find(double[] high, int startIndex, int endIndex) {

		this.doubles = ArrayUtils.toObject(high);
		
		if(startIndex < 0 || startIndex > endIndex)
			startIndex = 0;
		
		if(endIndex < startIndex || endIndex > (doubles.length - 1))
			endIndex = doubles.length - 1;

		IntStream.range(startIndex, endIndex).parallel().reduce((a, b) -> doubles[a] < doubles[b] ? b : a)
				.ifPresent(ix -> setValues(ix));

	}

	private void setValues(int ix) {
		this.index = ix;
		this.value = doubles[ix];
	}

	public double getValue() {
		return this.value;
	}

	public int getIndex() {
		return this.index;
	}
}
