package SWEProjectphase2.UI;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import SWEProjectphase2.Service.CourseService;

@RestController
public class CourseUI {
	@Autowired
	private CourseService courseservice;
	
	@RequestMapping(method=RequestMethod.POST,value="/CreateCourse")
	public   Map<String,String> CreateCourse(@RequestBody Map<String,String> json){
		return courseservice.CreateCourse(json.get("courseName"),json.get("CourseOwner"));
		
	}
	@RequestMapping(method=RequestMethod.GET,value="/ShowALLcourese")
	public Map<String,String> ShowALLcourese(){
		return courseservice.ShowALLcourese();
		
	}

}
