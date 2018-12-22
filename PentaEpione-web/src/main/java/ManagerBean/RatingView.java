package ManagerBean;

import javax.ejb.EJB; 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RateEvent;

import model.Rate;
import service.RatingserviceLocal;

@ManagedBean(name="ratingView")  
public class RatingView {
     
    private Integer rating1;   
    private Integer rating2;   
    private Integer rating3;   
    private Integer rating4 = 3;
    public static Integer rating;   
    public void onrate(RateEvent rateEvent ) { 
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Rate Event", "You rated:" + ((Integer) rateEvent.getRating()).intValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    	Integer note= ((Integer) rateEvent.getRating()).intValue(); 
    	rating=note;
      	System.out.println("CHZ: "+rating);
    	// rsl.addRate(new Rate(note ));  
    }
     
    public void oncancel() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancel Event", "Rate Reset");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
 
    public Integer getRating1() {
        return rating1;
    }
 
    public void setRating1(Integer rating1) {
        this.rating1 = rating1;
    }
 
    public Integer getRating2() {
        return rating2;
    }
 
    public void setRating2(Integer rating2) {
        this.rating2 = rating2;
    }
 
    public Integer getRating3() {
        return rating3;
    }
 
    public void setRating3(Integer rating3) {
        this.rating3 = rating3;
    }
 
    public Integer getRating4() {
        return rating4;
    }
 
    public void setRating4(Integer rating4) {
        this.rating4 = rating4;
    }
    @EJB
	    RatingserviceLocal   rsl ;  
	    public void DoAddRating() {
	       //RateEvent rateEvent FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Rate Event", "You rated:" + ((Integer) rateEvent.getRating()).intValue());
	    	Integer note=50;
	    			//((Integer) rateEvent.getRating()).intValue();
	    	 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Rate Event", "Chaima:" + note);
	    	  FacesContext.getCurrentInstance().addMessage(null, message);
	    	//rsl.addRate(new Rate(note));  
	    }
	    public void doSomeAction(){
			// Do any action that you would.
	
	    	Integer note=	50;
	    		//((Integer) rateEvent.getRating()).intValue(); 
			System.out.println("Hello JournalDev charfa !"+note.toString()); 
			 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Rate Event", "Chaima:" + note);
	    	  FacesContext.getCurrentInstance().addMessage(null, message);
		 
		}
	}

