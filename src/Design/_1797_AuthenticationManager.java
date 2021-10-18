package Design;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _1797_AuthenticationManager {

    Map<String, Integer> tokenMap = new HashMap<>();
    int timeToLive;
    public _1797_AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        tokenMap.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        if(!tokenMap.containsKey(tokenId)) return;
        if(tokenMap.get(tokenId) <= currentTime){
            tokenMap.remove(tokenId);
            return;
        }
        tokenMap.put(tokenId, currentTime+timeToLive);
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for(String id : tokenMap.keySet()){
            if(tokenMap.get(id) > currentTime){
                count++;
            }
        }
        return count;
    }
}
