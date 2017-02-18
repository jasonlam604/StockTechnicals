package com.jasonlam604.stocktechnicals.util;

public class LowestLow {

	private int index;

	private double value;

	/**
	 * Finds the lowest low from index 0 and to the indicated give range index
	 * 
	 * @param low
	 *            array of high values
	 * @param range
	 */
	public void find(double[] low, int startIndex, int endIndex) {

		this.value = low[startIndex];
		this.index = startIndex;	

		for (int i=startIndex; i < endIndex+startIndex; i++) {
			
			if (low[i] < this.value) {
				
				this.value = low[i];
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
