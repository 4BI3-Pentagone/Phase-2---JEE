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
import model.Extract;

@ManagedBean
@ViewScoped
public class ExtractDoctorList {
	
	@EJB
	ExtractionReso extract;
	List<Extract> docList = new ArrayList<Extract>();

	// pb.getPatient("59fdcc1c-9b1c-4caf-819d-f1a25b697eaf");

	

	@PostConstruct
	private void init() throws IOException {
		docList = extract.SearchBySpecialityandPlace(null, null);
		
	}

	public ExtractionReso getExtract() {
		return extract;
	}

	public void setExtract(ExtractionReso extract) {
		this.extract = extract;
	}

	public List<Extract> getDocList() {
		return docList;
	}

	public void setDocList(List<Extract> docList) {
		this.docList = docList;
	}

}
