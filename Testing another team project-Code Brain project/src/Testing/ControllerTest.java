package Testing;

import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class ControllerTest {
	Controller control=new Controller();
	@DataProvider(name="test1")
	 public static Object[][]Testgames(){
		  return new Object[][]{{true,"hellomath",1,"MCQ"},{true,"helloprogramming",1,"T/F"},{false,"Newgame",2,"XX"}};}
@Test(dataProvider="test1")
  public void setGame(boolean x,String gamename,int nofqes,String cate) {
   Assert.assertEquals(x,control.setGame(gamename, nofqes, cate));
  //  throw new RuntimeException("Test not implemented");
  }
}
