package OnlineCodingChallege.Cisco;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _MeanAndMode {

    private static void MeanMode(double[] nums){
        double mean = 0, sum = 0;
        Map<Double, Integer> freq = new HashMap<>();
        int maxFreq  = 0;
        double mode = Double.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            freq.put(nums[i], freq.getOrDefault(nums[i], 0)+1);
            maxFreq = Math.max(maxFreq, freq.get(nums[i]));
        }
        for(double key : freq.keySet()){
            if(freq.get(key)==maxFreq && mode > key){
                mode  = key;
            }
        }
        mean = sum/nums.length;
        System.out.printf("%.2f",mean);
        System.out.println();
        System.out.println(mode);
    }

    public static void main(String[] args) {
         double[] nums = {1, 2, 3, 4.5, 6.7, 8.6, 3.4, 3, 2};
         MeanMode(nums);
    }
}


/*
Data Format output in Java
// A Java program to demonstrate working of printf() in Java
class JavaFormatter1
{
  public static void main(String args[])
  {
    int x = 100;
    System.out.printf("Printing simple integer: x = %d\n", x);

    // this will print it upto 2 decimal places
    System.out.printf("Formatted with precision: PI = %.2f\n", Math.PI);

    float n = 5.2f;

    // automatically appends zero to the rightmost part of decimal
    System.out.printf("Formatted to specific width: n = %.4f\n", n);

    n = 2324435.3f;

    // here number is formatted from right margin and occupies a
    // width of 20 characters
    System.out.printf("Formatted to right margin: n = %20.4f\n", n);
  }
}


Output
Printing simple integer: x = 100
Formatted with precision: PI = 3.14
Formatted to specific width: n = 5.2000
Formatted to right margin: n =         2324435.2500

 */
