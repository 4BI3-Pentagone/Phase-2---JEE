package service;

import javax.ejb.Local;

import model.Rate;

@Local
public interface RatingserviceLocal {
 void addRate(Rate rate );
 
}
