package Testing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.util.Scanner;
import java.util.Vector;

public class Controller {

	public String GameName;
	public String type;
	public int NoOfQuestions;
	TeacherModel t = new TeacherModel();
	StudentModel s = new StudentModel();

	public String Check(String Username, String password) {

		String found = "";
		System.out.println("Login As: ");
		Scanner type = new Scanner(System.in);
		String typ = type.nextLine();

		if (typ.equals("teacher")) {
			if (t.Verify(Username, password)) {
				found = "teacher";

				return "teacher";

			}

		} else if (typ.equals("student")) {
			if (s.Verify(Username, password)) {
				found = "student";

				return "student";

			}
		} else {
			System.out.println("not allowed!");
		}

		return found;

	}

	public void AddUser(UserModel inf, String type) {
		if (type.equals("teacher")) {
			TeacherModel m = new TeacherModel();
			m.AddRecord(inf, type);
		} else if (type.equals("student")) {
			StudentModel s = new StudentModel();
			s.AddRecord(inf, type);
		} else {
			System.out.println("error input");
		}
	}

	boolean setGame(String GameName, int NoOfQ,String cate) {
		boolean done = false;
		if (cate.equals("MCQ")) {
         	MCQ mcq = new MCQ();
			mcq.AddGameToList(GameName);
			for (int i = 0; i < NoOfQ; i++) {
				System.out.println("enter question: ");
				Scanner q = new Scanner(System.in);
				mcq.AddQuestion(GameName, q.nextLine());
			}
			Vector<String> ModelAns = new Vector<String>();
			System.out.println("enter model answer in the same order of the questions");
			for (int i = 0; i < NoOfQ; i++) {
				System.out.println("enter Answer for Q" + (i + 1) + " ");
				Scanner a = new Scanner(System.in);
				ModelAns.add(a.nextLine());
			}
			mcq.WriteModelAns(ModelAns, GameName);
			System.out.println("Game added Successfully ;)");
			done = true;
		} else if (cate.equals("T/F")) {
			TrueFalse tf = new TrueFalse();
			tf.AddGameToList(GameName);
			for (int i = 0; i < NoOfQ; i++) {
				System.out.println("enter question: ");
				Scanner q = new Scanner(System.in);
				tf.AddQuestion(GameName, q.nextLine());
			}
			Vector<String> ModelAns = new Vector<String>();
			System.out.println("enter model answer in the same order of the questions");
			for (int i = 0; i < NoOfQ; i++) {
				System.out.println("enter Answer for Q" + (i + 1) + " ");
				Scanner a = new Scanner(System.in);
				ModelAns.add(a.nextLine());
			}
			tf.WriteModelAns(ModelAns, GameName);
			System.out.println("Game added Successfully ;)");
			done = true;
		} else {
			System.out.println("invalid game category!");
			done = false;
		}
		return done;

	}

	void SelectCategory(String Category) {
		if (Category.equals("MCQ")) {
			System.out.println("Game Instructions: you should choose only 1 choice");
			MCQ mcq = new MCQ();
			Scanner input=new Scanner(System.in);
			String name=input.next();
			mcq.ChooseGame(name);
		} else if (Category.equals("T/F")) {

			System.out.println("Game Instructions: you should enter true or false not both!");
			TrueFalse tf = new TrueFalse();
			Scanner input=new Scanner(System.in);
			String name=input.next();
			tf.ChooseGame(name);

		}

	}

}

