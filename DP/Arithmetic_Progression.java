// This is longest Arithmetic Progression
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length == 0 || A.length == 1 || A.length == 2) return 0;
        int len = A.length;
        int[][] dp = new int[len][len];
        int ans = 0;
        for (int j = len-1; j >= 0; j--){
            int i = j - 1;
            int k = j + 1;
            while(i >= 0 && k < len){
                // decide the value for dp[i][j];
                if(A[j] - A[i] > A[k] - A[j]) k++;
                else if (A[j] - A[i] < A[k] - A[j]){
                    dp[i][j] = 2; i --;
                }
                else{
                    dp[i][j] = dp[j][k] + 1;
                    if(dp[i][j] > 2) ans += dp[i][j]-2;
                    k++;
                    i--;
                }
            }
            while(i >= 0){
                dp[i][j] = 2;
                i--;
            }
        }
        
        for(int i =0; i < dp.length; i++){
            for(int j = 0; j< dp[i].length; j++)System.out.print(dp[i][j]);
            System.out.println();
        }
        return ans;
    }
}

// This is the sum of arithmetic slices:
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length == 0 || A.length == 1 || A.length == 2) return 0;
        int len = A.length;
        int[][] dp = new int[len][len];
        int ans = 0;
        for (int j = len-1; j >= 0; j--){
            int i = j - 1;
            int k = j + 1;
            while(i >= 0 && k < len){
                // decide the value for dp[i][j];
                if(A[j] - A[i] > A[k] - A[j]) k++;
                else if (A[j] - A[i] < A[k] - A[j]){
                    dp[i][j] = 2; i --;
                }
                else{
                    dp[i][j] = dp[j][k] + 1;
                    if(dp[i][j] > 2) ans += dp[i][j]-2;
                    k++;
                    i--;
                }
            }
            while(i >= 0){
                dp[i][j] = 2;
                i--;
            }
        }
        
        for(int i =0; i < dp.length; i++){
            for(int j = 0; j< dp[i].length; j++)System.out.print(dp[i][j]);
            System.out.println();
        }
        return ans;
    }
}