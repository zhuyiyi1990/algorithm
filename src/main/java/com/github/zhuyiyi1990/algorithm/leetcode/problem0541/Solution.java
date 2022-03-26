package com.github.zhuyiyi1990.algorithm.leetcode.problem0541;

//https://leetcode.com/problems/reverse-string-ii/
public class Solution {

    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i = i + 2 * k) {
            int left = i;
            int right = Math.min(i + k - 1, str.length - 1);
            System.out.println("i=" + i);
            System.out.println("left=" + left);
            System.out.println("right=" + right);
            for (int j = 0; j <= (right - left) / 2 && left + j < str.length; j++) {
                System.out.println("j=" + j);
                System.out.println((left + j) + "<->" + (right - j));
                char t = str[left + j];
                str[left + j] = str[right - j];
                str[right - j] = t;
            }
        }
        return new String(str);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseStr("abcdefg", 2));
//        System.out.println(new Solution().reverseStr("abcd", 2));
//        System.out.println(new Solution().reverseStr("abcd", 4));
//        System.out.println(new Solution().reverseStr("abcdefg", 8));
//        System.out.println(new Solution().reverseStr("abcdefg", 1213));
    }

}