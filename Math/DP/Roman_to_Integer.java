/*
Roman to Integer My Submissions Question
Total Accepted: 64375 Total Submissions: 175611 Difficulty: Easy
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

Hide Company Tags Uber
Hide Tags Math String
Hide Similar Problems (M) Integer to Roman
*/
public class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        for(int i = 0; i < s.length()-1; i++){
            int a = charToInt(s.charAt(i));
            int b = charToInt(s.charAt(i+1));
            if(a>=b)ans+=a;
            else ans-=a;
        }
        ans+=charToInt(s.charAt(s.length()-1));
        return ans;
    }

    public int charToInt(char cha){
        switch(cha){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}


// 8/5
class Solution {
    public int romanToInt(String s) {
        /*
            I, V, X, 1, 5, 10:  I, II, III, IV, V, VI, VII, VIII, IX   -- > 1~9  : first posiiton
            X, L, C, 10, 50, 100, X, XX, XXX, XL, L, LX, LXX, LXXX, XC, C   -->10~90 : second position
            C, D, M, 100, 500, 1000, C, CC, CCC, CD, D, DC, DCC, DCCC, CM, --->100~900: third position
            
            let's sat 864:  800 + 60 +4 : D(500)CCC(100) + L(50)X(10) + I(1)V(5)
            each layer: I, V, X. <= next layer: X, L, C. <= C, D, M
            if(s[n]<s[n+1])ans-=s[n]
            else ans+=s[n];
        */
        if(s==null || s.length()==0)return 0;
        Map<Character, Integer> map = new HashMap<Character,Integer>();
        map.put('I',1);map.put('V',5);map.put('X',10);map.put('L',50);map.put('C',100);map.put('D',500);map.put('M',1000);
        int ans = 0;
        for(int i = s.length()-1;i>=0;i--){
            
            if(i==s.length()-1)ans+=map.get(s.charAt(i));
            else{
                
                if(map.get(s.charAt(i))>=map.get(s.charAt(i+1)))ans+=map.get(s.charAt(i));
                else ans-=map.get(s.charAt(i));
            }
        }
        //s.charAt(0);
        return ans;
    }
}