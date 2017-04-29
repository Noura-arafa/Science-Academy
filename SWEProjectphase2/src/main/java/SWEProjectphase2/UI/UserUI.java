package SWEProjectphase2.UI;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    
    @CrossOrigin(origins = "http://localhost:8090")
@RequestMapping(method=RequestMethod.POST,value="/SignupAsTeacher")
public @ResponseBody Teacher SignupAsTeacher(@RequestBody Teacher user ){
    	System.out.println("vvvv "+user.getAge());
	String useremail = userservice.SignupAsTeacher(user);
	System.out.println("email  "+ useremail);
	if(useremail == null)
	{
		//return "email is arleady exist";
		return null;
	}
	return user;
}
@CrossOrigin(origins = "http://localhost:8090")
@RequestMapping(method=RequestMethod.POST,value="/SignupAsStudent")
public @ResponseBody Student SignupAsStudent(@RequestBody Student user ){
	System.out.println("yahooo");
	String useremail = userservice.SignupAsStudet(user);
	if(useremail == null)
	{
		return null;
	}
	return user;
}
@CrossOrigin(origins = "http://localhost:8090")
@RequestMapping(method=RequestMethod.POST,value="/Login")
public boolean Login (@RequestBody Map<String,String> json) {
	String useremail = userservice.Login(json.get("email"),json.get("password"));
	if(useremail == null)
	{
		return false;
	}
	else{
		return true;
	}
	
}

@CrossOrigin(origins = "http://localhost:8090")
@RequestMapping(method=RequestMethod.GET,value="/logedinTeacher")
public Teacher logedinTeacher(){
	return userservice.logedinTeacher();
}
@CrossOrigin(origins = "http://localhost:8090")
@RequestMapping(method=RequestMethod.GET,value="/logedinStudent")
public Student logedinStudent(){
	return userservice.logedinStudent();
}

@CrossOrigin(origins = "http://localhost:8090")
@RequestMapping(method=RequestMethod.GET,value="/Logout")
public void logout(){
	userservice.logout();
}

}
