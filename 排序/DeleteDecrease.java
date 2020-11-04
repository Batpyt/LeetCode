package 排序;
/*
删除某几列字符，使得剩余的字符数组为升序排列
c d g
a f i
删除b a h
计算至少删除几列
 */

public class DeleteDecrease {
    public static void main(String[] args) {
        String[] s = {"cba", "daf", "ghi"};
        System.out.println(minDeletionSize(s));
    }

    public static int minDeletionSize(String[] A) {
        int res = 0;

        for(int i = 0; i < A[0].length(); i++) {
            for(int j = 1; j < A.length; j++) {
                //如果判断到下一个字符比当前的小，则为降序，跳出循环并res++
                if(A[j - 1].charAt(i) > A[j].charAt(i)) {
                    res++;
                    break;
                }
            }

        }
        return res;
    }

}
