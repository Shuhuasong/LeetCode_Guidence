package Topological_Sort;

import java.util.*;

public class _207_CourseSchedule {

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
        //backtracking
        for(int i=0; i<graph[courNum].size(); i++){
            if(isCyclic(graph, visited, graph[courNum].get(i))){
                return true;
            }
        }
        visited[courNum] = false;
        return false;
    }

  */

    //TIme = O(E + V), visit each vertex and each edge once
    //Space = O(E + V), space for build graph
    public boolean canFinish(int numCourses, int[][] preCourses) {
        if(preCourses==null || preCourses.length==0) return true;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];

        for(int[] course : preCourses){
            int dest = course[0];
            int src = course[1];
            if(!graph.containsKey(src)){
                graph.put(src, new ArrayList<Integer>());
            }
            graph.get(src).add(dest);
            inDegree[dest]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int curNode = queue.poll();
            if(graph.containsKey(curNode)){
                for(int nei : graph.get(curNode)){
                    inDegree[nei]--;
                    if(inDegree[nei]==0){
                        queue.add(nei);
                    }
                }
            }
        }

        for(int i=0; i<numCourses; i++){
            if(inDegree[i] != 0) return false;
        }
        return true;
    }
}
