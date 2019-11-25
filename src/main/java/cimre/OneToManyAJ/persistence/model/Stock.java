package cimre.OneToManyAJ.persistence.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {
	
	
	private Integer stockId;
	private String stockCode;
	private String stockName;
	private Set<Product> products = new HashSet<Product>(0);

	@Id
	@Column(name = "stockId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}
	@Column(name = "stockCode", unique =true, nullable = false, length = 10)
	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	
	@Column(name = "stockName", unique =true, nullable = false, length = 20)
	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "stock_product", catalog = "jewelry_store", joinColumns = {
			@JoinColumn(name = "stockId", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "productId", nullable = false, updatable = false) })
	@Column(name = "productId")
	public Set<Product> getProduct() {
		return products;
	}

	public void setProduct(Set<Product> products) {
		this.products = products;
	
	}
}
