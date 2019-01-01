package service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Staff;
import model.User;

/**
 * Session Bean implementation class StaffService
 */
@Stateless
@LocalBean
public class StaffService implements StaffServiceLocal {

    /**
     * Default constructor. 
     */
	private List <Staff> lst=new ArrayList<Staff>();

	@PersistenceContext
	private EntityManager em;
	
    public StaffService() {
        // TODO Auto-generated constructor stub
    }
    @Override
	public void saveOrUpdate(Staff staff) {
		em.merge(staff);	
	}
	@Override
	public boolean AddStaff(Staff staff) {
		em.persist(staff);
		return true;
	}
	@Override
	public List<Staff> findAll() {
		return em.createQuery("select t from Staff t",Staff.class ).getResultList();
		
	}
	@Override
	public void DeleteStaff(Staff staff) {
		em.remove(em.merge(staff));
		
	}
}
