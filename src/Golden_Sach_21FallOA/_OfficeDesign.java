package Golden_Sach_21FallOA;

/**
 * Created by Shuhua Song
 */
public class _OfficeDesign {

    public static int maxNumColors(int[] prices, int money){
          if(prices.length==0 || money==0) return 0;
          int l = 0, res = 0, sum = 0;
          for(int r=0; r<prices.length; r++){
              sum += prices[r];
              while(sum > money){
                  sum -= prices[l++];
              }
              System.out.println(l + " "  + r );
              res = Math.max(0, r-l+1);
          }
          return res;
    }

    public static void main(String[] args) {
        int[] prices = {2, 3, 5, 1, 1, 2, 1};
        int money = 7;
        int result = maxNumColors(prices, money);
        System.out.println("result = " + result);
    }
}
