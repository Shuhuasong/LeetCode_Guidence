package Graph.Hard;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _1345_JumpGameIV {

    //Build a graph of n nodes where nodes are the indices of the array and edges for
    // node i are nodes i+1, i-1, j where arr[i] == arr[j].
    //Start bfs from node 0 and keep distance. The answer is the distance when you reach node n-1.

    //Bi-Direction BFS: Time = O(n), Space = O(n)
    public int minJumps(int[] arr) {
        if(arr.length <= 1) return 0;
        int n = arr.length;
        Map<Integer, List<Integer>> numToIndex = new HashMap<>();
        for(int i=0; i<n; i++){
            numToIndex.putIfAbsent(arr[i], new ArrayList<>());
            numToIndex.get(arr[i]).add(i);
        }
        Set<Integer> begin = new HashSet<>(), end = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        begin.add(0); end.add(n-1);
        visited.add(0); visited.add(n-1);
        int steps = 0;
        while(!begin.isEmpty()){
            if(begin.size() > end.size()){
                Set<Integer> temp = new HashSet<>();
                temp = begin;
                begin = end;
                end = temp;
            }
            Set<Integer> newBegin = new HashSet<>();
            for(int pos : begin){
                //jump to the same value
                List<Integer> neighbors = numToIndex.get(arr[pos]);
                for(int neigh : neighbors){
                    if(end.contains(neigh)) return steps+1;
                    if(visited.add(neigh)) newBegin.add(neigh);
                }
                //clear the same value in the list to avoid repeatly searching
                numToIndex.get(arr[pos]).clear();
                //jump to left and right position
                int x = pos + 1, y = pos - 1;
                if(end.contains(x) || end.contains(y)) return steps+1;
                if(x < n && visited.add(x)) newBegin.add(x);
                if(y >= 0 && visited.add(y)) newBegin.add(y);
            }
            steps++;
            begin = newBegin;
        }
        return steps;
    }

    //Single Direction BFS: Time = O(n), Space = O(n)
    // slower than Bi-direction BFS
/*    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> numToIndex = new HashMap<>();
        for(int i=0; i<n; i++){
            numToIndex.putIfAbsent(arr[i], new ArrayList<>());
            numToIndex.get(arr[i]).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(0);
        visited.add(0);
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int pos = q.poll();
                if(pos==n-1) return steps;
                List<Integer> neighbors = numToIndex.get(arr[pos]);
                neighbors.add(pos-1);
                neighbors.add(pos+1);
                for(int next : neighbors){
                    if(next >= 0 && next < n && visited.add(next)){
                        q.add(next);
                    }
                }
                //efficient when the array is : {7,7,7,7,7,7.......}
                numToIndex.get(arr[pos]).clear();
            }
            steps++;
        }
        return steps;
    }

 */


/*    public int minJumps(int[] arr) {
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
                //we can't use remove, only can use clear, to clear the data in list within this key
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

 */
}
