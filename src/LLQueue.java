public class LLQueue implements Queue
{

    private Node head;	 // head node of the list
    private Node tail;	 // last position in the list
    private long size;	 // number of nodes in the list

    public LLQueue() {
        tail = head = null;
        size = 0;
    }
    public void enqueue(Object el)
    {
        if (head == null){
            insertHead(el);
            return;
        }

        Node newnode = new Node(el, tail.getNext());
        tail.setNext(newnode);
        size++;

        tail = newnode;
    }

    public Object dequeue()
    {
        if (head == null)
            return null; // Can't do anything if it's empty

        Object returnHead = head.getElement();
        head = head.getNext();
        size--;
        return returnHead;
    }
    public boolean isEmpty() {
        return (size == 0);
    }

    public Object front()
    {
        if (isEmpty())
            return null;
        return head;
    }

    public long getSize() {
        return size;
    }

    public void insertHead(Object el){
        Node oldhead = head;
        head = new Node(el, oldhead);
        size++;
        if (size == 1)
            tail = head;
    }
}