/*
354. Russian Doll Envelopes  QuestionEditorial Solution  My Submissions
Total Accepted: 5003
Total Submissions: 17482
Difficulty: Hard
You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

Example:
Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

Hide Company Tags Google
Hide Tags Binary Search Dynamic Programming
Hide Similar Problems (M) Longest Increasing Subsequence
*/
public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null || envelopes.length==0 || envelopes[0].length==0)return 0;
        //quickSort(envelopes,0,envelopes.length-1);  You can not do that becasue you have to compare both [0] and [1] element
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
           } 
        });
        //for(int i=0;i<envelopes.length;i++)System.out.println(envelopes[i][0]+" - "+ envelopes[i][1]);
        return LIS(envelopes);
    }
    
    public void quickSort(int[][] envelopes,int low, int high){
        if(low>=high)return;
        //System.out.println(low+" to "+high);
        int pivot = low+(high-low)/2;
        pivot = envelopes[pivot][0];
        int l=low; int h=high;
        while(l<=h){//end condition
            //System.out.println(l+" - "+h);
            while(envelopes[l][0]<pivot)l++;
            while(envelopes[h][0]>pivot)h--;
            if(l<=h){
                int tem0=envelopes[l][0];
                int tem1=envelopes[l][1];
                
                envelopes[l][0]=envelopes[h][0];
                envelopes[l][1]=envelopes[h][1];
                
                envelopes[h][0]=tem0;
                envelopes[h][1]=tem1;
                l++;h--;
            }
        }
        //System.out.println(low+" - "+h+" and "+l+" - "+high);
        quickSort(envelopes,low,h);
        quickSort(envelopes,l,high);
    }
    
    public int LIS(int[][] arr){
        int[] dp = new int[arr.length]; // put id
        int len=0;
        
        for(int i=0;i<arr.length;i++){
            
            int s=0;int e=len-1;
            while(s<=e){ //Binary Search
                int mid=s+(e-s)/2;
                if(arr[dp[mid]][1]==arr[i][1]){s=mid;break;}
                else if(arr[dp[mid]][1]<arr[i][1])s=mid+1;
                else e=mid-1;
            }
            //System.out.println(s+" "+len);
            //if(i>0 && s>0 && arr[dp[s]][1]==arr[i][1])continue;
            //if(i>0 && s>0 && arr[dp[s-1]][0]==arr[i][0])continue;
            dp[s]=i;
            if(s==len)len++; 
        }
        //for(int i=0;i<dp.length;i++)System.out.println(arr[dp[i]][0]+" -* "+arr[i][1]);
        return len;
    }
}