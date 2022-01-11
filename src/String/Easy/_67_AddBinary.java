package String.Easy;

/**
 * Created by Shuhua Song
 */
public class _67_AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int m = a.length(), n = b.length();
        int pa = m-1, pb = n-1;
        int sum = 0, carry = 0;
        while(pa >= 0 || pb>=0){
            sum = carry;
            if(pa >= 0){
                if(a.charAt(pa)=='1') sum += 1;
                pa--;
            }
            if(pb >= 0){
                if(b.charAt(pb)=='1') sum += 1;
                pb--;
            }
            sb.insert(0, sum%2);
            carry = sum/2;
        }
        if(carry == 1){
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}
