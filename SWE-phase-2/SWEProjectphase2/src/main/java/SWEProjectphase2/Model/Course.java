package SWEProjectphase2.Model;

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
	  public Course() {
			
		}
	public Course(String courseName, Teacher teacher,int Counter) {
		super();
		this.CourseName = courseName;
		this.Counter = Counter;
		this.teacher = teacher;
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

	
}