package Golden_Sach_21FallOA;

/**
 * Created by Shuhua Song
 */
public class _GameWinner_Bob_Wendy {

    public static String findWinner(String s) {
        int bob_moves = 0, wendy_moves = 0;
        int n = s.length(), i = 0;
        while(i < n){
            int j = i, count = 0;
            while(j < n && s.charAt(i)==s.charAt(j)){
                count++;
                j++;
            }
            if(count > 2){
                if(s.charAt(i)=='w') wendy_moves += count-2;
                else{
                    bob_moves += count - 2;
                }
            }
            i = j;
        }
        if(bob_moves >= wendy_moves) return "bob";
        return "wendy";
    }

    public static void main(String[] args) {
        String s1 = "wwwbbbbwww";
        String s2 = "wwbbbwww";
        String s3 = "wwwbbbwwbbbbwww";
        System.out.println(findWinner(s1));
        System.out.println(findWinner(s2));
        System.out.println(findWinner(s3));
    }
}
