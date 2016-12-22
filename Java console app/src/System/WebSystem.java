package System;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import Game.Questions;
import Game.ScientificGame;
import Game.StudentGame;
import Game.TeacherGame;
import account.Student;
import account.Teacher;

public class WebSystem {
	 static ArrayList<Student> students=new ArrayList<Student>();
	 static ArrayList<Teacher> teachers=new ArrayList<Teacher>();
	static String type="";
	//ArrayList<ScientificGame> games = new ArrayList<ScientificGame>();
//Registration
//log in
//check email
//validate username,password
	public static void writeStudents(ArrayList<Student> arr) {
		PrintStream outstream = null;
		try {
			outstream = new PrintStream(new FileOutputStream("Students.txt"));
			System.setOut(outstream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<StudentGame> arr2 = new ArrayList<>();
		System.out.println(arr.size());
		for (int i = 0; i < arr.size(); i++) {
			
			System.out.println(arr.get(i).getname());
			System.out.println(arr.get(i).getid());
			System.out.println(arr.get(i).getgender());
			System.out.println(arr.get(i).getusername());
			System.out.println(arr.get(i).getpassword());
			System.out.println(arr.get(i).getage());
			System.out.println(arr.get(i).getemail());
			arr2 = arr.get(i).getgames();
			System.out.println(arr2.size());
			for (int j = 0; j < arr2.size(); j++) {
				System.out.println(arr2.get(j).getScore());
				System.out.println(arr2.get(j).getlastlevel());
				System.out.println(arr2.get(j).getLastQuestion());
				System.out.println(arr2.get(j).getId());
				System.out.println(arr2.get(j).getName());
			}
		}
	}
	public void WriteTeacher(ArrayList<Teacher> te) throws IOException{
		FileWriter file;
		File f=new File("Teachers.txt");
		file = new FileWriter(f);
		ArrayList<ScientificGame> arr2 = new ArrayList<>();
		file.write(Integer.toString(te.size()));
		file.write("\n");
		for (int i = 0; i < te.size(); i++) {
			file.write(te.get(i).getname());
			file.write("\n");
			//file.write(te.get(i).getid());
			//file.write("\n");
			file.write(te.get(i).getgender());
			file.write("\n");
			file.write(te.get(i).getusername());
			file.write("\n");
			file.write(te.get(i).getpassword());
			file.write("\n");
			file.write(Integer.toString(te.get(i).getage()));
			file.write("\n");
			file.write(te.get(i).getemail());
			file.write("\n");
			file.write(Integer.toString(te.get(i).createdgames.size()));
			file.write("\n");
			for(int j=0;j<te.get(i).createdgames.size();j++){
			file.write(te.get(i).createdgames.get(j).subject);
			file.write("\n");
			file.write(te.get(i).createdgames.get(j).Description);
			file.write("\n");
			//file.write(game.game_id);
			//file.write("\n");
			file.write(te.get(i).createdgames.get(j).game_name);
			file.write("\n");
			/*file.write(Integer.toString(te.get(i).createdgames.get(j).no_levels));
			file.write("\n");*/
			file.write(te.get(i).createdgames.get(j).teacher_name);
			file.write("\n");
			file.write(Double.toString(te.get(i).createdgames.get(j).average_rate));
			file.write("\n");
			file.write(te.get(i).createdgames.get(j).category_type);
			file.write("\n");
			file.write(Integer.toString(te.get(i).createdgames.get(j).score_cr.size()));
			file.write("\n");
			for(int n=0;n<te.get(i).createdgames.get(j).score_cr.size();n++){
				file.write(Integer.toString(te.get(i).createdgames.get(j).score_cr.get(n)));
				file.write("\n");
			}
			file.write(Integer.toString(te.get(i).createdgames.get(j).max_score));
			file.write("\n");
			if(te.get(i).createdgames.get(j).category_type.equals("MCQ")){
				//number of levels
				file.write(Integer.toString(te.get(i).createdgames.get(j).mcq.question.size()));
				file.write("\n");
				for(int m=0;m<te.get(i).createdgames.get(j).mcq.question.size();m++){
					file.write(Integer.toString(te.get(i).createdgames.get(j).mcq.question.get(m).no_questions));
					file.write("\n");
					for(int l=0;l<te.get(i).createdgames.get(j).mcq.question.get(m).question.size();l++){
						file.write(te.get(i).createdgames.get(j).mcq.question.get(m).question.get(l));
						file.write("\n");
						for(int k=0;k<4;k++){
							//System.out.println("the chice:"+game.mcq.question.get(i).choices.get(j).get(k));
							file.write(te.get(i).createdgames.get(j).mcq.question.get(m).choices.get(l).get(k));
							file.write("\n");
						}
						file.write(te.get(i).createdgames.get(j).mcq.question.get(m).correct_answer.get(l));
						file.write("\n");
					}
				}

			}
			else if(te.get(i).createdgames.get(j).category_type.equals("True/False")){
				//number of levels
				file.write(Integer.toString(te.get(i).createdgames.get(j).t_f.question.size()));
				file.write("\n");
				for(int m=0;m<te.get(i).createdgames.get(j).t_f.question.size();m++){
					file.write(Integer.toString(te.get(i).createdgames.get(j).t_f.question.get(m).no_questions));
					file.write("\n");
					for(int l=0;l<te.get(i).createdgames.get(j).t_f.question.get(i).no_questions;l++){
						file.write(te.get(i).createdgames.get(j).t_f.question.get(m).question.get(l));
						file.write("\n");
						
						file.write(te.get(i).createdgames.get(j).t_f.question.get(m).correct_answer.get(l));
						file.write("\n");
					}
				}
			}
			file.close();
			
		}
	}
	}
	public static ArrayList<Teacher> readTeacher() throws FileNotFoundException{
		Teacher t = new Teacher();
		ArrayList<Teacher> tech = new ArrayList<Teacher>();
		File f=new File("Teachers.txt");
		Scanner read = new Scanner(f);
		if(!read.hasNext()){
			return tech;
		}
		int S =Integer.parseInt(read.next());
		for(int i=0; i<S ; i++){
			t.setname(read.next());
			//t.setid(read.next());
			t.setgender(read.next());
			t.setusername(read.next());
			t.setpassword(read.next());
			t.setage(Integer.parseInt(read.next()));
			t.setemail(read.next());
			int S1 = Integer.parseInt(read.next());
			TeacherGame ga = new TeacherGame();
			
			for(int j=0;j<S1;j++){
				
			ga.subject = read.next();
			ga.Description = read.next();
			//ga.game_id=read.next();
			//System.out.println(read.next());
			ga.game_name =read.next();
			
			//ga.no_levels = Integer.parseInt(read.next());
			ga.teacher_name = read.next();
			ga.average_rate = Double.parseDouble(read.next());
			ga.category_type = read.next();
			int Score_size = Integer.parseInt(read.next());
			for(int n=0;n<Score_size;n++){
				ga.score_cr.add(Integer.parseInt(read.next()));
			}
			ga.max_score = Integer.parseInt(read.next());
			if(ga.category_type.equals("MCQ")){
				//number of levels
				ga.no_levels = Integer.parseInt(read.next());
				for(int m=0;m<ga.no_levels;m++){
					Questions q = new Questions();
				ga.mcq.number_question = Integer.parseInt(read.next());
					for(int l=0;l<ga.mcq.number_question;l++){
						
						//System.out.println(read.next());
						//	int size2 = Integer.parseInt(read.next());
							//for (int k = 0; k < size2; k++) {
								//game.mcq.question.get(i).question.add(read.next());
						//System.out.println(read.next());
								q.question.add(read.next());
								ArrayList<String> s = new ArrayList<>();
								
								for (int n = 0; n < 4; n++) {
									
									s.add(read.next());
								}
								q.choices.add(s);
								q.correct_answer.add(read.next());
							//}
							
							
					}
					ga.mcq.question.add(q);
					
					
					t.createdgames.add(ga);
				}

			}
			else if(ga.category_type.equals("True/False")){
				//number of levels
				ga.no_levels = Integer.parseInt(read.next());
				for (int m = 0; m < ga.no_levels; m++) {
					int size2 = Integer.parseInt(read.next());
					Questions q = new Questions();
					for (int l = 0; l < size2; l++) {	
						q.question.add(read.next());
						q.correct_answer.add(read.next());
					}
					ga.t_f.question.add(q);
					t.createdgames.add(ga);
				}
			}
			
			
		}
			
			tech.add(t);
		}
		
		read.close();
		return tech;
	}
	public static ArrayList<Student> readStudents(){
		FileInputStream instream = null;
		try {
			instream = new FileInputStream("Students.txt");
			System.setIn(instream);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} 
		
		ArrayList<Student> arr = new ArrayList<>();
		
		//Scanner sc = new Scanner(System.in);
		int size,size1;
		Student student = new Student();
		StudentGame game = new StudentGame();
		if(!sc.hasNext()){
			return arr;
		}
		size = sc.nextInt();
		for (int i = 0; i < size; i++) {
			student.setname(sc.next());
			student.setid(sc.next());
			student.setgender(sc.next());
			student.setusername(sc.next());
			student.setpassword(sc.next());
			student.setage(sc.nextInt());
			student.setemail(sc.next());
			size1 = sc.nextInt();
			for (int j = 0; j < size1; j++) {
				game.setScore(sc.nextInt());
				game.setLastLevel(sc.nextInt());
				game.setLastQuestion(sc.nextInt());
				game.setGameId(sc.next());
				game.setGameName(sc.next());
				student.setgames(game);
			}
			arr.add(student);
		}
		
		return arr;
	}
	
	public static int searchTeacher(String name){
		for (int i = 0; i < teachers.size(); i++) {
			if(teachers.get(i).getusername().equals(name)){
				return i;
			}
		}
		return -1;
	}
	public static int searchStudent(String name){
		for (int i = 0; i < students.size(); i++) {
			if(students.get(i).getusername().equals(name)){
				return i;
			}
		}
		return -1;
	}
static Scanner sc=new Scanner(System.in);
public boolean checkemail(String email,String type1){
	if(type1.equals("Teacher")){
		for(int i=0;i<teachers.size();i++){
			Teacher t=new Teacher();
			t=teachers.get(i);
			if(t.getemail().equals(email)){
				return false;
			}
		}
	}
	else{
		for(int i=0;i<students.size();i++){
			Student t=new Student();
			t=students.get(i);
			if(t.getemail().equals(email)){
				return false;
			}
		}
	}
	return true;
	}


public String Regestration(){
	System.out.println("Enter your type");
	 type=sc.next();
	if(type.equals("Teacher")){
		Teacher t=new Teacher();
		System.out.println("Enter your name ");
	t.setname(sc.next());
	System.out.println("Enter your gender ");
	t.setgender(sc.next());
	System.out.println("Enter your username ");
	t.setusername(sc.next());
	System.out.println("Enter your password ");
	t.setpassword(sc.next());
	System.out.println("Enter your age ");
	t.setage(sc.nextInt());
	System.out.println("Enter your email ");
	String email=sc.next();
	while(!checkemail(email,type)){
		System.out.println("Wrong email please enter another email ");
		email=sc.next();
	}
	t.setemail(email);
	teachers.add(t);
	System.out.println("Welcome prof: "+t.getusername());
	return t.getusername();
	}
	else{
		Student t=new Student();
		System.out.println("Enter your name ");
	t.setname(sc.next());
	System.out.println("Enter your gender ");
	t.setgender(sc.next());
	System.out.println("Enter your username ");
	t.setusername(sc.next());
	System.out.println("Enter your password ");
	t.setpassword(sc.next());
	System.out.println("Enter your age ");
	t.setage(sc.nextInt());
	System.out.println("Enter your email ");
	String email=sc.next();
	while(!checkemail(email,type)){
		System.out.println("Wrong email please enter another email ");
		email=sc.next();
	}
	t.setemail(email);
	students.add(t);
	System.out.println("Welcome: "+t.getusername());
	return t.getusername();
	}
}
public boolean validation(String type1,String username , String p){
	if(type1.equals("Teacher")){
		for(int i=0;i<teachers.size();i++){
			Teacher t=new Teacher();
			t=teachers.get(i);
			if(t.getusername().equals(username)&&t.getpassword().equals(p)){
				return true;
			}
		}
	}
	else{
		for(int i=0;i<students.size();i++){
			Student t=new Student();
			t=students.get(i);
			if(t.getusername().equals(username)&&t.getpassword().equals(p)){
				return true;
			}
		}
	}
	return false;
}
public String login(){
	System.out.println("Teacher");
	System.out.println("Student");
	type=sc.next();
	String username="";
	String p="";
	System.out.println("Enter your username");
	username=sc.next();
	System.out.println("Enter your password");
	p=sc.next();	
	while(!validation(type, username,p)){
	System.out.println("wrong username or password,enter them again ");
	System.out.println("Enter your username");
	username=sc.next();
	System.out.println("Enter your password");
	p=sc.next();
	
	}
	
	System.out.println("Welcome back ");
	return username;
}

	public Student findst(){
		Student st = new Student();
		for(int i=0; i<students.size();i++){
			
		}	
		return st;
	}

public static void main(String[]strg) throws IOException{
//	System.out.println("asjhjs: ");
	//Teacher t=new Teacher();
	//t.setname("MNOURA");
	//t.setGame();
	boolean Exit=true,state=false;
	WebSystem wbs = new WebSystem();
	//wbs.students = readStudents();
	wbs.teachers = readTeacher();
	String usrname="";
	Student st = new Student();
	Teacher t = new Teacher();
	String input;
	while(Exit){
	do{
	System.out.println("Signup ");
	System.out.println("Login ");
	input = sc.next();
	if(input.equals("Signup"))
		usrname = wbs.Regestration();
	else if(input.equals("Login"))
		usrname=wbs.login();
	
		
	state=true;
	}while(!state);
	do{	
		
	if(wbs.type.equals("Student")){
		for(int i=0; i <wbs.students.size(); i++){
			if(wbs.students.get(i).getusername().equals(usrname)){
				st = wbs.students.get(i);
				break;
			}
			
			
		}
		ArrayList<StudentGame> arr = new ArrayList<>();
		arr = st.getgames();
		if(arr.size() == 0)
			System.out.println("No regesterd games");
		else{
			System.out.println("My Games:");
			for (int i = 0; i < arr.size(); i++) {
				System.out.println(arr.get(i).getName()+"   Score: "+arr.get(i).getScore());
			}
		}
		
	//	st.getgames();	
		System.out.println("Do you want to play a game");
		input=sc.next();
		if(input.equals("Yes")){
		System.out.println("Enter the game name");
		input=sc.next();
		StudentGame stg = new StudentGame();
		stg.readGame();
		ArrayList<ScientificGame> arr2 = new ArrayList<>();
		arr2 = stg.games;
		int index = stg.searchGame(input);
		
		if(index == -1){
			System.out.println("Game not found");
		}
		else if(index>=0){
			StudentGame tmp = new StudentGame();
			tmp = st.searchGame(input);
			if(tmp.getName().equals(input)){
				System.out.println("i am here: ");
				stg = tmp;
				stg.games = arr2;
				
			}
			stg.playgame(stg.games.get(index));
			st.setgames(stg);
			System.out.println("hhii"+stg.getName());
			
		}
		wbs.students.add(st);

		
		//st.setgames();
		
		}
		
		else{
			state=false;
		}
	}
	
	else if(wbs.type.equals("Teacher")){
		for(int i=0; i <wbs.teachers.size(); i++){
			if(wbs.teachers.get(i).getusername().equals(usrname)){
				t = wbs.teachers.get(i);
				break;
			}
	}
	t.getgames();
	System.out.println("Do you want to make game");
	String choice=sc.next();
	if(choice.equals("Yes")){
		t.setGame();
	}
	
		System.out.println("Show game/Logout");
		input=sc.next();
		if(input.equals("Logout")){
		state=false;
		}
		else{
			System.out.println("Enter the game name");
			input=sc.next();
			for(int i=0;i<t.createdgames.size();i++){
				if(t.createdgames.get(i).getgamename().equals(input)){
					String gametype=t.createdgames.get(i).category_type;
					if(gametype.equals("MCQ")){
						for(int j=0;j<t.createdgames.get(i).no_levels;j++){
							for(int k=0;k<t.createdgames.get(i).mcq.question.get(j).question.size();k++){
								System.out.println("Q" +k +" " +t.createdgames.get(i).mcq.question.get(j).question.get(k));
									System.out.println(t.createdgames.get(i).mcq.question.get(j).choices.get(k));
								
							}
							
						}
					}
					else if(gametype.equals("True/False")){
						for(int j=0;j<t.createdgames.get(i).no_levels;j++){
							for(int k=0;k<t.createdgames.get(i).t_f.question.get(j).question.size();k++){
								System.out.println("Q" +k +" " +t.createdgames.get(i).t_f.question.get(j).question.get(k));
					
							}
							
						}
						
					}
					if(t.createdgames.get(i).comment.size()==0)
						System.out.println("No comments:");
					else{
						System.out.println("Comments: ");
						for(int m=0; m<t.createdgames.get(i).comment.size();m++)
							System.out.println(t.createdgames.get(i).comment.get(m));
					}
					
				}
			}
		}
	
}
	
}while(state);
	System.out.println("if you want to exit");
	input=sc.next();
	if(input.equals("Yes")){
		Exit=false;
	}
}
	//wbs.writeStudents(students);
	wbs.WriteTeacher(teachers);
}
}