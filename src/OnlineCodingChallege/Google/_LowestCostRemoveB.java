package OnlineCodingChallege.Google;

/**
 * Created by Shuhua Song
 */
public class _LowestCostRemoveB {

    static int cost = 0;
    private static int lowCostRemove(String s){
        if(s==null || s.length()==0) return 0;
        int l = 0, r = 0;
        int start = 0, end = 0;
        int leftDist = 0, rightDist = 0;
        //int  n = s.length();
        s = removeFrontEndB(s);
        if(s.length()==0) return cost;

        //remove middle b
        l = 0; r = s.length()-1;
        start = l; end = r;
        while(l < r && s.length()>0){
            System.out.println("test 1 = " + s + " " + l + " " + r);
            //Skip front a
           while(l < r && s.charAt(l) != 'b'){
               l++;
           }
           // Skip tail a
           while(l < r && s.charAt(r) != 'b'){
               r--;
           }
           if(l+1 == r) return cost;
           leftDist = l - start;
           rightDist = end - r;

           if(leftDist > rightDist){
               cost += rightDist;
               s = s.substring(0,r+1);
           }else{
               cost += leftDist;
               s = s.substring(l);
           }
           System.out.println("test 2 = " + s + " " + l + " " + r);
           s = removeFrontEndB(s);
            if(s.length() > 0){
                l = 0;
                start = 0;
                r = s.length()-1;
                end = s.length()-1;
            }

        }
        return cost;
    }

    private static String removeFrontEndB(String s){
        if(s==null || s.length()==0) return null;
        int l = 0, r = s.length()-1;
        int  n = s.length();
        //remove front b
        while(l < n && s.charAt(l)=='b'){
            cost++;
            l++;
        }
        //remove tail b
        if(s.length() > 0){
            r = s.length()-1;
            while(r >= 0 && s.charAt(r)=='b'){
                cost++;
                r--;
            }
        }
        s = s.substring(l, r+1);
        return s;
    }

    public static void main(String[] args) {
        String s = "abbaaba";
        int result = lowCostRemove(s);
        System.out.println(result);
    }
}
