package Topological_Sort;

import java.util.*;

public class _207_CourseSchedule {

     //BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = numCourses;
        int[] inDegree = new int[n];
        for(int[] p : prerequisites){
            int src = p[1], dest = p[0];
            graph.computeIfAbsent(src, k->new ArrayList<>()).add(dest);
            inDegree[dest]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(inDegree[i]!=0) continue;
            q.add(i);
        }
        Set<Integer> seen = new HashSet<>();
        while(!q.isEmpty()){
            int node = q.poll();
            seen.add(node);
            for(int next : graph.getOrDefault(node, new ArrayList<>())){
                inDegree[next]--;
                if(inDegree[next]==0) q.add(next);
            }
        }
        return seen.size()==n;
    }


    /* DFS
    Map<Integer, List<Integer>> graph;
    int[] visited;
    boolean valid = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         graph = new HashMap<>();
         int n = numCourses;
         visited = new int[n];
        //Build Graph
         for(int[] p : prerequisites){
             int src = p[1], dest = p[0];
             graph.computeIfAbsent(src, k->new ArrayList<>()).add(dest);
         }
        //DFS traverse
         for(int i=0; i<n; i++){
             //if node i has been visited
             if(visited[i]!=0) continue;
             dfs(i);
         }
        return valid;
    }

    private void dfs(int node){
        //mark has been visited
      visited[node] = 1;
      for(int next : graph.getOrDefault(node, new ArrayList<>())){
          //when neighbor hasn't been visited
          if(visited[next]==0) dfs(next);
          else if(visited[next]==1){
              //if the neighbor has been visited
              valid = false;
          }
      }
      //set the current node to other value to indicate the node has finished checking
      visited[node] = 2;
    }
     */



    //Time Limited Exceeded
   //Time = O(E + V^2)  Space = O(E + V)
 /*   public boolean canFinish(int numCourses, int[][] preCourses) {
        if(preCourses==null || preCourses.length==0) return true;
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] course : preCourses){
            int dest = course[0];
            int src = course[1];
            graph[src].add(dest);
        }
        boolean[] visited = new boolean[numCourses];
        for(int i=0; i<numCourses; i++){
            if(isCyclic(graph, visited, i)){
                return false;
            }
        }
        return true;
    }

    private boolean isCyclic(ArrayList<Integer>[] graph, boolean[] visited, int courNum){
        if(visited[courNum]) return true;

        visited[courNum] = true;
        for(int i=0; i<graph[courNum].size(); i++){
            if(isCyclic(graph, visited, graph[courNum].get(i))){
                return true;
            }
        }
        //backtracking
        visited[courNum] = false;
        return false;
    }

  */
}
