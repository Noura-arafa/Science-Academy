package SWEProjectphase2.UI;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import SWEProjectphase2.Model.Student;
import SWEProjectphase2.Model.Teacher;

import SWEProjectphase2.Service.UserService;



@RestController
public class UserUI {
    @Autowired
    private UserService userservice;
@RequestMapping(method=RequestMethod.POST,value="/SignupAsTeacher")
public @ResponseBody String  SignupAsTeacher(@RequestBody Teacher user ){
	String useremail = userservice.SignupAsTeacher(user);
	if(useremail == null)
	{
		return "email is arleady exist";
	}
	return useremail;
}

@RequestMapping(method=RequestMethod.POST,value="/SignupAsStudent")
public @ResponseBody String SignupAsStudent(@RequestBody Student user ){
	String useremail = userservice.SignupAsStudet(user);
	if(useremail == null)
	{
		return "email is arleady exist";
	}
	return useremail;
}
@RequestMapping(method=RequestMethod.POST,value="/Login")
public @ResponseBody String Login (@RequestBody Map<String,String> json) {
	String useremail = userservice.Login(json.get("email"),json.get("password"));
	if(useremail == null)
	{
		return "Wrong email or password";
	}
	else{
		return useremail;
	}
	
}

}
