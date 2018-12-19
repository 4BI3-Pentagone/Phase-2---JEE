package BeanEmel;

import javax.ejb.Local;

@Local
public interface PatBeanLocal {
	public void getPatient(String id );
	public void getCourse(String id);
	public void getTreatment(String id);
	}
