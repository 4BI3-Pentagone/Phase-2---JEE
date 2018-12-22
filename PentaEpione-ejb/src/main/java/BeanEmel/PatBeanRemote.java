package BeanEmel;

import javax.ejb.Remote;

@Remote
public interface PatBeanRemote {
	public void getPatient(String id);
	public void getCourse(String id);
	public void getTreatment(String id);
}
