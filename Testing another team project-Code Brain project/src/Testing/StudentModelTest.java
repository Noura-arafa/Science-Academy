package Testing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author norhan
 */
public class StudentModelTest {
    @DataProvider (name = "test1" ) 
    public static Object[][] TestLOgStudent (){
        //even - prime 
        // even -> 1 , prime 1
        return new Object [][]{{true,"alaa46", "2789"},{true,"alaa45","2789"},{true ,"nourhan","123" },{true,"ahmed","145"},{false,"karim","112"},{false ,"nourhan","222"},{false , "lolo","2789"}};    }
    
    @Test (dataProvider = "test1")
    public void Verify(boolean x ,String UserName, String Password) {
        Assert.assertEquals(x,UserName,Password);
    }
   
    @Test
    public void testSomeMethod() {
    }
    
}
