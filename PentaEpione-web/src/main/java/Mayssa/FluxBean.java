package Mayssa;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;

import model.Flux;
import service.FluxServiceLocal;

@SessionScoped
@ManagedBean
public class FluxBean {

	private int id;
	private double charge_horaire;
	private Flux flux;
	private String intitule;
	List<Flux> listFlux ;
	
	@EJB
	private FluxServiceLocal fs;
	
	public FluxBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init(){
		listFlux=fs.findListFlux();
	}
	public void addFluxBean()
	{
		flux=new Flux(charge_horaire,intitule);
		System.out.println(flux.getIntitule());
		fs.addFlux(flux);
	}
	
	public void deleteFluxBean()
	{
		fs.removeFlux(flux);
	}
	
	public void updateFluxBean()
	{
		fs.updateFlux(flux);
	}
	
	public void onEditLabel(CellEditEvent event) {
	    Object oldValue = event.getOldValue();
	    Object newValue = event.getNewValue();

	    if(newValue != null && !newValue.equals(oldValue)) {
	        DataTable s = (DataTable) event.getSource();
	        Flux d = (Flux) s.getRowData();
	        try {
	            fs.updateFlux(d);

	        } catch (Exception ex) {

	        }
	    }
	}
	
	public List<Flux> getListFlux()
	{
		return fs.findListFlux();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCharge_horaire() {
		return charge_horaire;
	}

	public void setCharge_horaire(double charge_horaire) {
		this.charge_horaire = charge_horaire;
	}
	public Flux getFlux() {
		return flux;
	}
	public void setFlux(Flux flux) {
		this.flux = flux;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	
}
