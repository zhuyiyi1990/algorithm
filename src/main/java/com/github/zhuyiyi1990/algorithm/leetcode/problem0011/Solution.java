package com.github.zhuyiyi1990.algorithm.leetcode.problem0011;

public class Solution {

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            if (height[i] <= height[j]) {
                max = Math.max(max, (j - i) * height[i]);
                i++;
            } else {
                max = Math.max(max, (j - i) * height[j]);
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution.maxArea(height1));
        int[] height2 = {1, 1};
        System.out.println(solution.maxArea(height2));
    }

}