/*
346. Moving Average from Data Stream My Submissions QuestionEditorial Solution
Total Accepted: 3036 Total Submissions: 5034 Difficulty: Easy
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
Hide Company Tags Google
Hide Tags Design Queue
*/
public class MovingAverage {

    /** Initialize your data structure here. */
    public double ans = 0;
    public double size = 0.0;
    public Queue<Integer> queue = new LinkedList<Integer>();
    public MovingAverage(int size) {
        //size=this.size/10.0*10.0;
        this.size=(double)size;
    }
    
    public double next(int val) {
        if(queue.size()<size){
            ans=(ans*queue.size()+val)/(queue.size()+1);
            queue.offer(val);
        }
        else{
            ans-=queue.poll()/size;
            ans+=val/size;
            queue.offer(val);
        }
        return ans;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
