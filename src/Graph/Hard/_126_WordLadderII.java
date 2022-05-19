package Graph.Hard;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _126_WordLadderII {

    Map<String, List<String>> graph = new HashMap<>();
    List<String> currPath = new ArrayList<>();
    List<List<String>> results = new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return results;
        // build the DAG using BFS
        buildGrahp_BFS(beginWord, endWord, dict);

        // every path will start from the beginWord
        currPath.add(beginWord);
        // traverse the DAG to find all the paths between beginWord and endWord
        backtrack(beginWord, endWord);

        return results;
    }

    private void backtrack(String beginWord, String endWord){
        if(beginWord.equals(endWord)){
            results.add(new ArrayList<>(currPath));
            return;
        }
        if(!graph.containsKey(beginWord)) return;

        for(String next : graph.get(beginWord)){
            currPath.add(next);
            backtrack(next, endWord);
            currPath.remove(currPath.size()-1);//
        }
    }


    private void  buildGrahp_BFS(String beginWord, String endWord, Set<String> dict){
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        // remove the root word which is the first layer in the BFS
        if(dict.contains(beginWord)) dict.remove(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while(!q.isEmpty()){
            int size = q.size();
            // nextLayer will store the words of current layer
            List<String> nextLayer = new ArrayList<>();

            for(int i=0; i<size; i++){
                String curr = q.poll();
                List<String> neighbors = getNeighbors(curr, dict);
                for(String next : neighbors){
                    nextLayer.add(next);
                    if(!graph.containsKey(curr)){
                        graph.put(curr, new ArrayList<>());
                    }
                    // add the edge from currWord to word in the list
                    graph.get(curr).add(next);
                    //make sure only store words in graph only one time
                    if(!visited.contains(next)){
                        q.add(next);
                        visited.add(next);
                    }
                }
            }
            // removing the words of the previous layer
            for(int i=0; i<nextLayer.size(); i++){
                if(dict.contains(nextLayer.get(i))){
                    dict.remove(nextLayer.get(i));
                }
            }
        }
    }

    private List<String> getNeighbors(String word, Set<String> dict){
        List<String> results = new ArrayList<>();
        char[] chs = word.toCharArray();
        for(int i=0; i<chs.length; i++){
            char curr = chs[i];
            for(char c='a'; c<='z'; c++){
                if(curr == c) continue;
                chs[i] = c;
                String newString = new String(chs);
                if(dict.contains(newString))
                    results.add(newString);
            }
            chs[i] = curr;
        }
        return results;
    }
}

//Build a graph: word==vertex, transfermation==edge

/*
1) the graph will be a Directed Acyclic Graph (DAG).
2) Use the BFS, add the edges into graph. Also once a level if finished remove the visited words from wordList.
3) Start from beginWord and while keep tracking of the current path as currPath traverse all the possible paths, whenever the path leads to the endWord store the path in shortestPaths.
4)note that in the graph all paths between beginWord and endWord, obtained through BFS, will be the shortest possible

"hit"
"cog"
["hot","dot","dog","lot","log","cog"]

           dot-------->dog
          /              \
hit-->hot                 \/
          \ lot-----------> log -----> cog

 */

