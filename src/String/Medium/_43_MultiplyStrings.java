package String.Medium;

/**
 * Created by Shuhua Song
 */
public class _43_MultiplyStrings {
    public String multiply(String num1, String num2) {
        if(num1==null || num2==null) return "0";
        int n1 = num1.length(), n2 = num2.length();
        int[] digits = new int[n1+n2];
        for(int i=n1-1; i>=0; i--){
            for(int j=n2-1; j>=0; j--){
                int prod = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                int p1 = i+j, p2 = i+j+1;
                int sum = prod + digits[p2];
                digits[p2] = sum%10;
                digits[p1] += sum/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int d : digits){
            if(!(d==0 && sb.length()==0)){
                sb.append(d);
            }
        }
        return sb.length()==0 ? "0" : sb.toString();
    }
}

/*
Solution:
idx 0 1 2

    1 2 3
      4 5
------------
      1 5
    1 0
  0 5
    1 2
  0 8          indices[1, 2] = indices[i+j, i+j+1]
0 4                          = indices[p1, p2]
---------------
0 5 5 3 5  final value
0 1 2 3 4  index

*/
