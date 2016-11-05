package com.jasonlam604.stocktechnicals.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class NumberFormatter {

	public static double roundTwoDecimals(double value) {
		return NumberFormatter.round(value,2);
	}
	
	public static double round(double value, int numberOfDigitsAfterDecimalPoint) {
        BigDecimal bigDecimal = new BigDecimal(value);
        bigDecimal = bigDecimal.setScale(numberOfDigitsAfterDecimalPoint, BigDecimal.ROUND_HALF_UP);
        return bigDecimal.doubleValue();
    }

}
