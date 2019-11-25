package cimre.OneToManyAJ;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import cimre.OneToManyAJ.persistence.model.Product;
import cimre.OneToManyAJ.persistence.model.Stock;
import cimre.OneToManyAJ.persistence.util.HibernateUtil;

public class App {
	
    public static void main( String[] args ) {
    	
        System.out.println( "Hibernate one to many (XML mapping)" );
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
//        
//        User user = new User();
//        user.setUserId(4);
//        user.setUsername("Jack");
//        user.setPassword("XxXx");
//        session.save(user);
//     
//        user.getProduct().add(product);	


        Stock stock = new Stock();
        stock.setStockCode("111111");
        stock.setStockName("Tiffanys");
        
        Product product1 = new Product();
        product1.setProduct_name(new String ("sugar"));
        Product product2 = new Product();
        product2.setProduct_name(new String ("kinder"));
                    
        Set<Product> products = new HashSet<Product>();
        products.add(product1);
        products.add(product2);
        stock.setProduct(products);
        
        session.save(stock);
        session.getTransaction().commit();
        System.out.println("Done");
        
        
    }
    
    
}
