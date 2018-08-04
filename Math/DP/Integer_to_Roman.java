/*
Integer to Roman 
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

Hide Tags Math String
Hide Similar Problems (E) Roman to Integer (M) Integer to English Words
*/
public class Solution {
    public String intToRoman(int num) {
        //I-1 V-5 X-10 L-50 C-100 D-500 M-1000
        //0-1;1-10;2-100;3-1000
        String ans = "";    
        String symbol[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};    
        int value[]=    {1000,900,500,400, 100, 90,  50, 40,  10, 9,   5,  4,   1};   
        for(int i=0;num!=0;++i){  
            while(num>=value[i]){  
                num-=value[i];  
                ans+=symbol[i];  
            }  
        }  
        return ans;  
    }
}


class Solution {
    public String intToRoman(int num) {
        /*
        I, V, X, 1, 5, 10:  I, II, III, IV, V, VI, VII, VIII, IX   -- > 1~9  : first posiiton
        X, L, C, 10, 50, 100, X, XX, XXX, XL, L, LX, LXX, LXXX, XC, C   -->10~90 : second position
        C, D, M, 100, 500, 1000, C, CC, CCC, CD, D, DC, DCC, DCCC, CM, --->100~900: third position
        M, 1000, M, MM,MMM --> 1000 ~ 3000

        let's sat 864:  800 + 60 +4 : D(500)CCC(100) + L(50)X(10) + I(1)V(5)
        each layer: I, V, X. <= next layer: X, L, C. <= C, D, M
        
        range: 1-3999:  3000 + 900 + 90 + 9
    */
        //at most for layer
        Map<Integer, String> map = new HashMap<Integer, String>();
        // Create templete -- first layer.   
        // second, replace.  X -->C,   V-->L,   I-->X,  ....
        map.put(1,"I");map.put(2,"II");map.put(3,"III");map.put(4,"IV");map.put(5,"V");
        map.put(6,"VI");map.put(7,"VII");map.put(8,"VIII");map.put(9,"IX"); map.put(0,""); 
        StringBuilder strb = new StringBuilder();
        for(int i = 0; i<4; i++){
            if(num==0)break;
            
            int bit = num % 10;
            num = num/10; 
            String temp = "";
            
            if(i==0){
                temp = map.get(bit);
            }
            if(i==1){
                temp = map.get(bit);
                temp=temp.replace('X','C');
                temp=temp.replace('V','L');
                temp=temp.replace('I','X');
            }
            if(i==2){
                temp = map.get(bit);
                temp=temp.replace('X','M');
                temp=temp.replace('V','D');
                temp=temp.replace('I','C');
            }
            if(i==3){
                temp = map.get(bit);
                temp=temp.replace('I','M');
            }
            
            strb.insert(0,temp);
        }
        return strb.toString();
    }
}