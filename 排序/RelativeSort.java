package 排序;

/**
 * 给你两个数组，arr1 和arr2，
 *
 * arr2中的元素各不相同
 * arr2 中的每个元素都出现在arr1中
 * 对 arr1中的元素进行排序，使 arr1 中项的相对顺序和arr2中的相对顺序相同。未在arr2中出现过的元素需要按照升序放在arr1的末尾。
 *
 * 示例：
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class RelativeSort {
    public static void main(String[] args) {
        int[] arr1 = {28,6,22,8,44,17};
        int[] arr2 = {22,28,8,6};

        RelativeSort r = new RelativeSort();
        int[] res = r.relativeSortArray(arr1, arr2);
        for(int i : res) {
            System.out.print(i + " ");
        }
    }
    /**
     * 先遍历arr1记录每个数出现的次数，记录在数组f中，再遍历arr2，根据出现的数字去匹配出现的次数然后赋值，并将该数字在f中的次数归零
     * 最后遍历f数组，非零的赋值在数组中
     */

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int upper = Integer.MIN_VALUE;
        //寻找最大值，f数组的大小为最大值+1即可
        for(int i : arr1) {
            if(i >= upper) upper = i;
        }

        //遍历arr1，将出现次数记录
        int[] f = new int[upper + 1];
        for(int i : arr1) {
            f[i]++;
        }

        //根据出现次数赋值
        //index为在数组arr1中的位置
        int index = 0;
        for(int i : arr2) {
            //按照当前i的出现次数给f[i]个元素赋值
            for(int j = 0; j < f[i]; j++) {
                arr1[index] = i;
                index++;
            }
            f[i] = 0;
        }

        //将剩余没在arr2中出现的元素添加到arr1末尾
        for(int i = 0; i < upper + 1; i++) {
            if(f[i] > 0) {
                for(int j = 0; j < f[i]; j++) {
                    arr1[index] = i;
                    index++;
                }
                f[i] = 0;
                System.out.println(i);
            }
        }
        return arr1;
    }
}
