package Topological_Sort;

import java.util.*;

public class _207_CourseSchedule {

    /*
       //Backtracking
       //Time = O(E + V)  Space = O(E + V)
   public boolean canFinish(int numCourses, int[][] prerequisites) {

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
        //checked[node_index]) which indicates whether we have done the cyclic check starting from a particular node.
        boolean[] visited = new boolean[numCourses];
        boolean[] checked = new boolean[numCourses];
        for(int i=0; i<numCourses; i++){
            if(withCycle(graph, visited, checked, i)){
                return false;
            }
        }
        return true;
    }


  /*
   * postorder DFS check that no cycle would be formed starting from currCourse
   */
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

        // before backtracking, mark the node in the path
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
    }




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
