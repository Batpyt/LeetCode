package 排序;

public class Kuaipai {
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        qs(arr,0,arr.length - 1);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void qs(int[] arr, int low, int high) {
        if(low < high) {
            int index = getIndex(arr, low, high);

            qs(arr, low, index - 1);
            qs(arr, index + 1, high);
        }

    }

    /*
    本质为挖坑填数+分治
    https://blog.csdn.net/wehung/article/details/82704565
     */
    public static int getIndex(int[] arr, int low, int high) {
        //设置一个基准值，为当前队首元素，基准值处挖了坑
        int key = arr[low];

        //当首指针小于尾指针时，循环
        while(low < high) {
            //5 3 2 1
            //当首尾指针符合条件，且尾指针元素大于基准值时，尾指针前移
            while(low < high && arr[high] >= key) {
                high--;
            }
            //当跳出循环时，说明当前尾指针元素比基准值小，将当前尾指针元素赋值给第首指针位置，给基准值填坑
            arr[low] = arr[high];
            //1 3 2 1

            //当首尾符合条件，且首指针元素小于基准值时，首指针后移
            while(low < high && arr[low] <= key) {
                low++;
            }
            //当跳出循环时，说明基首指针元素比基准值大，将首指针的元素赋值给尾指针位置
            arr[high] = arr[low];
            // 1 3 2 5
            //low = 4
        }
        //跳出循环时，low == high， 将基准值赋值给当前指针位置。
        arr[low] = key;
        return low;
    }
}
