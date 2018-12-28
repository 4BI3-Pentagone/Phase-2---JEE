package BeanEmel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.timeline.TimelineSelectEvent;
import org.primefaces.model.timeline.TimelineEvent;
import org.primefaces.model.timeline.TimelineModel;

import model.Appointment;

@ManagedBean(name = "basicTimelineView")
@ViewScoped
public class MycourseMB implements Serializable {
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

	public MycourseMB() {
		// TODO Auto-generated constructor stub
	}

	private TimelineModel model;

	private boolean selectable = true;
	private boolean zoomable = true;
	private boolean moveable = true;
	private boolean stackEvents = true;
	private String eventStyle = "box";
	private boolean axisOnTop;
	private boolean showCurrentTime = true;
	private boolean showNavigation = false;

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
	protected void initialize() {
		mycourse = pb.getCourse("4");
		for (Appointment a : mycourse) {
			model = new TimelineModel();

			Calendar cal = Calendar.getInstance();
			cal.setTime(a.getDate());
			;
			model.add(new TimelineEvent(a.getAspNetUser2().getFirstName(), cal.getTime()));

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
