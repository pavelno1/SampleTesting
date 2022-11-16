package utilities;

import java.util.List;

/**
 * Created by Paweł on 28.10.2022.
 */
public class SumLoop {
    Double sum=0.0;
    public Double Sum(List<Double> sub, int listSize) {
        System.out.println("list size: " + listSize);
        for (int i=0; i <= listSize-1; i++){
            sum=sum + sub.get(i);

        }
    return sum;
    }
}
