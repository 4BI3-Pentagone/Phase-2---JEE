package service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Appointment;
 

/**
 * Session Bean implementation class Appointmentservice
 */
@Stateless
@LocalBean
public class Appointmentservice implements AppointmentserviceRemote, AppointmentserviceLocal {
	@PersistenceContext
	   EntityManager em;

    /**
     * Default constructor. 
     */
    public Appointmentservice() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void UpdateAppointments(Appointment appointment) {
		 
			em.merge(appointment);
			em.flush();  
	}
	@Override
	public Appointment findById(int id) {
		return em.find(Appointment.class, id);
	}
	@Override
	public Appointment getAppointment(int id) {
		Appointment app = em.createQuery("Select c from Appointment c where appointmentId="+id, Appointment.class).getSingleResult();
		return app;
	}
	@Override
	public void UpdateAppointment(int id,int rate) {
	  //em.createQuery("Update Appointment  set rate="+rate+" where appointmentId="+id, Appointment.class).executeUpdate();
	  Query query = em.createQuery(
			    "Update Appointment  AS o  set o.rate=:rate where o.appointmentId=:appointmentId");
			query.setParameter("rate", rate);
			query.setParameter("appointmentId", id);
			int result = query.executeUpdate();
	}
}
