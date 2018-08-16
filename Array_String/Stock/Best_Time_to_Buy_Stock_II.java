class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<2)return 0;
        int pre = prices[0];
        int ans = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]>pre){
                ans+=prices[i]-pre;
            }
            pre=prices[i];
        }
        return ans;
    }
}