package Testing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeacherModel extends UserModel {

	public void AddRecord(UserModel inf, String type) {
		try {

			File TeacherModel = new File("TeacherModel.txt");
			FileWriter f = null;
			f = new FileWriter(TeacherModel, true);
			BufferedWriter bw = new BufferedWriter(f);
			bw.write(inf.userName + " " + inf.Password + " " + inf.Name + " " + inf.Gender + " " + inf.Age + " "
					+ inf.email);
			bw.newLine();
			bw.close();
		} catch (IOException ex) {
			Logger.getLogger(TeacherModel.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println("Done");
	}

	@Override
	boolean Verify(String UserName, String Password) {
		boolean found = false;
		try {
			Scanner t;
			String temp;

			t = new Scanner(new File("TeacherModel.txt"));
			while (t.hasNextLine()) {
				temp = t.nextLine();
				String[] data = temp.split(" ");

				if (data[0].equals(UserName) && (data[1]).equals(Password)) {
					found = true;
					System.out.println("Welcome!");
					break;
				}
			}
			if (!found) {
				System.out.println("Sorry, Wrong Username Or Pw");

			}
		} catch (FileNotFoundException ex) {
			Logger.getLogger(TeacherModel.class.getName()).log(Level.SEVERE, null, ex);
		}
		return found;
	}

}
