package account;

import java.util.ArrayList;

import Game.StudentGame;

public class Student extends Account {
	
	private ArrayList<StudentGame> playedgames ;
	
	
	public Student(){
		 playedgames = new ArrayList<>();
	}
	
	public void setgames(StudentGame game) {
		playedgames.add(game);
	}

	public ArrayList<StudentGame> getgames() {
			return this.playedgames;
		
	}
public StudentGame searchGame(String name){
		
		for (int i = 0; i < playedgames.size(); i++) {
			if(playedgames.get(i).getName().equals(name)){
				return playedgames.remove(i);
			}
		}
		return new StudentGame();
	}

	// play game as interface
}
