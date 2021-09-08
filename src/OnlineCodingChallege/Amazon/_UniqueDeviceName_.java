package OnlineCodingChallege.Amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
/*
leetCode--1487
 */
public class _UniqueDeviceName_ {

    private static String[] getFileUniqueFileName(int n, String[] fileNames){
        Map<String, Integer> map = new HashMap<>();
        Set<String> seen = new HashSet<>();
        String[] results = new String[fileNames.length];
        for(int i=0; i<fileNames.length; i++){
            String file = fileNames[i];
            if(!seen.contains(file)){
                seen.add(file);
                map.put(file, 1);
                results[i] = file;
            }else{
                int k = map.getOrDefault(file, 1);
                String newStr = file + k;
                while(seen.contains(newStr)){
                    k++;
                    newStr = file + k;
                }
                seen.add(newStr);
                results[i] = newStr;
                map.put(file, map.getOrDefault(file,0)+1);
            }
        }
        for(String key : map.keySet()){
            System.out.println(key + " " + map.get(key));
        }
        return results;
    }
    public static void main(String[] args) {
          String[] fileNames1 = {"system", "access", "access", "system", "access", "system"};
          String[] results1 = getFileUniqueFileName(6, fileNames1);

          for(String s : results1){
              System.out.print(s + " ");
          }
          System.out.println();
          String[] fileNames2 = {"ref", "ref", "ref", "gcd", "gcd", "gcd", "gcd2", "gcd3"};
          String[] results2 = getFileUniqueFileName(6, fileNames2);
          for(String s : results2){
              System.out.print(s + " ");
          }
    }
}
