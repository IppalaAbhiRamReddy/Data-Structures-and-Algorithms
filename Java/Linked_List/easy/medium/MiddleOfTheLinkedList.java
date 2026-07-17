package Java.Linked_List.easy.medium;

// Problem Link: https://leetcode.com/problems/middle-of-the-linked-list/

import java.util.*;

public class MiddleOfTheLinkedList {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /*
    Problem:
    Given the head of a singly linked list, return the middle node.

    If there are two middle nodes, return the second middle node.

    Example 1:
    Input:
    1 2 3 4 5

    Output:
    3 4 5

    Example 2:
    Input:
    1 2 3 4 5 6

    Output:
    4 5 6
    */

    // ==========================================================
    // Approach: Slow and Fast Pointers (Tortoise and Hare)
    // ==========================================================
    // Time Complexity : O(N)
    // Space Complexity: O(1)
    //
    // Move:
    // - slow pointer one step.
    // - fast pointer two steps.
    //
    // When fast reaches the end,
    // slow will be at the middle node.
    //
    // If the list has an even number of nodes,
    // the second middle node is returned.
    // ==========================================================

    public static ListNode middleNode(ListNode head) {

        ListNode slowp = head;
        ListNode fastp = head;

        while (fastp != null && fastp.next != null) {
            slowp = slowp.next;
            fastp = fastp.next.next;
        }

        return slowp;
    }

    // Print linked list from a given node
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Build linked list from array
    public static ListNode buildList(int[] arr) {

        if (arr.length == 0)
            return null;

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;

        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }

        return head;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the node values:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        ListNode head = buildList(arr);

        System.out.print("Original List: ");
        printList(head);

        ListNode middle = middleNode(head);

        System.out.print("Middle Node onwards: ");
        printList(middle);

        sc.close();
    }
}
