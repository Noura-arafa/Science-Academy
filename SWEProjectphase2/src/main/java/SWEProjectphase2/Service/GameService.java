package SWEProjectphase2.Service;


import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import SWEProjectphase2.Model.Complete;
import SWEProjectphase2.Model.Course;
import SWEProjectphase2.Model.Game;
import SWEProjectphase2.Model.Matching;
import SWEProjectphase2.Model.Student;
import SWEProjectphase2.Model.Teacher;


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

	public  boolean AddcompleteGameinDateBase(String coursename, String teacherid,Complete cgame ) {
		Course course = Courserepository.findOne(coursename);
		Teacher teacher =  teacherrepository.findOne(teacherid);
		cgame.setCourse(course);
		cgame.setTeacher(teacher);
		Complete newgame = Cgamerepository.findOne(cgame.getGameName());
		if(newgame ==null){
			Cgamerepository.save(cgame);
			int c = course.getCounter()  +1;
			course.setCounter(c);
			Courserepository.save(course);
	    	return true ;
		}
		return false;
    }
	
	public  boolean AddmatchingGameinDateBase(String coursename, String teacherid,Matching Mgame) {
		Course course = Courserepository.findOne(coursename);
		Teacher teacher =  teacherrepository.findOne(teacherid);
		Mgame.setCourse(course);
		Mgame.setTeacher(teacher);
		Matching temp = new Matching();;
		temp.setColumn1(Mgame.getColumn1());
		temp.setColumn2(Mgame.getColumn2());
		temp.setGameName(Mgame.getGameName());
		temp.setCourse(course);
		temp.setTeacher(teacher);
		temp.setModelanswer(Mgame.getModelanswer());
		System.out.println("the name :"+Mgame.getGameName());
		Matching newgame = Mgamerepository.findOne(Mgame.getGameName());
		if(newgame==null){
			Mgamerepository.save(temp);
			int c = course.getCounter()  +1;
			course.setCounter(c);
			Courserepository.save(course);
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
			System.out.println("yessss " + mgame.get(0).getGameName());
			for(int i=0; i<cgame.size(); i++)
			{
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
		System.out.println("sizeeee: " + coursegames.size());
		//System.out.println("ganmee: " + coursegames.get(0).getGameName());
		return coursegames;
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
	public int Submitanwers(String gamename,String Userid,ArrayList<String> answer){
		System.out.println("answer:  " + answer.get(0));
		Matching mgame = Mgamerepository.findOne(gamename);
		Complete cgame=Cgamerepository.findOne(gamename);
		Student student = studentrepository.findOne(Userid);
		Teacher teacher= teacherrepository.findOne(Userid);
		System.out.println("answeeeeer: " + answer.get(0));
		if(student !=null){
		if(mgame !=null)
		{
			for(int i=0; i<mgame.getModelanswer().size();i++){
				if(mgame.getModelanswer().get(i).equals(answer.get(i))) {
					int c=student.getScore();
					c++;
					student.setScore(c);
				}
			}
		}
		else if (cgame!=null){
			for(int i=0; i<cgame.getModelanswer().size();i++){
				if(cgame.getModelanswer().get(i).equals(answer.get(i))) {
					int c=student.getScore();
					c++;
					student.setScore(c);
				}
			}
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
				for(int i=0; i<mgame.getModelanswer().size();i++){
					if(mgame.getModelanswer().get(i).equals(answer.get(i))) {
						int c=teacher.getScore();
						c++;
						teacher.setScore(c);
					}
				}
			}
			else if (cgame!=null){
				for(int i=0; i<cgame.getModelanswer().size();i++){
					if(cgame.getModelanswer().get(i).equals(answer.get(i))) {
						int c=teacher.getScore();
						c++;
						teacher.setScore(c);
					}
				}
			}
			ArrayList<String> temp=teacher.getPlayedgame();
			temp.add(gamename);
			teacher.setPlayedgame(temp);
			teacherrepository.save(teacher);
			return teacher.getScore();
		}
		return 0;
		
	}

	
}
