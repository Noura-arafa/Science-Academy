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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author esraa
 */
public class TrueFalse extends GameModel {

	@Override
	public void modifyGame(String gamename) {
		super.modifyGame(gamename);
	}

boolean  AddQuestion(String GameName, String question) {
		try {
			File game = new File("TF" + GameName + ".txt");
			FileWriter f = null;
			f = new FileWriter(game, true);
			BufferedWriter bw = new BufferedWriter(f);
			bw.write(question);
			bw.newLine();
			bw.close();
			return true;
		} catch (IOException ex) {
			
			Logger.getLogger(StudentModel.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
		//System.out.println("question added");

	}

	void WriteModelAns(Vector<String> ModelAns, String GameName) {
		try {
			File game = new File("TF" + GameName + "ModelAns.txt");
			FileWriter f = null;
			f = new FileWriter(game, true);
			BufferedWriter bw = new BufferedWriter(f);

			for (int i = 0; i < ModelAns.size(); i++) {
				bw.write(ModelAns.elementAt(i));
				bw.newLine();
			}
			bw.close();
		} catch (IOException ex) {
			Logger.getLogger(MCQ.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	void AddGameToList(String GameName) {
		try {
			File GameList = new File("TFGameList.txt");
			FileWriter f = null;
			f = new FileWriter(GameList, true);
			BufferedWriter bw = new BufferedWriter(f);
			bw.write(GameName);
			bw.newLine();
			bw.close();
		} catch (IOException ex) {
			Logger.getLogger(MCQ.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	Vector<String> ReadGames() {
		Vector<String> GameList = new Vector<String>();
		try {
			Scanner t;
			String temp;

			t = new Scanner(new File("TFGameList.txt"));
			while (t.hasNextLine()) {
				temp = t.nextLine();
				GameList.add(temp);
			}

		} catch (FileNotFoundException ex) {
			Logger.getLogger(TeacherModel.class.getName()).log(Level.SEVERE, null, ex);
		}
		return GameList;

	}

	int ChooseGame(String GameN) {
		Vector<String> games = new Vector<String>();
		games = ReadGames();
		int score = 0;
		for (int i = 0; i < games.size(); i++) {
			System.out.println(games.elementAt(i));
		}
		
		try {
			Scanner t;
			String temp;

			t = new Scanner(new File("TF" + GameN + ".txt"));
			Scanner tt;
			String ttemp;
			tt = new Scanner(new File("TF" + GameN + "ModelAns.txt"));

			while (t.hasNextLine()) {
				temp = t.nextLine();
				System.out.println(temp);
				System.out.println("enter answer");
				Scanner ans = new Scanner(System.in);
				String answer = ans.nextLine();
				ttemp = tt.nextLine();
				if (ttemp.equals(answer)) {
					System.out.println("correct answer");
					score++;
				} else {
					System.out.println("wrong answer");
					System.out.println("correct answer is: " + ttemp);
				}

			}

		} catch (FileNotFoundException ex) {
			Logger.getLogger(TeacherModel.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println("game ended");
		System.out.println("your score is " + score);
		return score;
	}

	
}
