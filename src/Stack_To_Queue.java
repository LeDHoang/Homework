import java.util.Stack;
//Using Stack to implement Queue
public class Stack_To_Queue {
    static class Queue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;
    }

    //Push data to stack
    static void push(Stack<Integer> top_ref, int new_data) {
        top_ref.push(new_data);
    }

    //Remove top item of stack
    static int pop(Stack<Integer> top_ref) {
        //Underflow error if stack is empty
        if (top_ref.isEmpty()) {
            System.out.println("Stack Underflow");
            System.exit(0);
        }

        //else pop the data from the stack
        return top_ref.pop();
    }

    // Enqueue and Dequeue function
    //Push x to stack1
    static void enQueue(Queue q, int x) {
        push(q.stack1, x);
    }

    static int deQueue(Queue q) {
        int x;

        //If both are empty
        if (q.stack1.isEmpty() && q.stack2.isEmpty()) {
            System.out.println("Q is empty");
            System.exit(0);
        }

        //if stack2 empty move all element from stack1 to stack2 if stack1 is not empty
        if (q.stack2.isEmpty()) {
            while (!q.stack1.isEmpty()) {
                x = pop(q.stack1);
                push(q.stack2, x);
            }
        }
        //Pop froms stack2 only
        x = pop(q.stack2);
        return x;
    }

    public static void main(String args[]) {
        /* Create a queue with items 1 2 3*/
        Queue q = new Queue();
        q.stack1 = new Stack<>();
        q.stack2 = new Stack<>();
        enQueue(q, 1);
        enQueue(q, 2);
        enQueue(q, 3);

        /* Dequeue items */
        System.out.print(deQueue(q) + " ");
        System.out.print(deQueue(q) + " ");
        System.out.println(deQueue(q) + " ");
    }
}
