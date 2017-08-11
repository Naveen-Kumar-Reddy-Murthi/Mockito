/**
 * 
 */
package org.mnr.mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.inOrder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mnr.junitmockitointegration.CalculatorService;
import org.mnr.junitmockitointegration.MathApplication;
import org.mockito.InOrder;
import org.mockito.runners.MockitoJUnitRunner;

import com.sun.org.glassfish.external.statistics.annotations.Reset;

/**
 * @author Naveen Reddy
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationWithmockAndOrderTester {
   
	private CalculatorService calcService;
	private MathApplication mathApplication;

	@Before
	public void setUp(){
		mathApplication = new MathApplication();
		calcService= mock(CalculatorService.class);
		mathApplication.setCalcService(calcService);
        
	}
	
	@Test
	public void testAddandSubstract(){
		
		//add the behavior to add numbers
	      when(calcService.add(20.0,10.0)).thenReturn(30.0);

	      //subtract the behavior to subtract numbers
	      when(calcService.substract(20.0,10.0)).thenReturn(10.0);

	      //test the subtract functionality
	      Assert.assertEquals(mathApplication.substract(20.0, 10.0),10.0,0);

	      //test the add functionality
	      Assert.assertEquals(mathApplication.add(20.0, 10.0),30.0,0);

	      //verify call to calcService is made or not
	      verify(calcService).add(20.0,10.0);
	      verify(calcService).substract(20.0,10.0);
	      
	      InOrder inOrder =inOrder(calcService);
	      inOrder.verify(calcService).substract(20.0, 10.0);
	      inOrder.verify(calcService).add(20.0, 10.0);
	      
	      reset(calcService);
	      
//	      Assert.assertEquals(mathApplication.add(20.0, 10.0),30.0,0);//it fails as it was reset
	}

}
