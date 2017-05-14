package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SignupASTeacher {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8090/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSignupASTeacher() throws Exception {
    driver.get(baseUrl + "/Angularjs/templates/home.html");
    driver.findElement(By.cssSelector("input.animated")).click();
    driver.findElement(By.cssSelector("input.animated")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("lolo");
    driver.findElement(By.id("pw")).clear();
    driver.findElement(By.id("pw")).sendKeys("ll");
    driver.findElement(By.name("country")).clear();
    driver.findElement(By.name("country")).sendKeys("cairo");
    driver.findElement(By.name("college")).clear();
    driver.findElement(By.name("college")).sendKeys("home");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("lolo@");
    driver.findElement(By.name("age")).clear();
    driver.findElement(By.name("age")).sendKeys("22");
    driver.findElement(By.cssSelector("input.animated")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
