/*Plus One
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Hide Company Tags Google
Hide Tags Array Math
Hide Similar Problems (M) Multiply Strings (E) Add Binary
*/
public class Solution {
    public int[] plusOne(int[] digits) {
        int end = digits.length;
        int change = 1;
        for(int i=0;i<digits.length;i++){
            if(digits[i]!=9){
                change = 0;
                break;
            }
        }
        
        int[] ans = new int[end+change];
        if(digits==null || digits.length==0){return ans;}
        
        int carry=0; int plus = 0;
        for(int i=end-1;i>=0;i--){
                if(i==end-1){
                	plus=1;
                }
                else{
                	plus=0;
                }
                if((digits[i]+carry+plus)>=10){
                    ans[i+change]=(digits[i]+carry+plus)%10;
                    carry = (digits[i]+carry+plus)/10;
                }
                else{
                    ans[i]=digits[i]+plus+carry;
                    carry=0;
                }
            
            

        }
        
        if(change==1){ans[0]=carry;}
        
        
        return ans;
    }
}