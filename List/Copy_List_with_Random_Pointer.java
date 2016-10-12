/*
138. Copy List with Random Pointer  QuestionEditorial Solution  My Submissions
Total Accepted: 78755
Total Submissions: 300293
Difficulty: Hard
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

Hide Company Tags Amazon Microsoft Bloomberg Uber
Hide Tags Hash Table Linked List
Hide Similar Problems (M) Clone Graph
*/
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
      if (head == null) return null;
      
      Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
      
      // loop 1. copy all the nodes
      RandomListNode node = head;
      while (node != null) {
        map.put(node, new RandomListNode(node.label));
        node = node.next;
      }
      
      // loop 2. assign next and random pointers
      node = head;
      while (node != null) {
        map.get(node).next = map.get(node.next);
        map.get(node).random = map.get(node.random);
        node = node.next;
      }
      
      return map.get(head);
    }
}