package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class S3 {
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> charCounts = new HashMap<>();
        int subStrMaxLen = 0;
        int l = 0;
        int r = 0;

        while (r < s.length()) {
            char currentChar = s.charAt(r);
            int curCharCount = charCounts.getOrDefault(currentChar, 0);
            charCounts.put(currentChar, curCharCount + 1);

            while (charCounts.get(currentChar) > 1) {
                char leftChar = s.charAt(l);
                charCounts.put(leftChar, charCounts.get(leftChar) - 1);
                l++;
            }
            subStrMaxLen = Math.max(subStrMaxLen, r - l + 1);

            r++;

        }
        return subStrMaxLen;
    }
}
