package Graph.Hard;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _332_Reconstruct_Itinerary {

     //欧拉路径，一笔划过，经过所有的点
     public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, LinkedList<String>> graph = new HashMap<>();
        buildGraph(graph, tickets);
        LinkedList<String> res = new LinkedList<>();
        for(String k : graph.keySet()){
            Collections.sort(graph.get(k));
        }
        dfs(res, graph, "JFK");
        return res;
    }

    public void dfs(LinkedList<String> res, Map<String, LinkedList<String>> graph, String start){
        if(graph.containsKey(start)){
            LinkedList<String> dests = graph.get(start);
            while(dests.size()>0){
                String end = dests.pollFirst();
                dfs(res, graph, end);
            }
        }
        res.addFirst(start);
    }

    public void buildGraph(Map<String, LinkedList<String>> graph, List<List<String>> tickets){
        for(List<String> ticket : tickets){
            String src = ticket.get(0);
            String dst = ticket.get(1);
            if(!graph.containsKey(src)){
                graph.put(src, new LinkedList<>());
            }
            graph.get(src).add(dst);
        }
    }

}

/*
Solution:
1) the input graph is a DAG (Directed Acyclic Graph), since we could
   find at least a cycle in the graph.
2) the graph could even have some duplicate edges (i.e. we might have
   multiple flights with the same origin and destination).
Solution 1 : Backtracking + Greedy
Solution 2:  Sort children + post order traversal

Example-1:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 SFO <-- ATL <-- SFO <-- JFK <-- ATL <-- JFK
PostOrder = {SFO, ATL, SFO, JFK, ATL, JFK}
Reverse  =  {JFK, ATL, JFK, SFO, ATL, SFO}

Example-2:
tickets = [["JFK", "KUL"], ["JFK", "NRT"], ["NRT", "JFK"]]
Return  = {"JFK", "NRT", "JFK", "KUL"}
PostOrder = {KUL, JFK, NRT, JFK}
Reverse   = {JFK, NRT, JFK, KUL}
        JFK
      /     \
    KUL     NRT
            /
           JFK
*/
