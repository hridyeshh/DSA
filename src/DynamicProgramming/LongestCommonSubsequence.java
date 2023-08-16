package DynamicProgramming;
import java.util.*;
public class LongestCommonSubsequence {

    // Memorisation solution
    public static int lcsMemorisation(String s1, String s2, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + lcsMemorisation(s1, s2, i - 1, j - 1, dp);
        } else {
            return dp[i][j] =
                    Math.max(lcsMemorisation(s1, s2, i - 1, j, dp), lcsMemorisation(s1, s2, i, j - 1, dp));
        }
    }

    // Space Optimised solution

    public static int lcsOptimised(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[] prev = new int[n + 1];
        int[] cur = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    cur[j] = 1 + prev[j - 1];
                } else {
                    cur[j] = Math.max(prev[j], cur[j - 1]);
                }
                prev = cur;
            }
        }
        return prev[m];
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];
        Arrays.stream(dp).forEach(A -> Arrays.fill(A, -1));
        // shifting of index
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public static String findLCS(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        Arrays.stream(dp).forEach(A -> Arrays.fill(A, -1));
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int length = dp[n][m]; // length of the longest subsequence
        int i = n, j = m;
        int index = length - 1;
        String a = "";
        for (int k = 1; k <= length; k++) {
            a += " ";
        }
        StringBuilder s = new StringBuilder(s1);
        StringBuilder t = new StringBuilder(a);
        while (i > 0 && j > 0) {
            if (s.charAt(i - 1) == s2.charAt(j - 1)) {
                t.setCharAt(index, s.charAt(i - 1));
                index--;
                i--;
                j--;
            } else if (s.charAt(i - 1) > s2.charAt(j - 1)) {
                i--;
            } else j--;
        }
        return t.toString();
    }

    public static int lcs(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        int length = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    length = Math.max(length, dp[i][j]);
                } else dp[i][j] = 0;
            }
        }
        return length;
    }

    public static int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n+1][n+1];
        int count = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }
        for (int i = 0; i < n-1 ; i++) {
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                count++;
            }
        }
        for (int len = 3; len <= n ; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        // substring of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int start = 0;
        int maxLength = 1;
        // substring of length 2
        for (int i = 0; i < n-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                maxLength = 2;
            }
        }
        // substring of length 3
        for (int len = 3; len <= n ; len++) {
            for (int i = 0; i < n-len+1; i++) {
                int j  = i + len - 1; // ending index of the substring
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    if(len > maxLength){
                        start = i;
                        maxLength = len;
                    }
                }
            }
        }
        return s.substring(start, start + maxLength);
    }

    public static int minInsertions(String s) {
        return s.length() - longestPalindromeSequence(s);
    }
    public static int longestPalindromeSequence(String s){
        StringBuilder str = new StringBuilder(s);
        str.reverse().toString();
        int n = s.length();
        int m = str.length();
        int[][] dp = new int[n+1][m+1];
        Arrays.stream(dp).forEach(A -> Arrays.fill(A, -1));
        for(int i = 0; i <=n; i++){
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= m; j++) {
                if(s.charAt(i-1) == str.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        final int m = nums1.length;
        final int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i)
            for (int j = 1; j <= n; ++j)
                dp[i][j] = nums1[i - 1] == nums2[j - 1] ? dp[i - 1][j - 1] + 1
                        : Math.max(dp[i - 1][j], dp[i][j - 1]);

        return dp[m][n];
    }

    public static int minDistance(String word1, String word2) {
        return (word1.length() - lcsOptimised(word1,word2)) + (word2.length() - lcsOptimised(word1, word2));
    }

    public static String shortestCommonSuperSequence(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n ; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int len = dp[n][m];
        int i = n, j = m;
        int index = len-1;
        String ans = "";
        while(i > 0 && j > 0){
            if(a.charAt(i-1) == b.charAt(j-1)){
                ans += a.charAt(i-1);
                index--;
                i--;
                j--;
            }
            else if (dp[i][j - 1] > dp[i - 1][j]) {
                ans += b.charAt(j - 1);
                j--;
            } else {
                ans += a.charAt(i - 1);
                i--;
            }

        }
        while(i > 0) {
            ans += a.charAt(i-1);
            i--;
        }
        while(j > 0){
            ans += b.charAt(j-1);
            j--;
        }
        StringBuilder t = new StringBuilder(ans);
        return t.reverse().toString();
    }

    public static int minDistanceOther(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n ; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m ; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                if(word1.charAt(i-1) != word2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
//        System.out.println(minDistanceOther("intention", "execution"));
        System.out.println(longestCommonSubsequence("execution", "intention"));
    }
}