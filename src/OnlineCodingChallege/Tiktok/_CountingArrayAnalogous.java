package OnlineCodingChallege.Tiktok;

/**
 * Created by Shuhua Song
 */
public class _CountingArrayAnalogous {

    public static int countAnalogous(int[] diffs, int lowBound, int upperBound){
        int count = 0;
        for(int i=lowBound; i<= upperBound; i++){
            boolean isValid = true;
            int sum = i;
           for(int j=0; j<diffs.length; j++){
               sum += -diffs[j];
               System.out.println(sum);
               if(sum < lowBound || sum > upperBound){
                   isValid = false;
                   break;
               }
           }
           sum = 0;
           if(isValid){
               count++;
           }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] diff = {-2, -1, -2, 5};
        int res = countAnalogous(diff, 3, 10);
        System.out.println("Result = " + res);
    }
}
