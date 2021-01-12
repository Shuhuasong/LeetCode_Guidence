package DFS_and_BFS.Medium;

public class _1306_JumpGameIII {

    // DFS: Time = O(n) Space = O(n)
    public boolean canReach(int[] arr, int start) {
        if(start<0 || start>=arr.length || arr[start] < 0) return false;
        if(arr[start]==0) return true;
        arr[start] = -arr[start];
        return canReach(arr, start+arr[start]) || canReach(arr, start-arr[start]);
    }


    /*
     // BFS: Time = O(n) Space = O(n)
    public boolean canReach(int[] arr, int start) {
       Queue<Integer> queue = new LinkedList<>();
       queue.add(start);
       while(!queue.isEmpty()){
           int node = queue.poll();
           if(arr[node]==0) return true;
           if(arr[node] < 0)  continue;
           //arr[node] = -arr[node];
           if(node-arr[node]>=0){
               queue.add(node-arr[node]);
           }
           if(node+arr[node] < arr.length){
               queue.add(node+arr[node]);
           }
           arr[node] = -arr[node];
       }
      return false;
    }
     */
}
