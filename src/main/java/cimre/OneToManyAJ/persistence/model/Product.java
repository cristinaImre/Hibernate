package cimre.OneToManyAJ.persistence.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	
	private int productId;
	
	private String product_name;
	
	private Set<Stock> stock = new HashSet<Stock>(0);

	public Product() {
		super();
	}
	
	@Id
	@GeneratedValue
	@Column(name = "productId", unique = true, nullable = false)
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	@Column(name = "product_name", unique = true, nullable = false)
	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<Stock> getStock() {
		return this.stock;
	}
	public void setStock(Set<Stock> stock) {
		this.stock = stock;
	}
}
