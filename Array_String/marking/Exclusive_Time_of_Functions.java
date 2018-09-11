class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        int preTime = -1;
        int preId = 0;
        Stack<Integer> qId = new Stack<Integer>();
        
        for(int i=0;i<logs.size();i++){
            
            String[] str = logs.get(i).split(":");        
            int Id = Integer.parseInt(str[0]);
            boolean Sign = (str[1].equals("start")?true:false);
            int Time = Integer.parseInt(str[2]);                

            if(Sign){
                // clear previous points
                ans[preId] += Time - preTime - 1;
                qId.push(preId);
                // add itself
                ans[Id]++;
                preId = Id;
                preTime = Time;
            }else{
                // clear previous points
                ans[preId] += Time - preTime - 1;
                ans[Id]++;
                preId = qId.pop();
                preTime = Time;
            }
            
        }
        return ans;
    }
}