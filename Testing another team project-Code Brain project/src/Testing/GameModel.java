package Testing;


import java.util.Vector;

public abstract class GameModel {

	int score;

	public void ShowCateModel(String Categ) {

	}

	public void modifyGame(String gamename) {

	}

	public void DeleteGame(String gamename) {
	}

	public void AddComment(String gamename) {
	}

	public void RateGame(String gamename) {
	}

	public void ReplayONComment() {
	}

	abstract boolean AddQuestion(String GameName, String question);

	abstract void WriteModelAns(Vector<String> ModelAns, String GameName);

	abstract void AddGameToList(String GameName);

	abstract int ChooseGame(String GameN);
}
