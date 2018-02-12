import javax.swing.JOptionPane;
public class LLQueue implements Queue
{
    protected Object Q[]; // array used to implement the queue
    protected int rear = -1; // index for the rear of the queue
    protected int front = 0;
    protected int count = 0; // to keep track of if the amount of data in the array

    protected Node head;	 // head node of the list
    protected Node tail;	 // last position in the list
    protected Node curr;	 // node referencing current position in the list
    protected long size;	 // number of nodes in the list
    public LLQueue() {
// this constructor allows you to specify capacity
        curr = tail = head = null;
        size = 0;
    }
    public void enqueue(Object el)
    {
        if (head == null){
            insertHead(el);
            return;
        }

        Node newnode = new Node(el, curr.getNext());
        curr.setNext(newnode);
        size++;

        if (tail == curr)
            tail = newnode;

        curr = newnode;
    }
    public Object dequeue()
    {
// Can't do anything if it's empty
        if (isEmpty())
            return null;
        Object toReturn = Q[front];
        Q[front] = null; //set the object which has been dequeued to null to free it
        front = (front+1) % Q.length; //move the front of the queue forward by 1
        count--; // decrease the count by 1
        return toReturn;
    }
    public boolean isEmpty() {
        return (count == 0);
    }
    public boolean isFull() {
        return (count == size);
    }
    public Object front()
    {
        if (isEmpty())
            return null;
        return Q[0];
    }

    public void insertHead(Object el){
        Node oldhead = head;
        head = new Node(el, oldhead);
        size++;
        curr = head;
        if (size == 1)
            tail = head;
    }
}