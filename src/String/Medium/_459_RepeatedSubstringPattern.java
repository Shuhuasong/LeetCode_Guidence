package String.Medium;

public class _459_RepeatedSubstringPattern {

    //Time = O(n)  Space = O(n)
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] dp = new int[n];
        // Construct partial match table (lookup table).
        // It stores the length of the proper prefix that is also a proper suffix.
        // ex. ababa --> [0, 0, 1, 2, 1]
        // ab --> the length of common prefix / suffix = 0
        // aba --> the length of common prefix / suffix = 1
        // abab --> the length of common prefix / suffix = 2
        // ababa --> the length of common prefix / suffix = 1
        for (int i = 1; i < n; ++i) {
            int j = dp[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = dp[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                ++j;
            }
            dp[i] = j;
        }

        int l = dp[n - 1];
        // check if it's repeated pattern string
        return l != 0 && n % (n - l) == 0;
    }
}
