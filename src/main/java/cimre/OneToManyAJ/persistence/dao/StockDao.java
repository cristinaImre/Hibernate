package cimre.OneToManyAJ.persistence.dao;

import java.util.List;

import cimre.OneToManyAJ.persistence.model.Stock;

public interface StockDao  {


	public void addStock(Stock stockId);
	public void updateStock(Stock stockId);
	public List<Stock> listStock();
	public Stock getStockById(int stockId);
	public void removeStock(int stockId);
}
