package org.mnr.mockito;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.mnr.stock.Portfolio;
import org.mnr.stock.Stock;
import org.mnr.stock.StockService;


public class PortfolioTester {
	
	Portfolio portfolio;
	StockService stockService;
	
	public void setUp(){
		portfolio = new Portfolio();
		stockService = mock(StockService.class);
		portfolio.setStockService(stockService);
	}
	
	public boolean testMarketValue(){
		
		List<Stock> stocks = new ArrayList<Stock>();
		Stock google	 = new Stock(1,"Google",10);
		Stock microsoft	 = new Stock(2,"MicroSoft",100);
		stocks.add(google);
		stocks.add(microsoft);
		portfolio.setStocks(stocks);
		
		when(stockService.getPrice(google)).thenReturn(50.00);
		when(stockService.getPrice(microsoft)).thenReturn(1000.00);
		
		double marketValue= portfolio.getMarketValue();
		return marketValue==100500.0;
		
		
	}
	public static void main(String...args){
		
		PortfolioTester tester = new PortfolioTester();
		tester.setUp();
		System.out.println(tester.testMarketValue()?"pass":"fail");
	}


}
