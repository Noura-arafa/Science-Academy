package SWEProjectphase2.Service;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SWEProjectphase2.Model.Student;
import SWEProjectphase2.Model.Teacher;



@Service
public class UserService {
	@Autowired
//	private UserRepositry Userrepository;
	private TeacherRepository teacherrepository ;
	@Autowired
	private StudentRepository studentreposirory;
	
	public String SignupAsTeacher(Teacher user){
		String checkemail;
		checkemail=user.getEmail();
		Teacher newuser=new Teacher();
		newuser=teacherrepository.findOne(checkemail);
		ArrayList<String> temp = new ArrayList<String>();
		if(newuser==null){
			user.setPlayedgame(temp);
			teacherrepository.save(user);
			return user.getEmail();
		}
		return null;
	}
	public String SignupAsStudet(Student user){
		String checkemail;
		checkemail=user.getEmail();
		Student newuser=new Student();
		newuser=studentreposirory.findOne(checkemail);
		ArrayList<String> temp = new ArrayList<String>();
		if(newuser==null){
			user.setPlayedgame(temp);
			studentreposirory.save(user);
			return user.getEmail();
		}
		return null;
	}
	/*Log in function return user if the email and the password is correct 
	 * and in the database if not it will return null so the user
	 * can retry
	 */
	public String Login(String email, String password) {
		Teacher tuser = new Teacher();
		Student suser=new Student();
		tuser = teacherrepository.findOne(email);
		if(tuser==null){
			suser=studentreposirory.findOne(email);
			if(suser!=null){
				if(suser.getPassword().equals(password))
				     return suser.getEmail();
			}
		}
		else{
			if(tuser.getPassword().equals(password))
			    return tuser.getEmail();
		}
		return null;
	}
	

}
