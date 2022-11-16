package testcase;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static base.BaseTest.driver;

/**
 * Created by Paweł on 24.10.2022.
 */
public class FirstSampleTest {

    public static void  main(String[] args){

        /**
         * old way:
         System.setProperty("webdriver.chrome.driver", "C:\\Chrome_webdriver\\2022\\chromedriver.exe");
         ChromeDriver driver = new ChromeDriver();
         */

       /** old way 2:
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        System.out.println(driver);
        driver.get("http://coinmarketcap.com");
        */

        /**driver.findElement(By.xpath("//div[1]"));
         */


    }



}
