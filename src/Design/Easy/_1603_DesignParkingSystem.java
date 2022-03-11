package Design.Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _1603_DesignParkingSystem {
    Map<Integer, Integer> count;
    public _1603_DesignParkingSystem(int big, int medium, int small) {
        count = new HashMap<>();
        count.put(1, big);
        count.put(2, medium);
        count.put(3, small);
    }

    public boolean addCar(int carType) {
        if(count.getOrDefault(carType, 0) <= 0){
            return false;
        }else{
            count.put(carType, count.get(carType)-1);
            return true;
        }
    }
}
