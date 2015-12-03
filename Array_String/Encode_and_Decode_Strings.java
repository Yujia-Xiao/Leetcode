/*
Encode and Decode Strings
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
Machine 2 (receiver) has the function:
vector<string> decode(string s) {
  //... your code
  return strs;
}
So Machine 1 does:

string encoded_string = encode(strs);
and Machine 2 does:

vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.

Note:
The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
Hide Company Tags Google
Hide Tags String
Hide Similar Problems (E) Count and Say (M) Serialize and Deserialize Binary Tree
*/
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) { // ans=num+#+str
        String ans="";
        if(strs == null || strs.size()==0){
            return ans;
            }
        for(int i=0;i<strs.size();i++){ //0 - size-1, 
            ans=ans+strs.get(i).length()+"#"+strs.get(i);
        }
        return ans;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) { 
        //num,#,
        List<String> ans = new ArrayList<String>();
        if(s==null || s==""){return ans;}
        int position = 0; //position of the number mark
        int length = 0;
        String str = "";
        String numtemp = "";
        while(position<s.length()){
            //get length of the str from position
            int i = 0;
            while(s.charAt(position+i)!='#'){i++;}
            numtemp=s.substring(position,position+i);
            length=Integer.valueOf(numtemp);
            position=position+i;//make the position to #
            str=s.substring(position+1,position+length+1); //01234
            position=position+length+1;
            ans.add(str);
        }
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));