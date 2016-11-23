package com.jasonlam604.stocktechnicals.overlays;

/**
 * Pivots Points
 */
public class PivotPoints {

	public static int ZONE_POS_1 = 1;
	public static int ZONE_POS_2 = 2;
	public static int ZONE_POS_3 = 3;
	public static int ZONE_POS_4 = 4;
	public static int ZONE_POS_5 = 5;
	public static int ZONE_POS_6 = 6;
	public static int ZONE_POS_7 = 7;

	public static int ZONE_NEG_1 = -1;
	public static int ZONE_NEG_2 = -2;
	public static int ZONE_NEG_3 = -3;
	public static int ZONE_NEG_4 = -4;
	public static int ZONE_NEG_5 = -5;
	public static int ZONE_NEG_6 = -6;
	public static int ZONE_NEG_7 = -7;

	public static int ZONE_UNKNOWN = 0;

	// private double pivotPoint;
	private double r1;
	private double r2;
	private double r3;
	private double r4;
	private double r5;
	private double r6;
	private double r7;
	private double s1;
	private double s2;
	private double s3;
	private double s4;
	private double s5;
	private double s6;
	private double s7;

	private double pivotPoint;

	public PivotPoints() {

	}

	/**
	 * Generate Support and Resistance values
	 */
	public void calculate(double high, double low, double close) {
		this.generateSupportAndResistance(high, low, close);
	}

	private void generateSupportAndResistance(double high, double low, double close) {

		// Pivot Point
		this.pivotPoint = (high + low + close) / 3;

		// Resistance Values
		this.r1 = this.pivotPoint + (0.382 * (high - low));
		this.r2 = this.pivotPoint + (0.618 * (high - low));
		this.r3 = this.pivotPoint + (1 * (high - low));
		this.r4 = this.pivotPoint + (1.27 * (high - low));
		this.r5 = this.pivotPoint + (1.618 * (high - low));
		this.r6 = this.pivotPoint + (2 * (high - low));
		this.r7 = this.pivotPoint + (2.618 * (high - low));

		// Support Values
		this.s1 = this.pivotPoint - (0.382 * (high - low));
		this.s2 = this.pivotPoint - (0.618 * (high - low));
		this.s3 = this.pivotPoint - (1 * (high - low));
		this.s4 = this.pivotPoint - (1.27 * (high - low));
		this.s5 = this.pivotPoint - (1.618 * (high - low));
		this.s6 = this.pivotPoint - (2 * (high - low));
		this.s7 = this.pivotPoint - (2.618 * (high - low));
	}

	public int findZone(int price) throws Exception {
		if (price >= this.s7 && price < this.s6) {
			return PivotPoints.ZONE_NEG_7;
		} else if (price >= this.s6 && price < this.s5) {
			return PivotPoints.ZONE_NEG_6;
		} else if (price >= this.s5 && price < this.s4) {
			return PivotPoints.ZONE_NEG_5;
		} else if (price >= this.s4 && price < this.s3) {
			return PivotPoints.ZONE_NEG_4;
		} else if (price >= this.s3 && price < this.s2) {
			return PivotPoints.ZONE_NEG_3;
		} else if (price >= this.s2 && price < this.s1) {
			return PivotPoints.ZONE_NEG_2;
		} else if (price >= this.s1 && price < this.pivotPoint) {
			return PivotPoints.ZONE_NEG_1;
		} else if (price >= this.pivotPoint && price < this.r1) {
			return PivotPoints.ZONE_POS_1;
		} else if (price >= this.r1 && price < this.r2) {
			return PivotPoints.ZONE_POS_2;
		} else if (price >= this.r2 && price < this.r3) {
			return PivotPoints.ZONE_POS_3;
		} else if (price >= this.r3 && price < this.r4) {
			return PivotPoints.ZONE_POS_4;
		} else if (price >= this.r4 && price < this.r5) {
			return PivotPoints.ZONE_POS_5;
		} else if (price >= this.r5 && price < this.r6) {
			return PivotPoints.ZONE_POS_6;
		} else if (price >= this.r6 && price < this.r7) {
			return PivotPoints.ZONE_POS_7;
		}

		throw new Exception("No matching Zone");
	}

	public double zoneTopValue(int zone) throws Exception {

		if (zone == PivotPoints.ZONE_NEG_7)
			return this.s6;
		else if (zone == PivotPoints.ZONE_NEG_6)
			return this.s5;
		else if (zone == PivotPoints.ZONE_NEG_5)
			return this.s4;
		else if (zone == PivotPoints.ZONE_NEG_4)
			return this.s3;
		else if (zone == PivotPoints.ZONE_NEG_3)
			return this.s2;
		else if (zone == PivotPoints.ZONE_NEG_2)
			return this.s1;
		else if (zone == PivotPoints.ZONE_NEG_1)
			return this.pivotPoint;
		else if (zone == PivotPoints.ZONE_POS_1)
			return this.r1;
		else if (zone == PivotPoints.ZONE_POS_2)
			return this.r2;
		else if (zone == PivotPoints.ZONE_POS_3)
			return this.r3;
		else if (zone == PivotPoints.ZONE_POS_4)
			return this.r4;
		else if (zone == PivotPoints.ZONE_POS_5)
			return this.r5;
		else if (zone == PivotPoints.ZONE_POS_6)
			return this.r6;
		else if (zone == PivotPoints.ZONE_POS_7)
			return this.r7;
		else
			throw new Exception("Invalid zone given");
	}

	public double zoneBottomValue(int zone) throws Exception {

		if (zone == PivotPoints.ZONE_NEG_7)
			return this.s7;
		else if (zone == PivotPoints.ZONE_NEG_6)
			return this.s6;
		else if (zone == PivotPoints.ZONE_NEG_5)
			return this.s5;
		else if (zone == PivotPoints.ZONE_NEG_4)
			return this.s4;
		else if (zone == PivotPoints.ZONE_NEG_3)
			return this.s3;
		else if (zone == PivotPoints.ZONE_NEG_2)
			return this.s2;
		else if (zone == PivotPoints.ZONE_NEG_1)
			return this.s1;
		else if (zone == PivotPoints.ZONE_POS_1)
			return this.pivotPoint;
		else if (zone == PivotPoints.ZONE_POS_2)
			return this.r1;
		else if (zone == PivotPoints.ZONE_POS_3)
			return this.r2;
		else if (zone == PivotPoints.ZONE_POS_4)
			return this.r3;
		else if (zone == PivotPoints.ZONE_POS_5)
			return this.r4;
		else if (zone == PivotPoints.ZONE_POS_6)
			return this.r5;
		else if (zone == PivotPoints.ZONE_POS_7)
			return this.r6;
		else
			throw new Exception("Invalid zone given");
	}

	public double getR1() {
		return r1;
	}

	public double getR2() {
		return r2;
	}

	public double getR3() {
		return r3;
	}

	public double getR4() {
		return r4;
	}

	public double getR5() {
		return r5;
	}

	public double getR6() {
		return r6;
	}

	public double getR7() {
		return r7;
	}

	public double getS1() {
		return s1;
	}

	public double getS2() {
		return s2;
	}

	public double getS3() {
		return s3;
	}

	public double getS4() {
		return s4;
	}

	public double getS5() {
		return s5;
	}

	public double getS6() {
		return s6;
	}

	public double getS7() {
		return s7;
	}

	public double getPivotPoint() {
		return pivotPoint;
	}

}
