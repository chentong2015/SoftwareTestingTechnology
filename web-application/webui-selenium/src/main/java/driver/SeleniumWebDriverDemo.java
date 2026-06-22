package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class SeleniumWebDriverDemo {

    public static void main(String[] args) throws InterruptedException {
        // For Windows driver path
        // System.setProperty("webdriver.chrome.driver", "folder/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        String openURL = "http://localhost:8080/login.html";
        driver.get(openURL);

        driver.findElement(By.name("username")).sendKeys("chen");
        driver.findElement(By.name("password")).sendKeys("chen");
        driver.findElement(By.id("LoginUser")).click();
        Thread.sleep(5000);

        testCookies(driver);
        Thread.sleep(10000);
        driver.quit();
    }

    // 测试获取WebDriver的Cookies数据，测试数据有效性和用户Session信息
    private static void testCookies(WebDriver webDriver) throws InterruptedException {
        Set<Cookie> allCookies = webDriver.manage().getCookies();
        for(Cookie cookie: allCookies) {
            System.out.println(cookie.getName());
            System.out.println(cookie.isHttpOnly());
            System.out.println(cookie.getExpiry());
            System.out.println(cookie.getValue());
        }
        Thread.sleep(20000);

        System.out.println("Clean all cookies");
        webDriver.manage().deleteAllCookies();
    }
}