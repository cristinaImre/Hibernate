package cimre.OneToManyAJ.persistence.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cimre.OneToManyAJ.persistence.dao.ProductDao;
import cimre.OneToManyAJ.persistence.dao.StockDao;
import cimre.OneToManyAJ.persistence.model.Stock;

public class StockDaoImpl implements StockDao {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductDao.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void addStock(Stock stock) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(stock);
		logger.info("Stock saved succesfully, Stock Details=" + stock);
	}

	public void updateStock(Stock stock) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(stock);
		logger.info("Stock saved succesfully, Stock Details=" + stock);
		
	}
	
	@SuppressWarnings("unchecked")

	public List<Stock> listStock() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Stock> stockList = session.createQuery("from Stock").list();
		for (Stock stock : stockList) {
			logger.info("Stock List ::" + stock);
		}
		return stockList;
	}

	public Stock getStockById(int stockId) {
		Session session = this.sessionFactory.getCurrentSession();
		Stock stock = (Stock) session.load(Stock.class, new Integer(stockId));
		logger.info("Stock load successfully, Stock Details=" + stock);
		return stock;
	}

	public void removeStock(int stockId) {
		Session session = this.sessionFactory.getCurrentSession();
		Stock stock = (Stock) session.load(Stock.class, new Integer(stockId));
		if (null != stock) {
			session.delete(stock);
		}
		logger.info("Stock deleted successfully, Stock Details=" + stock);
	}
	

}
