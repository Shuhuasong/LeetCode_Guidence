package HashTable;

import java.util.HashSet;
import java.util.Set;

public class _202_HappyNumber {

     /*
    idea: during calculate the sum of each digit, some number will repeat the process, like
    116->38->73->58->89->145->42->20->4->16->37->58, so we need to check if there is a loop

    1.Given a number nn, what is its next number?
    2.Follow a chain of numbers and detect if we've entered a cycle.

    Based on our exploration so far, we'd expect continually following links to end in one of three ways.

    1) It eventually gets to 11.
    2) It eventually gets stuck in a cycle.
    3) It keeps going higher and higher, up towards infinity. (it is impossible, because when number is large, eg. 9999 => 324,
       it's sum will become lower
    */

    public boolean isHappy(int n) {
        // if(n==1) return true;
        Set<Integer> seen = new HashSet<>();
        while(n > 1 && !seen.contains(n)){
            seen.add(n);
            n = getNext(n);
            // System.out.println(n);
        }
        return n==1;
    }

    private int getNext(int n){
        int sum = 0;
        while(n > 0){
            int rem = n % 10;
            sum += rem * rem;
            n /= 10;
        }
        return sum;
    }
}
