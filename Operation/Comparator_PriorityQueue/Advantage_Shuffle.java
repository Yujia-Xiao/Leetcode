class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        //
        Arrays.sort(A);
        int[] ans = new int[A.length];
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return b[0]-a[0];
            }
        });
        for(int i=0;i<B.length;i++)queue.offer(new int[]{B[i],i});
        int l=0; int h = A.length-1;
        while(queue.size()!=0){
            int[] cul = queue.poll();
            int index = cul[1];
            int val = cul[0];
            if(val<A[h])ans[index]=A[h--];
            else ans[index]=A[l++];
        }
        return ans;
    }
}
/*
class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int n=A.length;
        int[] res= new int[n];
        PriorityQueue<int[]> pq= new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return b[0]-a[0];
            }
        });
        for (int i=0; i<n; i++) pq.add(new int[]{B[i], i});
        int lo=0, hi=n-1;
        while(!pq.isEmpty()){
            int[] cur= pq.poll();
            int idx=cur[1], val=cur[0];
            if (A[hi]>val) res[idx]=A[hi--];
            else res[idx]=A[lo++];
        }
        return res;
    }  
}

*/






