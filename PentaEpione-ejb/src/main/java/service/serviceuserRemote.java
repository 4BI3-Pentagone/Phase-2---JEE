package service;

import javax.ejb.Remote;

import model.AspNetUser;

@Remote
public interface serviceuserRemote {
	public AspNetUser login (String log , String mdp );

}
