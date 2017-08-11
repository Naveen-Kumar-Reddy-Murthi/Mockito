/**
 * 
 */
package org.mnr.mockito;

import static org.mockito.Mockito.spy;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mnr.junitmockitointegration.CalculatorService;
import org.mnr.junitmockitointegration.MathApplication;

/**
 * @author Naveen Reddy
 *
 */
public class MathApplicationWithSpy {
	
	private MathApplication mathApplication;
	private CalculatorService calcService;
	
	@Before
	public void setUp(){
		
		mathApplication = new MathApplication();
		Calculator calculator = new Calculator();
		calcService= spy(calculator);
		mathApplication.setCalcService(calculator);
		
		
	}
	
	class Calculator implements CalculatorService{

		public double add(double input1, double input2) {
			return input1+input2;
		}

		public double substract(double input1, double input2) {
			throw new UnsupportedOperationException("Not Available");
		}

		public double multiply(double input1, double input2) {
			throw new UnsupportedOperationException("Not Available");
		}

		public double divide(double input1, double input2) {
			throw new UnsupportedOperationException("Not Available");
		}
		
		
	}
	
	@Test
	public void test(){
		
		Assert.assertEquals(mathApplication.add(10.0, 10.0), 20,0);
		
	}

}
