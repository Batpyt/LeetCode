package 二分法;

public class PeakOfMountain {
    public static void main(String[] args) {
        int[] arr = {0, 10, 5, 2};
        System.out.println(peakIndexInMountainArray(arr));
    }


    public static int peakIndexInMountainArray(int[] arr) {
        if(arr.length == 3) return 1;
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
                left = mid;
            }
            else if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) {
                right = mid;
            }
            else if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
        }
        return left;
    }
}
