/*
Two Sum III - Data structure design
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
Hide Company Tags LinkedIn
Hide Tags Hash Table Design
Hide Similar Problems (M) Two Sum (E) Unique Word Abbreviation
*/
import java.util.Set;
import java.util.HashSet;

public class TwoSum {

    private Map<Integer,Integer> mHashMap = new HashMap<Integer,Integer>(); 
 
    
    // Add the number to an internal data structure.
	public void add(int number) {
	    if(mHashMap.containsKey(number)){
	        mHashMap.put(number,mHashMap.get(number)+1);
	    }
	    else {mHashMap.put(number,1);}
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
        for (Map.Entry<Integer,Integer> entry : mHashMap.entrySet()){
            if(entry.getKey()*2 == value){
                if(entry.getValue() >1){return true;}
            }
            else {
                if(mHashMap.containsKey(value-entry.getKey())){
                    if((value-entry.getKey())!=entry.getKey()){return true;}
                }
            }
        }
	   
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);


public class TwoSum {

    private Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    
    // Add the number to an internal data structure.
    public void add(int number) {
        if(map.containsKey(number))map.put(number,map.get(number)+1);
        else map.put(number,1);
        return;
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        /*
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getKey()==value/2){
                if(entry.getValue()>1)return true;
            }
            else if(map.containsKey(value-entry.getValue())) return true;
        }
        */
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getKey()*2 == value){
                if(entry.getValue() >1){return true;}
            }
            else{
                if(map.containsKey(value-entry.getKey())){
                    //if((value-entry.getKey())!=entry.getKey()){return true;}
                    return true;
                }
            }
        }
        return false;
    }
}
