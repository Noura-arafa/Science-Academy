package SWEProjectphase2.Service;


import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SWEProjectphase2.Model.Comment;
import SWEProjectphase2.Model.Complete;
import SWEProjectphase2.Model.Course;
import SWEProjectphase2.Model.Game;
import SWEProjectphase2.Model.Matching;
import SWEProjectphase2.Model.Student;
import SWEProjectphase2.Model.Teacher;
import ch.qos.logback.core.net.SyslogOutputStream;



@Service
public class GameService {
	@Autowired
	private  CompleteRepository Cgamerepository;
	@Autowired
	private  MatchingReposirory Mgamerepository;
	@Autowired
	private  CourseRepository Courserepository;
	@Autowired
	private TeacherRepository teacherrepository;
	@Autowired
	private StudentRepository studentrepository;
	@Autowired
	private CommentRepository commentRepository;

	public  boolean AddcompleteGameinDateBase(String coursename, String teacherid,Complete cgame ) {
		Course course = Courserepository.findOne(coursename);
		Teacher teacher =  teacherrepository.findOne(teacherid);
		cgame.setCourse(course);
		cgame.setTeacher(teacher);
		ArrayList<String> tech = new ArrayList<String>();
		tech.add(teacher.getEmail());
		cgame.setCollebrators(tech);
		Complete newgame = Cgamerepository.findOne(cgame.getGameName());
		if(newgame ==null){
			Cgamerepository.save(cgame);
			int c = course.getCounter()  +1;
			course.setCounter(c);
			Courserepository.save(course);
			 CourseService courseservice = new CourseService();
			  courseservice.notification_addnewgame(course, cgame.getGameName());

	    	return true ;
		}
		return false;
    }

	public  boolean EditcompleteGame(Complete cgame ,String teacherid  ) {
		Complete newgame = Cgamerepository.findOne(cgame.getGameName());
		if(newgame !=null){
			
			ArrayList<String> collebrators = newgame.getCollebrators();
			int x =collebrators.indexOf(teacherid);
			if(x!= -1){
					cgame.setCourse(newgame.getCourse());
					cgame.setTeacher(newgame.getTeacher());
					cgame.setCollebrators(newgame.getCollebrators());
				   Cgamerepository.save(cgame);
	    	return true ;
			}
			else {
				
				return false;
			}
		}
		return false;
    }
public  boolean EditmatchingGame(Matching mgame ,String teacherid  ) {
		
		Matching newgame =  Mgamerepository.findOne(mgame.getGameName());
		if(newgame !=null){
			ArrayList<String> collebrators = newgame.getCollebrators();
			int x =collebrators.indexOf(teacherid);
			if(x!= -1){
				mgame.setCourse(newgame.getCourse());
				mgame.setTeacher(newgame.getTeacher());
				mgame.setCollebrators(newgame.getCollebrators());
			 Mgamerepository.save(mgame);
	    	return true ;
			}
			else {
				return false;
			}
		}
		return false;
    }
	
	public  boolean AddmatchingGameinDateBase(String coursename, String teacherid,Matching Mgame) {
		Course course = Courserepository.findOne(coursename);
		Teacher teacher =  teacherrepository.findOne(teacherid);
		Mgame.setCourse(course);
		Mgame.setTeacher(teacher);
		ArrayList<String> tech = new ArrayList<String>();
		tech.add(teacher.getEmail());
		Mgame.setCollebrators(tech);
		Matching temp = new Matching();;
		temp.setColumn1(Mgame.getColumn1());
		temp.setColumn2(Mgame.getColumn2());
		temp.setGameName(Mgame.getGameName());
		temp.setCourse(course);
		temp.setTeacher(teacher);
		temp.setModelanswer(Mgame.getModelanswer());
		temp.setCollebrators(tech);	
		Matching newgame = Mgamerepository.findOne(Mgame.getGameName());
		if(newgame==null){
			Mgamerepository.save(temp);
			int c = course.getCounter()  +1;
			course.setCounter(c);
			Courserepository.save(course);
			 CourseService courseservice = new CourseService();
			 courseservice.notification_addnewgame(course, Mgame.getGameName());
	    	return true ;
		}
		return false;
    }
	
