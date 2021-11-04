package Heap.Medium;

/**
 * Created by Shuhua Song
 */
public class _853_CarFleet {

    //Time = O(n) Space = O(n)
    //Bucket Sort
    public int carFleet(int target, int[] position, int[] speed) {
        int[] bucket = new int[target];
        for(int i=0; i<position.length; i++){
            bucket[position[i]] = speed[i];
        }
        double slower = -1;
        int res = position.length;
        for(int i=target-1; i>=0; i--){
            if(bucket[i]==0) continue;
            double time = (double)(target-i)/bucket[i];
            if(time > slower){
                slower = time;
            }else{
                res--;
            }
        }
        return res;
    }


    /*
       //Time = O(nlogn) Space = O(n)
    class Car{
        int index;
        double time;
        public Car(int index, double time){
            this.index = index;
            this.time = time;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
         Queue<Car> pq = new PriorityQueue<>((o1, o2)->position[o2.index]-position[o1.index]);
         int n = position.length;
         if(n < 1) return 0;
         for(int i=0; i<position.length; i++){
              double time = (double)(target-position[i])/speed[i];
              System.out.println("time = " + time);
              pq.add(new Car(i, time));
         }

        int res = 1;
        while(!pq.isEmpty()){
            Car car = pq.poll();
            while(!pq.isEmpty() && pq.peek().time <= car.time){
                pq.poll();
            }
            if(!pq.isEmpty()) res++;
        }
        return res;
    }
     */
}
