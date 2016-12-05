package com.jasonlam604.stocktechnicals.overlays;

import com.jasonlam604.stocktechnicals.util.NumberFormatter;

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

	public int findZone(double price) throws Exception {
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

		throw new Exception("No matching zone");
	}

	public double zoneTopValue(int zone) throws Exception {

		if (zone == PivotPoints.ZONE_NEG_7)
			return this.getS6();
		else if (zone == PivotPoints.ZONE_NEG_6)
			return this.getS5();
		else if (zone == PivotPoints.ZONE_NEG_5)
			return this.getS4();
		else if (zone == PivotPoints.ZONE_NEG_4)
			return this.getS3();
		else if (zone == PivotPoints.ZONE_NEG_3)
			return this.getS2();
		else if (zone == PivotPoints.ZONE_NEG_2)
			return this.getS1();
		else if (zone == PivotPoints.ZONE_NEG_1)
			return this.getPP();
		else if (zone == PivotPoints.ZONE_POS_1)
			return this.getR1();
		else if (zone == PivotPoints.ZONE_POS_2)
			return this.getR2();
		else if (zone == PivotPoints.ZONE_POS_3)
			return this.getR3();
		else if (zone == PivotPoints.ZONE_POS_4)
			return this.getR4();
		else if (zone == PivotPoints.ZONE_POS_5)
			return this.getR5();
		else if (zone == PivotPoints.ZONE_POS_6)
			return this.getR6();
		else if (zone == PivotPoints.ZONE_POS_7)
			return this.getR7();
		else
			throw new Exception("Invalid zone given");
	}

	public double zoneBottomValue(int zone) throws Exception {

		if (zone == PivotPoints.ZONE_NEG_7)
			return this.getS7();
		else if (zone == PivotPoints.ZONE_NEG_6)
			return this.getS6();
		else if (zone == PivotPoints.ZONE_NEG_5)
			return this.getS5();
		else if (zone == PivotPoints.ZONE_NEG_4)
			return this.getS4();
		else if (zone == PivotPoints.ZONE_NEG_3)
			return this.getS3();
		else if (zone == PivotPoints.ZONE_NEG_2)
			return this.getS2();
		else if (zone == PivotPoints.ZONE_NEG_1)
			return this.getS1();
		else if (zone == PivotPoints.ZONE_POS_1)
			return this.getPP();
		else if (zone == PivotPoints.ZONE_POS_2)
			return this.getR1();
		else if (zone == PivotPoints.ZONE_POS_3)
			return this.getR2();
		else if (zone == PivotPoints.ZONE_POS_4)
			return this.getR3();
		else if (zone == PivotPoints.ZONE_POS_5)
			return this.getR4();
		else if (zone == PivotPoints.ZONE_POS_6)
			return this.getR5();
		else if (zone == PivotPoints.ZONE_POS_7)
			return this.getR6();
		else
			throw new Exception("Invalid zone given");
	}

	public double getR1() {
		return NumberFormatter.round(r1,2);
	}

	public double getR2() {
		return NumberFormatter.round(r2,2);
	}

	public double getR3() {
		return NumberFormatter.round(r3,2);
	}

	public double getR4() {
		return NumberFormatter.round(r4,2);
	}

	public double getR5() {
		return NumberFormatter.round(r5,2);
	}

	public double getR6() {
		return NumberFormatter.round(r6,2);
	}

	public double getR7() {
		return NumberFormatter.round(r7,2);
	}

	public double getS1() {
		return NumberFormatter.round(s1,2);
	}

	public double getS2() {
		return NumberFormatter.round(s2,2);
	}

	public double getS3() {
		return NumberFormatter.round(s3,2);
	}

	public double getS4() {
		return NumberFormatter.round(s4,2);
	}

	public double getS5() {
		return NumberFormatter.round(s5,2);
	}

	public double getS6() {
		return NumberFormatter.round(s6,2);
	}

	public double getS7() {
		return NumberFormatter.round(s7,2);
	}

	public double getPP() {
		return NumberFormatter.round(pivotPoint,2);
	}

}
