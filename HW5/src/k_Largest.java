import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class k_Largest
{
    // Function to find the k'th largest element using min-heap
    public static int findKthLargest(List<Integer> ints, int k)
    {
        // base case
        if (ints == null || ints.size() < k) {
            System.exit(-1);
        }

        // create a min-heap using the `PriorityQueue` class and insert
        // the first `k` array elements into the heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(ints.subList(0, k));

        //remaining array elements
        for (int i = k; i < ints.size(); i++)
        {
            // if the current element is more than the root of the heap
            if (ints.get(i) > pq.peek())
            {
                // replace root with the current element
                pq.poll();
                pq.add(ints.get(i));
            }
        }

        // return the root of min-heap
        return pq.peek();
    }


    public static void main(String[] args)
    {
        List<Integer> ints = Arrays.asList(2,3,4,8,7, 4, 6, 3, 9, 1);
        int k = 2;

        System.out.println("k'th largest array element is " + findKthLargest(ints, k));
    }
}
