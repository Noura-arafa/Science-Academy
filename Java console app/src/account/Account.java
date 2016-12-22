package account;

public class Account {
	private String name;
	private String id;
	private String gender;
	private String username;
	private String Password;
	private int age;
	private String email;
	Account(){
		name=""; id="";gender="";username="";Password=""; age=0;
	}
	public void setname(String name){
		this.name=name;
	}
	public void setid(String id){
		this.id=id;
	}
	public void setgender(String gender){
		this.gender=gender;
	}
	public void setusername(String username){
		this.username=username;
	}public void setpassword(String password){
		this.Password=password;
	}
	public void setage(int age){
		this.age=age;
	}
	
	public void setemail(String email){
		this.email=email;
	}
	public String getname(){
		return this.name;
	}
	public String getid(){
		return this.id;
	}
	public String getgender(){
		return this.gender;
	}
	public String getusername(){
		return this.username;
	}
	public int getage(){
		return this.age;
	}
	public String getpassword(){
		return this.Password;
	}
		public String getemail(){
		return this.email;
	}
}
