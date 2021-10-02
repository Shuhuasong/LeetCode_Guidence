package BINARYSEARCH_Web.BFS_DFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
/*
You are given a string cows representing the initial conditions of some cows. Each cow can take one of three values:

"L", meaning the cow is charging to the left.
"R", meaning the cow is charging to the right.
"@", meaning the cow is standing still.
Cows charging on a direction will pick up other cows unless the cow receives a force from the opposite direction. Then, it will stand still.

Return the orientation of each cow when the cow stop charging.

Constraints

n ≤ 100,000 where n is the length of cows
Example 1
Input
cows = "@L@R@@@@L"
Output
"LL@RRRLLL"
Example 2
Input
cows = "@@R@@@L@L"
Output
"@@RR@LLLL"
 */
public class _Moo_ {

    //BFS

    public String solve(String cows) {
        int n = cows.length();
        char[] arr = cows.toCharArray();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<arr.length; i++){
            if(arr[i]=='L' || arr[i]=='R'){
                q.add(i);
            }
        }

        int[] force = new int[n];
        while(!q.isEmpty()){
            HashSet<Integer> set = new HashSet<>();
            int size = q.size();
            for(int i=0; i<size; i++){
                int idx = q.poll();
                char c = arr[idx];
                if(c=='L' && (idx-1) >= 0){
                    if(arr[idx-1]=='@'){
                        force[idx-1]++;
                        set.add(idx-1);
                    }
                }
                if(c=='R' && (idx+1)<n){
                    if(arr[idx+1]=='@'){
                        force[idx+1] += 100;
                        set.add(idx+1);
                    }
                }
            }
            for(Integer i : set){
                if(force[i] == 101) continue;
                if(force[i] == 1){
                    arr[i] = 'L';
                    q.add(i);
                }else{
                    arr[i] = 'R';
                    q.add(i);
                }
            }
        }
        return new String(arr);
    }




    //Dynamic Programming
    /*
    Intuition
For Every Point Calculate the force created by 'L' and 'R'. The Lesser the number higher the force.

Implementation
Create a force array for left and right and calculate it respectively. for example: for right force calculation it will be 0 at the position where it 'R' in string and it will be nullified by 'L' in the string.
Check the code for more details.

Time Complexity
\mathcal{O}(n)O(n). Since we are passing through each array element only thrice.

Space Complexity
\mathcal{O}(n)O(n) Since we are using linear sized array.

    int inf = 1000_000_007;
    public String solve(String cows) {
        int n = cows.length();
        char[] arr = cows.toCharArray();
        int[] l = new int[n];
        int[] r = new int[n];

        int ri = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'L') {
                ri = -1;
            } else if (arr[i] == 'R') {
                ri = i;
            }
            r[i] = (ri != -1) ? i - ri : inf;
        }

        int li = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 'R') {
                li = -1;
            } else if (arr[i] == 'L') {
                li = i;
            }
            l[i] = (li != -1) ? li - i : inf;
        }
        for(int R : r){
            System.out.print(R + " ");
        }
        System.out.println();
        for(int L : l){
            System.out.print(L + " ");
        }
        char[] ans = new char[n];
        for (int i = 0; i < n; i++) {
            if (l[i] < r[i]) {
                ans[i] = 'L';
            } else if (l[i] > r[i]) {
                ans[i] = 'R';
            } else {
                ans[i] = '@';
            }
        }
        return new String(ans);
    }

     */

}
