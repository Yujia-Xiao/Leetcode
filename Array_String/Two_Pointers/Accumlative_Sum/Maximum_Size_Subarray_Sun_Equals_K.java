class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int len = 0;
        int tem = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] sum = new int[nums.length+1];
        map.put(0,0);
        for(int i=1;i<=nums.length;i++){
            sum[i]=sum[i-1]+nums[i-1];
            if(map.containsKey(sum[i]-k)){
                tem = i-(map.get(sum[i]-k));
                if(len < tem)len=tem;
            }
            if(!map.containsKey(sum[i])){//only keep the first index
                map.put(sum[i],i);
            }   
        }
        return len;
    }
}