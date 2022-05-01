package Graph.Hard;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _269_AlienDictionary {

    public String alienOrder(String[] words) {
        if(words==null || words.length==0) return "";
        //Step 1: create data structures and find all unique letters
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for(String word : words){
            for(char c : word.toCharArray()){
                graph.put(c, new ArrayList<>());
                inDegree.put(c, 0);
            }
        }
        //Step 2: Find all edges
        for(int i=0; i<words.length-1; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            //check if word2 is not a prefix of word1
            if(word1.length() > word2.length() && word1.startsWith(word2)){
                return "";
            }
            //Find the first non match and insert the corresponding relation
            //once find it, we exist the loop
            for(int j=0; j<Math.min(word1.length(), word2.length()); j++){
                if(word1.charAt(j)!=word2.charAt(j)){
                    char u = word1.charAt(j), v = word2.charAt(j);
                    graph.get(u).add(v);
                    inDegree.put(v, inDegree.get(v)+1);
                    break;
                }
            }
        }
        //Step 3: Breath-first-search
        Queue<Character> q = new LinkedList<>();
        for(char c : inDegree.keySet()){
            if(inDegree.get(c).equals(0)){
                q.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            char curr = q.poll();
            sb.append(curr);
            for(char nei : graph.get(curr)){
                inDegree.put(nei, inDegree.get(nei)-1);
                if(inDegree.get(nei).equals(0)){
                    q.add(nei);
                }
            }
        }
        if(sb.length() < inDegree.size()) return "";
        return sb.toString();
    }
}

/*
Step 1: create data structures and find all unique letters
Step 2: Find all edges
   --check if word2 is not a prefix of word1
       One edge case we need to be careful of is where a word is followed by its own prefix. In these cases, it is impossible to come up with a valid ordering and so we should return
    --find the first non match and insert the corresponding relation
Step 3: Breath-first-search
        check until queue is empty. After that, we check whether or not all letters were put in the output list. If some are missing, this is because we got to a point where all remaining letters had a cycle. In that case, we should return ""

e.g Find the first non match and insert the corresponding relation

   words = ["wrt","wrf","er","ett","rftt"]

 "wrt", "wrf", "er",  "ett",  "rftt"
 "wrf", "er",  "ett",  "rftt"
 t->f    w->e   r->t   e->r



Solution-topology order
1) find each pair of letters' order:
   compare words[i] and words[i+1],
   only compare the first different
   character.
2) use these pair to build a graph
3) then use BFS find topology order

["wrt","wrf","er","ett","rftt"]
"wrt"-"wrf" :  t < f
"wrf"-"er"  :  w < e
"er" -"ett" :  r < t
"ett"-"rftt":  e < r

w-->e-->r-->t--->f
*/



