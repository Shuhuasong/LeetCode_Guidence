package String;

public class _38_CountAndSay {

    public String CountAndSay(int n){
        if(n==1) return "1";
        String s = "1";
        for(int i=2; i<=n; i++){
            s = compress(s);
        }
        return s;
    }

    private String compress(String s){
       if(s==null || s.length()==0){
           return "";
       }
       char ch = s.charAt(0);
       int count = 1;
       StringBuilder sb = new StringBuilder();
       for(int i=1; i<s.length(); i++){
           if(s.charAt(i) != ch){
               sb.append(count).append(ch);
               count = 1;
               ch = s.charAt(i);
           }else{
               count++;
           }
       }
       sb.append(count).append(ch);
       return sb.toString();
    }
}
