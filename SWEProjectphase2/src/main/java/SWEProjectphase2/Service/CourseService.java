package SWEProjectphase2.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SWEProjectphase2.Model.Course;
import SWEProjectphase2.Model.Teacher;

@Service
public class CourseService {
	
	@Autowired
	private  CourseRepository Courserepository;
	@Autowired
	private TeacherRepository teacherrepository ;
    public  Map<String,String> CreateCourse(String courseName, String CourseOwner){
	  Course course =  Courserepository.findOne(courseName);
	  Course newcourse = new Course();
	  Teacher teacher=new Teacher();
	  Map<String,String> showcourse = new HashMap<String, String>();
	  if(course == null)
	  {
		  newcourse.setCourseName(courseName);
		  teacher=teacherrepository.findOne(CourseOwner);
		  newcourse.setTeacher(teacher);
		  Courserepository.save(newcourse);
		  showcourse.put(newcourse.getCourseName(), newcourse.getTeacher().getName());
		  return showcourse;
	  }
	  
	  return null;
		 
	 }
     public  Map<String,String> ShowALLcourese(){
    	 ArrayList<Course> courses = (ArrayList<Course>) Courserepository.findAll();
    	 if(courses != null)
    	 {
    		 Map<String,String> showcourse = new HashMap<String, String>();
        	 for(int i=0; i<courses.size();i++)
        	 {
        		 showcourse.put(courses .get(i).getCourseName(), courses .get(i).getTeacher().getName());
        	 }
        	 return showcourse;
    	 }
    	
    	 return null;
     }
	 


}
