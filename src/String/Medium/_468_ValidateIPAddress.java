package String.Medium;

/**
 * Created by Shuhua Song
 */
public class _468_ValidateIPAddress {

    public String validIPAddress(String IP) {
        if(IP==null || IP.length()==0) return "Neither";
        String[] strs = IP.split("[:|.]");

        for(String str : strs){
            System.out.println(str);
        }
        if(strs.length==4){
            if(!Character.isDigit(IP.charAt(0)) || !Character.isDigit(IP.charAt(IP.length()-1))){
                return  "Neither";
            }
            return validIPv4(strs);
        }else if(strs.length==8){
            if(!Character.isLetterOrDigit(IP.charAt(0)) || !Character.isLetterOrDigit(IP.charAt(IP.length()-1))){
                return  "Neither";
            }
            return validIPv6(strs);
        }
        return  "Neither";
    }

    private String validIPv4(String[] strs){
        for(String str : strs){
            //System.out.println(str);
            if(str.length()==0 || str.length()>1 && str.charAt(0)=='0' || str.length()>3) return "Neither";
            for(char c : str.toCharArray()){
                if(!Character.isDigit(c))  return "Neither";
            }
            if(Integer.parseInt(str) > 255){
                return "Neither";
            }
        }
        return "IPv4";
    }

    private String validIPv6(String[] strs){
        for(String str : strs){
            if(str.length()==0 || str.length()>4) return  "Neither";
            for(char c : str.toCharArray()){
                if(!Character.isDigit(c) && !Character.isLetter(c)) return "Neither";
                c = Character.toLowerCase(c);
                if(c>'f') return "Neither";
            }
        }
        return "IPv6";
    }
}

/*
1) check queryIP's len whether is too small or too long, len<7 || len>39
3) split the queryIP by using several delimiter
4) seperate the valid for IPv4 and IPv6 when it is len==4 or len==8
5) iterate each segment for IPv4:
   0> check first char and last whether are both digit
   1> check no leading zero, and 1<=len<=3
   2> check each char is digit
   3> check value with [0, 255]
6) iterate each segment for IPv6
   0> check first char and last whether are both digit or letter
   1> check length for segment with [1, 4]
   2> check each char is either digit or char with [a, f] or [A, F]



"172.16.254.1"
"2001:0db8:85a3:0:0:8A2E:0370:7334"
"256.256.256.256"
"2001:0db8:85a3:0:0:8A2E:0370:7334:"
"12..33.4"
"192.0.0.1"
*/
