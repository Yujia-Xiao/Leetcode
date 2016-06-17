/*
Restore IP Addresses My Submissions QuestionEditorial Solution
Total Accepted: 58478 Total Submissions: 244807 Difficulty: Medium
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

Hide Tags Backtracking String
*/
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new LinkedList<String>();
        String[] ip = new String[4];
        backtrack(ans,ip,0,0,s);//start value segment=1 --> segment=0
        return ans;
    }
    public void backtrack(List<String>ans, String[] ip, int segment, int idx,String s){
        if(idx==s.length() && segment==4){//the end condition is the most important
            String add = ip[0]+"."+ip[1]+"."+ip[2]+"."+ip[3];
            ans.add(add); 
            return;
        }
        if(idx==s.length() || segment==4)return;
        for(int len=1;len<=3 && idx+len<=s.length();len++){
            String tem = s.substring(idx,idx+len);
            int temInt = Integer.parseInt(tem);
            if(temInt>255 || (len>=2 && s.charAt(idx)=='0'))break;
            ip[segment]=tem;
            backtrack(ans,ip,segment+1,idx+len,s);
            ip[segment]="";
        }
    }
}