package BeanEmel;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import emel.Util;
import model.AspNetUser;
import model.Extract;
import service.ExtractionRemote;


@ManagedBean
@RequestScoped
public class ExtractionRessources {
	
	
	@PostConstruct
	private void init() {

		System.out.println(		);
	}
}

