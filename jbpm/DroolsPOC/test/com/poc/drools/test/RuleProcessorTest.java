package com.poc.drools.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.poc.drools.Applicant;
import com.poc.drools.RuleProcessor;

public class RuleProcessorTest {

	private RuleProcessor ruleProcessor;
	
	@Before
	public void setUp() throws Exception {
		ruleProcessor= new RuleProcessor();
	}

	@After
	public void tearDown() throws Exception {
		ruleProcessor=null;
	}

	@Test
	public void testIsApplicantEligible() {
		Applicant applicant = new Applicant();
		applicant.setAge(42);
		applicant.setName("Ayobami Adewole");
		String validFlag=ruleProcessor.isApplicantAgeEligible(applicant);
		System.out.println("testIsApplicantEligible"+ validFlag);
		//assertTrue(validFlag);
		assertEquals(validFlag, "middleage");
	}
	
	@Test
	public void testIsApplicantInEligible() {
		
		Applicant applicant = new Applicant();
		applicant.setAge(72);
		applicant.setName("Ayobami Adewole");
		String validFlag=ruleProcessor.isApplicantAgeEligible(applicant);
		System.out.println("testIsApplicantInEligible"+ validFlag);
		//assertFalse(validFlag);
		assertEquals(validFlag, "oldage");
	
		
	}

}
