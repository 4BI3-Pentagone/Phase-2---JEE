package service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class serviceuser
 */
@Stateless
@LocalBean
public class serviceuser implements serviceuserRemote, serviceuserLocal {

    /**
     * Default constructor. 
     */
    public serviceuser() {
        // TODO Auto-generated constructor stub
    }

}
