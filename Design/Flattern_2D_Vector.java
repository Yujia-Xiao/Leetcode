/*
Flatten 2D Vector
Implement an iterator to flatten a 2d vector.

For example,
Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

Hint:

How many variables do you need to keep track?
Two variables is all you need. Try with x and y.
Beware of empty rows. It could be the first few rows.
To write correct code, think about the invariant to maintain. What is it?
The invariant is x and y must always point to a valid point in the 2d vector. Should you maintain your invariant ahead of time or right when you need it?
Not sure? Think about how you would implement hasNext(). Which is more complex?Show More Hint 
Follow up:
As an added challenge, try to code it using only iterators in C++ or iterators in Java.

Hide Company Tags Google Airbnb Zenefits
Hide Tags Design
Hide Similar Problems (M) Binary Search Tree Iterator (M) Zigzag Iterator (M) Peeking Iterator
*/
public class Vector2D {

    List<List<Integer>> vec = new ArrayList<List<Integer>>();;
    private int[] index;
    private int[] hasValidVector;
    boolean allNull = false; //if it is all null
    int validVectorNum = 0;
    int currentVector = 0;
    int x = 0;
    int y = 0;
    
    public Vector2D(List<List<Integer>> vec2d) {
        vec = vec2d; 
        if(vec==null || vec.size()==0){allNull=true;}
        index = new int[vec2d.size()];
        for(int i=0;i<vec2d.size();i++){
            index[i]=vec2d.get(i).size(); //the end of each list
        }
        
        int j =0; int p = 0; int q = 0;
        hasValidVector = new int[vec.size()];//at most
        while(j<vec.size()){
        	if(vec.get(j).size()==0){p++;}
        	else{hasValidVector[q]=j;q++;}
        	j++;
        }
        if(p==vec.size()){allNull=true;} // in this case, we can know there must be a element
        //we have size - p
        validVectorNum = vec.size()-p;
        if(!allNull){x=hasValidVector[currentVector];y=0;}
        
    }

    public int next() {
        int ans = vec.get(x).get(y);
        if(y<index[x]-1){y++;}
        else{
            if(currentVector>=validVectorNum-1){allNull=true;}
            else{
                x=hasValidVector[currentVector+1];
                y=0;
                currentVector++;
            }
        }
        return ans;
    }

    public boolean hasNext() { // put the x and y to the right position
        if(allNull){return false;}
        return true;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */