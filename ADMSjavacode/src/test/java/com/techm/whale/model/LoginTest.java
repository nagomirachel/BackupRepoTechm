package com.techm.whale.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techm.whale.model.Login;

public class LoginTest{
	private Login login;

@Before
	public void setUp() {
		login = new Login();
		
}
		@Test
		public void testGetSet() {
			preparelogin();
			Assert.assertEquals( "nagomi",login.getUsername() );
			Assert.assertEquals( "nagomiRACHEL", login.getPassword() );
			
		}
		
		@Test
		public void testGetSetForNotBlankValues() {
			
			preparelogin();
			Assert.assertNotNull(login.getUsername());
			Assert.assertNotNull(login.getPassword());
			
			
		}
		
		
		private Login preparelogin(){
			
			login.setUsername("nagomi");
			login.setPassword("nagomiRACHEL");
			
			return login;
		}
		
		@After 
		public void tearDown() {
			login = null;
		}
		
	}

