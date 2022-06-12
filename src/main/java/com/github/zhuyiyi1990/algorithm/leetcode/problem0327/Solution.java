package com.github.zhuyiyi1990.algorithm.leetcode.problem0327;

//https://leetcode.cn/problems/count-of-range-sum/
public class Solution {

    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        int left = 0;
        int right = sums.length - 1;
        return count(sums, left, right, lower, upper);
    }

    private int count(long[] sums, int left, int right, int lower, int upper) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            if (lower <= sums[right] && sums[right] <= upper) {
                return 1;
            } else {
                return 0;
            }
        }
        int middle = left + ((right - left) >> 1);
        /*int result1 = count(sums, left, middle, lower, upper);
        int result2 = count(sums, middle + 1, right, lower, upper);
        int result3 = merge(sums, left, middle, right, lower, upper);
        return result1 + result2 + result3;*/
        return count(sums, left, middle, lower, upper) + count(sums, middle + 1, right, lower, upper) + merge(sums, left, middle, right, lower, upper);
    }

    private int merge(long[] sums, int left, int middle, int right, int lower, int upper) {
        int windowL = left;
        int windowR = left;
        int result = 0;
        for (int i = middle + 1; i <= right; i++) {
            long lowerBound = sums[i] - upper;
            long upperBound = sums[i] - lower;
            while (windowL <= middle && sums[windowL] < lowerBound) {
                windowL++;
            }
            while (windowR <= middle && sums[windowR] <= upperBound) {
                windowR++;
            }
            result += Math.max(0, windowR - windowL);
        }
        long[] help = new long[right - left + 1];
        int i = left, j = middle + 1, current = 0;
        while (i <= middle && j <= right) {
            if (sums[i] <= sums[j]) {
                help[current++] = sums[i];
                i++;
            } else {
                help[current++] = sums[j];
                j++;
            }
        }
        while (i <= middle) {
            help[current++] = sums[i];
            i++;
        }
        while (j <= right) {
            help[current++] = sums[j];
            j++;
        }
        for (i = 0; i < help.length; i++) {
            sums[left + i] = help[i];
        }
        return result;
    }

    public static void main(String[] args) {
        /*int[] nums = {-2, 5, -1};
        int lower = -2;
        int upper = 2;*/
        /*int[] nums = {0};
        int lower = 0;
        int upper = 0;*/
        /*int[] nums = {-3, 1, 2, -2, 2, -1};
        int lower = -3;
        int upper = -1;*/
        /*int[] nums = {2147483647, -2147483648, -1, 0};
        int lower = -1;
        int upper = 0;*/
        int[] nums = {-2147483647, 0, -2147483647, 2147483647};
        int lower = -564;
        int upper = 3864;
        System.out.println(new Solution().countRangeSum(nums, lower, upper));
    }

}