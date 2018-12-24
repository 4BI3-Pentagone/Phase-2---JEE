package emel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;



@Remote
public interface ExtractionInt {
public ArrayList<Extract>  SearchBySpeciality(String speciality,int pagenumber) throws IOException;
public ArrayList<Extract> SearchByPlace(String place,int pagenumber) throws IOException;
public ArrayList<Extract>  SearchBySpecialityandPlace(String spec,String place,int pagenumber) throws IOException;

public Extract searchexistingdoctor(String nom,String prenom,String specialie) throws IOException ;
public Doctor AddDoctor(String nom,String prenom ,String specialie,String password) throws IOException;
public Doctor AddDoctor(String nom, String prenom, String specialie, String password, String email) throws IOException;
public void test(String e,int b) throws IOException;
public Extract profile(String url) throws IOException ;
}
