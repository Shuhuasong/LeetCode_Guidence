package OnlineCodingChallege.Amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _SplitStringIntoPrimeNumber {

//Given a string made up to integers 0 to 9, count the number of ways to split the string into
// prime numbers in the range of 2 to 1000 inclusive, using up all the characters in the string.
//e.g "31" -> return 1
//e.g. "11373" -> return 6
//e.g. "1147" -> return 1 not 2, cause 1147 > 1000
    static Set<Integer> primeSet = new HashSet<>();
    private static int findNumCutWays(String s){
        List<List<Integer>> results = new ArrayList<>();
        findWays(s, new ArrayList<Integer>(), results);
        return results.size();
    }

    private static void findWays(String s, ArrayList<Integer> list, List<List<Integer>> results){
        if(s.length()==0){
            results.add(new ArrayList<>(list));
            System.out.println(list.toString());
            return;
        }
        for(int i=0; i<s.length(); i++) {
            String sub = s.substring(0, i + 1);
            int num = Integer.parseInt(sub);
            boolean isPrime = checkPrime(num);
            if (isPrime) {
                list.add(num);
                findWays(s.substring(i + 1), list, results);
                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean checkPrime(int num){
        if(primeSet.contains(num)) return true;
        boolean isPrime = isPrime(num);
        if(isPrime) primeSet.add(num);
        return isPrime;
    }

    private static boolean isPrime(int num){
        if(num<=1) return false;
        if(num==2) return true;
        if(num % 2==0) return false;
        for(int i=3; i<=num/2; i=i+2){
            if(num%i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String num  = "11373";
        System.out.println(findNumCutWays(num));
    }
}
