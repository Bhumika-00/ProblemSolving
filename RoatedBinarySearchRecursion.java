public class RoatedBinarySearchRecursion {
    public static void main(String[] args) {
        int arr[] = {5, 6, 7, 8, 9, 1, 2, 3};
        System.out.println(BinarySearch(arr, 1, 0, arr.length - 1));
    }

    public static int BinarySearch(int arr[], int key, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (arr[mid] == key) {
            return mid;
        }

        // Check if the left half is sorted
        if (arr[start] <= arr[mid]) {
            if (key >= arr[start] && key < arr[mid]) {
                return BinarySearch(arr, key, start, mid - 1);
            } else {
                return BinarySearch(arr, key, mid + 1, end);
            }
        } 
        // Right half is sorted
        else {
            if (key > arr[mid] && key <= arr[end]) {
                return BinarySearch(arr, key, mid + 1, end);
            } else {
                return BinarySearch(arr, key, start, mid - 1);
            }
        }
    }
}
