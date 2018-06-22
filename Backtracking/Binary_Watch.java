class Solution {
    public List<String> readBinaryWatch(int num) {
        int[] used = new int[10];
        List<List<Integer>> permutation = new LinkedList<List<Integer>>();
        List<String> ans = new LinkedList<String>();
        if(num == 0) {ans.add("0:00"); return ans;}
        backtracking(permutation, new LinkedList<Integer>(), used, 0, 0, num);
        
        //System.out.println(permutation.size());
        //for(int i = 0; i<permutation.size(); i++){System.out.println(permutation.get(i));}
        
        convert(ans, permutation);
        
        return ans;
    }
    
    public void backtracking(List<List<Integer>> permutation, List<Integer> temList, int[] used, int i, int start, int num){
        if(i == num){ // end ocndition == add condition
            permutation.add(new LinkedList<Integer>(temList));
            return;
        }
        if(i == used.length)return;
        
        for(int j = start; j < used.length; j++){
            if(used[j]==-1)continue;
            temList.add(j);used[j]=-1;
            backtracking(permutation, new LinkedList<Integer>(temList), used, i+1, j+1, num);
            temList.remove(i);used[j]=0;
        }
        return;
    }
    
    public void convert(List<String> ans, List<List<Integer>> permutation){
        
        int hour = 0;
        int min = 0;
        int index = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,1);map.put(1,2);map.put(2,4);map.put(3,8);map.put(4,16);
        map.put(5,32);map.put(6,1);map.put(7,2);map.put(8,4);map.put(9,8);

                System.out.println("per");

                System.out.println(permutation.size());

        for(int i = 0; i < permutation.size(); i++){
            for(int j = 0; j < permutation.get(i).size(); j++){
                index = permutation.get(i).get(j);
                if(index < 6) min += map.get(index);
                else hour += map.get(index);
            }
            if(hour < 12 && min < 60){
                String h = (min < 10 ? '0'+ String.valueOf(min) : String.valueOf(min));
                ans.add(String.valueOf(hour)+':'+ h );
            }
            hour = 0;
            min = 0;
                
        }
         System.out.println("ans");

        System.out.println(ans.size());
        
        return;
    }
}

