class Solution {
    public boolean isAdditiveNumber(String num) {
        // find a set with at least two numbers, which will split num into three numbers and can form addictive
        // position: 1 to length-1
        // return if find one possible solution
        if(num == null || num.length() < 3) return false;
        long[] used = new long[num.length()-1];
        return backtracking(num, new LinkedList<Integer>(), 1, 1, used);
    }
    
    public boolean backtracking(String num, LinkedList<Integer> temList, int splitNum, int start, long[] used){
        
        long a = 0;
        long b = 0;
        long c = 0;
        int size = temList.size();
        int pre = (size>=1 ? temList.get(size-1) : 0);
        int s = (size>2 ? temList.get(size-3) : 0);
        boolean check = true;
             
        // add ans condition
        if(temList.size() >= 2){ // 2 splits == 3 number
            
            a = Long.parseLong(num.substring(s, temList.get(size-2)));
  
            b = Long.parseLong(num.substring(temList.get(size-2), temList.get(size-1)));
    
            c = Long.parseLong(num.substring(temList.get(size-1), num.length()));
            
            if((num.substring(temList.get(size-1), num.length())).startsWith("0") && c != 0 ) check = false;
              
            if(a + b == c && check) return true;
            
        }
         
        System.out.println(temList);
        
        // end condition
        if(splitNum == num.length()) return false; 
        
        // iteration
        for(int j = start; j < num.length(); j++){
           
            // not used
            if(used[j-1] == -1) continue;
            
            // valide num
            if((num.substring(pre, j)).startsWith("0") && j-1-pre != 0 ) continue;
            
            // satify condition
            if(size >= 2){
                c = Long.parseLong(num.substring(pre, j));
                if(a + b != c) continue;
            } 
            
            // Let's try!
            temList.add(j); used[j-1] = -1;
            if(backtracking(num, new LinkedList<Integer>(temList), splitNum+1, j+1, used)) return true;
            temList.remove(splitNum-1); used[j-1] = 0;
        }
        
        return false;
    }
    
    
}