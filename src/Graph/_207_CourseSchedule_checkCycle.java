package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _207_CourseSchedule_checkCycle {

    //Backtracking
    //Time = O(V+E) , Space = O(V+E)
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
    }
}

/*
reformate the problem as graph problem, the course is vertex, the dependency between
courseis an edge.
--And the problem to determine if one could build a valid schedule of courses that satisfies all
the dependencies (i.e. constraints) would be equivalent to determine if the corresponding graph
is a DAG (Directed Acyclic Graph), i.e. there is no cycle existed in the graph.

How to check if a graph if cyclic ??
1) backtracking
   we incrementally follow the dependencies until either there is no more dependency or we come across a previously visited course along the path.
*/