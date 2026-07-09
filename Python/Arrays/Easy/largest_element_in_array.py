"""
Problem:
Given an array of integers, find the largest element in the array.

Example:
Input:  [10, 5, 20, 8]
Output: 20
"""


# ==========================================================
# Approach 1: Sorting
# ==========================================================
# Time Complexity : O(n log n)
# Space Complexity: O(1) (Ignoring the internal space used by Python's sort)
#
# Algorithm:
# 1. Sort the array in ascending order.
# 2. The last element of the sorted array is the largest.
# ==========================================================

def largest_element_sort(arr):
    arr.sort()
    return arr[-1]


# ==========================================================
# Approach 2: Array Traversal
# ==========================================================
# Time Complexity : O(n)
# Space Complexity: O(1)
#
# Algorithm:
# 1. Assume the first element is the largest.
# 2. Traverse the remaining elements of the array.
# 3. If the current element is greater than the largest,
#    update the largest.
# 4. After the traversal, return the largest element.
# ==========================================================

def largest_element_traversal(arr):
    largest = arr[0]

    for i in range(1, len(arr)):
        if arr[i] > largest:
            largest = arr[i]

    return largest