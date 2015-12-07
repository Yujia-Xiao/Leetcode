/*
Expression Add Operators 
Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
Examples: 
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
Credits:
Special thanks to @davidtan1890 for adding this problem and creating all test cases.
Hide Company Tags Google Cryptic Studios
Hide Tags Divide and Conquer
Hide Similar Problems (M) Evaluate Reverse Polish Notation (M) Basic Calculator (M) Basic Calculator II (M) Different Ways to Add Parentheses
*/
public class Solution {
    	 public List<String> addOperators(String num, int target) {
	        List<String> ansP = new LinkedList<String>();
	        List<String> ans = new LinkedList<String>();
	        if(num==null || num.length()==0) return ans;
	        String cAns = "";
            ["3+456*23+74-9-0","3+456*23+74-9+0"] <--3456237490, 9191
            divideConqur((int)(num.charAt(0)-'0'),num.substring(1,num.length()),target,ansP,cAns);
            for(String str: ansP){
                boolean add = true;
                String ansAdd = num.substring(0,1);
                for(int i=0;i<str.length();i++){
                    if(i+1<str.length()){
                        if(str.charAt(i)=='*' && num.charAt(i+1)=='0'&& str.charAt(i+1)==' '){
                            add=false;
                            break;
                        }
                    }
                    if(str.charAt(i)!=' '){ansAdd=ansAdd+str.substring(i,i+1)+num.substring(i+1,i+2);}
                    else {ansAdd=ansAdd+num.substring(i+1,i+2);}
                }
                if(add)ans.add(ansAdd);
            }
	        return ans;
	    }
	    
	    public void divideConqur(int pio, String num, int target, List<String> ansP, String CAns){
	        //use pro and num to achieve target(for this round). num.length()>=1
	        int newPio = (int)(num.charAt(0)-'0');
	        if(pio>=target){ //pio - () = target -> newTarget = pio - target
	            if(num.length()==1){
	                if(pio-newPio==target){ansP.add(CAns+"-");}
	            }
	            else{
	                divideConqur(newPio,num.substring(1,num.length()),pio-target,ansP,CAns+"-");
	            }
	        }
	        if(pio<=target){
	            if(num.length()==1){
	                if(pio*newPio==target){ansP.add(CAns+"*");}
	                if(pio+newPio==target){ansP.add(CAns+"+");}
	            }
	            else{
	                //multi
	                divideConqur(pio*newPio,num.substring(1,num.length()),target,ansP,CAns+"*");
	                //pio+()=target -> newTarget = target-pio
	                divideConqur(newPio,num.substring(1,num.length()),target-pio,ansP,CAns+"+");
	            }
	        }
	        
	        if(num.length()==1){
	            if(pio*10+newPio==target){ansP.add(CAns+" ");}   
	        }
	        else{
	            divideConqur(pio*10+newPio,num.substring(1,num.length()),target,ansP,CAns+" ");
	        }
	        
	        return;
	    }

}