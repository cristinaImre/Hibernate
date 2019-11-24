package cimre.OneToManyAJ.persistence.dao;

import java.util.List;
import cimre.OneToManyAJ.persistence.model.User;

public interface UserDao {
	
	public void addUser (User userId);
	public void updateUser (User userId);
	public List<User> listUsers();
	public User getUserById (int userId);
	public void removeUser (int userId);
	

}
