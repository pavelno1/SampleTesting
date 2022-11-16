package testcase;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Paweł on 27.10.2022.
 */
public class CheckMarketCapValue extends BaseTest {

    String marketCapValue;
    Double marketCapValueDouble;
    //Double marketValuesOfTop10;

    public Double convert(String stringNumber){

           /// int length = stringNumber.length();
            int iOfDot = stringNumber.indexOf(".");
            stringNumber = stringNumber.substring(0, iOfDot);

            System.out.println("test " + stringNumber);
            marketCapValueDouble = Double.valueOf(stringNumber);

            return marketCapValueDouble;
    }




    @Test
    public void CheckMarketCap() {

        marketCapValue = (driver.findElement(By.xpath("(//a[@href='/charts/'])[1]")).getText()).replace("$","").replace(" ","").replace(",",".");
        System.out.println("string " + marketCapValue);
        marketCapValueDouble = convert(marketCapValue);
        System.out.println("Value of Market Cap: " + marketCapValueDouble);
        Assert.assertTrue(marketCapValueDouble > 1.0E12, "Total Market Cap below 1T");

    }
}
