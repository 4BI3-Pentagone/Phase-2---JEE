package Mayssa;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import service.AffectationServiceLocal;
import service.AgentService;
import service.AgentServiceLocal;
import service.CongesServiceLocal;
import service.FluxServiceLocal;
import service.MissionServiceLocal;
import service.StatistiquesServiceLocal;
import model.Affectation;
import model.Agent;
import model.Conges;
import model.Flux;
import model.Mission;
import model.Statistiques;

@ManagedBean(name = "scheduleView")
@SessionScoped
public class ScheduleView {

	private ScheduleModel eventModel;

	private ScheduleEvent event = new DefaultScheduleEvent();

	private ScheduleEvent eventformap;

	private Flux flux;

	private int idFlux;

	private Affectation affectToPass;

	private List<Flux> listFlux;

	private List<Date> rangeDates;

	private Date selectedDate;

	private String dateString;

	private Mission selectedMission;
	
	private Statistiques stat;
	
	private Agent selectedAgent;

	private List<Mission> listMission;
	
	private List<Conges> listConges;

	private Map<String, Affectation> map;

	@EJB
	private AffectationServiceLocal as;

	@EJB
	private MissionServiceLocal ms;

	@EJB
	private FluxServiceLocal fs;
	
	@EJB
	private AgentServiceLocal ag;

	@EJB
	private StatistiquesServiceLocal ss;
	
	@EJB
	private CongesServiceLocal cgs;
	
	private List<Agent> listAgent;
	
	private List<Affectation> ListAffectation;

	private final String test = "test";

	@PostConstruct
	public void init() {
		listFlux = fs.findListFlux();
		listConges=cgs.findAllConges();
		listAgent = new ArrayList<Agent>();
		eventModel = new DefaultScheduleModel();
		map = new HashMap<String, Affectation>();
		ListAffectation = as.findListAffectation();
		
		for (Affectation affectation : ListAffectation) {
			eventformap = new DefaultScheduleEvent(affectation.getFlux().getIntitule(), affectation.getDate_debut(), affectation.getDate_fin(), "background: red;");
			eventModel.addEvent(eventformap);
			map.put(eventformap.getId(), affectation);
		}
		for (Conges c : listConges) {
			eventModel.addEvent(new DefaultScheduleEvent(c.getAgent().getNom()+" "+c.getAgent().getPrenom(),c.getDate_debut(),c.getDate_fin(), "conges"));
		}
	}

	public Date getRandomDate(Date base) {
		Calendar date = Calendar.getInstance();
		date.setTime(base);
		date.add(Calendar.DATE, ((int) (Math.random() * 30)) + 1); // set random
																	// day of
																	// month

		return date.getTime();
	}

