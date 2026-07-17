package Java.Two_pointers.medium;

/*
Problem Link:
https://leetcode.com/problems/string-compression/

Approach: Two Pointers (Read & Write)

Traverse the array using a read pointer to count consecutive
occurrences of each character. Write the character once, and if
its frequency is greater than 1, write the count digit by digit.

- Time: O(n)
- Space: O(1)
*/

class Solution {
    public int compress(char[] chars) {

        int start = 0;
        int write = 0;
        int n = chars.length;

        while (start < n) {

            char current = chars[start];
            int count = 0;

            // Count consecutive occurrences
            while (start < n && chars[start] == current) {
                start++;
                count++;
            }

            // Write the character
            chars[write] = current;
            write++;

            // Write the count if greater than 1
            if (count > 1) {
                for (char digit : String.valueOf(count).toCharArray()) {
                    chars[write] = digit;
                    write++;
                }
            }
        }

        return write;
    }
}
