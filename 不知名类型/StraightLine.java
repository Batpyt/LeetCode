package 不知名类型;
/**
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 *
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-it-is-a-straight-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class StraightLine {
    public static void main(String[] args) {

    }

    //计算斜率即可
    public static boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length <= 2) return true;
        int a = coordinates[1][0] - coordinates[0][0];
        int b = coordinates[1][1] - coordinates[0][1];
        for(int i = 2; i < coordinates.length; i++) {
            int tempa = coordinates[i][0] - coordinates[i-1][0];
            int tempb = coordinates[i][1] - coordinates[i-1][1];
            if(tempa * b != tempb * a) return false;
        }
        return true;
    }
}
