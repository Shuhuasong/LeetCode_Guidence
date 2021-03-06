package Prefix_Sum.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _1371_FindTheLongestSubstringContainingVowelsInEvenCounts {
    public int findTheLongestSubstring(String s) {
        int mark = 0;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('e');
        vowels.add('i'); vowels.add('o');
        vowels.add('u');
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(vowels.contains(c)){
                int shift = c-'a';
                mark ^= (1 << shift);
            }
            if(map.containsKey(mark)){
                res = Math.max(res, i-map.get(mark));
            }else{
                map.put(mark, i);
            }
        }
        return res;
    }
}
/*
本题是prefix+Hash+状压的综合考察。

本题要求寻找最长substring，使得其中元音字母的频次是偶数。对于一个区间内的频次，我们必然不会挨个去统计，
通常会采用前缀数组的方法。这样就转化为了减法：freq[i:j] = preFreq[j]-preFreq[i-1].

我们考察以第j个元素结尾的、最长的符合要求的子串。那么如何确定这个子串的左边界i呢？假设我们只关心一个字母a，
我们希望[i:j]区间内该字母频次是偶数，必然要求该字母的preFreq[j]和preFreq[i-1]的奇偶性要相同。目前我们对
preFreq[j]是已知的（假设是奇数），所以只要知道最小的i使得preFreq[i-1]是偶数即可。于是我们可以建立一个hash表，
在遍历j的过程中，存下最早出现奇数次preFreq的位置j即可。

本题要求区间内五个元音字母的频次都是偶数，所以我们可以用5个bit组成的二进制数来编码，来代表preFreq[j]里五个
字母频次的奇偶性。比如说我们遍历到j时，preFreq[j]对应的key=00100，就表示前j个元素里，字母i出现了奇数次而其他
元音字母出现了偶数次。此时我们只要查看Map里是否之前曾经出现过这个相同的key，有的话，那么最长区间的左端点就是
i = Map[key]+1，而区间长度就是j-Map[key]. 考察完j之后，如果key未曾被加入过Map中，则要记录Map[key] = j.
 */
