package SWEProjectphase2.Model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy =InheritanceType.TABLE_PER_CLASS)
public class Game {
	@Id
	@Column(name = "gameName",nullable=false)
	private String gameName;
	@Column(columnDefinition = "serial")
    private int id;
	@ManyToOne
    @JoinColumn(name="Teacher_ID", nullable=false)
	private Teacher teacher;
	@ManyToOne
    @JoinColumn(name="Course_ID", nullable=false)
	private Course course;
	@Column(name = "collebrators",nullable=true)
	private ArrayList<String> collebrators = new ArrayList<String>();
	@Column(name = "Canceled",nullable=false)
	private boolean canceled = false;
	
	public Game() {
		
	}
	
	public Game(String gameName, int id, Teacher teacher, Course course, ArrayList<String> collebrators,
			boolean canceled) {
		super();
		this.gameName = gameName;
		this.id = id;
		this.teacher = teacher;
		this.course = course;
		this.collebrators = collebrators;
		this.canceled = canceled;
	}



	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	
	
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<String> getCollebrators() {
		return collebrators;
	}
	public void setCollebrators(ArrayList<String> collebrators) {
		this.collebrators = collebrators;
	}
	public boolean isCanceled() {
		return canceled;
	}
	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}
	
	//@OneToMany(mappedBy = "game")
	// @Column(name= "paren_id")
//	public Set<String> getComments() {
//		return comments;
//	}
//
//	public void setComments(Set<String> comments) {
//		this.comments = comments;
//	}
	
	}