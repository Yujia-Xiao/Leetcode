/*
336. Palindrome Pairs  QuestionEditorial Solution  My Submissions
Total Accepted: 7899
Total Submissions: 37815
Difficulty: Hard
Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:
Given words = ["bat", "tab", "cat"]
Return [[0, 1], [1, 0]]
The palindromes are ["battab", "tabbat"]
Example 2:
Given words = ["abcd", "dcba", "lls", "s", "sssll"]
Return [[0, 1], [1, 0], [3, 2], [2, 4]]
The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.

Hide Company Tags Google Airbnb
Hide Tags Hash Table String Trie
Hide Similar Problems (M) Longest Palindromic Substring (H) Shortest Palindrome
*/
public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        Trie tree = new Trie();
        for(int i=0;i<words.length;i++)tree.insert(words[i],i);
        for(int i=0;i<words.length;i++)tree.searchPalindromePairs(ans,words[i],i);
        return ans;
    }
}

class TrieNode{
    public char c;
    Map<Character,TrieNode> children = new HashMap<Character,TrieNode>();
    int index=-1; //index of the word
    List<Integer> list = new LinkedList<Integer>();
    public TrieNode(char c){this.c=c;}
}

class Trie{
    private TrieNode root=new TrieNode(' ');
    
    public void insert(String s,int index){
        TrieNode cul = root;
        Map<Character,TrieNode> children = root.children;
        char[] sArr = s.toCharArray();
        
        for(int i=sArr.length-1;i>=0;i--){
            if(isPalindrome(s,0,i))cul.list.add(index);
            
            char c = sArr[i];
            if(children.containsKey(c)){
                cul=children.get(c);
            }
            else{
                TrieNode newN = new TrieNode(c);
                children.put(c,newN);
                cul=newN;
            }
            children=cul.children;
            if(i==0){
               cul.index=index;
            }
        }
        cul.index=index;//for ""
    }
    
    public void searchPalindromePairs(List<List<Integer>> ans, String s,int index){
        TrieNode cul = root;
        Map<Character,TrieNode> children = root.children;
        for(int i=0;i<s.length();i++){
            if(cul.index>=0 && cul.index!=index && isPalindrome(s,i,s.length()-1)){
                List<Integer> temAns = new LinkedList<Integer>();
                temAns.add(index);temAns.add(cul.index);
                ans.add(temAns);
            }
            char c = s.charAt(i);
            if(children.containsKey(c)){cul=children.get(c);children=cul.children;}
            else return;
        }
        if(cul.index>=0 && cul.index!=index){
            List<Integer> temAns = new LinkedList<Integer>();
            temAns.add(index);temAns.add(cul.index);
            ans.add(temAns);
        }
        
        for(int j: cul.list){
            if(j!=index){
                List<Integer> temAns = new LinkedList<Integer>();
                temAns.add(index);temAns.add(j);
                ans.add(temAns);
            }
        }
    }
    
    public boolean isPalindrome(String s, int index1,int index2){
        while(index1<index2){
            if(s.charAt(index1)!=s.charAt(index2))return false;
            index1++;index2--;
        }
        return true;
    }
    
}


//7/16/2018

class Solution {
    class TrieNode{
        char val;
        int index = -1;//put the end of the vocab
        Map<Character,TrieNode> children = new HashMap<Character, TrieNode>();
        List<Integer> list = new LinkedList<Integer>(); // to put palindrome
        public TrieNode(char ch){val=ch;}
    }
    
    class Trie{
        TrieNode root = new TrieNode(' ');
        
        public Trie(){};
        
        public void insert(String str, int index){
            char[] arr = str.toCharArray();
            TrieNode cul = root;
            Map<Character, TrieNode> children = root.children;
            for(int i = arr.length-1;i>=0;i--){
                if(!children.containsKey(arr[i]))children.put(arr[i],new TrieNode(arr[i]));
                if(isPalindrome(arr, 0, i))cul.list.add(index);
                cul=children.get(arr[i]);
                children=cul.children;
            }
            cul.index=index;
            return;
        }
        
        public void search(List<List<Integer>> ans, String str, int index){
            char[] arr = str.toCharArray();
            TrieNode cul = root;
            Map<Character,TrieNode> children = root.children;
            for(int i=0;i<arr.length;i++){
                if(cul.index!=-1 && cul.index!=index && isPalindrome(arr, i, arr.length-1)){
                    List<Integer> temAns = new LinkedList<Integer>();
                    temAns.add(index);temAns.add(cul.index);
                    ans.add(temAns);
                }
                if(!children.containsKey(arr[i]))return;
                cul=children.get(arr[i]);
                children=cul.children;
            }
            if(cul.index!=-1 && cul.index!=index){
                List<Integer> temAns = new LinkedList<Integer>();
                temAns.add(index);temAns.add(cul.index);
                ans.add(temAns);
            }
            if(cul.list.size()!=0){
                for(int j: cul.list){
                    if(j !=index){
                        List<Integer> temAns = new LinkedList<Integer>();
                        temAns.add(index);temAns.add(j);
                        ans.add(temAns);
                    }
                }
            }
        }
        
        public boolean isPalindrome(char[] arr, int s, int e){
            if(s>e)return false;
            while(s<=e){
                if(arr[s]!=arr[e])return false;
                s++;e--;
            }
            return true;
        }
    }
    
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(words==null || words.length==0)return ans;
        Trie tree = new Trie();
        for(int i=0; i<words.length;i++)tree.insert(words[i],i);
        for(int i=0;i<words.length;i++)tree.search(ans,words[i],i);
        return ans;
    }
}