package com.techm.whale.controller;

import java.util.List;









import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.techm.whale.beans.FamilyDelegateBean;
import com.techm.whale.model.Family;

/*
*
*This class is the Controller class  triggered immediately after the .jsp file is loaded
*/
@Controller
@RequestMapping("/whaleService")
/*@RequestMapping("/coffee")*/
public class FamilyController {
	private static final Logger logger = Logger.getLogger(FamilyController.class);
	
	
    /*
    *
    *This @Autowired annotation is used to resolve the dependency and make use the class 
    */
	@Autowired
	FamilyDelegateBean jobDelegateBean;
	
	
    /*
    *
    *This method is triggered after the value from .jsp file and values are compared.From this method its redirected 
    *to another method using the redirect keyword and further process is done
    */
    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String redirect() {
      logger.info("Redirect Method....");
       return "redirect:loadFamily";
    }
    
    /*@RequestMapping(value="{name}", method = RequestMethod.GET)
	public @ResponseBody Coffee getCoffeeInXML(@PathVariable String name) {

		Coffee coffee = new Coffee(name, 100);
		
		return coffee;

	}
*/
    /*
    *
    *This method is triggered from the view/edit jsp page. this method is used to display only a single record to be edited
    *
    */
    @ResponseBody
    @RequestMapping(value = "/edit/{familyCode}", method = RequestMethod.GET)
    public Family edit(@PathVariable Integer familyCode, @ModelAttribute("family") Family family) {
    	logger.info("familycode"+familyCode);
    	Family list= jobDelegateBean.editFamily(familyCode);
    	logger.info("Edit Method....");
      logger.info("family code"+list.getFamilyCode());
      logger.info("family name"+list.getFamilyName());
      /*logger.info("family eligiblity flag"+list.getEligibilityFlag());
      ModelAndView model = new ModelAndView("editFamily");
		model.addObject("familyList", list);*/
		return list;
       
    }
    
    
    /*
    *
    *This method is triggered from the delete button in the view page and it deletes the record selected.  
    *
    */
    @RequestMapping(value = "/delete/{familyCode}", method = RequestMethod.GET)
    public String delete(@PathVariable Integer familyCode, @ModelAttribute("family") Family family) {
    	logger.info("familycode"+familyCode);
    	jobDelegateBean.deleteFamily(familyCode);
    	logger.info("Delete Method....");
      return "deleteSuccess";
       
    }

    
    
    /*
    *
    *This method is triggered to update the edited values. 
    *
    */
    @RequestMapping(value = "/editinsert", method = RequestMethod.GET)
    public String editInsert(@ModelAttribute(value="family") Family family,  Model model) {
    	logger.info("inside editInsert Controller"+family.getFamilyCode());
    	jobDelegateBean.editInsertFamily(family);
    	return "editSuccess";
      
    }

    /*
    *
    *This method is triggered after the value from .jsp file and values are compared.From this method its redirected 
    *to another method using the redirect keyword and further process is done
    */
    
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view() {
    	logger.info("View Family Method....");
       return "redirect:viewFamily";
    }
 
    
    /*
    *
    *This method is triggered to load the jsp page for inserting a family record top the table.
    *
    */
    
    @ResponseBody
 @RequestMapping(value = "/loadFamily", method = RequestMethod.GET)
    public String loadFamily(@ModelAttribute("family") Family family,  Model model) {
	 logger.info("Load Family method");
        family = new Family();
        model.addAttribute("family",family);
        logger.info("Hi inside controller");
       return "addFamily";
    }
 
 
 /*
 *
 *This method is triggered to display the family records in the database 
 *
 */
 
 @ResponseBody
 @RequestMapping(value = "/viewFamily1", method = RequestMethod.GET)
	 public List<Family> viewFamily() {
	 		logger.info("inside controller view Family");
			List<Family> listFamily = jobDelegateBean.list();/*
			ModelAndView model = new ModelAndView("viewFamily");
			model.addObject("familyList", listFamily);*/
			return listFamily;
			}
 
 
 /*
 *
 *This method is triggered to insert the family records into the database 
 *
 */
	@RequestMapping(value="/{familyCode}/{familyName}/{createUserId}/{familyEligibiltyCode}/{eligibilityFlag}", method=RequestMethod.GET)
	 @Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@ResponseBody
	public String insertPlant(@PathVariable("familyCode") int familyCode,@PathVariable ("familyName") String familyName,
	@PathVariable("createUserId") int createUserId,@PathVariable("familyEligibiltyCode") int familyEligibiltyCode,
	@PathVariable("eligibilityFlag") String eligibilityFlag)
	{
		System.out.println(familyCode);
		System.out.println(familyName);
		/*logger.info("value in insert"+family.getFamilyName());
		logger.info("value in insert"+family.getFamilyCode());
		logger.info("value in insert"+family.getCreateUserId());
		jobDelegateBean.insertPlant(family);*/
		jobDelegateBean.insertPlant(familyCode,familyName,createUserId,familyEligibiltyCode, eligibilityFlag);
		  return "redirect:viewFamily1";
		  

	}
	
	
}
