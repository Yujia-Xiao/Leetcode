/*
Alien Dictionary 
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

For example,
Given the following words in dictionary,

[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
The correct order is: "wertf".

Note:
You may assume all letters are in lowercase.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
Hide Company Tags Google Facebook
Hide Tags Graph Topological Sort
Hide Similar Problems (M) Course Schedule II
*/
public class Solution {
     public String alienOrder(String[] words) {
	        //creat graph
	        Map<Character,Set<Character>> graph = new HashMap<Character,Set<Character>>();
	        Map<Character, Integer> degree = new HashMap<Character,Integer>();
	        String previous; String current; char p; char c;int length;
	        boolean Break = false;boolean ifGraphAdded = true;
	        for(int i=1;i<words.length;i++){
	            previous = words[i-1];
	            current = words[i];
	            length = Math.min(previous.length(),current.length());
	            Break = false;
	            for(int j=0;j<length;j++){
	                
	                p = previous.charAt(j);
	                c = current.charAt(j);
	                if(!degree.containsKey(p)){degree.put(p,0);} // collect discrete points
	                
	                if((p!=c) && (!Break)){
	                    //update graph
	                    ifGraphAdded = true;
	                    if(graph.containsKey(p)){
	                        Set<Character> temp = graph.get(p);
	                        ifGraphAdded=temp.add(c);
	                        graph.put(p,temp);
	                    }
	                    else{
	                        Set<Character> neighburTem = new HashSet<Character>();
	                        neighburTem.add(c);
	                        graph.put(p,neighburTem);
	                    }
	                    //update the degree
	                    if(degree.containsKey(c)){
	                        if(ifGraphAdded)degree.put(c,degree.get(c)+1);
	                    }
	                    else{degree.put(c,1);}
	                    
	                    //break;
	                    Break=true;
	                }
	            }
	        }
	        
	        String lastWord = words[words.length-1];
	        for(int i=0;i<lastWord.length();i++){
	             p=lastWord.charAt(i);
	             if(!degree.containsKey(p)){degree.put(p,0);} // collect discrete points
	        }
	        
	        //do the topological search
	        char charAdd =' ';
	        String ans = "";
	        int sizeOfDegree;
	        while(degree.size()!=0){
	            sizeOfDegree = degree.size();
	            Iterator it = degree.entrySet().iterator();
	            while(it.hasNext()){
	                Map.Entry pair = (Map.Entry)it.next();
	                charAdd = (char)pair.getKey();	                
	                if((int)pair.getValue()==0){
	                    degree.remove(charAdd);
	                    break;
	                }
	                sizeOfDegree--;
	            }
	            if(sizeOfDegree==0) return ""; //there is loop
	            
	            //update degree
	            if(!graph.containsKey(charAdd))ans=ans+charAdd;//discrete point
	            else{
	                ans=ans+charAdd;
	                Set<Character> nei = graph.get(charAdd);
	                for(char n : nei){
	                    degree.put(n,degree.get(n)-1);
	                }
	            }
	        }
	        return ans;
	    }    
}