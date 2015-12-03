/*
Zigzag Iterator
Given two 1d vectors, implement an iterator to return their elements alternately.

For example, given two 1d vectors:

v1 = [1, 2]
v2 = [3, 4, 5, 6]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

Clarification for the follow up question - Update (2015-09-18):
The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

[1,2,3]
[4,5,6,7]
[8,9]
It should return [1,4,8,2,5,9,3,6,7].
Hide Company Tags Google
Hide Tags Design
Hide Similar Problems (M) Binary Search Tree Iterator (M) Flatten 2D Vector (M) Peeking Iterator
*/
public class ZigzagIterator {
    private List<Integer> v1;
    private List<Integer> v2;
    private int i;
    private int j;
    private int listId;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        this.i = 0;
        this.j = 0;
        this.listId = 0;
    }

    public int next() {
        int result = 0;
        if (i >= v1.size()) {
            result = v2.get(j);
            j++;
        } else if (j >= v2.size()) {
            result = v1.get(i);
            i++;
        } else {
            if (listId == 0) {
                result = v1.get(i);
                i++;
                listId = 1;
            } else {
                result = v2.get(j);
                j++;
                listId = 0;
            }
        }        
        return result;        
    }
    
    public boolean hasNext() {
        return i < v1.size() || j < v2.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */