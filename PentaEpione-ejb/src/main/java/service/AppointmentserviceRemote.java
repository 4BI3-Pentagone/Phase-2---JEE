package service;

import javax.ejb.Remote;

import model.Appointment;

@Remote
public interface AppointmentserviceRemote {
	 void UpdateAppointments( Appointment appointment );
		Appointment findById(int id);
		Appointment getAppointment(int id);
		void UpdateAppointment(int id, int rate);
}
