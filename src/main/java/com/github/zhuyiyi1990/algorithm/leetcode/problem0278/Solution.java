package com.github.zhuyiyi1990.algorithm.leetcode.problem0278;

//https://leetcode.com/problems/first-bad-version/
public class Solution extends VersionControl {

    public Solution(int firstBadVersion) {
        super(firstBadVersion);
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int m = 0;
        int ans = 0;
        while (left <= right) {
            m = left + ((right - left) >> 1);
            if (isBadVersion(m)) {
                right = m - 1;
                ans = m;
            } else {
                left = m + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 2126753390;
        int bad = 1702766719;
        System.out.println(new Solution(bad).firstBadVersion(n));
    }

}