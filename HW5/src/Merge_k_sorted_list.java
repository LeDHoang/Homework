//NOde class
class Node {
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
    }
}

public class Merge_k_sorted_list {
    //Function to merge list with compare of 2 node
    public static Node SortedMerge(Node a, Node b)
    {
        Node result = null;
        /* Base cases */
        if (a == null)
            return b;
        else if (b == null)
            return a;

        //Compare a and b data
        if (a.data <= b.data) {
            result = a;
            result.next = SortedMerge(a.next, b);
        }
        else {
            result = b;
            result.next = SortedMerge(a, b.next);
        }
        return result;
    }
    //Main function to merge sorted lists
    //generate the sorted output list
    public static Node mergeKLists(Node arr[], int last)
    {
        // repeat until only one list is left or i>=j
        while (last != 0) {
            int i = 0, j = last;

            // (i, j) forms a pair
            while (i < j) {
                // merge List i with List j and store
                // merged list in List i
                arr[i] = SortedMerge(arr[i], arr[j]);

                // consider next pair
                i++;
                j--;

                // If all pairs are merged, update last
                if (i >= j)
                    last = j;
            }
        }

        return arr[0];
    }

    //Loop to print list
    public static void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String args[])
    {
        int k = 3; // Number of linked lists
        int n = 3; // Number of elements in each list

        // an array of pointers storing the head nodes
        // of the linked lists
        Node arr[] = new Node[k];

        arr[0] = new Node(1);
        arr[0].next = new Node(10);
        arr[0].next.next = new Node(20);

        arr[1] = new Node(4);
        arr[1].next = new Node(11);
        arr[1].next.next = new Node(13);

        arr[2] = new Node(3);
        arr[2].next = new Node(8);
        arr[2].next.next = new Node(9);

        // Merge all lists
        Node head = mergeKLists(arr, k - 1);
        printList(head);
    }
}
