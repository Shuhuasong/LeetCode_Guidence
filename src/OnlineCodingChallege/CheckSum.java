package OnlineCodingChallege;

/**
 * Created by Shuhua Song
 */
/*
Write a program that the computes an interger's checksum. To compute
the checksum, break the integer into its constituent digits and,
working from right to left, doubling every second digit. if the product results
in a number with two digits. treat those two digits independently. Then,
sum all the digits for the final checksum. For example,
1496 ---> break into constituents and doubling the ever second digits
 1  4  9  6 ======> 2  4  18  6
  2 + 4 + (1+8) + 6 = 21

case 2:
   nums = 5678
   result = 20
 */
public class CheckSum {

    public static int checkSum(int num){
        String s = Integer.toString(num);
        char[] chs = s.toCharArray();
        int[] nums = new int[chs.length];
        int n = chs.length;
        for(int i=n-1; i>=0; i--){
            if((n-i)%2==0){
                nums[i] = 2 * (int)(chs[i]-'0');
            }else{
                nums[i] = (int)(chs[i]-'0');
            }
        }
        int res = 0;
        for(int a : nums){
            System.out.println(a);
            while(a > 0){
                res += a%10;
                a /= 10;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 5678;
        System.out.println(checkSum(num));
    }
}
