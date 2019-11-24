package cimre.OneToManyAJ.persistence.daoImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import cimre.OneToManyAJ.persistence.dao.UserDao;
import cimre.OneToManyAJ.persistence.model.User;



public class UserDaoImpl implements UserDao {

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void addUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
		logger.info("User saved successfully, User details=" + user);
	}

	public void updateUser(User userId) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(userId);
		logger.info("User updated successfully, User details=" + userId);
	}

	@SuppressWarnings("unchecked")

	public List<User> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList = session.createQuery("from User").list();
		for (User user : usersList) {
			logger.info("User list ::" + user);
		}
		return usersList;
	}

	public User getUserById(int userId) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, new Integer(userId));
		logger.info("User loaded successfully, User details=" + user);
		return user;
	}

	public void removeUser(int userId) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, new Integer(userId));
		if (null != user) {
			session.delete(user);
		}
		logger.info("User deleted successfully, User details=" + user);
	}

}
