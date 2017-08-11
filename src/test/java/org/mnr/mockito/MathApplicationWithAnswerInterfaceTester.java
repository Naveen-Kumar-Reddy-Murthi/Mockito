package org.mnr.mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mnr.junitmockitointegration.CalculatorService;
import org.mnr.junitmockitointegration.MathApplication;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
/**
 * 
 * @author Naveen Reddy
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationWithAnswerInterfaceTester {

	private MathApplication mathApplication;
	private CalculatorService calcService;
	
	@Before
	public void setUp(){
		
		mathApplication = new MathApplication();
		calcService = mock(CalculatorService.class);
		mathApplication.setCalcService(calcService);
	}
	
	@Test
	public void answerDemoTest(){
		
		when(calcService.add(10.0,10.0)).thenAnswer(new Answer<Double>(){
		
			public Double answer(InvocationOnMock invocation) throws Throwable {
				
				Object[] args = invocation.getArguments();
				Object mocks = invocation.getMock();
				return 20.0;
			}
			
		});
		Assert.assertEquals(mathApplication.add(10.0,10.0), 20.0,0);
	}

}
