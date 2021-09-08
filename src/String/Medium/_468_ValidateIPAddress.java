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
            if(str.length()==0 || str.length()>3) return "Neither";
            if(str.length()==0 || str.length() > 1 && str.charAt(0)=='0'){
                return "Neither";
            }
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
                if(!Character.isLetterOrDigit(c) || !isValid(c)){
                    return  "Neither";
                }
            }
        }
        return "IPv6";
    }

    private boolean isValid(char c){
        String hexdigits = "0123456789abcdefABCDEF";
        if(hexdigits.indexOf(c)==-1){
            return false;
        }
        return true;
    }
}
