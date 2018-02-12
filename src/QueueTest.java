import javax.swing.JOptionPane;
public class QueueTest {
    public static void main(String[] args) {
// Create a Queue
        Queue q = new LLQueue();
// Put some strings onto the queue
        JOptionPane.showMessageDialog(null, "About to enqueue words onto queue: \nThe end is nigh!");
        q.enqueue("The");
        q.enqueue("end");
        q.enqueue("is");
        q.enqueue("nigh!");
// Now dequeue the word in position 0 to free it up
        JOptionPane.showMessageDialog(null, "About to dequeue the words ...");
        String word = (String)q.dequeue(); // Note: have to cast Objects popped to String
        JOptionPane.showMessageDialog(null, "Word dequeued: " +
                word);
// Will enqueue a word which will test if it will go back toposition 0 to put it in as capacity is 4
        JOptionPane.showMessageDialog(null, "About to enqueue words onto queue: \nDoes it loop back");
        q.enqueue("Does it loop back"); // worked and put into position 0
        q.enqueue("Object 5");
        JOptionPane.showMessageDialog(null, "About to dequeue the words ...");
        while(! q.isEmpty()) {
            String word1 = (String)q.dequeue(); // Note: have tocast Objects popped to String
            JOptionPane.showMessageDialog(null, "Word dequeued: " +
                    word1);
        }
        System.exit(0);
    }
}