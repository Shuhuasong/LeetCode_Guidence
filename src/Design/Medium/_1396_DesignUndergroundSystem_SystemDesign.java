package Design.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Shuhua Song
 */
/*
Note in the interview:
in a real interview, you should expect to discuss real-world issues related to it
(1) we need to store the data in a permanent datatbase, when computer fail(lose power), the data will lost;
(2) When the data is large, so we need to use several computer to store the data. then this will introduce concurrency issues that need to be addressed.
Solution #1 - using HashMap
checkInTimes = new HashMap (id -> checkInTime)
checkInStations = new HashMap (id -> stationName)
journeyTotals = new HashMap (startStation, endStation --> total)
numberOfJourney = new HashMap (startStation, endStation --> count)
Solution # -- two level of HashMap
checkInData  = new HashMap (id --> startStation, checkInTime)
journeyData = new HashMap (startStation, endStation --> total, count)
*/

public class _1396_DesignUndergroundSystem_SystemDesign {

    HashMap<Integer, String> idToStation = new HashMap<>();
    HashMap<Integer, Integer> idToStartTime = new HashMap<>();
    HashMap<String, Integer> journeyToTotal = new HashMap<>();
    HashMap<String, Integer> journeyToCount = new HashMap<>();
    public _1396_DesignUndergroundSystem_SystemDesign() {

    }

    public void checkIn(int id, String stationName, int t) {
        idToStation.put(id, stationName);
        idToStartTime.put(id, t);
    }

    public void checkOut(int id, String stationName, int t) {
        String startStation = idToStation.get(id);
        int startTime = idToStartTime.get(id);
        String journey = getJourney(startStation, stationName);
        int time = t - startTime;
        journeyToTotal.put(journey, journeyToTotal.getOrDefault(journey, 0)+time);
        journeyToCount.put(journey, journeyToCount.getOrDefault(journey, 0) + 1);
    }

    public double getAverageTime(String startStation, String endStation) {
        String journey = getJourney(startStation, endStation);
        int total = journeyToTotal.get(journey);
        int count = journeyToCount.get(journey);
        return total*1.0/count;
    }

    public String getJourney(String s1, String s2){
        return s1+ "->" +s2;
    }
 /*
    HashMap<Integer, String> idToStation = new HashMap<>();
    HashMap<Integer, Integer> idToStartTime = new HashMap<>();
    HashMap<String, List<Integer>> journeyToStation = new HashMap<>();

    public _1396_DesignUndergroundSystem_SystemDesign() {

    }

    public void checkIn(int id, String stationName, int t) {
        idToStation.put(id, stationName);
        idToStartTime.put(id, t);
    }

    public void checkOut(int id, String stationName, int t) {
        String startStation = idToStation.get(id);
        int startTime = idToStartTime.get(id);
        String journey = getJourney(startStation, stationName);
        if(!journeyToStation.containsKey(journey)){
            journeyToStation.put(journey, new ArrayList<>());
        }
        List<Integer> list = journeyToStation.get(journey);
        list.add(t-startTime);
        idToStartTime.remove(id);
        journeyToStation.put(journey, list);
    }

    public double getAverageTime(String startStation, String endStation) {
        String journey = getJourney(startStation, endStation);
        int total = 0;
        List<Integer> list = journeyToStation.get(journey);
        for(int a : list){
            total += a;
        }
        System.out.println(total + " " + list.size());
        return total*1.0/list.size();
    }

    public String getJourney(String s1, String s2){
        return s1+ "->" +s2;
    } */
}
