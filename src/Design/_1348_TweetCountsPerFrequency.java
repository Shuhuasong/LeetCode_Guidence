package Design;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _1348_TweetCountsPerFrequency {

    Map<String, TreeMap<Integer, Integer>> tweets;
    Map<String, Integer> timeMap;
    public _1348_TweetCountsPerFrequency() {
        tweets = new HashMap<>();
        timeMap = new HashMap<>();
        timeMap.put("minute", 60);
        timeMap.put("hour", 3600);
        timeMap.put("day", 86400);
    }
    //It is possible there are several tweets show up at the same time
    public void recordTweet(String tweetName, int time) {
        tweets.putIfAbsent(tweetName, new TreeMap<>());
        TreeMap<Integer, Integer> treemap = tweets.get(tweetName);
        treemap.put(time, treemap.getOrDefault(time, 0)+1);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> results = new ArrayList<>();
        if(!tweets.containsKey(tweetName)) return results;

        int timeGap = timeMap.get(freq);
        TreeMap<Integer, Integer> treemap = tweets.get(tweetName);
        int newStart = startTime;
        while(newStart <= endTime){
            int sum = 0;
            int end = Math.min(newStart+timeGap, endTime+1);
            Map<Integer, Integer> subMap = treemap.subMap(newStart, true, end, false);
            for(int val : subMap.values()){
                sum += val;
            }
            results.add(sum);
            newStart += timeGap;
        }
        return results;
    }
}
