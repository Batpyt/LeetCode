package 栈;

import java.util.*;

/**
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DailyTemperature {
    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures(T);
        for(int i : res) {
            System.out.print(i +" ");
        }
    }

    /*
    维护单调栈
    栈中储存正在寻找更高气温的天的索引
    当找到更高的气温时将天出栈，计算天数
     */
    public static int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];

        for(int i = 0; i < T.length; i++) {
            //当遇到有更高温度时，索引出栈，并计算天数
            while(!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int p = stack.pop();
                res[p] = i - p;
            }
            stack.push(i);
        }
        return res;
    }
}
