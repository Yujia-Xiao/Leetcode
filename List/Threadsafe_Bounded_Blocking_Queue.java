/*Implement following interface so that multi-put is atomic. 
Expect multiple producers and consumers inserting to 
and extracting from this queue implementation. */

/** 
* threadSafe bounded blocking queue implementation. 
* Expected to be used in a 
* Producer->Consumer pattern 
*/ 
public interface MultiPutBlockingBoundedQueue<E> { 

/** 
* Sets the capacity of the buffer. Can be called only once. If called more 
* than once or if the passed capacity is <= 0, throw an exception. 
*/ 
public void init(int capacity) throws Exception; 

/** 
* Get the next item from the queue throws Exception if not initialized 
*/ 
public E get() throws Exception; 

/** 
* Put the item to the tail of the queue. throws Exception if not 
* initialized 
*/ 
public void put(E obj) throws Exception; 

/** 
* Put the list of items in an atomic manner. The list can be more than the 
* capacity throws Exception if not initialized 
*/ 
public void multiput(List<E> objs) throws Exception; 

}