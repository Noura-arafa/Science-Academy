package Testing;

import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MCQTest {
MCQ ques=new MCQ();
@DataProvider(name="test1")
public static Object[][]TestMcq(){
	return new Object[][]{{1,"helloprogramming"}};
}
  @Test(dataProvider="test1")
  public void ChooseGame(int Score,String gamename) {
	  Assert.assertEquals(Score,ques.ChooseGame(gamename));
	  //throw new RuntimeException("Test not implemented");
  }
}
