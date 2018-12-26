package test;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import service.ExtractionRemote;



public class testextract {

	public static void main(String[] args) throws NamingException, IOException {
		// TODO Auto-generated method stub

		Context context= new InitialContext();
		String jndiName="PentaEpione-ear/PentaEpione-ejb/ExtractionReso!service.ExtractionRemote";	
		ExtractionRemote  proxy=(ExtractionRemote ) context.lookup(jndiName);
//	System.out.println(proxy.All());
//proxy.AddDoctor("meunier", "cecile", "medecin-generaliste", "rouen", "pa","email@e.com");
	
	}

}
