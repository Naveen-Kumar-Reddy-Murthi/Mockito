/**
 * 
 */
package org.mnr.stock;

import java.util.List;

/**
 * @author Naveen Reddy
 *
 */
public class Portfolio {
	
	private StockService stockService;
	private List<Stock> stocks;
	
	public StockService getStockService() {
		return stockService;
	}
	public List<Stock> getStocks() {
		return stocks;
	}
	public void setStockService(StockService stockService) {
		this.stockService = stockService;
	}
	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	
	public double getMarketValue(){
		
		double marketValue=0.0;
		
		for(Stock stock : stocks)
			marketValue+= stockService.getPrice(stock)*stock.getQuantity();
		
		return marketValue;
	}
}
