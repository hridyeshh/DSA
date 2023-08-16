package String;
import java.util.*;
import java.util.stream.*;

public class Problems {
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s).reverse();
        reverseWords(sb, sb.length());
        return cleanSpaces(sb, sb.length());
    }

    // function to reverse the words
    private static void reverseWords(StringBuilder sb, int n) {
        int i = 0;
        int j = 0;
        while (i < n) {
            while (i < j || i < n && sb.charAt(i) == ' ') // Skip spaces
                ++i;
            while (j < i || j < n && sb.charAt(j) != ' ') // Skip non spaces
                ++j;
            reverse(sb, i, j - 1); // Reverse the word
        }
    }

    // Trim leading, trailing, and middle spaces
    private static String cleanSpaces(StringBuilder sb, int n) {
        int i = 0;
        int j = 0;

        while (j < n) {
            while (j < n && sb.charAt(j) == ' ') // Skip spaces
                ++j;
            while (j < n && sb.charAt(j) != ' ') // Keep non spaces
                sb.setCharAt(i++, sb.charAt(j++));
            while (j < n && sb.charAt(j) == ' ') // Skip spaces
                ++j;
            if (j < n) // Keep only one space
                sb.setCharAt(i++, ' ');
        }
        // by now we have the string with all the extra spaces at the end e.g "hello world__"

        return sb.substring(0, i); // space cleaned substring
    }

    private static void reverse(StringBuilder sb, int l, int r) {
        while (l < r) {
            final char temp = sb.charAt(l);
            sb.setCharAt(l++, sb.charAt(r));
            sb.setCharAt(r--, temp);
        }
    }

    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (int num : nums) {
            if (set.contains(num - 1))
                continue;
            int length = 1;
            while (set.contains(++num))
                length++;
            ans = Math.max(ans, length);
        }
        return ans;
    }

        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            boolean[] seen = new boolean[rooms.size()];
            seen[0] = true; // room 0 is already unlocked so we can access this room
            Stack<Integer> keys = new Stack(); // to store the keys
            keys.add(0); // same reason
            while (!keys.isEmpty()) {
                for (int check : rooms.get(keys.pop())) {
                    if (!seen[check]) {
                        seen[check] = true;
                        keys.add(check);
                    }
                }
            }
            for (boolean visited : seen) {
                if (!visited) return false;
            }
            return true;
        }


    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }
}
