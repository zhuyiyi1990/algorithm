package com.github.zhuyiyi1990.algorithm.leetcode.problem3;

import java.util.Arrays;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int maxLength = 0;
        int r = 0;
        int currentLength;
        int[] table = new int[128];
        Arrays.fill(table, -1);
        while (r < chars.length) {
            do {
                table[chars[r]] = r;
                r++;
            } while (r < chars.length && table[chars[r]] == -1);
            currentLength = r - l;
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
            if (r < chars.length) {
                int temp = l;
                l = table[chars[r]] + 1;
                for (int i = temp; i < l; i++) {
                    table[chars[i]] = -1;
                }
            }
        }
        return maxLength;
    }
}

public class MyMain {

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }

}
