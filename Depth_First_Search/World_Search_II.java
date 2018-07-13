class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new LinkedList<String>();
        if(board == null || board.length == 0 || board[0].length == 0) return ans;
        if(words == null || words.length == 0)return ans;
        Trie tree = new Trie();
        for(int i=0; i<words.length; i++){tree.insert(words[i]);}
        tree.search(ans,board);
        return ans;
    }
    
    class TrieNode{
        char val;
        Map<Character, TrieNode> children = new HashMap<Character,TrieNode>();
        boolean hasWord = false;
        public TrieNode(char ch){
            val = ch;
        }
    }
    
    class Trie{
        TrieNode root = new TrieNode(' ');
        
        public void insert(String str){
            if(str == null || str.length() == 0)return;
            char[] arr = str.toCharArray();
            TrieNode cul = root;
            Map<Character, TrieNode> children = root.children;
            for(int i=0;i<arr.length;i++){
                if(!children.containsKey(arr[i])){
                    children.put(arr[i],new TrieNode(arr[i]));
                }
                cul = children.get(arr[i]);
                children = cul.children;
                }
                cul.hasWord = true;
        
            }
        
        public void search(List<String> ans, char[][] board){
            for(int i =0; i<board.length;i++){
                for(int j =0; j<board[0].length;j++){
                    if(!root.children.containsKey(board[i][j]))continue;
                    char temp = board[i][j];
                    board[i][j] = '0';
                    backtracking(ans, board,i,j,root.children.get(temp),""+temp);
                    board[i][j] = temp;
                    
                }
            }
            return;
        }
        
        public void backtracking(List<String> ans, char[][] board, int i, int j, TrieNode cul, String str){
            if(cul.hasWord){
                ans.add(str);
                cul.hasWord = false;
            }
            Map<Character,TrieNode> children = cul.children;
            /*
            for (Map.Entry<Character, TrieNode> entry : children.entrySet())
            {
                System.out.println(entry.getKey());
            }
            */
            if(children.size() == 0)return;
          
            int[] dx = {0,0,1,-1};
            int[] dy = {1,-1,0,0};
            
            for(int a = 0 ; a < 4; a++){
                int x=i+dx[a];
                int y=j+dy[a];
                
                if(x<0 || y<0 || x>=board.length || y>=board[0].length)continue;
                
                if(children.containsKey(board[x][y])){
                    char temp = board[x][y];
           
                    board[x][y] = '0';
                    backtracking(ans, board, x, y, children.get(temp), str+temp);
                    board[x][y] = temp;    
                }
                
            }
            
        }
    }
}