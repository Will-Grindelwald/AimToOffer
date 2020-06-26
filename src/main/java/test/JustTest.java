package test;

import java.util.HashSet;
import java.util.Set;

public class JustTest {

    public static void main(String[] args) {
        //        Object t = new StringBuffer();
        //        System.out.println(t.getClass().getName());
        //        Optional.ofNullable(null);
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }
}

class Solution {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        if (chars.length < 1) {
            return 0;
        }
        int max = 1, lenth = 1, i = 0, j = 1;
        Set<Character> charSet = new HashSet<>();
        charSet.add(chars[0]);
        while (j < chars.length) {
            if (charSet.add(chars[j])) {
                lenth++;
                max = Math.max(max, lenth);
            } else {
                while (i < j) {
                    if (chars[i] == chars[j]) {
                        i++;
                        lenth = j - i + 1;
                        break;
                    } else {
                        charSet.remove(chars[i]);
                        i++;
                    }
                }
            }
            j++;
        }
        return max;
    }
}