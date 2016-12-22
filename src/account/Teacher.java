package account;

import java.io.IOException;
import java.util.ArrayList;

import Game.ScientificGame;
import Game.TeacherGame;

public class Teacher extends Account{
		public ArrayList<TeacherGame> createdgames=new ArrayList<TeacherGame>();
		
		public void setGame() throws IOException{
			TeacherGame game=new TeacherGame();
			game=game.make_game(this.getname());
			createdgames.add(game);
		}
		public void getgames(){
			for(int i=0;i<createdgames.size();i++)
			{
				
				System.out.println(createdgames.get(i).getgamename());
			}
		}
		//create game as interface

	}
