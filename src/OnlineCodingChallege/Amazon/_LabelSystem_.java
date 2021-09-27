package OnlineCodingChallege.Amazon;

/**
 * Created by Shuhua Song
 */
/*
Given a string, construct a new string by rearranging the original string and deleting characters as needed.
Return the alphabetically largest string that can be constructed respecting a limit as to how many consecutive
characters can be the same.

Example:
s='bacc'
k=2

The largest string, alphabetically, is 'cccba' but it is not allowed because it uses the character 'c' more than
2 times consecutively. Therefore, the answer is 'ccbca'.

Function Description
Complete the function getLargestString in the editor below.

getLargestString has the following parameters:
string s[n]: the original string
int k: the maximum number of identical consecutive characters the new string can have

Returns:
string: the alphabetically largest string that can be constructed that has no more than k identical consecutive characters

Constraints

1<= n <= 10^5
1<= k <= 10^3
The string s contains only lowercase English letters.
Input Format For Custom Testing
Sample Case 0
Sample Input
STDIN Function

zzzazz --> string s = 'zzzazz'
2 --> k = 2

Sample Output
zzazz

Explanation
One 'z' must be removed so that no more than 2 consecutive characters are the same.
 */
public class _LabelSystem_ {

    public static String getLargestString(String origin, int k) {
        int[] board = new int[26];
        for(char c : origin.toCharArray()) {
            board[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int index = 25;
        int lastCount = 0;
        while(index >= 0) {
            if(board[index] == 0) {
                index--;
                lastCount = 0;
                continue;
            }
            if(lastCount < k) {
                sb.append((char)('a'+index));
                lastCount++;
                board[index]--;
            } else {
                for(int i=index-1; i>=0; i--) {
                    if(board[i] > 0) {
                        sb.append((char)('a'+i));
                        board[i]--;
                        lastCount = 0;
                        break;
                    }
                }
                if(lastCount != 0) {
                    break;
                }
            }
        }
        return sb.toString();
    }
    /*
    private static String largestString(String s, int k) {
	char[] chs = s.toCharArray();
	HashMap<Character, Integer> map = new HashMap<>();
	StringBuilder sb = new StringBuilder();

	for (char ch : chs) {
		map.put(ch, map.getOrDefault(ch, 0) + 1);
	}

	Set<Entry<Character, Integer>> set = map.entrySet();
	ArrayList<Entry<Character, Integer>> list = new ArrayList<>(set);
	Collections.sort(list, (a, b) -> (b.getKey().compareTo(a.getKey())));

	int i = 0;
	while (i < list.size()) {
		Entry<Character, Integer> firstEntry = list.get(i);
		char firstKey = firstEntry.getKey();
		int firstVal = firstEntry.getValue();

		if (firstVal > k) {
			// reduce by k
			int count = 0;
			while (count < k) {
				sb.append(firstKey);
				count++;
			}
			firstEntry.setValue(firstVal - k);

			// Just add 1 next character
			Entry<Character, Integer> secondEntry = list.get(i + 1);
			char secondKey = secondEntry.getKey();
			int secondVal = secondEntry.getValue();

			if (secondVal > 0) {
				sb.append(secondKey);
				secondEntry.setValue(secondVal - 1);
			}
		} else if (firstVal > 0 && firstVal <= k) {
			int count = 0;
			while (count < firstVal) {
				sb.append(firstKey);
				count++;
			}
			firstEntry.setValue(0);
		} else {// firstVal == 0
			i++;
		}
	}

	return sb.toString();
}

     */

    public static void main(String[] args) {
        String original = "zzzazz";
        System.out.println(getLargestString(original, 2));
    }
}
