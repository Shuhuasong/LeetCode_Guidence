package String.Medium;

/**
 * Created by Shuhua Song
 */
public class _2063_VowelsOfAllSubstrings {

    public long countVowels(String word) {
        long res = 0, n = word.length();
        for(int i=0; i<n; i++){
            char c = word.charAt(i);
            if("aeiou".indexOf(c) >= 0){
                res += (long)(i+1) * (n-i);
            }
        }
        return res;
    }
}

/*
for each vowel s[i],
it can form the substring start from s[x] and ending at s[y]
while 0 <= x <= i and i<=y < n
then there (i+1) choice for (n-i) choice for y
so there are (i+1) * (n-i) substrings containing s[i]
*/
