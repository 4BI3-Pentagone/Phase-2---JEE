package Mayssa;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.net.ssl.SSLParameters;

import org.primefaces.event.DragDropEvent;

import java.util.List;
import service.AgentService;
import service.AgentServiceLocal;
import service.ContratServiceLocal;
import service.SiteService;
import service.SiteServiceLocal;
import model.Agent;
import model.Contrat;
import model.Pays;
import model.Site;
import model.Ville;

@ManagedBean
@ViewScoped
public class AgentsBean {
	@EJB
	private AgentServiceLocal asl;
	@EJB
	private AgentService as;
	@EJB
	SiteServiceLocal ssl;
	@EJB
	SiteService ss;
	private String nom;
	private String prenom;
	private String matricule;
	private Agent agent;
	private String contrat;
	private List<Agent> agents;
	private int siteId;
	private Site site;
	private Agent selected;
	private boolean selection;
	private List<Contrat> listContrat;
	
	@EJB
	ContratServiceLocal cs;
	
	@PostConstruct
    public void init() {
		listContrat=cs.findAllContrat();
        agents = asl.getAllAgent();
    }
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public List<Agent> getAgents() {
		return agents;
	}
	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}
	public String addAgent() {
		site = new Site();
		site = ssl.getSiteByID(siteId);
		agent=new Agent(nom,prenom,matricule,site,contrat);
		asl.addAgent(agent);
		System.out.println(agent.getNom().concat(" ").concat(agent.getPrenom()));
		return "valider".concat(agent.getNom());
	}
	public List<Agent> getAllAgents() {
		return asl.getAllAgent();
	}
	
	public Site getSite() {
		return site;
	}
	
	public void setSite(Site site) {
		this.site = site;
	}
	
	public int getSiteId() {
		return siteId;
	}
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	public String removeAgent(Agent a) {
		asl.removeAgent(a);
		return a.getNom().concat(" is removed");
	}
	public String updateAgent (Agent a) {
		this.agent=a;
		asl.updateAgent(agent);
		return a.getNom().concat(" is modified");
	}
	public String refrech() {
		return "refrech";
	}
	public Agent getSelected() {
		return selected;
	}
	public void setSelected(Agent selected) {
		this.selected = selected;
	}
	public boolean isSelection() {
		return selection;
	}
	public void setSelection(boolean selection) {
		this.selection = selection;
	}
	public String selectAgent (Agent a) {
		this.selected=a;
	    this.nom=a.getNom();
	    this.site=a.getSite();
	    this.prenom=a.getPrenom();
	    this.matricule=a.getMatricule();
	    this.contrat=a.getContrat();
		System.out.println(a.getNom());
		this.selection=true;
		return a.getNom().concat(" si selected.");
	}
	public String unSelectAgent() {
		this.selected=new Agent();
	    this.nom="";
	    this.site=new Site();
	    this.prenom="";
	    this.matricule="";
	    this.siteId=0;
		this.selection=false;
		return "unselection";
	}
	public String updateAgent () {
		site=ssl.getSiteByID(siteId);
		this.selected.setNom(this.nom);
		this.selected.setPrenom(prenom);
		this.selected.setMatricule(matricule);
		this.selected.setSite(site);
		this.selected.setContrat(contrat);
		asl.updateAgent(this.selected);
		return "updated";
	}

	public String getContrat() {
		return contrat;
	}

	public void setContrat(String contrat) {
		this.contrat = contrat;
	}

	public List<Contrat> getListContrat() {
		return listContrat;
	}

	public void setListContrat(List<Contrat> listContrat) {
		this.listContrat = listContrat;
	}

	
	
}
