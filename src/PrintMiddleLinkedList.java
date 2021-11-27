import java.util.Objects;
import java.util.Scanner;

public class PrintMiddleLinkedList {
    static class Node {
        String data;
        Node next;

        Node(String d) {
            data = d;
            next = null;
        }
    }

    static class LinkedList {
        Node head;
        public String GetNth(int index) {
            Node current = head;
            int count = 0;
            while (current != null) {
                if (count == index)
                    return current.data;
                count++;
                current = current.next;
            }
            assert (false);
            return "0";
        }

        public void push(String new_data) {
            Node new_Node = new Node(new_data);
            new_Node.next = head;
            head = new_Node;
        }

    }
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string to push into the linked list: (Enter Stop* to end)");
        while (true) {
            String input = sc.nextLine();
            if (!Objects.equals(input, "Stop*")) {
                list.push(input);
            } else {
                break;
            }
        }
        System.out.println("Enter the index to the last of the element that you want to print");
        int index = sc.nextInt();
        System.out.println("Element at index yu trying to find is "+ list.GetNth(index));
}

}
