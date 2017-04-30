package SWEProjectphase2.Model;

import java.util.ArrayList;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;


@Entity
@PrimaryKeyJoinColumns({
	@PrimaryKeyJoinColumn(name="game_name",referencedColumnName="gameName")
})
public class Matching extends Game {
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name = "gaameId",nullable=false)
//	int gameId;
	@Column(name = "column1",nullable=false)
	ArrayList<String> column1;
	
	@Column(name = "column2",nullable=false)
	ArrayList<String> column2;
	
	@Column(name = "modelanswer",nullable=false)
	ArrayList<String> modelanswer;
	/*@Id
	@Column(name = "gaameId",nullable=false)
	private String gameId;*/

	public Matching(){
		
	}
	public Matching(ArrayList<String> column1, ArrayList<String> column2, ArrayList<String> modelanswer) {
		super();
		//this.gameId = gameId;
		this.column1 = column1;
		this.column2 = column2;
		this.modelanswer = modelanswer;
	}

	/*public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}*/

	public ArrayList<String> getColumn1() {
		return column1;
	}

	public void setColumn1(ArrayList<String> column1) {
		this.column1 = column1;
	}

	public ArrayList<String> getColumn2() {
		return column2;
	}

	public void setColumn2(ArrayList<String> column2) {
		this.column2 = column2;
	}

	public ArrayList<String> getModelanswer() {
		return modelanswer;
	}

	public void setModelanswer(ArrayList<String> modelanswer) {
		this.modelanswer = modelanswer;
	}
	
	
	

}
