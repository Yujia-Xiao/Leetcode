/*
H-Index
Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.

Hint:

An easy approach is to sort the array first.
What are the possible values of h-index?
A faster approach is to use extra space.
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Hide Company Tags Google Facebook
Hide Tags Hash Table Sort
Hide Similar Problems (M) H-Index II
*/
public class Solution {
    public int hIndex(int[] citations) {
        if(citations==null || citations.length==0){return 0;}
        Arrays.sort(citations);
        // 1 - n is possible solution, max. begin from n! 
        int n = citations.length;
        
        if(citations[0]>=n){return n;}
        for(int i=1;i<=n-1;i++){
            if(citations[i]>=n-i && citations[i-1]<=n-i){
                return n-i;
            }
        }
        return 0;
    }
}