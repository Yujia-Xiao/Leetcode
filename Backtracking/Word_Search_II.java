/* 31 %
212. Word Search II My Submissions QuestionEditorial Solution
Total Accepted: 21744 Total Submissions: 107753 Difficulty: Hard
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
Note:
You may assume that all inputs are consist of lowercase letters a-z.

click to show hint.

Hide Company Tags Microsoft Google Airbnb
Hide Tags Backtracking Trie
Hide Similar Problems (M) Word Search
*/
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie tree = new Trie();
        List<String> ans = new LinkedList<String>();
        for(int i=0;i<words.length;i++)tree.insert(words[i]);
        tree.search(ans,board);
        return ans;
    }
}

class TrieNode{
    char c;
    boolean hasWord;
    Map<Character,TrieNode> children = new HashMap<Character,TrieNode>();
    public TrieNode(char c){this.c=c;}
}

class Trie{
    private TrieNode root = new TrieNode(' ');
    
    public void insert(String s){
        TrieNode cul = root;
        Map<Character,TrieNode>children = root.children;
        char[] sArr = s.toCharArray();
        for(int i=0;i<s.length();i++){
            char c = sArr[i];
            if(children.containsKey(c)){
                cul=children.get(c);    
            }
            else{
                TrieNode tem = new TrieNode(c);
                children.put(c,tem);
                cul=tem;
            }
            children=cul.children;
            if(i==s.length()-1)cul.hasWord=true;
        }
    }
    
    public void search(List<String> ans,char[][]board){
        Map<Character,TrieNode> children = root.children; 
         for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                char tem = board[i][j];
                if(children.containsKey(tem)){
                    board[i][j]=0;
                    backtrack(ans,tem+"",board,i,j,children.get(tem));
                    board[i][j]=tem;    
                }
            }
        }
    }
    
    private void backtrack(List<String> ans,String s,char[][]board,int i,int j, TrieNode cul){
            Map<Character,TrieNode> children = cul.children;        
            if(cul.hasWord){ans.add(s);cul.hasWord=false;}
            if(children.size()==0)return;
            
            int[] dx = {0,1,0,-1};
            int[] dy = {1,0,-1,0};
            
            for(int n=0;n<4;n++){
                int x=i+dx[n]; int y=j+dy[n];
                if(x<0 || y<0 || x>=board.length || y>=board[x].length|| board[x][y]==0)continue;
                char c =board[x][y];
                if(children.containsKey(c)){
                    board[x][y]=0;
                    backtrack(ans,s+c,board,x,y,children.get(c));      
                    board[x][y]=c;  
                }
            }
    }
}