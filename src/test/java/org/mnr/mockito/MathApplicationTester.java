/**
 * 
 */
package org.mnr.mockito;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mnr.junitmockitointegration.CalculatorService;
import org.mnr.junitmockitointegration.MathApplication;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
/**
 * @author Naveen Reddy
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

	@InjectMocks
	MathApplication mathApplication = new MathApplication();
	
	@Mock
	CalculatorService calcService;
	
	@Test
	public void addTest(){
		//add the behavior of calc service to add two numbers
		when(calcService.add(10.0, 20.0)).thenReturn(30.00);
		
		//test the add functionality
		Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0,0);
		
		//verify the behavior
		verify(calcService).add(10.0, 20.0);
	}
	
	@Test
	public void substractTest(){
		//add the behavior of calc service to add two numbers
		when(calcService.substract(20.0, 10.0)).thenReturn(10.0);
		//test the substract functionality
		Assert.assertEquals(mathApplication.substract(20.0, 10.0), 10,0);
		//verify the behavior
		verify(calcService).substract(20.0, 10.0);
	}
	
	@Test
	public void multiplyTest(){
		//add the behavior of calc service to multiply two numbers
		when(calcService.multiply(10.0, 10.0)).thenReturn(100.0);
		//test the multiply functionality
		Assert.assertEquals(mathApplication.multiply(10.0, 10.0), 100.0,0);
		//verify the behavior
				verify(calcService).multiply(10.0, 10.0);
	}
	
	@Test
	public void divideTest(){
		//add the behavior of calc service to divide two numbers
		when(calcService.divide(10.0, 10.0)).thenReturn(0.0);
		//test the divide functionality
		Assert.assertEquals(mathApplication.divide(10.0, 10.0), 0.0,0);
		//verify the behavior
		verify(calcService).divide(10.0, 10.0);
	}
  
	@Test
	public void expectingCallsTest()
	{
		when(calcService.add(10.0, 10.0)).thenReturn(20.0);
		
		when(calcService.substract(20.0, 10.0)).thenReturn(10.0);
		
		Assert.assertEquals(mathApplication.add(10.0, 10.0), 20,0);
		Assert.assertEquals(mathApplication.add(10.0, 10.0), 20,0);
		Assert.assertEquals(mathApplication.add(10.0, 10.0), 20,0);
		Assert.assertEquals(mathApplication.substract(20.0, 10.0),10,0);
		
		verify(calcService,times(3)).add(10.0, 10.0);
		//or below
		verify(calcService,atLeast(3)).add(10.0,10.0);
		verify(calcService,atMost(3)).add(10.0,10.0);
		
		verify(calcService).substract(20.0, 10.0);
		//or below
		verify(calcService,atLeastOnce()).substract(20.0, 10.0);
		
		verify(calcService,never()).divide(10, 10);
	}
	@Test(expected=ArithmeticException.class)
	public void exceptionHanldingTest(){
		
		doThrow(new ArithmeticException("divide by zero exception")).
		when(calcService).divide(10.0,0.0);
		
		Assert.assertEquals(mathApplication.divide(10.0, 0.0),0.0,0);
		
		
	}
	
}
