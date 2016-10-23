package com.jasonlam604.stockanalyzer.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class NumberHelper {

	public static double roundTwoDecimals(double value) {
		return NumberHelper.round(value,2);
	}
	
	public static double round(double value, int numberOfDigitsAfterDecimalPoint) {
        BigDecimal bigDecimal = new BigDecimal(value);
        bigDecimal = bigDecimal.setScale(numberOfDigitsAfterDecimalPoint, BigDecimal.ROUND_HALF_UP);
        return bigDecimal.doubleValue();
    }

}
