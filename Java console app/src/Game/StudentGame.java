package Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import account.Teacher;

public class StudentGame {

	private int score = 0;
	private int lastlevel = 0;
	private int lastQuestion = 0;
	private String gameID;
	private String gameName;
	private boolean rated = false;
	public static ArrayList<ScientificGame> games = new ArrayList<>();
	
	public StudentGame(){
		 score = 0;
		 lastlevel = 0;
		 lastQuestion = 0;
		 gameName="";
		 gameID="";
		 rated=false;
	}
	public void readGame() throws FileNotFoundException{
		
		File f = new File("Scientificgame.txt");
		Scanner sc = new Scanner(f);
		ScientificGame game = new ScientificGame();
		while(sc.hasNext()){
			game.subject = sc.next();
			game.Description = sc.next();
			//game.game_id = sc.next();
			game.game_name = sc.next();
			game.no_levels = Integer.parseInt(sc.next());
			game.teacher_name = sc.next();
			game.average_rate = Double.parseDouble(sc.next());
			game.category_type = sc.next();
			int size = sc.nextInt();
			for (int i = 0; i < size; i++) {
				game.score_cr.add(Integer.parseInt(sc.next()));
			}
			game.max_score = Integer.parseInt(sc.next());
			if(game.category_type.equals("MCQ")){
				game.no_levels = Integer.parseInt(sc.next());
				for (int i = 0; i < game.no_levels; i++) {
					int size2 = Integer.parseInt(sc.next());
					Questions q = new Questions();
					for (int j = 0; j < size2; j++) {
						//game.mcq.question.get(i).question.add(sc.next());
						q.question.add(sc.next());
						ArrayList<String> s = new ArrayList<>();
						for (int n = 0; n < 4; n++) {
							s.add(sc.next());
						}
						q.choices.add(s);
						q.correct_answer.add(sc.next());
					}
					
					game.mcq.question.add(q);
				}
			
				games.add(game);
			}
			else if(game.category_type.equals("True/False")){
				game.no_levels = Integer.parseInt(sc.next());
				for (int i = 0; i < game.no_levels; i++) {
					int size2 = Integer.parseInt(sc.next());
					Questions q = new Questions();
					for (int j = 0; j < size2; j++) {	
						q.question.add(sc.next());
						q.correct_answer.add(sc.next());
					}
					game.t_f.question.add(q);
					games.add(game);
				}
			}
			
		}
		
		
	}
	
	public void setScore(int s){
		this.score = s;
	}
	public void setLastLevel(int s){
		this.lastlevel = s;
	}
	public void setLastQuestion(int s){
		this.lastQuestion = s;
	}
	public void setGameId(String s){
		this.gameID = s;
	}
	public void setGameName(String s){
		this.gameName = s;
	}
	public int getlastlevel(){
		return lastlevel;
	}
	public int getScore(){
		return score;
	}
	public int getLastQuestion(){
		return lastQuestion;
	}
	public String getId(){
		return gameID;
	}
	public String getName(){
		return gameName;
	}
	
	
	public void playgame(ScientificGame game){

		System.out.println("category " + game.category_type.equals("MCQ"));
		Scanner sc = new Scanner(System.in);
		game.setStudents(this.getId());
		this.gameName = game.game_name;
		this.gameID = game.game_id;
		game.show_averagerate();
		System.out.println("Your Current Score is "+this.score);
		System.out.println("Your Current Level is "+this.lastlevel);
		if(game.category_type.equals("True/False")){
			for (int i = lastlevel; i < game.no_levels; i++) {
				for (int j = lastQuestion; j < game.t_f.question.size(); j++) {
					System.out.println("game size: "+ game.t_f.question.size());
					System.out.println(game.t_f.question.get(i).question.get(j));
					System.out.println("True or False or exit to end the game");
					String temp;
					temp = sc.next();
					if(game.t_f.question.get(i).correct_answer.get(j).equals(temp)){
						System.out.println("Correct answer");
						score += game.score_cr.get(i);
					}
					else if(temp.equals("exit")){
						lastlevel = i;
						lastQuestion = j;
						System.out.println("Bye Bye");
						
						return;
					}
					else{
						System.out.println("Sorry Wrong Answer");
					}
				}
			}
		}
		else if(game.category_type.equals("MCQ")){
			
			for (int i = lastlevel; i < game.no_levels; i++) {
				
				for (int j = lastQuestion; j < game.mcq.question.get(i).question.size(); j++) {
				//no of levels
					System.out.println(game.mcq.question.get(i).question.get(j));
					
						System.out.println(game.mcq.question.get(i).choices.get(j));
					
					System.out.println("Choose your answer or exit to end the game");
					String temp;
					
					while(true){
					temp = sc.next();
					if(game.mcq.question.get(i).correct_answer.get(j).equals(temp)){
						System.out.println("Correct Answer");
						score += game.score_cr.get(i);
						break;
					}
					else if(temp.equals("exit")){
						lastlevel = i;
						lastQuestion = j;
						System.out.println("Your Current Score is "+this.score);
						System.out.println("Your Current Level is "+this.lastlevel);
						System.out.println("Bye Bye");
						
						return;
					}
					else{
						System.out.println("Sorry Wrong Answer");
						System.out.println("Try again please");
					}
					}
				}
			}
		}
		System.out.println("You finished the game successfuly");
		System.out.println("For Comment press 1");
		System.out.println("For rate press 2");
		System.out.println("For go to your profile press 3 ");
		int choice = sc.nextInt();
		if(choice == 1){
			System.out.println("Enter your comment");
			String s;
			s = sc.next();
			game.setComment(s);
		}
		else if(choice == 2){
			System.out.println("Enter your Rate from 1 to 3");
			if(this.rated == false){
				int s ;
				s = sc.nextInt();
				game.setRate(s);
			}
			else{
				System.out.println("sorry you can rate the game one time");
			}
			
		}
		else if(choice == 3){
			//go to profile
		}
		

	}
	
	public static int searchGame(String name){
		for (int i = 0; i < games.size(); i++) {
			if(games.get(i).getgamename().equals(name)){
				return i;
			}
		}
		return -1;
	}
	

	
public static void main(String[] args) throws IOException {
		
//	Teacher s = new Teacher();
//	s.setname("Yasser");
//	s.setGame();
        StudentGame student1 = new StudentGame();
	
		student1.readGame();
	student1.playgame(StudentGame.games.get(0));
		StudentGame s = new StudentGame();
		s.readGame();
		System.out.println(s.games.get(1).game_name+s.games.get(1).category_type);
		s.playgame(StudentGame.games.get(1));
		
	}
	
	
}
