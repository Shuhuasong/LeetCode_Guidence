package Greedy.Medium;

/**
 * Created by Shuhua Song
 */
public class _2116_CheckIfParentheseStringCanBeValid {

    public boolean canBeValid(String s, String locked) {
        int n = s.length(), bal = 0, change = 0;
        if(n%2==1) return false;
        //from left to right
        for(int i=0; i<n; i++){
            if(locked.charAt(i)=='0'){
                change++;
            }else{
                if(s.charAt(i)=='(') bal++;
                else{
                    bal--;
                }
            }
            if(bal + change < 0){
                return false;
            }
        }

        //from right to left
        bal = 0;
        change = 0;
        for(int i=n-1; i>=0; i--){
            if(locked.charAt(i)=='0'){
                change++;
            }else{
                if(s.charAt(i)==')') bal++;
                else{
                    bal--;
                }
            }
            if(bal+change<0){
                return false;
            }
        }
        return true;
    }
}

/*
Only locked = '1' counts, locked = '0' can be anything
from left to right, we can check if ')' is too many but we can't tell that '(' is too many
vice versa, from right to left, we can check if '(' is too many but we can't tell that ')' is too many
The above two checks can validate
Suppose there is an invalid string can pass the check
if it does have excessive '(' from left to right at some point, then it can be found from right to left

A useful trick (when doing any parentheses validation) is to greedily check balance left-to-right, and then right-to-left.
Left-to-right check ensures that we do not have orphan ')' parentheses.
Right-to-left checks for orphan '(' parentheses.

*/
