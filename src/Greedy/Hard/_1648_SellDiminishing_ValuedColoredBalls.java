package Greedy.Hard;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _1648_SellDiminishing_ValuedColoredBalls {
    //Time = O(n*logn), Space = O(n)
    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        long res = 0, count = 1;
        int i = inventory.length-1;
        while(orders > 0){
            if(i > 0 && inventory[i]-inventory[i-1] > 0 && orders >= count*(inventory[i]-inventory[i-1])){
                res += count * sumFromXtoY(inventory[i], inventory[i-1]);
                orders -= count * (inventory[i]-inventory[i-1]);
            }else if(i==0 || inventory[i]-inventory[i-1] > 0){
                long newOrder = orders/count;
                res += count * sumFromXtoY(inventory[i], inventory[i]-newOrder);
                long remindOrder = orders%count;
                res += remindOrder * (inventory[i]-newOrder);
                orders = 0;
            }
            res %= 1000000007;
            i--;
            count++;
        }
        return (int)res;
    }

    private long sumFromXtoY(long x, long y){
        return (x*(x+1))/2 - (y*(y+1))/2;
    }
}

    /*
      //TLE
    public int maxProfit(int[] inventory, int orders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);
        for(int inven : inventory){
            pq.offer(inven);
        }
        int res = 0;
        while(!pq.isEmpty() && orders > 0){
            int val = pq.poll();
            res += val;
            val--;
            orders--;
            if(val==0) continue;
            pq.offer(val);
        }
        return res;
    }
     */

/*
        Solution: Greedy + Math(arithmetic sequence)
        Sort the colors in order.
        Find a group of colors that have the same number of balls.
        We can sell them together to speed up the process until the # of
        orders < 0
        e.g  inventory = {2, 4, 6, 6, 9, 10}
        if we sell them in greedy, the list will be:
        {10, 9, 9, 8, 8, 7, 7, 6, 6, 6, 6, 5, 5, 5, 5, 4, 4, 4, 4, 4, 3, 3, 3 }

        Using count, I am trying to improve the greedy by creating groups and calculating sum of the groups instead.

        group 1 - 10 => 10
        group 2 - 9, 9, 8, 8, 7, 7 => 2 * (9 + 8 + 7)
        group 3 - 6, 6, 6, 6, 5, 5, 5, 5 => 4 * (6 + 5)
        group 4 - 4, 4, 4, 4, 4 => 1 * (5)
        group 5 - 3, 3, 3 => 1 * (3)
        n denotes index , count denotes number of elements traversed, orders denotes number of orders.

        n = 5, orders = 23, count = 1
        inventory[5]-inventory[4] > 0 => (10 - 9 > 0)
        orders >= count * (inventory[5]-inventory[4]) => (23 >= 1 * (10-9))
        for 1 * (10-9) orders, we can sell at (1 * 10) => 10
        n = 4, orders = 22, count = 2
        inventory[4]-inventory[3] > 0 => (9 - 6 > 0)
        orders >= count * (inventory[4]-inventory[3]) => (22 >= 2 * (9-6))
        for 2 * (9-6) orders, we can sell at (2 * (9 + 8 + 7)) => 2 * (9* 10/2 - 6* 7/2) => 2 * 24 => 48
        n = 3, orders = 16, count = 3
        inventory[3]-inventory[2] = 0
        n = 2, orders = 16, count = 4
        inventory[2]-inventory[1] > 0 => (6 - 4 > 0)
        orders >= count * (inventory[2]-inventory[1]) => (16 >= 4 * (6-4))
        for 4 * (6-4) orders, we can sell at (4 * (6 + 5)) => 4 * (6* 7/2 - 4* 5/2) => 4 * 11 => 44
        n = 1, orders = 8, count = 5
        inventory[1]-inventory[0] > 0 => (4 - 2 > 0)
        orders >= count * (inventory[1]-inventory[0]) => (8 >= 5 * (4-2)) => false
        a = orders/count => 8/5 => 1, we can sell (5 * (4 - 3)) orders at (5 * (4)) => 20
        remaining orders => b = orders%count => 8%5 => 3 , we can sell (3) orders at 3 * (4 -1) => 9
        total = 10 + 48 + 44 + 20 + 9 => 131

        [1000000000]
        1000000000
        */