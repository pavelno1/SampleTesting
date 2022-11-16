package testcase;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.SumLoop;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Paweł on 28.10.2022.
 */
public class TotalCapOf10 extends BaseTest {

    List<Double> marketValuesOfTop10= new ArrayList<>();
    int maxRank = 10;
    CheckMarketCapValue cap = new CheckMarketCapValue();
   // public SumLoop sum = new SumLoop();
   // public Double s = sum.Sum(CapValuesOfTop10(), CapValuesOfTop10().size());


    public List<Double> CapValuesOfTop10() {

        marketValuesOfTop10.clear();

        for (int rank = 1; rank <= maxRank; rank++) {

            String marketValuesTech;
            marketValuesTech = driver.findElement(By.xpath("(//div[@display='flex']//a[@class='cmc-link']/../..)[" + rank + "]/following-sibling::td[5]//p//span[2]")).getText().replace("$","").replace(",","");
            System.out.println("bla " + marketValuesTech);
            marketValuesOfTop10.add(Double.valueOf(marketValuesTech));
            System.out.println("Rank " + rank + ": " + marketValuesOfTop10.get(rank-1));
        }
        return marketValuesOfTop10;
    }



    @Test
    public void SumOfTop10(){
        marketValuesOfTop10.clear();
        SumLoop sum = new SumLoop();
        Double s = sum.Sum(CapValuesOfTop10(), CapValuesOfTop10().size());
        System.out.println("Total sum of TOP10: " + s);
        Assert.assertTrue(s > 1.0E12, "Top10 Market Cap Not over 1T");
    }

    @Test
    public void SumOfTop10Ratio(){
        String marketCapValue = (driver.findElement(By.xpath("(//a[@href='/charts/'])[1]")).getText()).replace("$","").replace(" ","").replace(",",".");
        System.out.println("string " + marketCapValue);
        Double marketCapValueDouble = cap.convert(marketCapValue);
        SumLoop sum = new SumLoop();
        Double s = sum.Sum(CapValuesOfTop10(), CapValuesOfTop10().size());
        System.out.println("Ratio:" + s/marketCapValueDouble);
        Assert.assertTrue( s/marketCapValueDouble < 0.8, "Top10 Market Cap is bigger than 80% of Total Market Cap");

    }

}