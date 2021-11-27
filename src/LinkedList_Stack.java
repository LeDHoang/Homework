import static java.lang.System.exit;
class StackUsingLinkedlist {

    // A linked list node
    private class Node {

        int data; // integer data
        Node link; // reference variable Node type
    }
    // create global top reference variable global
    Node top;
    // Constructor
    StackUsingLinkedlist()
    {
        this.top = null;
    }

    // push to insert at beginning
    public void push(int x)
    {
        // new temp node
        Node temp = new Node();

        // if stack is full then it would cause overflow
        if (temp == null) {
            System.out.print("\nHeap Overflow");
            return;
        }

        // initialize data and link ot temp
        temp.data = x;
        temp.link = top;
        // update top reference
        top = temp;
    }

    // check if stack its empty or not
    public boolean isEmpty()
    {
        return top == null;
    }

    // return top node
    public int peek()
    {
        if (!isEmpty()) {
            return top.data;
        }
        else {
            System.out.println("Stack is empty");
            return -1;
        }
    }

    // pop top element
    public void pop()
    {
        // check for stack underflow
        if (top == null) {
            System.out.print("\nStack Underflow");
            return;
        }
        // update the top pointer to point to the next node
        top = (top).link;
    }

    public void display()
    {
        // check for stack underflow
        if (top == null) {
            System.out.print("\nStack Underflow");
            exit(1);
        }
        else {
            //Loop to display each node from top down
            Node temp = top;
            while (temp != null) {

                // print node data
                System.out.printf("%d->", temp.data);

                // move to next node
                temp = temp.link;
            }
        }
    }
}
public class LinkedList_Stack {
    public static void main(String[] args) {
        // create Object of Implementing class
        StackUsingLinkedlist obj = new StackUsingLinkedlist();
        // insert Stack value
        obj.push(11);
        obj.push(22);
        obj.push(33);
        obj.push(44);

        // test function of display,pop,peek
        obj.display();
        System.out.printf("\nTop element is %d\n", obj.peek());
        obj.pop();
        obj.pop();
        obj.display();
        System.out.printf("\nTop element is %d\n", obj.peek());
    }
}

