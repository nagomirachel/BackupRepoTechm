package com.techm.whale.controller;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.techm.whale.beans.LoginDelegateBean;
import com.techm.whale.model.Login;

@Controller
public class LoginController {

	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	LoginDelegateBean loginDelegateBean;
	
	Login login;
	
	@RequestMapping(value = "/tologin", method = RequestMethod.GET)
    public String tologin(){
    	logger.info("Inside ToLogin");
        return "redirect:loadLogin";}
    
    @RequestMapping(value = "/loadLogin", method = RequestMethod.GET)
    public String loadLogin(@ModelAttribute(value="login") Login login,  Model model){
    	logger.info("Inside loadlogin");
        login = new Login();
        model.addAttribute("login", login);
        return "Loginpage";}
    
    @RequestMapping(value = "/newMethod", method = RequestMethod.GET)
    public String newMethod(@ModelAttribute(value="login") Login login,  Model model, BindingResult result){
       logger.info("inside Controller new method");
       String username=login.getUsername();
       String password=login.getPassword();
       logger.info("Username"+username);
       logger.info("Password"+password);
       
       if(!loginDelegateBean.insertLogin(login)){
    	   result.addError(new ObjectError("err","Invalid Credentials"));
       }else{
    	   return "Home";
       }
       
       return "Loginpage";}
}


