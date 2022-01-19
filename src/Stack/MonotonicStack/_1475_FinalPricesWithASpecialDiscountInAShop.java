package Stack.MonotonicStack;

import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _1475_FinalPricesWithASpecialDiscountInAShop {

    //we don't need to create a new result, we can change the value
    //in the Original array
    //Time = O(n), Space = O(1)
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && prices[stack.peek()] >= prices[i]){
                prices[stack.pop()] -= prices[i];
            }
            stack.push(i);
        }
        return prices;
    }

/*  public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && prices[stack.peek()] >= prices[i]){
                int idx = stack.pop();
                res[idx] = prices[idx]-prices[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int idx = stack.pop();
            res[idx] = prices[idx];
        }
        return res;
    } */
}
