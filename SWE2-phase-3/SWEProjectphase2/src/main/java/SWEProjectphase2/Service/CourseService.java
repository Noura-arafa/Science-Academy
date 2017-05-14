package SWEProjectphase2.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SWEProjectphase2.Model.Course;
import SWEProjectphase2.Model.Student;
import SWEProjectphase2.Model.Teacher;

@Service
public class CourseService {
	
	@Autowired
	private  CourseRepository Courserepository;
	@Autowired
	private TeacherRepository teacherrepository ;
	@Autowired
	private StudentRepository studentrepository;
    public Course CreateCourse(String courseName, String CourseOwner){
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
		  return newcourse;
	  }
	  
	  return null;
		 
	 }
     public ArrayList<Course> ShowALLcoureses(){
    	 ArrayList<Course> courses = (ArrayList<Course>) Courserepository.findAll();
    	 if(courses != null)
    	 {
//    		 Map<String,String> showcourse = new HashMap<String, String>();
//        	 for(int i=0; i<courses.size();i++)
//        	 {
//        		 showcourse.put(courses .get(i).getCourseName(), courses .get(i).getTeacher().getName());
//        	 }
    		
        	 return courses;
    	 }
    	
    	 return null;
     }
	 public void notification_addnewgame(Course course,String gamename){
		// Course course = Courserepository.findOne(coursename);
		 Teacher teacher;
		 Student student;
		 System.out.println("here players " + course.getPlayers().size());
		 for(int i=0;i<course.getPlayers().size();i++){
			 System.out.println("here players ");
			 student = studentrepository.findOne(course.getPlayers().get(i));
			 if(student != null){
				 ArrayList <String> notify = student.getUnreaded();
				 notify.add("There is  "+gamename+" game added in " + course.getCourseName()+" course");
				 student.setUnreaded(notify);
				 studentrepository.save(student);
			 }
			 else {
				 teacher = teacherrepository.findOne(course.getPlayers().get(i));
				 if(teacher != null){
				 ArrayList<String> notify = teacher.getUnreaded();
				 notify.add("There is  "+gamename+" game added in " + course.getCourseName()+" course");
				 teacher.setUnreaded(notify);
				 teacherrepository.save(teacher);
				 }
			 }
		 }
	 }


}
