package Testing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.util.Vector;

public class UI {

    Controller user = new Controller();


     String SignUp() {
        UserModel u = new UserModel() {
            @Override
            boolean Verify(String UserName, String Password) {
                throw new UnsupportedOperationException("Not supported yet."); 
            }

			@Override
			void AddRecord(UserModel inf, String type) {
				// TODO Auto-generated method stub
				
			}
        };
        System.out.println("enter name");
        Scanner name = new Scanner(System.in);
        u.Name = name.next();
        System.out.println("enter gender");
        Scanner gender = new Scanner(System.in);
        u.Gender = gender.next();
        System.out.println("enter age");
        Scanner age = new Scanner(System.in);
        u.Age = age.nextInt();
        System.out.println("enter email");
        Scanner email = new Scanner(System.in);
        u.email = email.next();
        System.out.println("enter user name");
        Scanner username = new Scanner(System.in);
        u.userName = username.next();
        System.out.println("enter password");
        Scanner password = new Scanner(System.in);
        u.Password = password.next();
        System.out.println("enter type");
        Scanner type = new Scanner(System.in);
         String typ=type.nextLine();

        user.AddUser(u, typ);
        return typ;
     
    }
String Login(){
    

System.out.println("enter name");
        Scanner username = new Scanner(System.in);
        String name=username.next();
        System.out.println("enter password");
        Scanner password = new Scanner(System.in);
       String password1=password.next();
       
         return user.Check(name,password1);
         

}
//hana ya menna 
boolean AddGame(){
    System.out.println("enter GameName");
    Scanner GName = new Scanner(System.in);
    String GGName=GName.nextLine();
    System.out.println("enter No. Of Questions");
    Scanner NoOfQ = new Scanner(System.in);
    String category=GName.next();
    return user.setGame(GGName,NoOfQ.nextInt(),category);

}

void PlayGame(){
    System.out.println("Choose Game Category");
    System.out.println("MCQ or T/F");
    Scanner s=new Scanner(System.in);
    String Category=s.nextLine();
    user.SelectCategory(Category);
    
}

}
