package com.techm.whale.dao;
import com.techm.whale.model.Login;


/* 
 * Interface for the LoginDao with methods to be implemented in DaoImplementation
 * */
public interface LoginDao {
	
	
/* 
 * This method is used to validate the users with the values in database
 * */
public boolean insertLogin(Login login);
}