	public  ArrayList<Game> ShowGamesInCourse(String coursename){
		Course course = Courserepository.findOne(coursename);
		int c = course.getCounter();
		ArrayList<Complete> cgame =  (ArrayList<Complete>) Cgamerepository.findAll();
		ArrayList<Matching> mgame =  (ArrayList<Matching>) Mgamerepository.findAll();
		 ArrayList<Game> coursegames = new  ArrayList<Game>();
		
		if(cgame !=null && c !=0)
		{
			System.out.println("in if coumplete");
			for(int i=0; i<cgame.size(); i++)
			{
				if(c == 0)
					break;
				if(cgame.get(i).getCourse().getCourseName().equals(coursename))
				{
					//coursegames.add(cgame.get(i).getGameName());
					coursegames.add(cgame.get(i));
					c--;
				}
			}
		}
		if(mgame !=null && c!=0)
		{
			System.out.println("da5lt al mgame " +mgame.size());
			for(int i=0; i<mgame.size(); i++)
			{
				System.out.println("game " + mgame.get(i).getGameName() + " course " + mgame.get(i).getCourse().getCourseName());
				
				if(c == 0)
					break;
				if(mgame.get(i).getCourse().getCourseName().equals(coursename))
				{
					//coursegames.add(mgame.get(i).getGameName());
					coursegames.add(mgame.get(i));
					c--;
					
				}
			}
		}
		
		System.out.println("ganmee: " + coursegames.size());
		return coursegames;
	}
	public  ArrayList<Game> ShowGamesForTeacher(String teacherName){
		ArrayList<Complete> cgame =  (ArrayList<Complete>) Cgamerepository.findAll();
		ArrayList<Matching> mgame =  (ArrayList<Matching>) Mgamerepository.findAll();
		 ArrayList<Game> teachergames = new  ArrayList<Game>();
		 for(int i =0; i<cgame.size();i++){
			 if(cgame.get(i).getTeacher().getName()==teacherName){
				 teachergames.add(cgame.get(i));
			 }
		 }
		 for(int i =0; i<mgame.size();i++){
			 if(mgame.get(i).getTeacher().getName()==teacherName){
				 teachergames.add(mgame.get(i));
			 }
		 }
		
		//System.out.println("ganmee: " + coursegames.get(0).getGameName());
		return teachergames;
	}
	public boolean AddComment(String gamename , String userid , String Comment  ){
		
		Matching mgame = Mgamerepository.findOne(gamename);
		Complete cgame = Cgamerepository.findOne(gamename);
		Student student =  studentrepository.findOne(userid);
		Teacher teacher =  teacherrepository.findOne( userid );
		System.out.println( mgame.getGameName());
		
		if(mgame != null){
			if(student != null){
				Comment comment = new Comment();
				comment.setComment(Comment);
				comment.setGame(mgame);
				comment.setId(mgame.getId());
				comment.setStudentName(userid);
				commentRepository.save(comment);
				System.out.println(comment.getComment());
				return true;
				
			}
			else if (teacher !=null){
				Comment comment = new Comment();
				comment.setComment(Comment);
				comment.setGame(mgame);
				comment.setId(mgame.getId());
				comment.setTeacherName(userid);
				commentRepository.save(comment);
				return true;
			}
			else {
				return false ;
			}
		}
		else if (cgame !=null) {
			System.out.println("cgame");
			if(student != null){
				Comment comment = new Comment();
				comment.setComment(Comment);
				comment.setGame(cgame);
				comment.setId(cgame.getId());
				comment.setStudentName(userid);
				commentRepository.save(comment);
				return true;
				
			}
			else if (teacher !=null){
				Comment comment = new Comment();
				comment.setComment(Comment);
				comment.setGame(cgame);
				comment.setId(cgame.getId());
				comment.setTeacherName(userid);
				commentRepository.save(comment);
				System.out.println(comment.getComment());
				return true;
			}
			else {
				return false ;
			}
		}
		return false;
		
	}
	public Game playgame(String gamename) {
		Matching mgame = Mgamerepository.findOne(gamename);
		Complete cgame=Cgamerepository.findOne(gamename);
		if(mgame !=null)
		{
			return mgame;
		}
		else if (cgame!=null){
			return cgame;
		}
		
		return null;
	}
	public boolean gametype(String gamename){
		Matching mgame = Mgamerepository.findOne(gamename);
		Complete cgame=Cgamerepository.findOne(gamename);
		if(mgame !=null)
		{
			return true;
		}
		return false;
			
	}
public int Submitanwers(String gamename,String Userid,ArrayList<String> answer){
		
		Matching mgame = Mgamerepository.findOne(gamename);
		Complete cgame=Cgamerepository.findOne(gamename);
		Student student = studentrepository.findOne(Userid);
		Teacher teacher= teacherrepository.findOne(Userid);
		 
		if(student !=null){
		if(mgame !=null)
		{
			Course course = mgame.getCourse();
			ArrayList<String> player = course.getPlayers();
			player.add(Userid);
			course.setPlayers(player);
			mgame.setCourse(course);
			for(int i=0; i<mgame.getModelanswer().size();i++){
				if(mgame.getModelanswer().get(i).equals(answer.get(i))) {
					int c=student.getScore();
					c++;
					student.setScore(c);
				}
			}
			Courserepository.save(course);
		}
		else if (cgame!=null){
			Course course = cgame.getCourse();
			ArrayList<String> player = course.getPlayers();
			player.add(Userid);
			course.setPlayers(player);
			cgame.setCourse(course);
			for(int i=0; i<cgame.getModelanswer().size();i++){
				if(cgame.getModelanswer().get(i).equals(answer.get(i))) {
					int c=student.getScore();
					c++;
					student.setScore(c);
				}
			}
			Courserepository.save(course);
		}
		ArrayList<String> temp=student.getPlayedgame();
		temp.add(gamename);
		student.setPlayedgame(temp);
		studentrepository.save(student);
		return student.getScore();
	}
		else if(teacher!=null){
			if(mgame !=null)
			{
				Course course = mgame.getCourse();
				ArrayList<String> player = course.getPlayers();
				player.add(Userid);
				course.setPlayers(player);
				mgame.setCourse(course);
				for(int i=0; i<mgame.getModelanswer().size();i++){
					if(mgame.getModelanswer().get(i).equals(answer.get(i))) {
						int c=teacher.getScore();
						c++;
						teacher.setScore(c);
					}
				}
				Courserepository.save(course);
			}
			else if (cgame!=null){
				Course course = cgame.getCourse();
				ArrayList<String> player = course.getPlayers();
				player.add(Userid);
				course.setPlayers(player);
				cgame.setCourse(course);
				for(int i=0; i<cgame.getModelanswer().size();i++){
					if(cgame.getModelanswer().get(i).equals(answer.get(i))) {
						int c=teacher.getScore();
						c++;
						teacher.setScore(c);
					}
				}
				Courserepository.save(course);
			}
			ArrayList<String> temp=teacher.getPlayedgame();
			temp.add(gamename);
			teacher.setPlayedgame(temp);
			teacherrepository.save(teacher);
			
			return teacher.getScore();
		}
		return 0;
		
	}
	public boolean copyGame(String techemail,String gamename,String newName,String newcourse)
	{
		//System.out.println("Name "+techemail+" gamename "+gamename+" newName "+newName);
		Course course=Courserepository.findOne(newcourse);
		boolean type = gametype(gamename);
		if(course == null) 
			return false;
		if(type)
		{
			Matching temp=new Matching();
			Matching mgame = Mgamerepository.findOne(gamename);
			temp.setColumn1(mgame.getColumn1());
			temp.setColumn2(mgame.getColumn2());
			int x = course.getCounter() +1;
			course.setCounter(x);
			temp.setCourse(course);
			temp.setCollebrators(mgame.getCollebrators());
			temp.setModelanswer(mgame.getModelanswer());
			temp.setGameName(newName);
			temp.setTeacher(mgame.getTeacher());
			Mgamerepository.save(temp);
			Courserepository.save(course);
			CourseService courseservice = new CourseService();
			 courseservice.notification_addnewgame(course, temp.getGameName());
			return true;
			
		}
		else if(!type) {
		Complete temp=new Complete();
			Complete cgame = Cgamerepository.findOne(gamename);
			int x = course.getCounter() +1;
			course.setCounter(x);
			temp.setCourse(course);
			temp.setGameName(newName);
			temp.setModelanswer(cgame.getModelanswer());
			temp.setQuestion(cgame.getQuestion());
			temp.setCollebrators(cgame.getCollebrators());
			temp.setTeacher(cgame.getTeacher());
			Cgamerepository.save(temp);
			Courserepository.save(course);
			CourseService courseservice = new CourseService();
			 courseservice.notification_addnewgame(course, temp.getGameName());
			return true;
		}
		return false;
	}
	public void AddGameCollaborator(String gamename,String newemail){
		boolean Type=gametype(gamename);
		if(Type){
			Matching mgame=Mgamerepository.findOne(gamename);
			Teacher teacher=teacherrepository.findOne(newemail);
			
			if(teacher!=null)
			{
			ArrayList<String> emails=mgame.getCollebrators();
			emails.add(teacher.getName());
			mgame.setCollebrators(emails);
			Mgamerepository.save(mgame);
			}
		}
			else if(!Type)
			{
				Complete cgame=Cgamerepository.findOne(gamename);
				Teacher teacher1=teacherrepository.findOne(newemail);
				if(teacher1!=null)
				{
					ArrayList<String> emails=cgame.getCollebrators();
					emails.add(teacher1.getName());
					cgame.setCollebrators(emails);
					Cgamerepository.save(cgame);
				}
			}
			
			
		
	
}
	//authority
	public void Cancelgame(String gamename,String email){
		boolean Type=gametype(gamename);
		if(Type)
		{
			Matching mgame=Mgamerepository.findOne(gamename);
			mgame.setCanceled(true);
			Teacher teacher=teacherrepository.findOne(email);
			ArrayList<String> cancel=teacher.getCanceledgames();
			cancel.add(gamename);
			teacher.setCanceledgames(cancel);
			teacherrepository.save(teacher);
			Mgamerepository.save(mgame);
		}
		else {
			Complete cgame=Cgamerepository.findOne(gamename);
			cgame.setCanceled(true);
			Teacher teacher=teacherrepository.findOne(email);
			ArrayList<String> cancel=teacher.getCanceledgames();
			cancel.add(gamename);
			teacher.setCanceledgames(cancel);
			teacherrepository.save(teacher);
			Cgamerepository.save(cgame);
		}
	}
	public ArrayList<String> showcanceledgames(String teacheremail){
		System.out.println("teacher email " + teacheremail);
		Teacher teacher = teacherrepository.findOne(teacheremail);
		return teacher.getCanceledgames();	
	}
	
	public void unCancelgame(String gamename,String email){
		Teacher teacher=teacherrepository.findOne(email);
		ArrayList<String> array=teacher.getCanceledgames();
		int index=array.indexOf(gamename);
		if(index!=-1)
		   array.remove(index);
		boolean Type=gametype(gamename);
		if(Type){
			Matching mgame=Mgamerepository.findOne(gamename);
			mgame.setCanceled(false);
			Mgamerepository.save(mgame);
		}
		else{
			Complete cgame=Cgamerepository.findOne(gamename);
			cgame.setCanceled(false);
			Cgamerepository.save(cgame);
			
		}
		
	}



	
}
