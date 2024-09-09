package com.github.zhuyiyi1990.algorithm.leetcode.problem0009;

public class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int back = 0;
        int i = x;
        while (i > 0) {
            back = back * 10 + i % 10;
            i /= 10;
        }
        return x == back;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(-121));
        System.out.println(solution.isPalindrome(10));
    }

}