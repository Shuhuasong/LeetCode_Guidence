package OnlineCodingChallege.Citadel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _PrimeFactorVisitation {

    private static int[] lightBulbs(int[] states, int[] nums){
        int n = states.length;
        for(int num : nums){
            Set<Integer> primes = getPrimes(num);
            for(int p : primes){
                for(int i=p-1; i<n; i += p){
                    //System.out.println(i + " ");
                    states[i] = (states[i]==0 ? 1 : 0);
                }
                for(int s : states){
                    System.out.print(s + " ");
                }
                System.out.println();
            }
        }
        //for(int s : states){
           // System.out.print(s + " ");
        //}
        return states;
    }

    // A function to print all prime factors
    // of a given number n
    private static Set<Integer> getPrimes(int num){
        Set<Integer> set = new HashSet<>();
        // get the number of 2s that divide n
        while(num % 2 == 0){
            set.add(2);
            num /= 2;
        }
        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for(int i=3; i*i < num; i += 2){
            // While i divides n, print i and divide n
            while(num%i == 0){
                set.add(i);
                num /= i;
            }
        }
        // This condition is to handle the case whien
        // n is a prime number greater than 2
        if(num > 2){
            set.add(num);
        }
        return set;
    }

    public static void main(String[] args) {
        int[] states = {1, 1, 0, 0, 1, 1, 0, 1, 1, 1};
        int[] nums = {3, 4, 15};
        int[] result = lightBulbs(states, nums);
    }
}
