package Mayssa;

import javax.enterprise.context.RequestScoped;

import javax.enterprise.inject.Alternative;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

import service.AgentService;
import model.Agent;
import model.Mission;

@ManagedBean
@RequestScoped
public class ChartBean {

	
	private BarChartModel model;
    @EJB
    private AgentService agentService;
    
    /**
     * Creates a new instance of ChartBean
     */
    public ChartBean() {
    }

    public BarChartModel getBarModel() {
        return model;
    }
    @PostConstruct
    private void initialize() {
    	
        //Map<String, Number> salesByCustomer = new HashMap<String, Number>();
        Map<Object, Number> salesBy_Customer = new HashMap<Object, Number>();
        Map<Object, Number> salesByCustomer = new HashMap<Object, Number>();

        List<Agent> agents = agentService.findAll();
        
        
        
        for (Agent c : agents) {
            double sales = 0.0;
            
            for (Mission p : c.getMissionCollection()) {
                sales += p.getMatricule().getNbreHeure().doubleValue();
            }
           // salesByCustomer.put(c.getNom(), sales);
            Object obj=c.getNom();
            salesBy_Customer.put(obj, sales);
        } 
        	for (Agent c : agents) {
                double inc = 0.0;
                for (Mission p : c.getMissionCollection()) {
                    //sales += p.getMatricule().getNbreHeure().doubleValue();
                    inc +=p.getAffectation().getFlux().getCharge_horaire();
                }
               // salesByCustomer.put(c.getNom(), sales);
                Object obj=c.getNom();
                salesByCustomer.put(obj, inc);
            }
        model = new BarChartModel();
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Heures Total");
        boys.setData(salesBy_Customer);
        model.addSeries(boys);
        
        ChartSeries horraire = new ChartSeries();
        horraire.setLabel("Heures travaillées");

        horraire.setData(salesByCustomer);
        model.addSeries(horraire);
      //  System.out.println(salesBy_Customer.get("bbb"));
       // model.setData(salesByCustomer);
        
        model.setStacked(true);
        model.setShowPointLabels(true);
        model.setTitle("Charge Horaire");
        model.setLegendPosition("ne");
        
        Axis xAxis = new CategoryAxis("Anos");
        model.getAxes().put(AxisType.X, xAxis);
        
        xAxis.setLabel("Nom des Agents");
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(200);
        
    }
    
    
    

    public BarChartModel getModel() {
        return model;
    }
    
    
    

}
