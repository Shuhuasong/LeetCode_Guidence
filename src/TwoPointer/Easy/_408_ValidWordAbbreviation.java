package TwoPointer.Easy;

/**
 * Created by Shuhua Song
 */
public class _408_ValidWordAbbreviation {

    public boolean validWordAbbreviation(String word, String abbr) {
        int n1 = word.length(), n2 = abbr.length();
        int p1 = 0, p2 = 0;
        while(p1 < n1 && p2 < n2){
            if(Character.isLetter(abbr.charAt(p2))){
                if(word.charAt(p1)==abbr.charAt(p2)){
                    p1++;
                    p2++;
                }else{
                    return false;
                }
            }else if(Character.isDigit(abbr.charAt(p2))){
                //No leading zero
                if(abbr.charAt(p2)=='0'){
                    return false;
                }
                int val = 0;
                while(p2 < n2 && Character.isDigit(abbr.charAt(p2))){
                    val = val * 10 + abbr.charAt(p2)-'0';
                    p2++;
                }
                p1 += val;
            }
        }
        return p1==n1 && p2==n2;
    }
}


/*
val = 2, p1 = 1, p2 = 2
p2 = 3
"apple"
    |
"a2e"

"i n  ternationalization"
   p1
"i 1  2 iz4n"
   p2

*/