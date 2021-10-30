package Pramp.String.Medium;

import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _1209_RemoveAllAdjacentDuplicatesInStringII {

    //Memoise Count : Time = O(n) Space = O(n)
    public String removeDuplicates(String s, int k) {
        if(s==null || s.length()==0) return s;
        StringBuilder sb = new StringBuilder(s);
        int[] count = new int[s.length()];
        for(int i=0; i<sb.length(); i++){
            if(i==0 || sb.charAt(i) != sb.charAt(i-1)){
                count[i] = 1;
            }else{
                count[i] = count[i-1] + 1;
                if(count[i]==k){
                    sb.delete(i-k+1, i+1);
                    i = i-k;
                }
            }
        }
        return sb.toString();
    }
    /*

    //Memoise Count : Time = O(n) Space = O(n)
    public String removeDuplicates(String s, int k) {
         if(s==null || s.length()==0) return s;
         StringBuilder sb = new StringBuilder(s);
         Stack<Integer> stack = new Stack<>();
         for(int i=0; i<sb.length(); i++){
             if(i==0 || sb.charAt(i) != sb.charAt(i-1)){
                 stack.push(1);
             }else{
                 int top = stack.pop() + 1;
                 if(top==k){
                     sb.delete(i-k+1, i+1);
                     i = i-k;
                 }else{
                     stack.push(top);
                 }
             }
         }
        return sb.toString();
    }
     */

/*
    //Time = O(n) Space = O(n)
    public String removeDuplicates(String s, int k) {
        if(s==null || s.length()==0) return s;
        char[] chs = s.toCharArray();
        Stack<int[]> stack = new Stack<>();
        for(char c : chs){
            if(stack.isEmpty() || stack.peek()[0] != c){
                stack.push(new int[]{c, 1});
            }else{
                if(stack.peek()[0]==c && stack.peek()[1]==k-1){
                    stack.pop();
                }else{
                    stack.peek()[1] += 1;
                }
            }
            //System.out.println((char)(stack.peek()[0]+'a') + " " + stack.peek()[1]);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            int[] cell = stack.pop();
            char ch = (char)(cell[0]);
            int time = cell[1];
            for(int i=0; i<time; i++){
                sb.insert(0,ch);
            }
            //  System.out.println(ch);

        }
        return sb.toString();
    }

 */

}

//delete(int start, int end) method of StringBuilder class removes the characters starting from index start to index end-1 from String contained by StringBuilder.
