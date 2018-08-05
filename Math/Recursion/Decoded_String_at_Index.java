
class Solution {
    public String decodeAtIndex(String S, int K) {
        if(S==null || S.length() == 0 )return "";
        long index = 0;//// !!!!! K is int, but index might be long. be careful!!
        
        for(int i=0;i<S.length();i++){
            char ch = S.charAt(i);
            
            if(i==0 || (ch >= 'a' && ch<='z')){// index 0 is char!
                index++;
                if(index==K) return Character.toString(ch);
            }else{
                long preindex = index;
                index = index*(ch-'0');
                if(index>=K){
                    int nextIndex = ((K-1) % (int)preindex) + 1;
                    return decodeAtIndex(S.substring(0,i), nextIndex);
                }
            }        
        }
        
        return "";            
    }
}
/*
class Solution {
public String decodeAtIndex(String S, int K) {
        String cur="";
        long curlen = 0;
        for(int i=0;i<S.length();i++){
            char curchar = S.charAt(i);
            if(Character.isLetter(curchar)){
                curlen+=1;
                if(curlen>K-1){
                    return ""+curchar;
                }
            }
            if(Character.isDigit(curchar)){
                int times = curchar-'0';
                long prelen = curlen;
                curlen*=times;
                if(curlen>K-1){
                    return decodeAtIndex(S,(K-1)%(int)prelen+1);
                }
            }
        }
        return "";
    }
}
*/