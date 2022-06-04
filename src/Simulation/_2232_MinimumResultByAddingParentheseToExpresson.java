package Simulation;

/**
 * Created by Shuhua Song
 */
public class _2232_MinimumResultByAddingParentheseToExpresson {

    public String minimizeResult(String exp) {
        int idx = exp.indexOf("+");
        int minVal = Integer.MAX_VALUE, start = 0, end = 0;
        int n = exp.length();
        for(int l=0; l<idx; l++){
            int val1 = (l==0) ? 1 : Integer.parseInt(exp.substring(0, l));
            int val2 = Integer.parseInt(exp.substring(l, idx));
            for(int r=idx+2; r<=n; r++){
                int val3 = Integer.parseInt(exp.substring(idx+1, r));
                int val4 = (r==n) ? 1 : Integer.parseInt(exp.substring(r));
                int curr = val1 * (val2+val3) * val4;
                if(curr < minVal){
                    minVal = curr;
                    start = l;
                    end = r;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(exp.substring(0, start));
        sb.append("(");
        sb.append(exp.substring(start, end));
        sb.append(")");
        sb.append(exp.substring(end));

        return sb.toString();
    }

/*
Solution: Two Pointer
one before "+", the other after "+"
e.g
  2 4 7 3 + 3 8 32
    |         |
    p1        p2
[0, idx-2] [idx+2, n-1]

*/


    /*
    public String minimizeResult(String exp) {
        String[] numS = exp.split("\\+");
        String num1 = numS[0], num2 = numS[1];

        int minRes = Integer.MAX_VALUE, start = -1, end = 0;
        System.out.println(num1  + " " + num2);
        for(int i=0; i<num1.length(); i++){
            int num1V1 = -1, num1V2 = -1, num2V1 = -1, num2V2 = -1;

                if(i==0){
                    num1V1 = 1;
                    num1V2 = Integer.parseInt(num1.substring(i));
                }else{
                    num1V1 = Integer.parseInt(num1.substring(0,i));
                    num1V2 = Integer.parseInt(num1.substring(i));
                }


            for(int j=1; j<=num2.length(); j++){
                if(j==num2.length()){
                    num2V2 = 1;
                    num2V1 = Integer.parseInt(num2.substring(0,j));
                }else{
                    num2V1 = Integer.parseInt(num2.substring(0, j));
                    num2V2 = Integer.parseInt(num2.substring(j));
                }

                int curr = num1V1 * (num1V2 + num2V1) * num2V2;
                if(curr < minRes){
                    minRes = curr;
                    start = i;
                    end = j;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(num1.substring(0, start));
        sb.append("(");
        sb.append(num1.substring(start));
        sb.append("+");
        sb.append(num2.substring(0,end));
        sb.append(")");
        sb.append(num2.substring(end));
        return sb.toString();
    }


     */

}
