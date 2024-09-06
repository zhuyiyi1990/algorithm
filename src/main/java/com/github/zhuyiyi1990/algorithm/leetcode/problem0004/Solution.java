package com.github.zhuyiyi1990.algorithm.leetcode.problem0004;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int num = m + n;
        int start;
        if (num % 2 == 0) {
            start = num / 2 - 1;
        } else {
            start = num / 2;
        }
        int result = 0;
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < num; i++) {
            if (i >= start) {
                if (i1 < nums1.length && i2 < nums2.length) {
                    result = result + Math.min(nums1[i1], nums2[i2]);
                } else if (i1 >= nums1.length) {
                    result = result + nums2[i2];
                } else {
                    result = result + nums1[i1];
                }
                if (num % 2 != 0) {
                    return result;
                } else if (i > start) {
                    return result / 2.0;
                }
            }
            if (i1 >= nums1.length) {
                i2++;
            } else if (i2 >= nums2.length) {
                i1++;
            } else if (nums1[i1] <= nums2[i2]) {
                i1++;
            } else {
                i2++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        Solution solution = new Solution();
        double result = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

}