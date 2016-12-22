package Game;

import java.util.ArrayList;

public class Category {
public	int number_question;
public 	ArrayList<Questions> question = new ArrayList<Questions>();
	public void add(){
		number_question=6;
	}
	public void setnoofquestions(int no){
		number_question = no;
	}
	
	
	public int getnoofquestions(){
		return number_question;
	}
	public static void main(String[] args) {
		

	}

}
