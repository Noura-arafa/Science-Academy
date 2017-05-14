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
public class Complete extends Game {
	@Column(name = "question",nullable=false)
	ArrayList<String> question;
	@Column(name = "modelanswer",nullable=false)
	ArrayList<String> modelanswer;
	/*@Id
	@Column(name = "gaameId",nullable=false)
	private String gameId;*/

	public Complete() {
		
	}
	public Complete(ArrayList<String> question, ArrayList<String> modelanswer) {
		super();
		this.question = question;
		this.modelanswer = modelanswer;
	}
	public ArrayList<String> getQuestion() {
		return question;
	}
	public void setQuestion(ArrayList<String> question) {
		this.question = question;
	}
	public ArrayList<String> getModelanswer() {
		return modelanswer;
	}
	public void setModelanswer(ArrayList<String> modelanswer) {
		this.modelanswer = modelanswer;
	}

	

}
