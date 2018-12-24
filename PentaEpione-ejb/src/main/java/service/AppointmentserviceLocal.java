package service;

import javax.ejb.Local;

import model.Appointment;
import model.Rate;

@Local
public interface AppointmentserviceLocal {
	 void UpdateAppointments( Appointment appointment );

	Appointment findById(int id);

	Appointment getAppointment(int id);

	void UpdateAppointment(int id, int rate);
}
