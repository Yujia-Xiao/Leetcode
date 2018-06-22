class Solution {
    public int countArrangement(int N) { // 3
        // Get the # of permutations which satisfy certain conditions:
        int[] ans = new int[1];//[0] 
        int[] used = new int[N];// [0,0,0]
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        backtracking(ans, 1, N, used, list, new LinkedList<Integer>()); // 0, 1, 3, [0,0,0]
        //for(int a = 0; a < list.size(); a++){System.out.println(list.get(a));}
        return ans[0];
    }
    
    public void backtracking(int[] ans, int i, int N, int[] used, List<List<Integer>> list, List<Integer> temList){
        if(i==N+1){// 1 == 4 2!=4
            ans[0]++;
            list.add(new LinkedList<Integer>(temList));
        }
        for(int j = 1; j<N+1; j++){ // j = 1 - 3 j= 1 - 3
            if(used[j-1] == -1)continue;
            
            if(j % i == 0 || i % j == 0){//j=1
                temList.add(j); used[j-1] = -1;
                backtracking(ans, i+1, N, used, list, new LinkedList<Integer>(temList));// [0], 2, 3, [-1, 0, 0]
                temList.remove(i-1); used[j-1] = 0;
            }
            else continue;
        }
        return;
    }
}