package com.github.zhuyiyi1990.algorithm.leetcode.problem0278;

public class VersionControl {

    private int firstBadVersion;

    public VersionControl(int firstBadVersion) {
        this.firstBadVersion = firstBadVersion;
    }

    public boolean isBadVersion(int version) {
        return version >= firstBadVersion;
    }

}