package Mayssa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


import org.primefaces.PrimeFaces;

import service.AgentServiceLocal;
import model.Agent;
import model.Contrat;
import model.Site;
import model.Staff;

@ManagedBean
@ApplicationScoped

public class StaffBean implements Serializable{
	
	private int id;
	private String nom;
	private String prenom;
	private String matricule;
	private String contrat;
	private int nbreHeure;
				
					
					
					private static final long serialVersionUID = 1L;
				
					private List<Agent> agents;
				    
				    private List<Agent> filteredStaff;
				     
				    private Agent selectedStaff;
				    
				    @EJB
					private AgentServiceLocal agentService;
					private boolean formDisplay = false;
					private List<Agent> list = new ArrayList<Agent>();
    
					private Agent agent = new Agent();

					public boolean isFormDisplay() {
						return formDisplay;
					}


					public List<Agent> displayStaff(){
						return list = agentService.findAll();
					}
					
					
					public void buttonAction(ActionEvent actionEvent) {
				        addMessage("effectué avec succés!!");
				    }
					public void addMessage(String summary) {
				        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
				        FacesContext.getCurrentInstance().addMessage(null, message);
				    }

					public void setFormDisplay(boolean formDisplay) {
						this.formDisplay = formDisplay;
					}
					
					
	
	
					public StaffBean() {
						super();
					}

					
					
					public String Save(){
						agentService.AjoutAgent(agent);
				        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("effectué avec succés!!"));
						return "/faces/staff?faces-redirect=true";
					}
					
					
					public void deleteAgent() {
				        agentService.DeleteAgent(selectedStaff);
				        selectedStaff = null;
				    }

					
					public void reset() {
				        PrimeFaces.current().resetInputs("form2:panel2");
				    }


					public int getId() {
						return id;
					}


					public void setId(int id) {
						this.id = id;
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


					public String getContrat() {
						return contrat;
					}


					public void setContrat(String contrat) {
						this.contrat = contrat;
					}


					public int getNbreHeure() {
						return nbreHeure;
					}


					public void setNbreHeure(int nbreHeure) {
						this.nbreHeure = nbreHeure;
					}


					public List<Agent> getAgents() {
						return agents;
					}


					public void setAgents(List<Agent> agents) {
						this.agents = agents;
					}


					public List<Agent> getFilteredStaff() {
						return filteredStaff;
					}


					public void setFilteredStaff(List<Agent> filteredStaff) {
						this.filteredStaff = filteredStaff;
					}


					public Agent getSelectedStaff() {
						return selectedStaff;
					}


					public void setSelectedStaff(Agent selectedStaff) {
						this.selectedStaff = selectedStaff;
					}


					public AgentServiceLocal getAgentService() {
						return agentService;
					}


					public void setAgentService(AgentServiceLocal agentService) {
						this.agentService = agentService;
					}


					public List<Agent> getList() {
						return list;
					}


					public void setList(List<Agent> list) {
						this.list = list;
					}


					public Agent getAgent() {
						return agent;
					}


					public void setAgent(Agent agent) {
						this.agent = agent;
					}


					


					
					
}
