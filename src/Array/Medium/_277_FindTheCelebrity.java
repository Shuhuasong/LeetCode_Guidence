package Array.Medium;

public class _277_FindTheCelebrity {

    private boolean knows(int i, int j){
        return true;
    }

    //Solution#1-Bruteforece
    //Time = O(n^2) Space = O(1)
 /*   int size;
    public int findCelebrity(int n){
        this.size = n;
        for(int i=0; i<n; i++){
            if(isCelebrity(i)){
                return i;
            }
        }
        return -1;
    }

    private boolean isCelebrity(int i){
        for(int j=0; j<size; i++){
            if(i==j) continue;
            if(knows(i, j) || !knows(j, i)){
                return false;
            }
        }
        return true;
    }
  */

  // Solution#2- logical deduction
  // Time = O(n)   Space = O(1)
  /* idea: if knows(0, 1) = true, then 0 is not a celebrity, but maybe 1 is a potential celebirty, then we set candidate = 1
           if knows(0, 1) = false, then 1 is not a celebrity(rule out), then we keep ask next person using knows(0, 2)
   */
  int size;
    public int findCelebrity(int n) {
        this.size = n;
        int curCandidate = 0;
        for(int i=0; i<n; i++){
            if(knows(curCandidate, i)){
                curCandidate = i;
            }
        }
        if(isCelebrity(curCandidate)){
            return curCandidate;
        }
        return -1;
    }

    private boolean isCelebrity(int i){
        for(int j=0; j<size; j++){
            if(i==j) continue;
            if(knows(i, j) || !knows(j, i)){
                return false;
            }
        }
        return true;
    }

   //Solution#3- Logical Deduction with Caching (follow up question)
    /*
    real-world problem: request a page in the internet

     private int size;
    private Map<Pair<Integer, Integer>, Boolean> cache = new HashMap<>();
    @Override
    public boolean knows(int a, int b){
        if(!cache.containsKey(new Pair(a,b))){
            cache.put(new Pair(a, b), super.knows(a,b));
        }
        return cache.put(new Pair(a, b), super.knows(a, b));
    }
    public int findCelebrity(int n) {
        this.size = n;
        int curCandidate = 0;
        for(int i=0; i<n; i++){
            if(knows(curCandidate, i)){
                curCandidate = i;
            }
        }
        if(isCelebrity(curCandidate)){
            return curCandidate;
        }
        return -1;
    }

    private boolean isCelebrity(int i){
        for(int j=0; j<size; j++){
            if(i==j) continue;
            if(knows(i, j) || !knows(j, i)){
                return false;
            }
        }
        return true;
    }
     */
}
