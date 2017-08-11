/**
 * 
 */
package org.mnr.mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.timeout;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.mnr.junitmockitointegration.CalculatorService;
import org.mnr.junitmockitointegration.MathApplication;

/**
 * @author Naveen Reddy
 *
 */
public class MathApplicationTimeOutTester {

	private MathApplication mathApplication;
	private CalculatorService calcService;
	
	@Before
	public void setUp(){
		
		mathApplication = new MathApplication();
		calcService = mock(CalculatorService.class);
		mathApplication.setCalcService(calcService);
	}

	@Test
	public void test() {
		when(calcService.add(10, 10)).thenReturn(20.0);
		when(calcService.substract(20,10)).thenReturn(10.0);
		
		Assert.assertEquals(mathApplication.add(10, 10), 20.0,0);
		
		verify(calcService,timeout(100)).add(10, 10);
		verify(calcService,timeout(100).times(1)).add(10,10);
	}

}
