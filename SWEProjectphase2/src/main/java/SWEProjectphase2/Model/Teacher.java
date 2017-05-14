package SWEProjectphase2.Model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Teacher {
	@Id
	@Column(name = "email",nullable=false)
	private String email;
	@Column(columnDefinition = "serial")	
	private int id;
	@Column(name = "name",nullable=false)
	private String name;
	@Column(name = "password",nullable=false)
	private String password;
	@Column(name = "country",nullable=false)
	private String country;
	@Column(name = "college",nullable=false)
	private String college;
	@Column(name = "type",nullable=false)
	private String type;
	@Column(name = "age",nullable=false)
	private int age;
	@Column(name = "score",nullable=false)
	private int score=0;
	@Column(name = "playedgame",nullable=false)
	private ArrayList<String> playedgame;
	@Column(name = "UnReadedNotification",nullable=true)
	private ArrayList<String> unreaded = new ArrayList<String>();
	@Column(name = "ReadedNotification",nullable=true)
	private ArrayList<String> readed = new ArrayList<String>();
	@Column(name = "CanceledGames",nullable=true)
	private ArrayList<String> canceledgames=new ArrayList<String>();
	public Teacher(){
		
	}
	
	public Teacher(String email, int id, String name, String password, String country, String college, String type,
			int age, int score, ArrayList<String> playedgame, ArrayList<String> unreaded, ArrayList<String> readed,
			ArrayList<String> canceledgames) {
		super();
		this.email = email;
		this.id = id;
		this.name = name;
		this.password = password;
		this.country = country;
		this.college = college;
		this.type = type;
		this.age = age;
		this.score = score;
		this.playedgame = playedgame;
		this.unreaded = unreaded;
		this.readed = readed;
		this.canceledgames = canceledgames;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public ArrayList<String> getPlayedgame() {
		return playedgame;
	}
	public void setPlayedgame(ArrayList<String> playedgame) {
		this.playedgame = playedgame;
	}
	public ArrayList<String> getUnreaded() {
		return unreaded;
	}
	public void setUnreaded(ArrayList<String> unreaded) {
		this.unreaded = unreaded;
	}
	public ArrayList<String> getReaded() {
		return readed;
	}
	public void setReaded(ArrayList<String> readed) {
		this.readed = readed;
	}
	public ArrayList<String> getCanceledgames() {
		return canceledgames;
	}
	public void setCanceledgames(ArrayList<String> canceledgames) {
		this.canceledgames = canceledgames;
	}

	
	
	
	
	
}
