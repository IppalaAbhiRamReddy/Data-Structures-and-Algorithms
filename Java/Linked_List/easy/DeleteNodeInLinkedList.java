package Java.Linked_List.easy;
// Problem Link: https://leetcode.com/problems/delete-node-in-a-linked-list/

/*
Problem:
You are given a node in a singly linked list that needs to be deleted.

You are NOT given access to the head of the list.
Instead, you are given direct access to the node to be deleted.

It is guaranteed that:
- The node is not the last node in the list.
- All values in the linked list are unique.

Delete the given node by modifying the linked list in-place.

Example:

Input:
head = [4,5,1,9], node = 5

Output:
[4,1,9]

Explanation:
Copy the value of the next node into the current node,
then bypass the next node.
*/

public class DeleteNodeInLinkedList {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // ==========================================================
    // Approach: Copy Next Node's Value
    // ==========================================================
    // Time Complexity : O(1)
    // Space Complexity: O(1)
    //
    // Since we are not given the head of the list,
    // we cannot find the previous node.
    //
    // Instead:
    // 1. Copy the value of the next node into the current node.
    // 2. Skip the next node by updating the current node's next pointer.
    //
    // This effectively removes the given node from the linked list.
    // ==========================================================

    public static void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }
}