package SWEProjectphase2.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	@Column(name = "TeacherName",nullable=true)
	String teacherName;
	@Column(name = "StudentName",nullable=true)
	String studentName;
	@Column(name = "comment",nullable=false)
	String comment;
	@Id
	@Column(name = "Id",nullable=false)
	int Id;
	@ManyToOne
    @JoinColumn(name="game", nullable=false)
	Game game;
	

	public Comment() {
		super();
	}


	public Comment(String teacherName, String studentName, String comment, int id, Game game) {
		super();
		this.teacherName = teacherName;
		this.studentName = studentName;
		this.comment = comment;
		Id = id;
		this.game = game;
	}


	public String getTeacherName() {
		return teacherName;
	}


	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public Game getGame() {
		return game;
	}


	public void setGame(Game game) {
		this.game = game;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
