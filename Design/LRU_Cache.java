/*
146. LRU Cache  QuestionEditorial Solution  My Submissions
Total Accepted: 88939
Total Submissions: 560833
Difficulty: Hard
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Hide Company Tags Google Uber Facebook Twitter Zenefits Amazon Microsoft Snapchat Yahoo Bloomberg Palantir
Hide Tags Design
*/
public class LRUCache {
    
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }
    
    /**
     * Always add the new node right after head;
     */
    private void addNode(DLinkedNode node){
        node.pre = head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
    }
    
    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(DLinkedNode node){
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;
        
        pre.post = post;
        post.pre = pre;
    }
    
    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DLinkedNode node){
        this.removeNode(node);
        this.addNode(node);
    }
    
    // pop the current tail. 
    private DLinkedNode popTail(){
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }
    
    private Map<Integer, DLinkedNode> 
        cache = new HashMap<Integer, DLinkedNode>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;
    
    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
    
        head = new DLinkedNode();
        head.pre = null;
        
        tail = new DLinkedNode();
        tail.post = null;
        
        head.post = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        
        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1; // should raise exception here.
        }
        
        // move the accessed node to the head;
        this.moveToHead(node);
        
        return node.value;
    }
    
    
    public void set(int key, int value) {
        DLinkedNode node = cache.get(key);
        
        if(node == null){
            
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            
            this.cache.put(key, newNode);
            this.addNode(newNode);
            
            ++count;
            
            if(count > capacity){
                // pop the tail
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        }else{
            // update the value.
            node.value = value;
            this.moveToHead(node);
        }
        
    }
}