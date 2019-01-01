package Mayssa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.DragDropEvent;
import org.primefaces.model.DualListModel;

import service.AffectationServiceLocal;
import service.FluxServiceLocal;
import model.Affectation;
import model.Flux;

@SessionScoped
@ManagedBean
public class AffectationBean {

	private int id;
	private Date date_debut;
	private Date date_fin;
	private List<Flux> flux;
	private List<Flux> droppedFlux;
	private Affectation affect;
	
	
	@EJB
	AffectationServiceLocal as;
	
	@EJB
	private FluxServiceLocal fs;
	
	public AffectationBean() {

	}
	
	@PostConstruct
	public void init(){
		flux=fs.findListFlux();
		droppedFlux=new ArrayList<Flux>();
	}
	
	public void addAffectationBean(Affectation affectation)
	{
		as.addAffectation(affectation);
	}
	
	public void OnDropFlux(DragDropEvent ddEvent){
		Flux fluxx=((Flux) ddEvent.getData());
		droppedFlux.add(fluxx);
		flux.remove(fluxx);

		
	}
	
	public void comfirm(){
		//affect=new Affectation(droppedFlux);
		as.addAffectation(affect);
	}
		
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public List<Flux> getFlux() {
		return flux;
	}

	public void setFlux(List<Flux> flux) {
		this.flux = flux;
	}

	public List<Flux> getDroppedFlux() {
		return droppedFlux;
	}

	public void setDroppedFlux(List<Flux> droppedFlux) {
		this.droppedFlux = droppedFlux;
	}

	public Affectation getAffect() {
		return affect;
	}

	public void setAffect(Affectation affect) {
		this.affect = affect;
	}



}
