package service;

import javax.ejb.Local;

import model.AspNetUser;

@Local
public interface UserLoginSignLocal {
	public AspNetUser login (String log , String mdp );
	public void addUser(AspNetUser U);

}
