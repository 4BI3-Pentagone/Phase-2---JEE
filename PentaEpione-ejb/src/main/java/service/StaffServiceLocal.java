package service;

import java.util.List;

import javax.ejb.Local;

import model.Staff;

@Local
public interface StaffServiceLocal {
	public boolean AddStaff(Staff staff);
	public List<Staff> findAll();
	public void saveOrUpdate(Staff staff);
	void DeleteStaff(Staff staff);
}
