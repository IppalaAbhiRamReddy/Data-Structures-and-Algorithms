"""
Problem:
Given an m × n matrix, return all elements of the matrix in spiral order.

Example:
Input:
[
 [1, 2, 3],
 [4, 5, 6],
 [7, 8, 9]
]

Output:
[1, 2, 3, 6, 9, 8, 7, 4, 5]

Explanation:
Traverse the matrix layer by layer in clockwise order until all
elements have been visited.
"""
from typing import List


# ==========================================================
# Approach 1: Boundary Traversal + Counter
# ==========================================================
# Time Complexity : O(m × n)
# Space Complexity: O(1) (excluding the output array)
#
# Maintain four boundaries (top, bottom, left, and right)
# representing the current layer of the matrix.
#
# Keep track of the number of visited elements
# using a counter (`count`).
# Before adding an element, ensure `count < total`
# to avoid revisiting elements when the remaining 
# layer has only one row or one column.
# Traverse in clockwise order while shrinking the 
# corresponding boundary after each traversal.
# ==========================================================

def spiral_order_counter(matrix: List[List[int]]) -> List[int]:
    res = []

    n = len(matrix)
    m = len(matrix[0])

    top = 0
    bottom = n - 1
    left = 0
    right = m - 1

    count = 0
    total = n * m

    while count < total:
        
        # Traverse the top row from left to right
        for j in range(left, right + 1):
            if count < total:
                count += 1
                res.append(matrix[top][j])
        top += 1

        # Traverse the rightmost column from top to bottom
        for i in range(top, bottom + 1):
            if count < total:
                count += 1   
                res.append(matrix[i][right])
        right -= 1

        # Traverse the bottom row from right to left
        for j in range(right, left - 1, -1):
            if count < total:
                count += 1
                res.append(matrix[bottom][j])
        bottom -= 1
        
        # Traverse the leftmost column from bottom to top
        for i in range(bottom, top - 1, -1):
            if count < total:
                count += 1
                res.append(matrix[i][left])
        left += 1  

    return res                       


# ==========================================================
# Approach 2: Boundary Traversal (Optimized)
# ==========================================================
# Time Complexity : O(m × n)
# Space Complexity: O(1) (excluding the output array)
#
# Maintain four boundaries (top, bottom, left, and right)
# representing the current layer of the matrix.
#
# Traverse each boundary in clockwise order and shrink the
# corresponding boundary after every traversal.
# Before traversing the bottom row or left column, check
# whether the boundaries are still valid to avoid revisiting
# elements.
# ==========================================================

def spiral_order_optimized(matrix: List[List[int]]) -> List[int]:
    res = []

    n = len(matrix)
    m = len(matrix[0])

    top = 0
    bottom = n - 1
    left = 0
    right = m - 1
    
    while left <= right and top <= bottom:
        
        # Traverse the top row from left to right
        for j in range(left, right + 1):
            res.append(matrix[top][j])
        top += 1

        # Traverse the rightmost column from top to bottom
        for i in range(top, bottom + 1):
            res.append(matrix[i][right])
        right -= 1

        # Traverse the bottom row from right to left
        if top <= bottom:
            for j in range(right, left - 1, -1):
                res.append(matrix[bottom][j])
            bottom -= 1

        # Traverse the leftmost column from bottom to top
        if left <= right:
            for i in range(bottom, top - 1, -1):
                res.append(matrix[i][left])
            left += 1  

    return res                       

    
