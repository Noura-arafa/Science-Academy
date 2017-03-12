package Game;

import java.util.ArrayList;

public class Questions {
	
	public ArrayList<String> question = new ArrayList<String>();
	public int number_choices;
	public int no_questions;
	public ArrayList<ArrayList<String>> choices = new ArrayList<ArrayList<String>>();
	public ArrayList<String> correct_answer = new ArrayList<String>();
	
	public void setnoofchoices(int number){
		number_choices = number;
	}
	public void setquestions(ArrayList<String> ques){
		question = ques;
	}
	
	
	public void setchoices(ArrayList<ArrayList<String>> choice){
		choices = choice ;
	}
	public int getnoofchoices(){
		return number_choices;
	}
	public ArrayList<String> getquestions(){
		return question;
	}
	
	
	public ArrayList<ArrayList<String>>  getchoices(){
		return choices;
	}
	
	public void setcorrectanswer(ArrayList<String> answer){
		correct_answer = answer;
	}
	public ArrayList<String> getcorrectanswer(){
		return correct_answer;
	}
	
	
	public static void main(String[] args) {
		
	}
}
