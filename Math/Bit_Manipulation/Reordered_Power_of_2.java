class Solution {
    public boolean reorderedPowerOf2(int N) {
        //1<=N<=10^9.  int: 2^32
        long c = counter(N);
        
        for(int i=0;i<32;i++){
            if(counter(1<<i)==c)return true;
        }
        return false;
    }
    public long counter(int N){
        long keep = 0;
        for(;N>0;N/=10){
            keep+=(int)Math.pow(10,N%10);
        }
        return keep;
    }
}
/*
 public boolean reorderedPowerOf2(int N) {
        long c = counter(N);
        for (int i = 0; i < 32; i++)
            if (counter(1 << i) == c) return true;
        return false;
    }
    public long counter(int N) {
        long res = 0;
        for (; N > 0; N /= 10) res += (int)Math.pow(10, N % 10);
        return res;
    }
    
*/