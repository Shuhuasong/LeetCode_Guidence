package Graph.Hard;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _1345_JumpGameIV {

    //Build a graph of n nodes where nodes are the indices of the array and edges for
    // node i are nodes i+1, i-1, j where arr[i] == arr[j].
    //Start bfs from node 0 and keep distance. The answer is the distance when you reach node n-1.

    //Time = O(n), Space = O(n)
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n<=1) return 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<n; i++){
            if(!graph.containsKey(arr[i])){
                graph.put(arr[i], new ArrayList<>());
            }
            graph.get(arr[i]).add(i);
        }
        //sotre the nodes in current layer
        List<Integer> curList = new LinkedList<>();
        curList.add(0);
        Set<Integer> visited = new HashSet<>();
        int steps = 0;
        while(!curList.isEmpty()){
            List<Integer> newList = new LinkedList<>();
            //iterat the node
            for(int node : curList){
                if(node==n-1)
                    return steps;
                //Check if the node visite
                for(int child : graph.get(arr[node])){
                    if(!visited.contains(child)){
                        newList.add(child);
                        visited.add(child);
                    }
                }

                //graph.remove(arr[node]);
                //we can use remove, only can use clear, to clear the data in list within this key
                //clear the list to provent redundant search
                graph.get(arr[node]).clear();

                if(node-1>=0 && !visited.contains(node-1)){
                    newList.add(node-1);
                    visited.add(node-1);
                }
                if(node+1<n && !visited.contains(node+1)){
                    newList.add(node+1);
                    visited.add(node+1);
                }
            }
            steps++;
            curList = newList;
        }
        return -1;
    }
}
