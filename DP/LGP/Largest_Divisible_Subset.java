/*
368. Largest Divisible Subset  QuestionEditorial Solution  My Submissions
Total Accepted: 12359
Total Submissions: 38583
Difficulty: Medium
Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

nums: [1,2,3]

Result: [1,2] (of course, [1,3] will also be ok)
Example 2:

nums: [1,2,4,8]

Result: [1,2,4,8]
Credits:
Special thanks to @Stomach_ache for adding this problem and creating all test cases.

Hide Company Tags Google
Hide Tags Dynamic Programming Math
*/
public class Solution {
   /* public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new LinkedList<Integer>();
        int n = nums.length;
        if(n<1)return ans;
        Arrays.sort(nums);
        int AnsLen = 1;
        int AnsI = 0;
        int AnsJ = 0;
        int[][] dp = new int[n][n];
        int[][] next = new int[n][n];
        for(int i=0;i<n-1;i++){
            Arrays.fill(next[i],-1);
            if(nums[n-1] % nums[i]==0){
                dp[i][n-1]=2;
                if(AnsLen<dp[i][n-1]){
                    AnsLen=dp[i][n-1];
                    AnsI=i;
                    AnsJ=n-1;
                }                
            }
        }
        for(int j=n-2;j>=0;j--){
            int i = j-1; 
            int k = j+1;
            while(i>=0 && k<n){
                if((nums[j] % nums[i]==0) && (nums[k] % nums[j]==0)){
                    dp[i][j]=dp[j][k]+1;
                    next[i][j]=k;
                    if(AnsLen<dp[i][j]){
                        AnsLen=dp[i][j];
                        AnsI=i;
                        AnsJ=j;
                    }
                    i--;k++;
                }else if(nums[i]*nums[k]>nums[j]*nums[j]){
                    dp[i][j]=2;i--;
                }else k++;
            }
            while(i>=0){dp[i][j]=2;i--;}
        }
        
        if(AnsLen==1){
            ans.add(nums[AnsI]);
        }else if(AnsLen>=2){
            while(AnsJ!=-1){
                ans.add(nums[AnsI]);
                int tem = next[AnsI][AnsJ];
                AnsI=AnsJ;
                AnsJ=tem;
            }
            ans.add(nums[AnsI]);
        }

        return ans;
    }
    */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int[] pre = new int[n];
        Arrays.sort(nums);
        int max = 0, index = -1;
        for (int i = 0; i < n; i++) {
            count[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (1 + count[j] > count[i]) {
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while (index != -1) {
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }
}


// 07/02/2018
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        /* sort the array
           find the largest geometric progression
        */
        List<Integer> ans = new LinkedList<Integer>();
        if(nums == null || nums.length == 0) return ans;
        int index = 0;
        Arrays.sort(nums);
        int len = nums.length;
        int[] count = new int[len];
        int[] pre = new int[len]; // keep the previous index
        for (int i = 0; i < len; i++){
            count[i] = 1; pre[i] = -1;
        }
        for(int i = 1; i < len; i++){
            for(int j = i-1; j >= 0; j--){
                if(nums[j] % nums[i] == 0 || nums[i] % nums[j] == 0){
                    if(count[j] + 1 > count[i]){
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                    if(count[i] > count[index]){
                        index = i; 
                    }
                }    
            }   
        }
        /*
        for(int i=0; i<len;i++){
            System.out.print(count[i]);
            //
        
        }
        System.out.println();
        for(int i=0; i<len;i++){
            System.out.print(pre[i]);
            //System.out.println;
        
        }
        */
        while(index != -1){
            ans.add(0,nums[index]);
            index = pre[index];
        }
        
        return ans;
    }
}