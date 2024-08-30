package com.github.zhuyiyi1990.algorithm.leetcode.problem0006;

// https://leetcode.com/problems/zigzag-conversion/
public class Solution {

    public String convert(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }
        int v = 1;
        int index = 0;
        char[] sca = s.toCharArray();
        for (int i = 0; i < sca.length; i++) {
            sbs[index].append(sca[i]);
            if (numRows > 1) {
                if (v > 0) {
                    if (index == numRows - 1) {
                        v = -1;
                    }
                    index = index + v;
                } else {
                    if (index == 0) {
                        v = 1;
                    }
                    index = index + v;
                }
            }
        }
        for (int i = 1; i < sbs.length; i++) {
            sbs[0].append(sbs[i]);
        }
        return sbs[0].toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.convert("PAYPALISHIRING", 3);
        System.out.println(result);
        result = solution.convert("PAYPALISHIRING", 4);
        System.out.println(result);
        result = solution.convert("A", 1);
        System.out.println(result);
        result = solution.convert("AB", 1);
        System.out.println(result);
    }

}