	public Date getInitialDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);

		return calendar.getTime();
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	/*
	 * private Calendar today() { Calendar calendar = Calendar.getInstance();
	 * calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
	 * calendar.get(Calendar.DATE), 0, 0, 0);
	 * 
	 * return calendar; }
	 */

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}

	public void addEvent(ActionEvent actionEvent) {
		flux = findFluxById(idFlux);
		Affectation affect;
		Mission mission;
		ScheduleEvent event2;
		event2 = new DefaultScheduleEvent(flux.getIntitule(), event.getStartDate(), event.getEndDate(),"background: red;");
		event2.setId(event.getId());
		if (event.getId() == null) {
			eventModel.addEvent(event2);
			affect = new Affectation(event.getStartDate(), event.getEndDate(), flux);
			as.addAffectation(affect);
			map.put(event.getId(), affect);
		}

		else {
			int id = map.get(event.getId()).getId();
			System.out.println("id :    " + id);
			affect = new Affectation(id, event2.getStartDate(), event2.getEndDate(), flux);
			eventModel.updateEvent(event2);
			as.updateAffectation(affect);
			map.put(event.getId(), affect);
		}

		event = new DefaultScheduleEvent();
	}

	public void deleteEvent(ActionEvent actionEvent) {
		eventModel.deleteEvent(event);
		Affectation affect = new Affectation();
		affect = map.get(event.getId());
		as.deleteAffectation(affect);
		map.remove(event.getId());

	}

	public void selectFlux() {
		affectToPass = map.get(event.getId());
		rangeDates = getDatesBetween(affectToPass.getDate_debut(), affectToPass.getDate_fin());
	}

	public static List<Date> getDatesBetween(Date startDate, Date endDate) {
		List<Date> datesInRange = new ArrayList<>();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(startDate);

		Calendar endCalendar = new GregorianCalendar();
		endCalendar.setTime(endDate);

		while (calendar.before(endCalendar)) {
			Date result = calendar.getTime();
			datesInRange.add(result);
			calendar.add(Calendar.DATE, 1);
		}
		return datesInRange;
	}

	public void selectSpecificMission() throws ParseException {
		selectedDate = StringDateConverter(dateString);
		listMission = new ArrayList<Mission>();
		listMission = ms.findMissionbyDateAffect(selectedDate, affectToPass);
		for (Mission m : listMission) {
			System.out.println("mission :  " + m.getAffectation().getId());
		}
		listAgent=ag.findAgentNotAffected(selectedDate);
	}

	public void deleteSelectedMission() {
		System.out.println("removed mission : " + selectedMission.getId());
		ms.removeMission(selectedMission);
		listMission.remove(selectedMission);
		//createOrupdateStat(selectedAgent, test);
		listAgent=ag.findAgentNotAffected(selectedDate);
	}
	
	public void affectAgent(){
		Mission miss=new Mission("actif",selectedDate,affectToPass,selectedAgent);
		ms.addMission(miss);
		listAgent.remove(selectedAgent);
		//createOrupdateStat(selectedAgent,true);
		listMission=ms.findMissionbyDateAffect(selectedDate, affectToPass);
	}
	
	public void createOrupdateStat(Agent agent,Boolean test){
		stat=ss.findStat(agent);
		if (test){
		if(stat!=null){
			stat.setHeure_travail(stat.getHeure_travail()+8);
			ss.updateStat(stat);
		}
		else {
			stat=new Statistiques(8,0,0,0,agent);
			ss.addStat(stat);
		}
		}
		if (!test){
			if(stat!=null){
				stat.setHeure_travail(stat.getHeure_travail()-8);
				ss.updateStat(stat);
			}
		}
	}

	/*
	 * Getters and Setters below , plus schedule functions !! !!
	 */

	public Date StringDateConverter(String d) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.US);
		Date date = (Date) formatter.parse(d);
		return date;
	}

	public void onEventSelect(SelectEvent selectEvent) {
		event = (ScheduleEvent) selectEvent.getObject();
	}

	public void onDateSelect(SelectEvent selectEvent) {
		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
	}

	public void onEventMove(ScheduleEntryMoveEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved",
				"Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

		addMessage(message);
	}

	public void onEventResize(ScheduleEntryResizeEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized",
				"Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

		addMessage(message);
	}

	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public List<Affectation> getListAffectation() {
		return ListAffectation;
	}

	public void setListAffectation(List<Affectation> listAffectation) {
		ListAffectation = listAffectation;
	}

	public Flux getFlux() {
		return flux;
	}

	public void setFlux(Flux flux) {
		this.flux = flux;
	}

	public int getIdFlux() {
		return idFlux;
	}

	public void setIdFlux(int idFlux) {
		this.idFlux = idFlux;
	}

	public List<Flux> getListFlux() {
		return listFlux;
	}

	public void setListFlux(List<Flux> listFlux) {
		this.listFlux = listFlux;
	}

	public Flux findFluxById(int id) {
		for (Flux f : listFlux) {
			if (f.getId() == id)
				return f;
		}
		return null;
	}

	public Affectation getAffectToPass() {
		return affectToPass;
	}

	public void setAffectToPass(Affectation affectToPass) {
		this.affectToPass = affectToPass;
	}

	public String getTest() {
		return test;
	}

	public List<Date> getRangeDates() {
		return rangeDates;
	}

	public void setRangeDates(List<Date> rangeDates) {
		this.rangeDates = rangeDates;
	}

	public Date getSelectedDate() {
		return selectedDate;
	}

	public void setSelectedDate(Date selectedDate) {
		this.selectedDate = selectedDate;
	}

	public List<Mission> getListMission() {
		return listMission;
	}

	public void setListMission(List<Mission> listMission) {
		this.listMission = listMission;
	}

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public Mission getSelectedMission() {
		return selectedMission;
	}

	public void setSelectedMission(Mission selectedMission) {
		this.selectedMission = selectedMission;
	}

	public List<Agent> getListAgent() {
		return listAgent;
	}

	public void setListAgent(List<Agent> listAgent) {
		this.listAgent = listAgent;
	}

	public Agent getSelectedAgent() {
		return selectedAgent;
	}

	public void setSelectedAgent(Agent selectedAgent) {
		this.selectedAgent = selectedAgent;
	}

	public Statistiques getStat() {
		return stat;
	}

	public void setStat(Statistiques stat) {
		this.stat = stat;
	}

	public List<Conges> getListConges() {
		return listConges;
	}

	public void setListConges(List<Conges> listConges) {
		this.listConges = listConges;
	}

}