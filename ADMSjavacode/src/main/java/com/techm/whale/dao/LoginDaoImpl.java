package com.techm.whale.dao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.techm.whale.model.Login;

public class LoginDaoImpl implements LoginDao{
	private static final Logger logger = Logger.getLogger(LoginDaoImpl.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean insertLogin(Login login) {
		boolean userExists = false;
		 
		
		logger.info("Inside dao impl");
		int rowcount = jdbcTemplate.queryForInt("select count(*) from whale_user " +
				" where user_name = ? and password = ?",
				login.getUsername(),login.getPassword());
		if(rowcount>=1){
			userExists = true;
		}
		return userExists;	
	}

}



