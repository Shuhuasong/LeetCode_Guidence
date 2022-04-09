package String.Medium;

/**
 * Created by Shuhua Song
 */
public class _8_StringToInteger_atoi {

    //Time = O(n)
    public int myAtoi(String s) {
        s = s.trim();
        int n = s.length();
        if(n==0) return 0;
        int sign = 1, i = 0;
        int val = 0, base = 1;
        char ch = s.charAt(0);
        if(Character.isDigit(ch)) sign = 1;
        else if(ch == '-'){
            sign = -1;
            i++;
        }else if(ch == '+'){
            sign = 1;
            i++;
        }
        for(int j=i; j<n; j++){
            char c = s.charAt(j);
            if(!Character.isDigit(c)){
                break;
            }
            else if(Character.isDigit(c)){
                int digit = c - '0';
                if(val > Integer.MAX_VALUE/10 || val == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE%10){
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                val = val * 10 + digit;
            }
        }
        return val*sign;
    }

    /*
     public int myAtoi(String s) {
        s = s.trim();
        if(s==null || s.length()==0) return 0; //case0 = " "
        int sign = 1, idx = 0;
        if(s.charAt(0)=='-'){ //case1 = " -42"
            sign = -1;
            idx++;
        }else if(s.charAt(0)=='+'){ // case2 = "+1"
            sign = 1;
            idx++;
        }
        System.out.println(s);
        long res = 0;
        while(idx < s.length()){
            char c = s.charAt(idx);
            if(!Character.isDigit(c)) break;
            res = res * 10 + (c-'0');
            idx++;
            if(res > Integer.MAX_VALUE){
                return sign==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return sign * (int)res;
    }
     */
}



/*
Note:
1) only when the num type is long or BigInteger, we can do following compare:  num = num * 10  + digit
          if(num > INT.MAX) then return INT.MAX;
          else if(num < INT.MIN) then return INT.MIN

2) Overflow case, INT.MAX = 2^31 -1 = 2147483647
   <1> If num < INT.MAX/10 ==> append any digit, res < INT.MAX==fine
   <2> IF num > INT.MAX/10 ==> append any digit, res > INT.MAX==overflow
   <3> IF num == INT.MAX/10 ==> append digit 0-7, res <= INT.MAX ==fine
3) Underflow case, INT.MIN = -2^31 = -2147483648
   <1> If num > INT.MIN/10 ==> append any digit, res > INT.MIN==fine
   <2> IF num < INT.MIN/10 ==> append any digit, res < INT.MIN==underflow
   <3> IF num == INT.MIN/10 ==> append digit 0-8, res >= INT.MIN

Interview Tip: Asked a question like this in an interview? Be sure to communicate thoroughly
 with your interviewer to make sure you're covering all cases. In this problem, the rules
 are very thorough because there is no interviewer to communicate with. However, in an
  interview, each of these rules is a potential question to ask the interviewer if the
  rule is not already stated.
*/
