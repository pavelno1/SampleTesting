package base;

import com.sun.org.apache.xpath.internal.operations.Equals;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Paweł on 24.10.2022.
 */
public class BaseTest {

    public static WebDriver driver;
    public static Properties prop = new Properties();
    public static FileReader fr;

    @BeforeTest
    public void setUp() throws IOException {

        if(driver==null){
            FileReader fr = new FileReader("**/src/test/resources/configfiles/config.properties");
            prop.load(fr);
        }

        if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(prop.getProperty("initialUrl"));
        }
        else if(prop.getProperty("browser").equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(prop.getProperty("initialUrl"));
        }

    }

    @AfterTest
    public void  closeDown(){

        driver.close();
        System.out.println("Test Finished");

    }
}
