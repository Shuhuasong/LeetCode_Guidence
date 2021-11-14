package OnlineCodingChallege.Twilio;

/**
 * Created by Shuhua Song
 */
/*
E164 number:
--May optionaly start with '+'
--Will have up to 15 digits in length (not including the '+'
--Digits can be between 0-9. the first digit can never be 0
Other channel address:
--No whites space allowed
--the provider and identifie will alwasy be seperated b on colon: {provider}:{identifier}
--Valid provider are : whatsapp, wechat, and messenger
  -- input could be lower or upper case, but output should always be uppercase
--Valid identifier
  --identifier are between 1 and 248 character long
  -- whatsapp and messenger identifier must specifically be E.164 numbers
  -- other providers can have identifier that are made up of any English alphanumeric character and the characters
     '+', '-', '@', '.', '_
     --including any other characters would make the identifier invalid
 */

public class _ValidatePhoneNumber {

    public static String validatePhoneNumberFormat(String address) {
        // Write your code here
        if(isE164Num(address)){
            return "SMS";
        }
        String[] splits = address.split(":");
        if(splits.length != 2) return "INVALID_ADDRESS";
        char[] chars = splits[0].toCharArray();
        for(int i=0; i<chars.length; i++){
            chars[i] = Character.toLowerCase(chars[i]);
        }
        splits[0] = new String(splits[0]);
        if((splits.equals("whatsapp") && splits.equals("messenger") && splits.equals("wechat"))){
            return "INVALID_ADDRESS";
        }
        System.out.println(splits[0]);
        System.out.println(splits[1]);
        if(!splits[0].equals("wechat")){
            boolean isE164 = isE164Num(splits[1]);
            System.out.println("isE164 = " + isE164);
            System.out.println(splits[0]);
            System.out.println(splits[1]);
            if(isE164){
                //return splits[0].equals("whatsapp") ? "WHATSAPP" : "MESSENGER";
                if(splits[0].equals("messenger")){
                    return "MESSENGER";
                }else{
                    return "WHATSAPP";
                }
            }
        }else{
            if(splits[1].length() < 1 || splits[1].length() > 248){
                return "INVALID_ADDRESS";
            }
            char[] chs = splits[1].toCharArray();
            for(char c : chs){
                if(c==' ') return "INVALID_ADDRESS";
                if(!Character.isDigit(c) && !Character.isLetter(c) && !(c=='+' || c=='-' || c=='_' || c=='@' || c=='.')){
                    return "INVALID_ADDRESS";
                }
            }
            return "WECHAT";
        }

        return "INVALID_ADDRESS";
    }

    public static boolean isE164Num(String address){
        if(address.charAt(0) != '+'){
            address = "+" + address;
        }
        if(address.length()-1 > 15) return false;
        for(int i=1; i<address.length(); i++){
            if(i==1 && address.charAt(i)=='0') return false;
            if(!Character.isDigit(address.charAt(i))) return false;
        }
        return true;
    }

    private static boolean isE164Number(String address) {
        if(address.charAt(0) != '+'){
            address = "+" + address;
        }
        if(address.length()-1 > 15) return false;
        for(int i=1; i<address.length(); i++){
            if(i==1 && address.charAt(i)=='0') return false;
            if(!Character.isDigit(address.charAt(i))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String phone = "+15555555555";
        System.out.println(validatePhoneNumberFormat(phone));
        String p1 = "wechat:songsaf098";
        System.out.println(validatePhoneNumberFormat(p1));
    }

}
