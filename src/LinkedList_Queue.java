class QNode {
    int key;
    QNode next;

    // default constructor
    public QNode(int key) {
        this.key = key;
        this.next = null;
    }
}

// class representing the queue line
// LIFO
class Queue {
    QNode front, rear;

    public Queue() {
        this.front = this.rear = null;
    }

    // enqueue to add a key to the line
    void enqueue(int key) {

        // Create a new node
        QNode temp = new QNode(key);

        // If queue is empty, new node is both front and rear
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }

        // Add the new node at the end of queue
        this.rear.next = temp;
        this.rear = temp;
    }

    // dequeue to remove top of line
    void dequeue() {
        // If queue is empty, return NULL.
        if (this.front == null)
            return;

        // Store front of the line and change the top node
        QNode temp = this.front;
        this.front = this.front.next;

        // If front becomes NULL, then change rear also as NULL
        if (this.front == null)
            this.rear = null;
    }
}

public class LinkedList_Queue {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.dequeue();
        q.dequeue();
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.dequeue();
        System.out.println("Queue Front : " + q.front.key);
        System.out.println("Queue Rear : " + q.rear.key);
    }
}
