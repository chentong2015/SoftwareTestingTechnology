package driver;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class SeleniumWebDriver {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        String openURL = "https://www.selenium.dev/";
        driver.get(openURL);
        Thread.sleep(5000);
        driver.quit();
    }

    // 从WebDriver.Options中获取浏览器Cookies
    // 可用于测试Cookie数据有效性和用户Session信息
    private static void handleCookies(WebDriver webDriver) {
        Set<Cookie> allCookies = webDriver.manage().getCookies();
        for(Cookie cookie: allCookies) {
            System.out.println(cookie.getName());
            System.out.println(cookie.isHttpOnly());
            System.out.println(cookie.getExpiry());
            System.out.println(cookie.getValue());
        }
        webDriver.manage().deleteAllCookies();
    }
}