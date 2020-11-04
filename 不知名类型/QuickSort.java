package 不知名类型;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4,5,6,3,2,2,8,1,2};
        qsort(arr,0,arr.length - 1);

        for(int i : arr) {
            System.out.print(i+" ");
        }
    }

    public static void qsort(int[] arr, int low, int high) {
        if(low < high) {
            int index = getIndex(arr,low,high);

            qsort(arr,low, index - 1);
            qsort(arr, index + 1, high);
        }

    }

    public static int getIndex(int[] arr, int low, int high) {
        int key = arr[low];

        while(low < high) {
            while(low < high && arr[high] >= key) high--;
            arr[low] = arr[high];

            while(low < high && arr[low] <= key) low++;
            arr[high] = arr[low];
        }
        arr[low] = key;
        return low;
    }
}
