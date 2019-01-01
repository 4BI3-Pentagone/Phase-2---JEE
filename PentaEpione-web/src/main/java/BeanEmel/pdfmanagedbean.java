package BeanEmel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.itextpdf.text.DocumentException;

import model.AspNetUser;

@ManagedBean
@ViewScoped
public class pdfmanagedbean {
	@EJB
	getPdf pdf ;
	public getPdf getPdf() {
		return pdf;
	}


	public void setPdf(getPdf pdf) {
		this.pdf = pdf;
	}


	public List<AspNetUser> getMypatient() {
		return mypatient;
	}


	public void setMypatient(List<AspNetUser> mypatient) {
		this.mypatient = mypatient;
	}


	List<AspNetUser> mypatient = new ArrayList<AspNetUser>();
	@PostConstruct
	private void init() {
		
		System.out.println("bonjour");
	}
	
	
	public void doPrint () throws DocumentException, IOException
	{
		pdf.Print();
		
	}
}
