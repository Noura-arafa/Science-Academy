package Game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import System.WebSystem;
import account.Teacher;

public class TeacherGame extends ScientificGame {

	
	
	ArrayList<String> student_ids = new ArrayList<String>();
	
	//bnkteb size bta3 kol arryalist 2blih
	public void Writefile(ScientificGame game) throws IOException{
		FileWriter file;
		File f=new File("Scientificgame.txt");
		file = new FileWriter(f,true);
		file.write(game.subject);
		file.write("\n");
		file.write(game.Description);
		file.write("\n");
		//file.write(game.game_id);
		//file.write("\n");
		file.write(game.game_name);
		file.write("\n");
		file.write(Integer.toString(game.no_levels));
		file.write("\n");
		file.write(game.teacher_name);
		file.write("\n");
		file.write(Double.toString(game.average_rate));
		file.write("\n");
		file.write(game.category_type);
		file.write("\n");
		file.write(Integer.toString(game.score_cr.size()));
		file.write("\n");
		for(int i=0;i<game.score_cr.size();i++){
			file.write(Integer.toString(game.score_cr.get(i)));
			file.write("\n");
		}
		file.write(Integer.toString(game.max_score));
		file.write("\n");
		if(game.category_type.equals("MCQ")){
			//number of levels
			file.write(Integer.toString(game.mcq.question.size()));
			file.write("\n");
			for(int i=0;i<game.mcq.question.size();i++){
				file.write(Integer.toString(game.mcq.question.get(i).no_questions));
				file.write("\n");
				for(int j=0;j<game.mcq.question.get(i).no_questions;j++){
					file.write(game.mcq.question.get(i).question.get(j));
					file.write("\n");
					for(int k=0;k<4;k++){
						file.write(game.mcq.question.get(i).choices.get(j).get(k));
						file.write("\n");
					}
					file.write(game.mcq.question.get(i).correct_answer.get(j));
					file.write("\n");
				}
			}

		}
		else if(game.category_type.equals("True/False")){
			//number of levels
			file.write(Integer.toString(game.t_f.question.size()));
			file.write("\n");
			for(int i=0;i<game.t_f.question.size();i++){
				file.write(Integer.toString(game.t_f.question.get(i).no_questions));
				file.write("\n");
				for(int j=0;j<game.t_f.question.get(i).no_questions;j++){
					file.write(game.t_f.question.get(i).question.get(j));
					file.write("\n");
					
					file.write(game.t_f.question.get(i).correct_answer.get(j));
					file.write("\n");
				}
			}
		}
		file.close();
	}
	// make teacher game and return it & put that informations in Scientific game which student will get it to play
	//Questions is class that contain the questions, the correct answer and another attributes that specific to MCQ question
	//get questions, its attribute and attributes of the game form the user except student id 
	public TeacherGame make_game(String owner) throws IOException{
		
		TeacherGame game = new TeacherGame();
		game.setowner(owner);
		
		ScientificGame ga = new ScientificGame();
		ga.setowner(owner);
		game.subject=choose_subject();
		ga.subject = game.subject;
		String choice = choose_category();
		game.category_type = choice;
		ga.category_type = choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the game name ");
		game.game_name = sc.next();
		ga.game_name=game.game_name;
		System.out.println("Enter the game Description ");
		game.Description=sc.next();
		ga.Description=game.Description;
		System.out.println("Enter number of levels: ");
		game.no_levels = sc.nextInt();
		ga.no_levels = game.no_levels;
		if(game.category_type.equals("MCQ")){
			//System.out.println("mennetiiiii");
			for(int i=0; i<game.no_levels;i++){
				Questions ques = new Questions();
				System.out.println("Enter number of quetsions of this level: ");
				ques.no_questions = sc.nextInt();
				System.out.println("Enter the score of the question per level: ");
				int sco = sc.nextInt();
				game.score_cr.add(sco);
				ga.score_cr.add(sco);
				game.max_score += (ques.no_questions * sco );
				ga.max_score = game.max_score;
				for(int j=0; j<ques.no_questions; j++){
					System.out.println("Enter the question content: ");
					String temp = sc.next();
					ques.question.add(temp);
					System.out.println("Enter the choices: ");
					ArrayList<String> tempchoices = new ArrayList<String>();
					for(int k=0; k<4; k++){
						temp = sc.next();
						tempchoices.add(temp);
					}
					ques.choices.add(tempchoices);
					System.out.println("Enter the correct answer: ");
					String correct = sc.next();
					ques.correct_answer.add(correct);
				}
				//game.mcq.add();
				//System.out.println("the size : "+game.mcq.question.size());
			     game.mcq.question.add(ques);
				ga.mcq.question.add(ques);
			}
		}
		
		else if (choice.equals("True/False")){
			for(int i=0; i<game.no_levels;i++){
				Questions ques = new Questions();
				System.out.println("Enter number of quetsions of this level: ");
				ques.no_questions = sc.nextInt();
				System.out.println("Enter the score of the question per level: ");
				int sco = sc.nextInt();
				game.score_cr.add(sco);
				game.max_score += (ques.no_questions * sco );
				ga.score_cr.add(sco);
				ga.max_score = game.max_score;
				for(int j=0; j<ques.no_questions; j++){
					System.out.println("Enter the question content: ");
					String temp = sc.next();
					ques.question.add(temp);
					System.out.println("Enter the correct answer: ");
					String correct = sc.next();
					ques.correct_answer.add(correct);
				}
				game.t_f.question.add(ques);
				ga.t_f.question.add(ques);
			}
		}
		Writefile(ga);
		return game;	
	}
	
	
	public void view_averagerate(){
		
	}
	
	public void setstudent(String st_ids){
		student_ids.add(st_ids);
	}

	public ArrayList<String> getstudent(){
		return student_ids;
	}

	public static void main(String[] args) {
		

	}

}
