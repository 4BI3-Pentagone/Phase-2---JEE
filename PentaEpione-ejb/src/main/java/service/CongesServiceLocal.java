package service;

import java.util.List;

import javax.ejb.Local;

import model.Conges;

@Local
public interface CongesServiceLocal {

	public List<Conges> findAllConges();
}
