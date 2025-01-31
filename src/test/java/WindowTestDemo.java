import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowTestDemo {
    public static void main(String[] args) throws InterruptedException {
        newTabbedWindowTest();



    }
    public static void newTabbedWindowTest() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromiumdriver().create();
        driver.manage().window().maximize();
        //   Set<Cookie> cookies = driver.manage().getCookies();
        //   Cookie jsessionid = driver.manage().getCookieNamed("JSESSIONID");
        //   driver.manage().deleteCookie(jsessionid);
        //   driver.manage().getCookieNamed("JSESSIONID");
        driver.manage().deleteAllCookies();
        driver.get("https://demo.automationtesting.in/Windows.html");

        driver.findElement(By.xpath("//a[contains(text(),'Open New Tabbed Windows')]")).click();

        //Store the parent window
        String parentWindow = driver.getWindowHandle();

        driver.findElement(By.xpath("//a/button[contains(text),'click']")).click();
        Thread.sleep(3000);
        System.out.println(driver.getTitle());

        Set<String> chiledWindows = driver.getWindowHandles();

        for (String window : chiledWindows){
            if (window.equals(parentWindow)){
                driver.switchTo().window(window);
                break;
            }
        }

        System.out.println(driver.getTitle());
        driver.switchTo().window(parentWindow);
        //driver.switchTo().defaultContent();
    }
}
