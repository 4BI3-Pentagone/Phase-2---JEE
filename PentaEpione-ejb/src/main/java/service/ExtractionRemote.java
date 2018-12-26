package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import model.AspNetUser;
import model.Extract;



@Remote
public interface ExtractionRemote {
public ArrayList<Extract>  SearchBySpeciality(String speciality,int pagenumber) throws IOException;
public ArrayList<Extract> SearchByPlace(String place,int pagenumber) throws IOException;
public ArrayList<Extract>  SearchBySpecialityandPlace(String spec,String place,int pagenumber) throws IOException;

public Extract searchexistingdoctor(String nom,String prenom,String specialie ,String ville) throws IOException ;
public List<AspNetUser> All() ;
public AspNetUser AddDoctor(String nom, String prenom, String specialie,String ville, String password, String email) throws IOException;
public void test(String e,int b) throws IOException;
public Extract profile(String url) throws IOException ;
}
