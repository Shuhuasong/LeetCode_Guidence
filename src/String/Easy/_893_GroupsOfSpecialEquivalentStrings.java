package String.Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _893_GroupsOfSpecialEquivalentStrings {

    public int numSpecialEquivGroups(String[] A) {
        Set<String> seen = new HashSet<>();
        for(String s : A){
            int[] count = new int[52]; //0-25: for even indexed character
            //26-55: for odd indexed character
            for(int i=0; i<s.length(); i++){
                count[s.charAt(i)-'a' + 26 * (i % 2)]++; //26 * (i % 2) returns 0 if even and 26 if odd
            }
            seen.add(Arrays.toString(count));
        }
        return seen.size();
    }
}

/*
for example ["abcd","cdab","cbad","xyzz","zzxy","zzyx"]
abcd -> ac, bd
cdab -> ca, db -> ac, bd (sorted)
cbad -> ca, bd -> ac, bd (sorted)
xyzz -> xz, yz
zzxy -> zx, zy -> xz, yz (sorted)
zzyx -> zy, zx -> yz, xz (sorted)
*/
