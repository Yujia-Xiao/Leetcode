/*

374. Guess Number Higher or Lower
   

Question Editorial Solution  
 My Submissions 
•Total Accepted: 5644
•Total Submissions: 17788
•Difficulty: Easy
We are playing the Guess Game. The game is as follows:
I pick a number from 1 to n. You have to guess which number I picked.
Every time you guess wrong, I'll tell you whether the number is higher or lower.
You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
Example:
n = 10, I pick 6.
Return 6.
Hide Company Tags Google  
Hide Tags Binary Search  
Hide Similar Problems
 (E) First Bad Version (M) Guess Number Higher or Lower II 
*/

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int s =1; int e=n;
        while(s<=e){ // 1, 10 ; 6, 10; 6,7
            
            int mid=s+(e-s)/2;// 1+4 =5 ; 6+2 =8// 6+0
            
            int g=guess(mid); // -1
            //System.out.println(s+" "+e+" "+mid+" "+g);
            if(g==0)return mid;
            else if(g==1)s=mid+1;// e=7
            else e=mid-1; //s=6
        }
        return 0;
    }
}