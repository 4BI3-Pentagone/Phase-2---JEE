package service;

import java.util.List;

import javax.ejb.Remote;

import model.Conges;

@Remote
public interface CongesServiceRemote {

	public List<Conges> findAllConges();
}
