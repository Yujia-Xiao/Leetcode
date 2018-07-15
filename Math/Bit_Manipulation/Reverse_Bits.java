/*
Reverse Bits 
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?

Related problem: Reverse Integer

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Hide Tags Bit Manipulation
Hide Similar Problems (E) Number of 1 Bits
*/
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        String str = "";
        for(int i=0;i<32;i++){
            if((n&1)==1)str=str+"1";
            else str=str+"0";
            n=n>>>1;
        }
        return Integer.parseUnsignedInt(str, 2);
    }
}