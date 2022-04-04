package com.github.zhuyiyi1990.algorithm.leetcode.problem1721;

import java.awt.print.Printable;

//https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
public class Solution {

    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = null;
        ListNode pre_first = null;
        ListNode second = null;
        ListNode pre_second = null;
        int i = 0;
        ListNode cursor = head;
        while (cursor != null) {
            i++;
            if (i <= k) {
                pre_first = first;
                first = cursor;
            }
            if (i == k) {
                pre_second = second;
                second = head;
            } else if (i > k) {
                pre_second = second;
                second = second.next;
            }
            cursor = cursor.next;
        }
        System.out.println("pre_first:" + (pre_first == null ? null : pre_first.val));
        System.out.println("first:" + (first == null ? null : first.val));
        System.out.println("pre_second:" + (pre_second == null ? null : pre_second.val));
        System.out.println("second:" + (second == null ? null : second.val));
        if (pre_first == null) {
            second.next = first.next;
            pre_second.next = first;
            first.next = null;
            return second;
        } else if (pre_second == null) {
            first.next = second.next;
            pre_first.next = second;
            second.next = null;
            return first;
        } else {
            ListNode temp = first.next;
            first.next = second.next;
            second.next = temp;
            pre_first.next = second;
            pre_second.next = first;
            return head;
        }
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        print(head);
        head = new Solution().swapNodes(head, 2);
//        head = new Solution().swapNodes(head, 1);
//        head = new Solution().swapNodes(head, 5);
        print(head);
        head = new ListNode(7);
        head.next = new ListNode(9);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(5);
        print(head);
        head = new Solution().swapNodes(head, 5);
        //TODO
        print(head);
    }

}