package com.github.zhuyiyi1990.algorithm.leetcode;

public class ListNode {

    int val;

    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current1 = l1;
        ListNode current2 = l2;
        ListNode root = new ListNode();
        ListNode cursor = root;
        int sum = 0;
        int remain = 0;
        while (current1 != null && current2 != null) {
            sum = (current1.val + current2.val + remain) % 10;
            remain = (current1.val + current2.val + remain) / 10;
            cursor.next = new ListNode(sum);
            cursor = cursor.next;
            current1 = current1.next;
            current2 = current2.next;
        }
        while (current1 != null) {
            sum = (current1.val + remain) % 10;
            remain = (current1.val + remain) / 10;
            cursor.next = new ListNode(sum);
            cursor = cursor.next;
            current1 = current1.next;
        }
        while (current2 != null) {
            sum = (current2.val + remain) % 10;
            remain = (current2.val + remain) / 10;
            cursor.next = new ListNode(sum);
            cursor = cursor.next;
            current2 = current2.next;
        }
        if (remain != 0) {
            cursor.next = new ListNode(remain);
            cursor = cursor.next;
        }
        return root.next;
    }

}