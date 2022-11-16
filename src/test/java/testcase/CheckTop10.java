package testcase;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paweł on 25.10.2022.
 */

public class CheckTop10 extends BaseTest{

        List<String> listOfTop10 = new ArrayList<>();

        @Test
        public void ListTop10(){
            for (int rank=1;rank<=10;rank++) {
                listOfTop10.add(driver.findElement(By.xpath("(//div[@display='flex']//a[@class='cmc-link']//div//div//p[@font-weight='semibold'])[" + rank + "]")).getText());
            }
            System.out.println(listOfTop10);
            Assert.assertTrue(listOfTop10.contains("Bitcoin"), "There is no Bitcoin in the TOP10");

    }

}
