package com.techm.whale.beans;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.techm.whale.dao.LoginDao;
import com.techm.whale.model.Login;

public class LoginDelegateBean {
private static final Logger logger = Logger.getLogger(LoginDelegateBean.class);
	
	@Autowired
	LoginDao loginDao;
	
	public boolean insertLogin(Login login) {
		

		logger.info("Inside bean method");
		return loginDao.insertLogin(login);	
		
	}
	}

