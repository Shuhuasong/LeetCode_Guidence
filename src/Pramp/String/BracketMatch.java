package Pramp.String;
import java.io.*;
import java.util.*;

public class BracketMatch {

     /*
     Bracket Match
A string of brackets is considered correctly matched if every opening bracket in the string can be paired up with a later closing bracket, and vice versa. For instance, “(())()” is correctly matched, whereas “)(“ and “((” aren’t. For instance, “((” could become correctly matched by adding two closing brackets at the end, so you’d return 2.

Given a string that consists of brackets, write a function bracketMatch that takes a bracket string as an input and returns the minimum number of brackets you’d need to add to the input in order to make it correctly matched.

Explain the correctness of your code, and analyze its time and space complexities.

Examples:

input:  text = “(()”
output: 1

input:  text = “(())”
output: 0

input:  text = “())(”
output: 2
Constraints:

[time limit] 5000ms

[input] string text

1 ≤ text.length ≤ 5000
[output] integer

  ) ( ) ) ) )
             |

  STACK:
  ) ) ) )

  ) () ) ( ( (
        *
  difCount = 2  if(diffCount < 0) result++;
  result = 2

  return diffCount + result

  */

    static int bracketMatch(String s) {
        // your code goes here
        if(s==null || s.length()==0) return 0;
        int difCount = 0, result = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                difCount += 1;
            }else{
                difCount -= 1;
                if(difCount < 0){
                    result += 1;
                    difCount += 1;
                }
            }
        }
        return result+difCount;
    }

    public static void main(String[] args) {

    }
}
