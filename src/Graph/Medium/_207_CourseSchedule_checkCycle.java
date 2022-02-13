package Graph.Medium;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _207_CourseSchedule_checkCycle {
    //BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites==null || prerequisites.length==0) return true;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = numCourses;
        int[] inDegree = new int[numCourses];
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
        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            for(int nei : graph.get(node)){
                inDegree[nei]--;
                if(inDegree[nei]==0) q.add(nei);
            }
        }
        return count==n;
    }

    /*
     //DFS
    int[] visited;
    boolean valid = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites==null || prerequisites.length==0) return true;
 	    Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = numCourses;
        visited = new int[n];
        //Build Graph
        for(int i=0; i<n; i++) graph.put(i, new ArrayList<>());
        for(int[] p : prerequisites){
            int start = p[1], end = p[0];
            graph.get(start).add(end);
        }
        //DFS traverse
        for(int i=0; i<n; i++){
            if(visited[i] != 0) continue;
            dfs(i, graph);
        }
        return valid;
    }

    private void dfs(int node, Map<Integer, List<Integer>> graph){
         visited[node] = 1;
         for(int nei : graph.get(node)){
            //when neighb hasn't been visited
            if(visited[nei]==0) dfs(nei, graph);
            else if(visited[nei]==1){
                //if the neighb has been visited
                valid = false;
            }
         }
        //set the curr node to other value to indicate the node have finished check
         visited[node] = 2;
    }
     */

    //Backtracking
    //Time = O(V+E) , Space = O(V+E)
 /*   public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] p  : prerequisites){
            if(graph.containsKey(p[1])){
                graph.get(p[1]).add(p[0]);
            }else{
                List<Integer> nextCourse = new ArrayList<>();
                nextCourse.add(p[0]);
                graph.put(p[1], nextCourse);
            }
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] checked = new boolean[numCourses];
        for(int i=0; i<numCourses; i++){
            if(withCycle(graph, visited, checked, i)){
                return false;
            }
        }
        return true;
    }

    private boolean withCycle(Map<Integer, List<Integer>> graph, boolean[] visited, boolean[] checked, int node){

        //bottom case
        //this node has been checked, no cycle would be formed with this node
        if(checked[node]){
            return false;
        }

        //come across a previously visited node, that is detect the cycle
        if(visited[node]){
            return true;
        }
        //no following course, no loop
        if(!graph.containsKey(node)){
            return false;
        }

        visited[node] = true;
        boolean isCycle = false;
        //postOrder DFS, to visit all its children first
        for(Integer nei : graph.get(node)){
            isCycle = withCycle(graph, visited, checked, nei);
            if(isCycle){
                break;
            }
        }
        //after the visited children, we come back to process the node itself
        //remove the node from the path
        visited[node] = false;
        //Now we have visited the node in the downstream,
        //we complete the check of this node
        checked[node] = true;
        return isCycle;
    } */


 //===============================================================

    /*
     Map<Integer, List<Integer>> graph;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
 	    graph = new HashMap<>();
        int n = numCourses;
 	    int[] inDegree = new int[n];
        for(int[] p  : prerequisites) {
              int src = p[1];
 	          int dest = p[0];
              if(!graph.containsKey(src)) {
		         graph.put(src, new ArrayList<>());
		      }
             graph.get(src).add(dest);
             inDegree[dest]++;
        }

          Queue<Integer>  q = new LinkedList<>();
           for(int i=0; i<n; i++) {
                if(inDegree[i]==0) {
                  q.add(i);
                }
          }

         while(!q.isEmpty()) {
 	      int node = q.poll();
              if(graph.containsKey(node)) {
	            for(int nei : graph.get(node)) {
                    inDegree[nei]--;
                   if(inDegree[nei] == 0) {
                      q.add(nei);
                   }
               }
	       }
      }

      for(int i=0; i<n; i++) {
 		if(inDegree[i] != 0) return false;
	  }
       return true;
    }
     */
}

/*
reformate the problem as graph problem, the course is vertex, the dependency between
courseis an edge.
--And the problem to determine if one could build a valid schedule of courses that satisfies all
the dependencies (i.e. constraints) would be equivalent to determine if the corresponding graph
is a DAG (Directed Acyclic Graph), i.e. there is no cycle existed in the graph.

How to check if a graph if cyclic ??
1) backtracking
   we incrementally follow the dependencies until either there is no more dependency or we come across a previously
   visited course along the path.
*/
