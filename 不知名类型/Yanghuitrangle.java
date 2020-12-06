package 不知名类型;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Yanghuitrangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    /*
    1
    1 1
    1 2 1
    1 3 3 1
    1 4 6 4 1
    1 5 10 10 5 1
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new LinkedList<>();
        int[][] row = new int[numRows][numRows];
        for(int i = 0; i < numRows; i++) {
            List<Integer> list = new LinkedList<>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    row[i][j] = 1;
                }
                else{
                    row[i][j] = row[i - 1][j - 1] + row[i - 1][j];
                }
                list.add(row[i][j]);
            }
            lists.add(list);
        }
        return lists;
    }
}
