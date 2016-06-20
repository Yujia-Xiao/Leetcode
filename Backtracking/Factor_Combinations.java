/*
Factor Combinations 
Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note: 
Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
You may assume that n is always positive.
Factors should be greater than 1 and less than n.
Examples: 
input: 1
output: 
[]
input: 37
output: 
[]
input: 12
output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
input: 32
output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]
Hide Company Tags LinkedIn
Hide Tags Backtracking
Hide Similar Problems (M) Combination Sum
*/

//Solution 2
public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(n<=3)return ans;
        backtrack(ans,new LinkedList<Integer>(),n,2,false);
        return ans;
    }
    
    public void backtrack(List<List<Integer>> ans, List<Integer> temList, int n, int start,boolean second){
        if(n==1){ans.add(new LinkedList<Integer>(temList));}
        else{
            for(int i=start;i<=n/2;i++){
                if(n % i !=0)continue;
                temList.add(i);
                backtrack(ans,new LinkedList<Integer>(temList),n/i,i,true);
                temList.remove(temList.size()-1);
            }
            if(second && n>=start){
                temList.add(n);
                ans.add(new LinkedList<Integer>(temList));
            }
        }
    }
   
}

//Solution 1
public class Solution {
    public List<List<Integer>> getFactors(int n) {
        //backtracking
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(n<=1)return ans;
        List<Integer> list = new LinkedList<Integer>();
        for(int i=2;i*i<=n;i++){
            if(n % i==0){
                list.add(i);
                backtrack(n/i,list,ans);
                list.remove(list.size()-1);
            }
        }
        return ans;
    }
    public void backtrack(int n, List<Integer> list, List<List<Integer>> ans){
        List<Integer> newList = new LinkedList<Integer>(list);
        //boolean ifAdd = false; 
        for(int i=2;i*i<=n;i++){
            if((n % i)==0){
                newList.add(i);
                backtrack(n/i,newList,ans);
                newList.remove(newList.size()-1);
                //ifAdd = true;
            }
        }
        //if(!ifAdd){
            newList.add(n);
            Collections.sort(newList);
            if(!ans.contains(newList))ans.add(newList);
        //}
        return;
    }
}


