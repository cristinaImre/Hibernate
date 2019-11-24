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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
//	@Column(name = "userId")
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//@ElementCollection(targetClass=Role.class)
	@Column(name = "productId")
	private Set<Product> products = new HashSet<Product>(0);

	private String userName;
	private String password;
	private int productId;

	public String getUserName() {
		return userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public Set<Product> getProduct() {
		return products;
	}
}
