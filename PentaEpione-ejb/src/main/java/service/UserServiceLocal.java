package service;

import java.util.List;

import javax.ejb.Local;

import model.User;

@Local
public interface UserServiceLocal {
	public boolean AddUser(User user);
	public User authenticate(String nom, String password) ;
	public List<User> findAll();
	boolean loginExists(String nom);
	public void saveOrUpdate(User user);
	public User getConnected();
	public void setConnected(User connected);
	void DeleteUser(User user);



}
