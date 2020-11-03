package 排序;
/*
给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。

返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：

如果 S[i] == "I"，那么 A[i] < A[i+1]
如果 S[i] == "D"，那么 A[i] > A[i+1]
 

示例 1：

输入："IDID"
输出：[0,4,1,3,2]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/di-string-match
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class StringMatch {
    public static void main(String[] args) {
        String s = "IDID";
        int[] res = diStringMatch(s);
        for(int i : res) {
            System.out.println(i);
        }
    }

    public static int[] diStringMatch(String S) {
        int len = S.length();
        int[] res = new int[len + 1];

        /*
        双指针，一个指向最小可用，一个指向最大可用
        如果是I，当前为最小可用，如果是D，当前为最大可用
         */
        int low = 0, high = len;
        for(int i = 0; i < len; i++) {
            if(S.charAt(i) == 'I') {
                res[i] = low;
                low++;
            }
            else {
                res[i] = high;
                high--;
            }
        }
        res[len] = low;
        return res;
    }
}
