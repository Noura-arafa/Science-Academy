package Testing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

public class Phase3SW {
	static String type = "";

	public static void main(String[] args) {
		UI x = new UI();

		System.out.println("1.Login " + " " + "2.SignUP ");
		Scanner c = new Scanner(System.in);
		String choice = c.next();

		if (choice.equals("1")) {
			String y = x.Login();

			type = y;

			/***************** student login ***********/
			if (type.equals("student")) // student has one choice(play game)
			{
				while (true) {
					System.out.println("1.play game");
					Scanner n = new Scanner(System.in);
					String h = n.next();
					x.PlayGame();
					System.out.println("do you want Logout? " + "1.yes" + " " + "2.no");
					String d = n.next();
					if (d.equals("1")) {
						break;
					} else if (d.equals("2")) {
						continue;
					} else {
						System.out.println("wrong input");
						break;
					}

				}
			}
			/************** teacher login ******************/
			if (type.equals("teacher")) // teacher has 2 choice
			{
				while (true) {
					System.out.println("1.play game " + "2.add game"); // choice
																		// feature
					Scanner n = new Scanner(System.in);
					String h = n.next();
					if (h.equals("1")) {
						x.PlayGame();
						System.out.println("do you want Logout? " + "1.yes" + " " + "2.no");
						String d = n.next();
						if (d.equals("1")) {
							break;
						} else if (d.equals("2")) {
							continue;
						} else {
							System.out.println("wrong input");
							break;
						}

					} else if (h.equals("2")) {
						x.AddGame();
						System.out.println("do you want Logout? " + "1.yes" + " " + "2.no");
						String d = n.next();
						if (d.equals("1")) {
							break;
						} else if (d.equals("2")) {
							continue;
						} else {
							System.out.println("wrong input");
							break;
						}

					}
				}
			}

		} else if (choice.equals("2")) {
			String typ = x.SignUp();
			// System.out.println("type:"+type);
			/********** student sign up ***********/
			if (typ.equals("student")) // student has one choice(play game)
			{
				while (true) {
					System.out.println("1.play game");
					Scanner n = new Scanner(System.in);
					String h = n.next();
					x.PlayGame();
					System.out.println("do you want Logout? " + "1.yes" + " " + "2.no");
					String d = n.next();
					if (d.equals("1")) {
						break;
					} else if (d.equals("2")) {
						continue;
					} else {
						System.out.println("wrong input");
						break;
					}

				}
			}
			/************** teacher sign up ******************/
			if (typ.equals("teacher")) // teacher has 2 choice
			{
				while (true) {
					System.out.println("1.play game " + "2.add game"); // choice
																		// feature
					Scanner n = new Scanner(System.in);
					String h = n.next();
					if (h.equals("1")) {
						x.PlayGame();
						System.out.println("do you want Logout? " + "1.yes" + " " + "2.no");
						String d = n.next();
						if (d.equals("1")) {
							break;
						} else if (d.equals("2")) {
							continue;
						} else {
							System.out.println("wrong input");
							break;
						}

					} else if (h.equals("2")) {
						x.AddGame();
						System.out.println("do you want Logout? " + "1.yes" + " " + "2.no");
						String d = n.next();
						if (d.equals("1")) {
							break;
						} else if (d.equals("2")) {
							continue;
						} else {
							System.out.println("wrong input");
							break;
						}

					}
				}
			}

		} else {
			System.out.println("invalid choice");
		}
		// System.out.println(x.Login(type));

		// x.SignUp(type);

		// x.AddGame();
		// x.PlayGame();

	}

}
