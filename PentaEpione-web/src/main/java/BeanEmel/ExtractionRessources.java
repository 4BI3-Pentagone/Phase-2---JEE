package BeanEmel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.timeline.TimelineSelectEvent;
import org.primefaces.model.timeline.TimelineEvent;
import org.primefaces.model.timeline.TimelineModel;

import model.Appointment;

@ManagedBean
@ViewScoped
public class ExtractionRessources {

	/**
	* 
	*/
	// private static final long serialVersionUID = 1L;
	@EJB
	PatBean pb;
	List<Appointment> mycourse = new ArrayList<Appointment>();

	public List<Appointment> getMycourse() {
		return mycourse;
	}

	public void setMycourse(List<Appointment> mycourse) {
		this.mycourse = mycourse;
	}

	TimelineModel model;

	boolean selectable = true;
	boolean zoomable = true;
	boolean moveable = true;
	boolean stackEvents = true;
	String eventStyle = "box";
	boolean axisOnTop;
	boolean showCurrentTime = true;
	boolean showNavigation = false;

	public PatBean getPb() {
		return pb;
	}

	public void setPb(PatBean pb) {
		this.pb = pb;
	}

	public void setModel(TimelineModel model) {
		this.model = model;
	}

	@PostConstruct
	private void init() {
		mycourse = pb.getCourse("4");
		model = new TimelineModel();
		for (Appointment a : mycourse) {
		

			Calendar cal = Calendar.getInstance();
			cal.setTime(a.getDate());
			;
			model.add(new TimelineEvent(a.getAppointmentId(), cal.getTime()));
			System.out.println("here");
		}
	}

	public void onSelect(TimelineSelectEvent e) {
		TimelineEvent timelineEvent = e.getTimelineEvent();

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected event:",
				timelineEvent.getData().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public TimelineModel getModel() {
		return model;
	}

	public boolean isSelectable() {
		return selectable;
	}

	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}

	public boolean isZoomable() {
		return zoomable;
	}

	public void setZoomable(boolean zoomable) {
		this.zoomable = zoomable;
	}

	public boolean isMoveable() {
		return moveable;
	}

	public void setMoveable(boolean moveable) {
		this.moveable = moveable;
	}

	public boolean isStackEvents() {
		return stackEvents;
	}

	public void setStackEvents(boolean stackEvents) {
		this.stackEvents = stackEvents;
	}

	public String getEventStyle() {
		return eventStyle;
	}

	public void setEventStyle(String eventStyle) {
		this.eventStyle = eventStyle;
	}

	public boolean isAxisOnTop() {
		return axisOnTop;
	}

	public void setAxisOnTop(boolean axisOnTop) {
		this.axisOnTop = axisOnTop;
	}

	public boolean isShowCurrentTime() {
		return showCurrentTime;
	}

	public void setShowCurrentTime(boolean showCurrentTime) {
		this.showCurrentTime = showCurrentTime;
	}

	public boolean isShowNavigation() {
		return showNavigation;
	}

	public void setShowNavigation(boolean showNavigation) {
		this.showNavigation = showNavigation;
	}
}
