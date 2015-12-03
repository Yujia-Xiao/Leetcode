/*
Min Stack My Submissions Question
Total Accepted: 53043 Total Submissions: 254686 Difficulty: Easy
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Hide Company Tags Amazon Google Uber Zenefits
Hide Tags Stack Design
Hide Similar Problems (H) Sliding Window Maximum
*/
class MinStack {   
    private List<Integer> stack = new ArrayList<Integer>();
    private List<Integer> minStack = new ArrayList<Integer>();
    public void push(int x) { //O(1)
        stack.add(x);
        if(minStack.isEmpty() || minStack.get(minStack.size()-1)>=x){
            minStack.add(x);
        }
    }

    public void pop() { //O(1)
        if(stack.isEmpty() || minStack.isEmpty()){return;}
        else{
            int a = stack.get(stack.size()-1);
            int b = minStack.get(minStack.size()-1);
            if(a==b){
                minStack.remove(minStack.size()-1);
            }
            stack.remove(stack.size()-1);
        }
    }

    public int top() { //O(1)
        if(stack.isEmpty()){return 0;}
        else{return stack.get(stack.size()-1);}
    }

    public int getMin() { //O(1)
        if(minStack.isEmpty()){return 0;}
        else{return minStack.get(minStack.size()-1);}
    }
}
