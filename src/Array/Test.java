package Array;

/**
 * Created by Shuhua Song
 */
public class Test {

    public static void main(String[] args) {
        int num1 = 0;
        int num2 = 0;
        for(int i=0; i<5; i++){
            System.out.println(num1 + " " + num2);
            if((++num1 > 2) && (++num2 > 2)){
                //System.out.println(num1 + " " + num2);
                num1++;

            }
        }
        System.out.println(num1 + " " + num2);
    }
}
