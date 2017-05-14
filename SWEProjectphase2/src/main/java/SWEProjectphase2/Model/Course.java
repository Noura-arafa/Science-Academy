package SWEProjectphase2.Model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Course {
	@Id
    @Column(name = "CourseName",nullable=false)
	private String CourseName;
	@ManyToOne
    @JoinColumn(name="teacher_ID", nullable=false)
	private Teacher teacher;
	@Column(name = "Counter")
	private int  Counter =0;
	@Column(name = "Players",nullable=true)
	private ArrayList<String> players = new ArrayList<String>();
	
	  public Course() {
			
		}

	public Course(String courseName, Teacher teacher, int counter, ArrayList<String> players) {
		super();
		CourseName = courseName;
		this.teacher = teacher;
		Counter = counter;
		this.players = players;
	}


	public String getCourseName() {
		return CourseName;
	}


	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}


	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


	public int getCounter() {
		return Counter;
	}


	public void setCounter(int counter) {
		Counter = counter;
	}


	public ArrayList<String> getPlayers() {
		return players;
	}


	public void setPlayers(ArrayList<String> players) {
		this.players = players;
	}

}