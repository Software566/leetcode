import java.util.*;

class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // Build frequency map for t
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Sliding window
        HashMap<Character, Integer> window = new HashMap<>();

        int required = map.size();
        int formed = 0;

        int left = 0;
        int start = 0;
        int minlen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            // Add character to current window
            window.put(c, window.getOrDefault(c, 0) + 1);

            // Check if a required character is completely satisfied
            if (map.containsKey(c)
                    && window.get(c).intValue() == map.get(c).intValue()) {

                formed++;
            }

            // Shrink window while it is valid
            while (left <= right && formed == required) {

                // Update minimum window
                if (right - left + 1 < minlen) {
                    minlen = right - left + 1;
                    start = left;
                }

                // Remove left character
                char leftchar = s.charAt(left);

                window.put(leftchar, window.get(leftchar) - 1);

                // Check if removing it made window invalid
                if (map.containsKey(leftchar)
                        && window.get(leftchar) < map.get(leftchar)) {

                    formed--;
                }

                left++;
            }
        }

        // No valid window found
        if (minlen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minlen);
    }
}