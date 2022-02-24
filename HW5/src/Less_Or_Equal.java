public class Less_Or_Equal {

    // Using binary search to count
    static int binarySearchCount(int arr[], int n, int key)
    {
        int left = 0, right = n;

        int mid = 0;
        while (left < right) {
            mid = (right + left) >> 1;

            // check if key is in array
            if (arr[mid] == key) {

                // If duplicates then use position of last elements
                while (mid + 1 < n && arr[mid + 1] == key)
                    mid++;
                break;
            }

            // If key is smaller, ignore right half
            else if (arr[mid] > key)
                right = mid;

            // If key is greater, ignore left half
            else
                left = mid + 1;
        }

        // If key is not found in array then it will be
        // before mid
        while (mid > -1 && arr[mid] > key)
            mid--;

        // Return mid + 1 as the count
        return mid + 1;
    }

    // main code
    public static void main(String[] args)
    {
        int arr[] = { 1,2,3,4,5,6};
        int key = 5;
        int n = arr.length;
        System.out.print(binarySearchCount(arr, n, key));
    }}
