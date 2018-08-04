class Solution {
    public int[] countBits(int num) {
        /*
         0<= i <= num(5) , how many 1
         00, 01, 10, 11, 1+00, 1+01, 1+10, 1+11,
         [0,1,1,2,1,2]: 
         5 = 4 + 1 : n[5] = 1 (position 4) + n[(5-4)] = 1+1=2
         6 = 4 + 2: n[6] = 1 + n[6-4]= 2
         7 = 4 + 3: n[7] = 1 +n [7-4] = 3
        */
        int[] ans = new int[num+1];
        //num >=0 , non-negative
        int base = 1;
        for(int i=0;i<=num;i++){
            if(i==0){ans[i]=0;continue;}
            else if(i==1){ans[i]=1;continue;}
            else if(i==(int)Math.pow(2,base)){ //2 
                base++;//base=2  -- 4
            }
            ans[i]=1+ans[i-(int)Math.pow(2,base-1)]; // 2:  1 + n[0] = 1
        }
        return ans;
    }
}