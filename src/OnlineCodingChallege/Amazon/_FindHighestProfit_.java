package OnlineCodingChallege.Amazon;

import CodeSignal._getLengthOfRibbons;

import java.util.PriorityQueue;
/*
the same with ：LC _1648_Sell Diminishing_Valued Colored Balls

Amazon Online Assessment (OA) - Find The Highest Profit
An e-commerce company imports a type of fitness band from China and sell them in US for a higher price for a profit.
The company has multiple suppliers for the product, each with their own inventory. The suppliers raise the price of
their product when inventory gets small due to scarcity. More specifically, the profit the e-commerce company makes
for each product sold is equal to the number of products left from the supplier.

Given a list of integers representing the number of products each supplier has and an integer representing the number
 of products sold, find the maximum profit the company can make.

Examples
Example 1:
Input:
inventories = [4, 6] order = 4

Output: 19
Explanation:
There are two suppliers, with inventory 4 and 6 respectively. A total of 7 items are ordered. We can make maximum profit by

getting 1 item from the first supplier for 6
getting 1 item from the first supplier for 5
getting 1 item from the first supplier for 4
getting 1 item from the second supplier for 4
The maximum profit is 6 + 5 + 4 + 4 = 19.

Example 2:
Input:
inventories = [10, 10]

order = 5

Output: 46
Explanation:
The maximum profit we can generate is by

getting 1 item for a profit of 10 from the first supplier
getting 1 item for a profit of 10 from the second supplier
getting 1 item for a profit of 9 from the first supplier
getting 1 item for a profit of 9 from the second supplier
getting 1 item for a profit of 8 from the first or second supplier
The maximum profit is 10 + 10 + 9 + 9 + 8 = 46.
java
 */
/**
 * Created by Shuhua Song
 */
public class _FindHighestProfit_ {

    private static int getHighestProfit(int[] inventory, int orders){
        int mod = 1000000007;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : inventory) {
            pq.offer(num);
        }

        int cur = pq.poll();
        int count = 1; // When pq poll the next element, +1 to count.
        long res = 0;
        while (orders > 0) {
            int next = pq.isEmpty() ? 0 : pq.peek();
            // If the number for [next + 1, cur] less than orders, add them ALL.
            if ((cur - next) * count <= orders) {
                // Add all the sum, and don't forget cast!
                long num =  (1L * (next + 1 + cur) * (cur - next) * count / 2) % mod;
                res = (res + num) % mod;
                orders -= (cur - next) * count;

            } else {
                // If the number for [next + 1, cur] greater than orders, only add partially.
                // Calculate the new next where the add stops.
                next = cur - orders / count;
                long num =  (1L * (next + 1 + cur) * (cur - next) * count / 2) % mod;
                res = (res + num) % mod;
                // For the last number to add (new next), and don't forget cast! I forget here in contest!
                res = (res + 1L * next * (orders % count)) % mod;
                orders = 0;
            }

            if (!pq.isEmpty()) cur = pq.poll();
            count++;
        }
        return (int) res;
    }


    public static void main(String[] args) {
         int[] productss = {4, 6};
        System.out.println(getHighestProfit(productss, 4));

        int[] products2 = {10, 10};
        System.out.println(getHighestProfit(products2, 5));
    }
}
