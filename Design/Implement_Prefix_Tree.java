/*
Implement Trie (Prefix Tree) 
Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.

Hide Company Tags Google Uber Facebook
Hide Tags Trie Design
Hide Similar Problems (M) Add and Search Word - Data structure design
*/
class TrieNode {
    // Initialize your data structure here.
    char c;
    boolean hasWord = false;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    public TrieNode() {}
    public TrieNode(char c){this.c = c;}
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        HashMap<Character, TrieNode> children = root.children;
        char[] wordArray = word.toCharArray();
        //if has related child, go there. if not, creat new one.
        for(int i=0; i<wordArray.length;i++){
            if(children.containsKey(wordArray[i])){
                cur=children.get(wordArray[i]);
            }
            else{
                TrieNode newNode = new TrieNode(wordArray[i]);
                children.put(wordArray[i],newNode);
                cur = newNode;
            }
            children = cur.children;
        }
        cur.hasWord = true;
        return;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = SearchIfContain(word);
        if(cur==null)return false;
        return cur.hasWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(SearchIfContain(prefix)==null)return false;
        return true;
    }
    
    public TrieNode SearchIfContain(String s){
        TrieNode cur = root;
        HashMap<Character,TrieNode> children = root.children;
        char[] wordArray = s.toCharArray();
        for(int i=0; i<wordArray.length;i++){
            if(children.containsKey(wordArray[i])){
                cur = children.get(wordArray[i]);
            }
            else{return null;}
            children=cur.children;
        }
        return cur;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");