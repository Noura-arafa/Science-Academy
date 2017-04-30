package SWEProjectphase2.UI;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import SWEProjectphase2.Model.Course;
import SWEProjectphase2.Service.CourseService;

@RestController
public class CourseUI {
	@Autowired
	private CourseService courseservice;
	@CrossOrigin(origins = "http://localhost:8090")
	@RequestMapping(method=RequestMethod.POST,value="/CreateCourse")
	public   Course CreateCourse(@RequestBody Map<String,String> json){
		return courseservice.CreateCourse(json.get("courseName"),json.get("CourseOwner"));
		
	}
	@CrossOrigin(origins = "http://localhost:8090")
	@RequestMapping(method=RequestMethod.GET,value="/ShowALLcoureses")
	public ArrayList<Course> ShowALLcoureses(){
		return courseservice.ShowALLcoureses();
		
	}

}
