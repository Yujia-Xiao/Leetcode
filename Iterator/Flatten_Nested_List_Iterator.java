/*
341. Flatten Nested List Iterator  QuestionEditorial Solution  My Submissions
Total Accepted: 17788
Total Submissions: 49548
Difficulty: Medium
Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

Example 2:
Given the list [1,[4,[6]]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].

Hide Company Tags Google Facebook Twitter
Hide Tags Stack Design
Hide Similar Problems (M) Flatten 2D Vector (M) Zigzag Iterator (M) Mini Parser
*/
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    
    Queue<Integer> q = new LinkedList<Integer>();
    List<NestedInteger> list;
    int index = 0;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        list=nestedList;
    }

    @Override
    public Integer next() {
        return q.poll();
    }

    @Override
    public boolean hasNext() {
        if(q.peek()!=null)return true;
      
        while(index<list.size()){
            NestedInteger tem = list.get(index);index++;
            if(tem.isInteger())q.offer(tem.getInteger());
            else{
                NestedIterator it = new NestedIterator(tem.getList());
                while(it.hasNext())q.offer(it.next());
            }
            if(q.peek()!=null)return true;
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack = new Stack<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()) {
            NestedInteger curr = stack.peek();
            if(curr.isInteger()) {
                return true;
            }
            stack.pop();
            for(int i = curr.getList().size() - 1; i >= 0; i--) {
                stack.push(curr.getList().get(i));
            }
        }
        return false;
    }
}

public class NestedIterator implements Iterator<Integer> {
    Deque<NestedInteger> s;

    public NestedIterator(List<NestedInteger> nestedList) {
        s = new ArrayDeque<>(nestedList == null ? Arrays.asList() : nestedList);
    }
    
    @Override
    public Integer next() {
        return s.pollFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!s.isEmpty() && !s.peekFirst().isInteger()) {
            List<NestedInteger> list = s.pollFirst().getList();
            for (int i=list.size()-1; i>=0; i--) s.addFirst(list.get(i));
        }
        return !s.isEmpty();
    }
}