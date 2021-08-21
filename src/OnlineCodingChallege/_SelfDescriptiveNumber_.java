package OnlineCodingChallege;

/**
 * Created by Shuhua Song
 */
public class _SelfDescriptiveNumber_ {

    private static boolean checkSelfDescript(int num){
        String s = Integer.toString(num);
        char[] chs = s.toCharArray();
        int[] count = new int[10];
        //sum of all digits of a self-descriptive number
        for(char c : chs){
            count[c-'0']++;
        }
        for(int i=0; i<chs.length; i++){
            if(count[i] != (chs[i]-'0')){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int num = 521001000;
        System.out.println(checkSelfDescript(num));
    }
}
/*
1210
2020
21200
3211000
42101000
521001000
 */
