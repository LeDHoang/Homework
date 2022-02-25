class Sort {
    public static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length);
        return nums;
    }

    public static void mergeSort(int[] nums, int start, int end) {
        //base condition
        if (end - start == 1) {
            return;
        }
        int mid = (start + end) / 2;
        //sort the left part
        mergeSort(nums, start, mid);
        //sort the right part
        mergeSort(nums, mid, end);
        //merge the sorted parts
        mergeSortedParts(nums, start, mid, end);
    }

    public static void mergeSortedParts(int[] nums, int s, int m, int e) {
        int[] sorted = new int[e - s];
        int i = s, j = m, k = 0;
        //comparing both the sorted halfs/array
        while (i < m && j < e) {
            if (nums[i] < nums[j]) {
                sorted[k] = nums[i];
                i++;
            } else {
                sorted[k] = nums[j];
                j++;
            }
            k++;
        }
        //if some elements are left in first sorted half/array, copy them as is
        while (i < m) {
            sorted[k] = nums[i];
            i++;
            k++;
        }
        //if some elements are left in second sorted half/array, copy them as is
        while (j < e) {
            sorted[k] = nums[j];
            j++;
            k++;
        }
        //updating the initial array
        for (int l = 0; l < sorted.length; l++) {
            nums[s + l] = sorted[l];
        }
    }
}