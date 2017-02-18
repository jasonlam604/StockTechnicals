package com.jasonlam604.stocktechnicals.util;

public class HighestHigh {

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

		this.value = high[startIndex];
		this.index = startIndex;	

		for (int i=startIndex; i < endIndex+startIndex; i++) {
			
			if (high[i] > this.value) {
				
				this.value = high[i];
				this.index = i;
				
			}
		}
	}

	public double getValue() {
		return this.value;
	}

	public int getIndex() {
		return this.index;
	}
}
