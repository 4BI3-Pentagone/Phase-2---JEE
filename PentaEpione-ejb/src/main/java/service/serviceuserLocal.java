package service;

import javax.ejb.Local;

import model.AspNetUser;

@Local
public interface serviceuserLocal {

	public AspNetUser login (String log , String mdp );
}
