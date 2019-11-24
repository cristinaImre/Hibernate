package cimre.OneToManyAJ.persistence.daoImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import cimre.OneToManyAJ.persistence.dao.ProductDao;
import cimre.OneToManyAJ.persistence.model.Product;

public class ProductDaoImpl implements ProductDao {

	private static final Logger logger = LoggerFactory.getLogger(ProductDao.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void addProduct(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(product);
		logger.info("Product saved succesfully, Product Details=" + product);
	}

	public void updateProduct(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(product);
		logger.info("Product updated succesfully, Product Details=" + product);
	}

	@SuppressWarnings("unchecked")

	public List<Product> listProducts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Product> productsList = session.createQuery("from Product").list();
		for (Product product : productsList) {
			logger.info("Product List ::" + product);
		}
		return productsList;
	}

	public Product getProductById(int productId) {
		Session session = this.sessionFactory.getCurrentSession();
		Product product = (Product) session.load(Product.class, new Integer(productId));
		logger.info("Product load successfully, Product Details=" + product);
		return product;
	}

	public void removeProduct(int productId) {
		Session session = this.sessionFactory.getCurrentSession();
		Product product = (Product) session.load(Product.class, new Integer(productId));
		if (null != product) {
			session.delete(product);
		}
		logger.info("Product deleted successfully, Product Details=" + product);
	}

}
