package OnlineCodingChallege.Amazon;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Shuhua Song
 */
public class _937_ReOrderDataInLogFiles {

    public String[] reorderLogFiles(String[] logs) {

            Comparator<String> myComp = new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    //split each log into two parts : <identifier, content>
                    String[] strs1 = s1.split(" ", 2);
                    String[] strs2 = s2.split(" ", 2);

                    boolean isDigit1 = Character.isDigit(strs1[1].charAt(0));
                    boolean isDigit2 = Character.isDigit(strs2[1].charAt(0));
                    //case 1: both logs are letter logs
                    if (!isDigit1 && !isDigit2) {
                        //first compare the content
                        int comp = strs1[1].compareTo(strs2[1]);
                        if (comp != 0) {
                            return comp;
                        }
                        //logs of same content, compare the identifiers
                        return strs1[0].compareTo(strs2[0]);
                    }
                    //case 2 : one of logs is digit-log
                    //log1==letter log, log2 = digit log
                    if (!isDigit1 && isDigit2) {
                        //the letter-log comes before digit-log
                        //we want to order in this way: log1 log2
                        //want to make log1 as s2, so s1 < s2==-1
                        return -1;
                    } else if (isDigit1 && !isDigit2) {
                        //log1 = digit, log2 = letter
                        //if we want to order in this way : log2 log1
                        //we want to push log1 in the bottom
                        //we consider log2 > log1, so ==>return 1, elem1 > element 1
                        return 1;
                    } else {
                        //case3 : both logs are digit-log
                        return 0;
                    }
                }
            };
            Arrays.sort(logs, myComp);
            return logs;
        }

}

/*
int compare(T o1, T o2){
    if(o1 < o2){
        return -1;
    }else if(o1==o2){
        return 0;
    }else{
        return 1;
    }
} */
