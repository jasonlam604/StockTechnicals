package com.jasonlam604.stocktechnicals.indicators;

public class CommodityChannelIndex {

	public double execute(double[] high,double[] low,double[] close,int range) throws Exception {
		
		TypicalPrice typicalPrice = new TypicalPrice();
		double[] tp = typicalPrice.executeSet(high,low,close);
		
		SimpleMovingAverage simpleMovingAverage = new SimpleMovingAverage();
		double[] sma = simpleMovingAverage.execute(tp, range);
		
		double cci = 0;
		
	
		for (int i= range-1; i<close.length; i++) {
			
			double sum = 0;
			double mean_deviation = 0;
			
			for (int j = i - range + 1; j < i+1; j++){
				sum += Math.abs(tp[j]-sma[i]);    
			}

		}
		
		return cci; 
	}
	
}
