package Heap;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _1057_CampusBikes {
    //Bucket Sort Time = O(m*n)
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int m = workers.length, n = bikes.length;
        List<int[]>[] pairList = new ArrayList[2001];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int dist = getDist(workers[i], bikes[j]);
                if(pairList[dist]==null){
                    pairList[dist] = new ArrayList();
                }
                pairList[dist].add(new int[]{i, j});
            }
        }

        int[] res = new int[m];
        Set<Integer> usedBikes = new HashSet<>();
        Arrays.fill(res, -1);
        for(int i=0; i<2001; i++){
            if(pairList[i]==null) continue;
            List<int[]> pairs = pairList[i];
            for(int j=0; j<pairs.size(); j++){
                int[] pair = pairs.get(j);
                if(res[pair[0]]==-1 && !usedBikes.contains(pair[1])){
                    res[pair[0]] = pair[1];
                    usedBikes.add(pair[1]);
                }
            }
        }
        return res;
    }

    private int getDist(int[] worker, int[] bike){
        int px = worker[0], py = worker[1];
        int qx = bike[0], qy = bike[1];
        return Math.abs(px-qx) + Math.abs(py-qy);
    }

    //Time = O(nlogn)
  /*  public int[] assignBikes(int[][] workers, int[][] bikes) {
        int m = workers.length, n = bikes.length;
        Queue<int[]> pq = new PriorityQueue<>((a, b)->{
            if(a[0]==b[0]){
                if(a[1]==b[1])
                    return a[2]-b[2];
                else
                    return a[1]-b[1];
            }else{
                return a[0]-b[0];
            }
        });

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int dist = Math.abs(workers[i][0]-bikes[j][0]) + Math.abs(workers[i][1]-bikes[j][1]);
                pq.add(new int[]{dist, i, j});
            }
        }
        int[] res = new int[m];
        Arrays.fill(res, -1);
        Set<Integer> usedBike = new HashSet<>();
        //distribut the bikes
        while(!pq.isEmpty()){
            int[] pair = pq.poll();
            int workerIdx = pair[1], bikeIdx = pair[2];
            // System.out.println(workerIdx + " " + bikeIdx);
            if(res[workerIdx]==-1 && !usedBike.contains(bikeIdx)){
                res[workerIdx] = bikeIdx;
                usedBike.add(bikeIdx);
            }
        }
        return res;
    }
   /*
    private int getDist(int[] worker, int[] bike){
        int px = worker[0], py = worker[1];
        int qx = bike[0], qy = bike[1];
        return Math.abs(px-qx) + Math.abs(py-qy);
    } */
}
