class Solution {
    public int lengthLongestPath(String input) {
        /*
            /n can split each item
            /t can split each level
            
            total Len:
            stack: keep element of each level 
            
            dir    --- level 1
                subdir1 ---- level2 = number of "\t" + 1
                subdir2
                    file.ext  ---- level3 = number of "\t" + 1           
            
           stack:     len=18   max:
           8(file.ext)  ---- level 3
           7(subdir2)     ---level 2
           3(dir)   ---- level1
            
        */
        int len = 0;
        int max = 0;
        String[] arr = input.split("\n");
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0;i<arr.length;i++){
            int level = arr[i].lastIndexOf("\t") + 2; 
            level = level==0 ? 1 : level;
            
            int itemLen = arr[i].length()-(level-1) + 1;
            /*
            System.out.println(arr[i]);
            System.out.println(itemLen);
            System.out.println(level);*/
            
            //change level // find the parent
            while(stack.size()>=level){
                //System.out.println(level);
                len-=stack.pop();
            }               
            
            //push
            len+=itemLen;
            stack.push(itemLen);
            
            //System.out.println(len);
            //update answer
            if(arr[i].contains(".")){
                max = Math.max(max,len-1);
            }
        }
        
        return max;
    }
}