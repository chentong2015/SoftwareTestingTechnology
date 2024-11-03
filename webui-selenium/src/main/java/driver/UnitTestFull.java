package driver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;

public class UnitTestFull {

	public static void main(String[] args) {
		WebDriver webDriver = new ChromeDriver();
		webDriver.get("http://www.baidu.com");
		
		// 添加暂停的时间
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// 使用CSS来做选择器，查找页面的唯一元素
		webDriver.findElement(By.id("kw")).sendKeys("Selenium Driver");
		webDriver.findElement(By.name("wd")).sendKeys("baidu");
		webDriver.findElement(By.className("s_ipt")).sendKeys("baidu");
		
		// 默认取第一个的标签名称
		webDriver.findElement(By.tagName("input")).sendKeys("test");
		
		// 链接的完全匹配和部分匹配
		webDriver.findElement(By.linkText("hao123")).click();
		webDriver.findElement(By.partialLinkText("hao")).click();
		
		// xpath路径选择，使用FirePath直接定位
		webDriver.findElement(By.xpath(".//*[@id='kw']")).sendKeys("test");

		// Table: 层级定位的方式
		String urlString = "D:\\www\\table.html"; // Loacl path
		WebElement table = webDriver.findElement(By.tagName("table"));
		// table.findElement(By.tagName("tr")); 定位单一元素
		List<WebElement> rows = table.findElements(By.tagName("tr")); // 定位一组的元素

        for (WebElement webElement : rows) {
            List<WebElement> tds = webElement.findElements(By.tagName("td"));
            for (WebElement td : tds) {
                System.out.println(td.getText());
            }
        }
	}
}
