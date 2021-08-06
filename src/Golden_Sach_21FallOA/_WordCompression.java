package Golden_Sach_21FallOA;

import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _WordCompression {

    static class Pair{
        char c;
        int count;
        Pair(char c, int count){
            this.c = c;
            this.count = count;
        }
    }

    public static String wordCompression(String word, int k){
        if(word.length()==0 || k==0) return word;
        if(k==1) return "";
        Stack<Pair> stack = new Stack<>();
        for(char c : word.toCharArray()){
            if(!stack.isEmpty() && c==stack.peek().c){
                stack.peek().count += 1;
                if(stack.peek().count==k){
                    stack.pop();
                }

            }else{
                Pair pair = new Pair(c, 1);
                stack.push(pair);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            Pair p = stack.pop();
            for(int i=0; i<p.count; i++) {
                sb.insert(0, p.c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String word1 = "abbcccddeeeffgggb";
        String word2 = "aba";
        String word3 = "baadddeefffgggc";
        int k1 = 3, k2 = 2, k3 = 2;
        System.out.println(wordCompression(word1, k1));
        System.out.println(wordCompression(word2, k2));
        System.out.println(wordCompression(word3, k3));
    }
}
