package cimre.OneToManyAJ;

import org.hibernate.Session;

import cimre.OneToManyAJ.persistence.model.Product;
import cimre.OneToManyAJ.persistence.model.User;
import cimre.OneToManyAJ.persistence.util.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hibernate one to many (XML mapping)" );
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        
        User user = new User();
        user.setUserId(3);
        user.setUsername("Blabla");
        user.setPassword("crazy");
        session.save(user);
        	
        Product product = new Product();
        product.setProductId(18);
        product.setProduct_name(new String ("toy"));
        
        user.getProduct().add(product);
        
        session.save(product);
        session.getTransaction().commit();
        System.out.println("Done");
    }
}
