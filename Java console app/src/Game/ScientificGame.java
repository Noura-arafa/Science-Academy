package Game;

import java.util.ArrayList;
import java.util.Scanner;

public class ScientificGame {
	public String subject;
	public String Description;
    public	String game_id;
	public String game_name;
	public int no_levels;
    public String teacher_name;
    public	double average_rate;
    public	String category_type;
    public	ArrayList<Integer> score_cr = new ArrayList<Integer>();
    public	int max_score =0;
    public	MCQ mcq=new MCQ();
    public	True_False t_f=new True_False();
	public ArrayList<String> comment = new ArrayList<String>();
	public ArrayList<String> students = new ArrayList<>();
	 public ScientificGame(){
		no_levels = 0; average_rate=0.0;Description="";game_id="1";
		subject=""; Description="";game_id="";game_name=""; teacher_name="";
	    category_type="";
	}
	 
	 public void show_rate(ScientificGame game) {
			System.out.println("Rate of the game is " + game.average_rate);
		}

		public void setRate(int rate) {
			if (rate == 1) {
				this.average_rate = students.size() * ((average_rate * (students.size() - 1)) + 1);
			} else if (rate == 2) {
				average_rate = students.size() * ((average_rate * (students.size() - 1)) + 2);
			} else if (rate == 3) {
				average_rate = students.size() * ((average_rate * (students.size() - 1)) + 3);
			}
		}

		public void setStudents(String s) {
			if (!students.contains(s)) {
				students.add(s);
			}
		}

		public ArrayList<String> getStudents() {
			return this.students;
		}

		public void setComment(String comment) {
			this.comment.add(comment);
		}
	public void setsubject(String su){
		subject = su;
	}
	public void setdescription(String decp){
		Description = decp;
	}
	
	public void setgamename(String name){
		game_name= name ;
	}
	
	public void setgame_id(String ID){
		game_id = ID;
	}
	
	public void setno_levels(int number){
		no_levels = number;
	}
	
	public String getsubject(){
		return subject;
	}
	public String getdescription(){
		return Description ;
	}
	
	public String getgamename(){
		return game_name;
	}
	
	public String getgame_id(){
		return game_id;
	}
	
	public int setno_levels(){
		return no_levels;
	}
	
	public ArrayList<String> getcomment(){
		return comment;
		}
	
	public String choose_subject(){
		System.out.println("Choose subject: ");
		System.out.println("1-Math");
		System.out.println("2-Science");
		Scanner sc = new Scanner(System.in);
		 subject = sc.next();
		return subject;
	}
	
	
	public String choose_category(){
		System.out.println("Choose category: ");
		System.out.println("1-MCQ");
		System.out.println("2-True/False");
		Scanner sc = new Scanner(System.in);
		String choice = sc.next();
		 return choice;
		 
	}
	
	public void write_description(){
		
	}
	
	public void show_averagerate(){
		System.out.println("Average rate: " + average_rate);
	}
	
	
	
	public ArrayList<Integer> getscorecriteria(){
		return score_cr;
	}
	
	public int getmaxscore(){
		return max_score;
	}
	public void setowner(String teacher){
		teacher_name = teacher;
	}

	public String getowner(){
		return teacher_name;
	}

	public static void main(String[] args) {
		

	}

}
