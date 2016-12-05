package com.jasonlam604.stocktechnicals.overlays;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.jasonlam604.stocktechnicals.overlays.PivotPoints;

// See http://stockcharts.com/school/doku.php?id=chart_school:technical_indicators:pivot_points
// on determine what high, low, close to use
public class PivotPointsTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void calcPPResistanceSupport() {

		PivotPoints pivotPoints = new PivotPoints();
		pivotPoints.calculate(61.26, 57.28, 60.61);

		// Assert Resistance and Support
		Assert.assertEquals(70.14, pivotPoints.getR7(), 0);
		Assert.assertEquals(67.68, pivotPoints.getR6(), 0);
		Assert.assertEquals(66.16, pivotPoints.getR5(), 0);
		Assert.assertEquals(64.77, pivotPoints.getR4(), 0);
		Assert.assertEquals(63.70, pivotPoints.getR3(), 0);
		Assert.assertEquals(62.18, pivotPoints.getR2(), 0);
		Assert.assertEquals(61.24, pivotPoints.getR1(), 0);
		Assert.assertEquals(59.72, pivotPoints.getPP(), 0);
		Assert.assertEquals(58.20, pivotPoints.getS1(), 0);
		Assert.assertEquals(57.26, pivotPoints.getS2(), 0);
		Assert.assertEquals(55.74, pivotPoints.getS3(), 0);
		Assert.assertEquals(54.66, pivotPoints.getS4(), 0);
		Assert.assertEquals(53.28, pivotPoints.getS5(), 0);
		Assert.assertEquals(51.76, pivotPoints.getS6(), 0);
		Assert.assertEquals(49.30, pivotPoints.getS7(), 0);
		
		
		try {
			
			// Test Zones Boundaries (top and bottom)
			
			Assert.assertEquals( pivotPoints.getS6(), pivotPoints.zoneTopValue(PivotPoints.ZONE_NEG_7), 0);
			Assert.assertEquals( pivotPoints.getS7(), pivotPoints.zoneBottomValue(PivotPoints.ZONE_NEG_7), 0);
			
			Assert.assertEquals( pivotPoints.getS5(), pivotPoints.zoneTopValue(PivotPoints.ZONE_NEG_6), 0);
			Assert.assertEquals( pivotPoints.getS6(), pivotPoints.zoneBottomValue(PivotPoints.ZONE_NEG_6), 0);

			Assert.assertEquals( pivotPoints.getS4(), pivotPoints.zoneTopValue(PivotPoints.ZONE_NEG_5), 0);
			Assert.assertEquals( pivotPoints.getS5(), pivotPoints.zoneBottomValue(PivotPoints.ZONE_NEG_5), 0);
			
			Assert.assertEquals( pivotPoints.getS3(), pivotPoints.zoneTopValue(PivotPoints.ZONE_NEG_4), 0);
			Assert.assertEquals( pivotPoints.getS4(), pivotPoints.zoneBottomValue(PivotPoints.ZONE_NEG_4), 0);
			
			Assert.assertEquals( pivotPoints.getS2(), pivotPoints.zoneTopValue(PivotPoints.ZONE_NEG_3), 0);
			Assert.assertEquals( pivotPoints.getS3(), pivotPoints.zoneBottomValue(PivotPoints.ZONE_NEG_3), 0);

			Assert.assertEquals( pivotPoints.getS1(), pivotPoints.zoneTopValue(PivotPoints.ZONE_NEG_2), 0);
			Assert.assertEquals( pivotPoints.getS2(), pivotPoints.zoneBottomValue(PivotPoints.ZONE_NEG_2), 0);
			
			Assert.assertEquals( pivotPoints.getPP(), pivotPoints.zoneTopValue(PivotPoints.ZONE_NEG_1), 0);
			Assert.assertEquals( pivotPoints.getS1(), pivotPoints.zoneBottomValue(PivotPoints.ZONE_NEG_1), 0);

			Assert.assertEquals( pivotPoints.getR1(), pivotPoints.zoneTopValue(PivotPoints.ZONE_POS_1), 0);
			Assert.assertEquals( pivotPoints.getPP(), pivotPoints.zoneBottomValue(PivotPoints.ZONE_POS_1), 0);

			Assert.assertEquals( pivotPoints.getR2(), pivotPoints.zoneTopValue(PivotPoints.ZONE_POS_2), 0);
			Assert.assertEquals( pivotPoints.getR1(), pivotPoints.zoneBottomValue(PivotPoints.ZONE_POS_2), 0);

			Assert.assertEquals( pivotPoints.getR3(), pivotPoints.zoneTopValue(PivotPoints.ZONE_POS_3), 0);
			Assert.assertEquals( pivotPoints.getR2(), pivotPoints.zoneBottomValue(PivotPoints.ZONE_POS_3), 0);
			
			Assert.assertEquals( pivotPoints.getR4(), pivotPoints.zoneTopValue(PivotPoints.ZONE_POS_4), 0);
			Assert.assertEquals( pivotPoints.getR3(), pivotPoints.zoneBottomValue(PivotPoints.ZONE_POS_4), 0);
			
			Assert.assertEquals( pivotPoints.getR5(), pivotPoints.zoneTopValue(PivotPoints.ZONE_POS_5), 0);
			Assert.assertEquals( pivotPoints.getR4(), pivotPoints.zoneBottomValue(PivotPoints.ZONE_POS_5), 0);
			
			Assert.assertEquals( pivotPoints.getR6(), pivotPoints.zoneTopValue(PivotPoints.ZONE_POS_6), 0);
			Assert.assertEquals( pivotPoints.getR5(), pivotPoints.zoneBottomValue(PivotPoints.ZONE_POS_6), 0);
			
			Assert.assertEquals( pivotPoints.getR7(), pivotPoints.zoneTopValue(PivotPoints.ZONE_POS_7), 0);
			Assert.assertEquals( pivotPoints.getR6(), pivotPoints.zoneBottomValue(PivotPoints.ZONE_POS_7), 0);
		
			
			// Find Matching Zone based on price value
			Assert.assertEquals( PivotPoints.ZONE_POS_7, pivotPoints.findZone(69.99), 0);
			Assert.assertEquals( PivotPoints.ZONE_POS_6, pivotPoints.findZone(66.17), 0);
			Assert.assertEquals( PivotPoints.ZONE_POS_5, pivotPoints.findZone(64.78), 0);
			Assert.assertEquals( PivotPoints.ZONE_POS_4, pivotPoints.findZone(63.71), 0);
			Assert.assertEquals( PivotPoints.ZONE_POS_3, pivotPoints.findZone(62.19), 0);
			Assert.assertEquals( PivotPoints.ZONE_POS_2, pivotPoints.findZone(61.25), 0);
			Assert.assertEquals( PivotPoints.ZONE_POS_1, pivotPoints.findZone(59.73), 0);
			Assert.assertEquals( PivotPoints.ZONE_NEG_1, pivotPoints.findZone(58.21), 0);
			Assert.assertEquals( PivotPoints.ZONE_NEG_2, pivotPoints.findZone(57.27), 0);
			Assert.assertEquals( PivotPoints.ZONE_NEG_3, pivotPoints.findZone(55.75), 0);
			Assert.assertEquals( PivotPoints.ZONE_NEG_4, pivotPoints.findZone(54.67), 0);
			Assert.assertEquals( PivotPoints.ZONE_NEG_5, pivotPoints.findZone(53.29), 0);
			Assert.assertEquals( PivotPoints.ZONE_NEG_6, pivotPoints.findZone(51.77), 0);
			Assert.assertEquals( PivotPoints.ZONE_NEG_7, pivotPoints.findZone(49.31), 0);
		} catch (Exception e) {

		}
	}

	@Test
	public void testInvalidTopZone() throws Exception {

		PivotPoints pivotPoints = new PivotPoints();
		pivotPoints.calculate(61.26, 57.28, 60.61);

		thrown.expect(Exception.class);
		thrown.expectMessage("Invalid zone given");
		
		pivotPoints.zoneTopValue(9999);
	}
	
	@Test
	public void testInvalidBottomZone() throws Exception {

		PivotPoints pivotPoints = new PivotPoints();
		pivotPoints.calculate(61.26, 57.28, 60.61);

		thrown.expect(Exception.class);
		thrown.expectMessage("Invalid zone given");
		
		pivotPoints.zoneBottomValue(9999);
	}
	
	@Test
	public void testInvalidZoneMatch() throws Exception {

		PivotPoints pivotPoints = new PivotPoints();
		pivotPoints.calculate(61.26, 57.28, 60.61);

		thrown.expect(Exception.class);
		thrown.expectMessage("No matching zone");
		
		pivotPoints.findZone(9999);
	}
}
