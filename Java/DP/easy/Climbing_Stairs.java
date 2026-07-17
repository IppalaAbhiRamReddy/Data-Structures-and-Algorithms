package Java.DP.easy;

// Problem Link: https://leetcode.com/problems/climbing-stairs/

/*
Problem:
You are climbing a staircase. It takes `n` steps to reach the top.

Each time you can either climb 1 step or 2 steps.

Return the total number of distinct ways to reach the top.

Example 1:
Input:
n = 2

Output:
2

Explanation:
There are two ways:
1. 1 + 1
2. 2

------------------------------------------------------------

Example 2:
Input:
n = 3

Output:
3

Explanation:
There are three ways:
1. 1 + 1 + 1
2. 1 + 2
3. 2 + 1
*/

public class Climbing_Stairs {

    // ==========================================================
    // Approach: Fibonacci (Space Optimized Dynamic Programming)
    // ==========================================================
    // Time Complexity : O(N)
    // Space Complexity: O(1)
    //
    // Observation:
    // To reach the nth stair, there are only two possibilities:
    //
    // 1. Reach (n-1)th stair and take 1 step.
    // 2. Reach (n-2)th stair and take 2 steps.
    //
    // Therefore,
    //
    // ways(n) = ways(n-1) + ways(n-2)
    //
    // This is exactly the Fibonacci recurrence.
    //
    // Instead of storing all previous values in a DP array,
    // we only keep track of the last two computed values,
    // reducing the space complexity to O(1).
    // ==========================================================

    public static int climbStairs(int n) {

        // Base cases
        if (n <= 2)
            return n;

        // ways to reach stair 1 and stair 2
        int a = 1;
        int b = 2;

        // Compute ways for stairs 3 to n
        for (int i = 3; i <= n; i++) {

            int c = a + b;

            // Update previous two values
            a = b;
            b = c;
        }

        return b;
    }

    // Driver Code
    public static void main(String[] args) {

        int n = 5;

        System.out.println("Number of ways = " + climbStairs(n));
    }
}