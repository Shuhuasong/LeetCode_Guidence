package Array.Medium;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class test {

      public static  int solution(int n, String s){
          String[] reserveSeats = s.split("\\s+");
          Arrays.sort(reserveSeats);
          for(String w : reserveSeats){
              System.out.println(w);
          }
          return 0;
      }

    public static void main(String[] args) {
       String s = "1A 3C 2B 40G 5A";
       solution(1, s);
    }
}
