package OnlineCodingChallege.Cisco;

/**
 * Created by Shuhua Song
 */
public class _204_CountPrime {

    public int countPrimes(int n) {
        if(n<=0) return 0;
        boolean[] prime = new boolean[n+1];
        for(int i=0; i<prime.length; i++) {
            prime[i] = true;
        }

        for(int i=2; i*i <= n; i++){
            if(prime[i]){
                for(int j=i*i; j<=n; j=j+i){
                    prime[j] = false;
                }
            }
        }
        int count = 0;
        for(int i=2; i<prime.length-1; i++){
            if(prime[i]) count++;
        }
        return count;
    }
}
