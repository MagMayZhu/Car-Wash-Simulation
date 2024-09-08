import java.util.LinkedList;
import java.lang.Object; 
import java.util.NoSuchElementException;

/**
 * Give the method purpose. For example enqueue method adds the last item. 
 *
 * @author (Maggie Zhu and Anna Phyo)
 * @version (4-22-24)
 */
public class LLQueues<T> extends Object implements KQueue<T>
{
    // instance variables - replace the example below with your own
    private LinkedList<T> LinkedList;

    /**
     * Constructor for objects of class LLQueues
     */
    public LLQueues()
    {
        // initialise instance variables
        this.LinkedList = new LinkedList();
    }

    /** Returns <code>true</code> if this queue is empty;
     *  <code>false</code> otherwise.
     **/
    @Override
    public boolean isEmpty()
    {
        return (LinkedList.isEmpty());
    }

    /** Adds a specified object to the "back" of this queue.
     *    @param item - the object to add to the queue
     **/
    @Override
    public void enqueue(T item)
    {
        LinkedList.addLast(item);
    }

    /** Removes the element at the "front" of this queue.
     *    @returns the removed element
     *    @throws NoSuchElementException if the queue is empty
     **/
    @Override
    public T dequeue()
    {
        if(isEmpty())
            throw new NoSuchElementException("Queue");
        return LinkedList.removeFirst();
    }

    /** Returns the element at the "front" of this queue, without
     *  modifying the queue.
     *    @returns the element at the front of the queue
     *    @throws NoSuchElementException if the queue is empty
     **/
    @Override
    public T peekFront(){
        if(isEmpty()){
            throw new NoSuchElementException();

        }
        return LinkedList.peekFirst();
    }

    public int Size()
    {
        return LinkedList.size();
    }

    /**
     * method that gets the current state of the queue 
     * return the current state of queue in a single string. 
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();// Creating the StringBuilder object
        sb.append("["); // adds bracket to start of list 
        for(int i=0 ; i <LinkedList.size() ; i++){// create loop to add to String if follows 
            sb.append(LinkedList.get(i).toString());// Adding an item in a specific index into a String. 
            if ( i != LinkedList.size() -1){// if if i does not equal add comma .
                sb.append(","); 
            }
        }
        sb.append("]");// End the string with bracket
        return sb.toString(); // return the string sb. 

    }
}

