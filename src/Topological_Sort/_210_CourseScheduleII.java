package Topological_Sort;

import java.util.*;

public class _210_CourseScheduleII {


    //BFS Time = O(V+E), Space = O(V+E)
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = numCourses;
        int[] inDegree = new int[n];
        for(int i=0; i<n; i++) graph.put(i, new ArrayList<>());
        for(int[] p : prerequisites){
            int start = p[1], end = p[0];
            graph.get(start).add(end);
            inDegree[end]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(inDegree[i]==0) q.add(i);
        }
        int[] res = new int[n];
        int k = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            res[k++] = node;
            for(int neigh : graph.get(node)){
                inDegree[neigh]--;
                if(inDegree[neigh]==0){
                    q.add(neigh);
                }
            }
        }
        if(k != n) return new int[0];
        return res;
    }

 /*   public int[] findOrder(int numCourses, int[][] preCourses) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDegree = new int[numCourses];
        int[] resultsOrder = new int[numCourses];
        for(int[] course : preCourses){
            int dest = course[0];
            int src = course[1];
            if(!adjList.containsKey(src)){
                adjList.put(src, new ArrayList<Integer>());
            }
            adjList.get(src).add(dest);
            inDegree[dest]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }

        int j = 0;
        while(!queue.isEmpty()){
            int curNode = queue.poll();
            resultsOrder[j++] = curNode;
            if(adjList.containsKey(curNode)){
                for(int nei : adjList.get(curNode)){
                    inDegree[nei]--;
                    if(inDegree[nei]==0){
                        queue.add(nei);
                    }
                }
            }
        }
        if(j==numCourses) return resultsOrder;
        else
            return new int[0];
    } */
}
