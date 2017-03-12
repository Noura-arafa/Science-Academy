package Testing;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TrueFalseTest {

	TrueFalse ques=new TrueFalse();
	@DataProvider(name="test1")
	public static Object[][]TestMcq(){
		return new Object[][]{{true,"test" , "5+2"}};
	}
	  @Test(dataProvider="test1")
	  public void AddQuestion(boolean add , String GameName, String question)
	  {
		  Assert.assertEquals(add, ques.AddQuestion(GameName,question));
	  }
  
}
