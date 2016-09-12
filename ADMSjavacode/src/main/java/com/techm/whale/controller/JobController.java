package com.techm.whale.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.techm.whale.beans.JobDelegateBean;
import com.techm.whale.model.FamilyPlant;


@Controller
public class JobController {

                private static final Logger logger = Logger.getLogger(JobController.class);
                
                @Autowired
                JobDelegateBean jobDelegateBean;
                
                
                
                @RequestMapping(value = "/redirect_to_add_family_plant", method = RequestMethod.GET)
    public String redirectAddFamilyPlant() {
      logger.info("redirecting to add family plant page");
       return "redirect:redirectinsertFamilyPlant";
    }

                @RequestMapping(value = "/redirectinsertFamilyPlant", method = RequestMethod.GET)
    public String loadFamilyPlant(@ModelAttribute("familyPlantCode") FamilyPlant familyPlant,  Model model) {
                familyPlant = new FamilyPlant();
        model.addAttribute("familyplant",familyPlant);
       return "AddFamilyPlant";
    }
    
                @RequestMapping(value="/insertfamilyplant", method=RequestMethod.POST)
                public String insertfamilyPlant(@ModelAttribute(value="familyPlantCode") FamilyPlant familyplant,  Model model){
                                logger.info("calling jobdelegate bean to insert family plant");
                                logger.info("FAMILY PLANT CODE IN DELEGATEBEAN"+familyplant.getFamilyPlantCode());
                                jobDelegateBean.insertfamilyPlant(familyplant);
                                return "AddFamilyPlant";
                }

   
                
    @RequestMapping(value = "/view_family_plant", method = RequestMethod.GET)
    public String redirectviewFamilyPlant() {
      return "redirect:redirectviewFamilyPlant";
    }
                
    
    @RequestMapping(value = "/redirectviewFamilyPlant", method = RequestMethod.GET)
                public ModelAndView viewFamilyPlant() {
                                               
                                                List<FamilyPlant> listobject = jobDelegateBean.listfamilyPlant();
                                                ModelAndView model = new ModelAndView("ViewFamilyPlantCode");
                                                model.addObject("familyplantList", listobject);
                                                logger.info("inside controller view Family plant ");
                                                return model;
                                }
    
                
    
    @RequestMapping(value = "/editfamilyplantcode/{familyPlantCode}", method = RequestMethod.GET)
    public ModelAndView editfamilyplantCode(@PathVariable Integer familyPlantCode, @ModelAttribute("familyplant") FamilyPlant familyplant) {
                logger.info("familycodeeeee"+familyPlantCode);
                FamilyPlant list= jobDelegateBean.editFamilyplant(familyPlantCode);
      ModelAndView model = new ModelAndView("EditFamilyPlant");
                                model.addObject("familyplantList", list);
                                return model;
       
    }
    
    
    
    @RequestMapping(value = "/editinsertfamilyplant", method = RequestMethod.GET)
    public String editInsert(@ModelAttribute(value="familyplant") FamilyPlant familyplant,  Model model) {
                logger.info("value of family code inside controller (EDIT INSERT FAMILY PLANT)"+familyplant.getFamilyCode());
                jobDelegateBean.editinsertfamilyPlant(familyplant);
                return "redirect:redirectviewFamilyPlant";
      
    }
    
  
    
    @RequestMapping(value = "/deletefamilyplant/{familyPlantCode}", method = RequestMethod.GET)
    public String delete(@PathVariable Integer familyPlantCode, @ModelAttribute("familyplant") FamilyPlant familyplant) {
                logger.info("familyplantcode to be deleted (in JOBController)"+familyPlantCode);
                jobDelegateBean.deletefamilyPlant(familyPlantCode);
      
      return "DeleteFP";
       
    }
    
   
    @RequestMapping(value = "/", method = RequestMethod.GET)
                public ModelAndView viewHome() {
                logger.info("to render the home page....");
                               ModelAndView model = new ModelAndView("AddFamilyPlant");
                               return model;
                                }
    

}
