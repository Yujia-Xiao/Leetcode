class Solution {
    public int[] plusOne(int[] digits) {
        //carry on & no carry on
        int[] ans = new int[digits.length];
        int carry = 1;
        int i = digits.length-1;
        while(i>=0){
            if(digits[i]==9 && carry==1){
                ans[i]=0;
            }else{
                ans[i]=digits[i]+carry;
                carry=0;
            }
            i--;
        }
        if(carry==1){
            ans = new int[digits.length+1];
            ans[0]=1;
        }
        return ans;
    }
}