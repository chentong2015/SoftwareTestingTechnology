package driver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

// TODO. 独立测试UI的每个功能
public class UnitTestCase {

  private WebDriver driver;
  private boolean acceptNextAlert = true;

  // @BeforeEach
  public void setUp() {
    driver = new ChromeDriver();
  }

  // @Test
  public void testCase1() throws InterruptedException {
    driver.get("http://www.google.com/");
    Thread.sleep(5000);
    WebElement searchBox = driver.findElement(By.name("q"));
    searchBox.sendKeys("ChromeDriver");
    searchBox.submit();
    Thread.sleep(5000);
  }

  // @Test
  public void testCase2() {
    driver.get("https://www.katalon.com/");
    driver.findElement(By.id("kw")).click();
    driver.findElement(By.id("kw")).clear();
    driver.findElement(By.id("kw")).sendKeys("selenium");
    driver.findElement(By.id("kw")).sendKeys(Keys.DOWN);
    driver.findElement(By.id("kw")).sendKeys(Keys.ENTER);
    driver.findElement(By.linkText("Selenium - Web Browser Automation")).click();
  }

  // @AfterEach
  public void tearDown() {
    driver.quit();
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
