package com.jasonlam604.stocktechnicals.overlays;

import org.junit.Assert;
import org.junit.Test;

import com.jasonlam604.stocktechnicals.overlays.PivotPoints;

// See http://stockcharts.com/school/doku.php?id=chart_school:technical_indicators:pivot_points
// on determine what high, low, close to use
public class PivotPointsTest {

    @Test
    public void calcTypicalPrice() {
    	
    	PivotPoints pivotPoints = new PivotPoints();
    	pivotPoints.calculate(61.26,57.28,60.61);
    	
    	Assert.assertEquals(62.18, pivotPoints.getR2() , 0);
    	Assert.assertEquals(61.24, pivotPoints.getR1() , 0);
    	Assert.assertEquals(59.72, pivotPoints.getPP() , 0);
    	Assert.assertEquals(58.20, pivotPoints.getS1() , 0);
    	Assert.assertEquals(57.26, pivotPoints.getS2() , 0);
    }
	
}
