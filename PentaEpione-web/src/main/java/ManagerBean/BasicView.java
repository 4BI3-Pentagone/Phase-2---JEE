package ManagerBean;
import java.io.Serializable; 
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.primefaces.event.SelectEvent;

import model.Appointment;
import service.AppointmentserviceLocal;
import service.RatingserviceLocal;

@ManagedBean(name="dtBasicView") 
public class BasicView implements Serializable {
      
    private List<Appointment> appointments;
    @ManagedProperty("#{appService}")
    private AppointmentBean service;
 
    @PostConstruct
    public void init() { 
        appointments=service.createAppoint();
    }
     
   
    public List<Appointment> getAppointments() {
        return appointments;
    }
 
    public void setService(AppointmentBean service) {
        this.service = service;
    }
    @EJB
    AppointmentserviceLocal   rsl ;  
    
   public void UpdateRateApp(String rate,String appointmentId) { 
   	System.out.println("rate: "+rate +"  appointmentId: "+ appointmentId); 
   	int id=Integer.parseInt(appointmentId);
    	//Appointment  appointment=rsl.getAppointment(id);
    	int Apprate=Integer.parseInt(rate);
      	 rsl.UpdateAppointment (id,Apprate);
    	//appointment.setRate(Apprate);   	 rsl.UpdateAppointments(appointment) ;  
   	}
    public void onRowSelect(SelectEvent event) { 
     	Integer note= ((Appointment) event.getObject()).getRate()  ; 
     	 
    	System.out.println("CHZnote: "+note); 
    }
}