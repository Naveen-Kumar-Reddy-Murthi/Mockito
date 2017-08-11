/**
 * 
 */
package org.mnr.mockito;

import static org.mockito.BDDMockito.*;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mnr.junitmockitointegration.CalculatorService;
import org.mnr.junitmockitointegration.MathApplication;

import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author Naveen Reddy
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationBehaviouralTest {

	private MathApplication mathApplication;
	private CalculatorService calcService;
	
	@Before
	public void setUp(){
		
		mathApplication = new MathApplication();
		calcService = mock(CalculatorService.class);
		mathApplication.setCalcService(calcService);
	}

	
	@Test
	public void behaviourTest(){
		
		//when
		
		when(calcService.add(20, 10)).thenReturn(30.0);
		
		//Given
		given(calcService.add(10, 10)).willReturn(30.0);
		
		double result = calcService.add(20,10);
		
		//then
		
		Assert.assertEquals(result, 30.0,0);
	}
}
