"""
Problem:
Given an array of positive integers, find the second largest DISTINCT element.

Example:
Input:  [12, 35, 1, 10, 34, 1]
Output: 34

Explanation:
The largest element is 35, and the second largest distinct element is 34.
"""


# ==========================================================
# Approach 1: Sorting
# ==========================================================
# Time Complexity : O(n log n)
# Space Complexity: O(1) (Ignoring Python's sorting implementation)
#
# Sort the array in ascending order and traverse from the end
# to find the first element smaller than the maximum.
# ==========================================================

def second_largest_sort(arr):
    arr.sort()

    largest = arr[-1]

    for i in range(len(arr) - 2, -1, -1):
        if arr[i] != largest:
            return arr[i]

    return -1  # No second largest element exists


# ==========================================================
# Approach 2: Two Pass Traversal
# ==========================================================
# Time Complexity : O(n)
# Space Complexity: O(1)
#
# Pass 1:
#   Find the largest element.
#
# Pass 2:
#   Find the largest element smaller than the maximum.
# ==========================================================

def second_largest_two_pass(arr):
    n = len(arr)

    # Find the largest element
    first_max = arr[0]
    for i in range(1, n):
        if arr[i] > first_max:
            first_max = arr[i]

    # Find the second largest distinct element
    second_max = -1

    for i in range(n):
        if arr[i] != first_max and arr[i] > second_max:
            second_max = arr[i]

    return second_max