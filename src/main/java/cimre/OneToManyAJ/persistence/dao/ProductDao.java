package cimre.OneToManyAJ.persistence.dao;

import java.util.List;

import cimre.OneToManyAJ.persistence.model.Product;

public interface ProductDao {
	
	public void addProduct (Product ProductId);
	public void updateProduct (Product ProductId);
	public List<Product> listProducts();
	public Product getProductById (int ProductId);
	public void removeProduct (int ProductId);
	

}
