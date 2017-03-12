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
public class TeacherModelTest {
    @DataProvider (name = "test1" ) 
    public static Object[][] TestLOgStudent (){
        //even - prime 
        // even -> 1 , prime 1
        return new Object [][]{{true,"esraa22", "1234"},{true,"mohamed11", "5688"},{true ,"mohamed12", "5668" },{true,"mohamed13", "5658"},{true,"mohamed14", "5648"},{true ,"mohamed15", "5628"},{false , "lolo","2789"},{false , "mohamed15","2789"},{false , "rahma","5628"}};    }
    
    @Test (dataProvider = "test1")
    public void Verify(boolean x ,String UserName, String Password) {
        Assert.assertEquals(x,UserName,Password);
    }

    @Test
    public void testSomeMethod() {
    }
    
}
