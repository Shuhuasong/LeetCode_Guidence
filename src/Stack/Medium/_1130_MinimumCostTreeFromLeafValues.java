package Stack.Medium;

import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _1130_MinimumCostTreeFromLeafValues {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        int res = 0;
        for(int curr : arr){
            while(stack.peek() <= curr){
                int mid= stack.pop();
                res += mid * Math.min(stack.peek(), curr);
            }
            stack.push(curr);
        }
        while(stack.size() > 2){
            res += stack.pop() * stack.peek();
        }
        return res;
    }

}


/*
 public int mctFromLeafValues(int[] A) {
        int n = A.length;
        int[] nextGreat = new int[n], prevGreat = new int[n];
        Arrays.fill(nextGreat, Integer.MAX_VALUE);
        Arrays.fill(prevGreat, Integer.MAX_VALUE);
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && A[stack.peek()] <= A[i]){
                int idx = stack.pop();
                nextGreat[idx] = A[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) stack.pop();
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && A[stack.peek()]  < A[i]){
                int idx = stack.pop();
                prevGreat[idx] = A[i];
            }
            stack.push(i);
        }
        for(int a : nextGreat){
            //System.out.print(a + " ");
        }
        System.out.println();
        for(int b : prevGreat){
           // System.out.print(b + " ");
        }
        int cost = 0;
        for(int i=0; i<n; i++){
            int min = Math.min(nextGreat[i], prevGreat[i]);
            if(min != Integer.MAX_VALUE){
                cost += A[i] * min;
            }
        }
        return cost;
    }
 */

/*
intuition:
The problem can be translate as following:
Given an array A, choose two neighbors in the array a and b,
we can remove the smaller one min(a, b), and the cost is a*b.
What is the minimum cost to remove the whole array until only one left ?

to remove a number a, it needs cost a*b, where b>=a.
so a has to be removed by a bigger number.
we want to minimize the cost, so we need to minimize b
the b has two candidate, the first bigger number on the left,
the first bigger on the right.

So. the cost to remove a is  a * min(left, right)
we need to remove elem from smallest to bigger
we check the min(left, right)
for each element a, cost = min(left, right) * a

Time : O(n^2)
Space: O(n)

*/
