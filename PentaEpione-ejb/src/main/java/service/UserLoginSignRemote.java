package service;

import javax.ejb.Remote;

import model.AspNetUser;

@Remote
public interface UserLoginSignRemote {
	public AspNetUser login (String log , String mdp );
	public void addUser(AspNetUser U);

}
