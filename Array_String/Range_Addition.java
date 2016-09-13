/*
370. Range Addition  QuestionEditorial Solution  My Submissions
Total Accepted: 3744
Total Submissions: 7365
Difficulty: Medium
Assume you have an array of length n initialized with all 0's and are given k update operations.

Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.

Return the modified array after all k operations were executed.

Example:

Given:

    length = 5,
    updates = [
        [1,  3,  2],
        [2,  4,  3],
        [0,  2, -2]
    ]

Output:

    [-2, 0, 3, 5, 3]
Explanation:

Initial state:
[ 0, 0, 0, 0, 0 ]

After applying operation [1, 3, 2]:
[ 0, 2, 2, 2, 0 ]

After applying operation [2, 4, 3]:
[ 0, 2, 5, 5, 3 ]

After applying operation [0, 2, -2]:
[-2, 0, 3, 5, 3 ]
Hint:

Thinking of using advanced data structures? You are thinking it too complicated.
For each update operation, do you really need to update all elements between i and j?
Update only the first and end element is sufficient.
The optimal time complexity is O(k + n) and uses O(1) extra space.
Credits:
Special thanks to @vinod23 for adding this problem and creating all test cases.

Hide Company Tags Google
Hide Tags Array
*/
public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];
        for(int i=0;i<updates.length;i++){
            int s = updates[i][0];
            int e = updates[i][1];
            int add = updates[i][2];
            if(s>-1 && s<length)ans[s]+=add;   
            if(e+1>-1 && e+1<length)ans[e+1]-=add;   
        }
        for(int i=1;i<length;i++){
            ans[i]+=ans[i-1];
        }
        return ans;
    }
}