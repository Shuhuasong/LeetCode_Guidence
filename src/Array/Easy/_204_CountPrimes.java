package Array.Easy;

/**
 * Created by Shuhua Song
 */
public class _204_CountPrimes {

      public int countPrimes(int n) {
      if(n<=1) return 0;
      boolean[] isPrime = new boolean[n];
      //Arrays.fill(isPrime, true);
      for(int i=0; i<n; i++) {
          isPrime[i] = true;
      }
        // Loop's ending condition is i * i <= num instead of i <= sqrt(num)
   // to avoid repeatedly calling an expensive function sqrt()
      for(int i=2; i * i < n; i++){
          if(!isPrime[i]) continue;
          for(int j=i*i; j<n; j += i){
              isPrime[j] = false;
          }
      }
      int res = 0;
      for(int i=2; i<n; i++){
          if(isPrime[i]){
              res++;
          }
      }
        return res;
    }

    /*
    //Time Limit Exceed
     //Time = O(n * sqrt(n)) = O(n^1.5)
    public int countPrimes(int n) {
       if(n <= 2) return 0;
       int count = 0;
       for(int i=1; i<n; i++){
           if(isPrime(i)){
               count++;
           }
       }
        return count;
    }

    private boolean isPrime(int num){
        if(num <= 1) return false;
        for(int i=2; i*i<=num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
     */
}
