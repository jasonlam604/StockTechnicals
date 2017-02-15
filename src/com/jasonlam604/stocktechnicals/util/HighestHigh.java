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
	public void find(double[] high, int range) {

		this.doubles = ArrayUtils.toObject(high);

		int limit = doubles.length - 1;

		if (range < limit)
			limit = range;

		IntStream.range(0, limit).parallel().reduce((a, b) -> doubles[a] < doubles[b] ? b : a)
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
