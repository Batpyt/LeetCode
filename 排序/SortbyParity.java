package 排序;
/*
按奇偶排序：一偶一奇/偶完了奇
 */

public class SortbyParity {
    public static void main(String[] args) {
        int[] a = {4,2,5,7};
        SortbyParity s = new SortbyParity();
        int[] res = s.sortArrayByParityII(a);
        for(int i : res) {
            System.out.print(i +" ");
        }
        System.out.println();
        int[] b = {3,1,2,4};
        int[] ress = s.sortArrayByParity(b);
        for(int i : ress) {
            System.out.print(i + " ");
        }
    }

    /**
     * 双指针，一个指偶数位置一个指奇数位置
     */
    public int[] sortArrayByParityII(int[] A) {
        int[] res = new int[A.length];
        int even = 0;
        int odd = 1;
        for(int i : A) {
            if(i % 2 == 0) {
                res[even] = i;
                even = even + 2;
            }
            else {
                res[odd] = i;
                odd = odd + 2;
            }
        }

        return res;
    }

    //首位双指针
    public int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];
        int left = 0;
        int right = A.length - 1;
        for(int i : A) {
            if(i % 2 == 0) {
                res[left] = i;
                left++;
            }
            else {
                res[right] = i;
                right--;
            }
        }
        return res;
    }

}
