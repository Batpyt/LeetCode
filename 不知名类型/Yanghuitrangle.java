package 不知名类型;

import java.util.ArrayList;
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
        //System.out.println(generate(5));
        System.out.println(getRow(3));
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

    /**
     * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        int[][] row = new int[rowIndex+1][rowIndex+1];
        for(int i = 0; i < rowIndex+1; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    row[i][j] = 1;
                }
                else {
                    row[i][j] = row[i - 1][j] + row[i - 1][j - 1];
                }
            }
        }
        for(int i : row[rowIndex]) {
            list.add(i);
        }
        return list;
    }

    //杨辉三角公示
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int) cur);
            cur = cur * (rowIndex-i)/(i+1);
        }
        return res;
    }
}
