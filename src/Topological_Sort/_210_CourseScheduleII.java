package Topological_Sort;

import java.util.*;

public class _210_CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] preCourses) {
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
    }
}
