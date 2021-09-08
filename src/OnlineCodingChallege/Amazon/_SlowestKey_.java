package OnlineCodingChallege.Amazon;

/**
 * Created by Shuhua Song
 */
public class _SlowestKey_ {

    private static char findLongestDuration(String keyPress, int[] releaseTime){
        char res = keyPress.charAt(0);
        int maxTime = releaseTime[0];
        int n = releaseTime.length, curTime = 0;
        for(int i=1; i<n; i++){
            curTime = releaseTime[i] - releaseTime[i-1];
            if(curTime > maxTime){
                maxTime = curTime;
                res = keyPress.charAt(i);
            }else if(curTime == maxTime){
                if(res < keyPress.charAt(i)){
                    res = keyPress.charAt(i);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
         int[] releaseTime1 = {9, 29, 49, 50};
         String keyPress1 = "cbcd";
         int[] releasetime2 = {12, 23, 36, 46, 62};
         String keyPress2 = "spuda";
        System.out.println(findLongestDuration(keyPress1, releaseTime1));
        System.out.println(findLongestDuration(keyPress2, releasetime2));
    }
}
