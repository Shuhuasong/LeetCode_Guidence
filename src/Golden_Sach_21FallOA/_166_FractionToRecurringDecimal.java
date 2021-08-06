package Golden_Sach_21FallOA;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _166_FractionToRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";
        StringBuilder sb = new StringBuilder();
        if(numerator>0 && denominator<0 || numerator<0 && denominator>0) sb.append("-");
        long x = Math.abs(Long.valueOf(numerator));
        long y = Math.abs(Long.valueOf(denominator));
        sb.append(String.valueOf(x/y));
        long reminder = x%y;
        if(reminder==0) return sb.toString();
        sb.append(".");
        Map<Long,Integer> map = new HashMap<>();
        while(reminder != 0){
            if(map.containsKey(reminder)){
                sb.insert(map.get(reminder), "(");
                sb.append(")");
                break;
            }
            map.put(reminder, sb.length());
            reminder *= 10;
            sb.append(String.valueOf(reminder/y));
            reminder %= y;
        }
        return sb.toString();
    }
}
