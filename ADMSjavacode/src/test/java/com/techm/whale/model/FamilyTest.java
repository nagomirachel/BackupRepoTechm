package com.techm.whale.model;


import static org.junit.Assert.*;

import com.techm.whale.model.Family;





import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class FamilyTest {

	Logger logger = Logger.getLogger(FamilyTest.class);	
private Family family;
	
	@Before
	public void setUp() {
		family = new Family();
		logger.info("before Junit in family");
	}
	
	@Test
	public void testFamily() {
		preparefamily();
		assertTrue("failure - family plant  name is not right","Nagomi".equals(family.getFamilyName()));
		Assert.assertEquals( 21850, family.getFamilyCode() );
		Assert.assertEquals( "Priya", family.getFamilyName() );
		Assert.assertEquals( 21850, family.getCreateUserId() );
		Assert.assertEquals( "2015-04-22", family.getDateCreated() );
		Assert.assertEquals(5000,family.getFamilyEligibiltyCode());
		Assert.assertEquals("Y",family.getEligibilityFlag());
	}
	
	
	
	@Test
	public void testFamilyForNotBlankValues() {
		
		preparefamily();
		Assert.assertNotNull( family.getFamilyCode() );
		Assert.assertNotNull( family.getFamilyName() );
		Assert.assertNotNull(family.getCreateUserId() );
		Assert.assertNotNull( family.getDateCreated() );
	}
	
	
	private Family preparefamily(){
		
		family.setFamilyCode( 21850 );
		family.setFamilyName( "Priya" );
		family.setCreateUserId( 21850 );
		family.setEligibilityFlag("Y");
		family.setFamilyEligibiltyCode(5000);
		return family;
	}
	
	@After 
	public void tearDown() {
		family = null;
		logger.info("After Junit in family");
	}

}
