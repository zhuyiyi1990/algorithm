package com.github.zhuyiyi1990.algorithm.leetcode.problem0905;

import java.util.Arrays;

//https://leetcode.com/problems/sort-array-by-parity/
public class Solution {

    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < nums.length && nums[left] % 2 == 0) {
                left++;
            }
            while (right >= 0 && nums[right] % 2 == 1) {
                right--;
            }
            if (left < right && nums[left] % 2 == 1 && nums[right] % 2 == 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};
        System.out.println(Arrays.toString(new Solution().sortArrayByParity(nums)));
        int[] nums2 = {0};
        System.out.println(Arrays.toString(new Solution().sortArrayByParity(nums2)));
        int[] nums3 = {0, 1};
        System.out.println(Arrays.toString(new Solution().sortArrayByParity(nums3)));
    }

}