package 栈;

import java.util.Deque;
import java.util.Stack;
/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
 * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 * 示例 1：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class CheckStack {
    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        System.out.println(validateStackSequences(pushed,popped));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        //新建一个栈来模拟
        Stack<Integer> s = new Stack<>();

        int j = 0;
        //模拟入栈出栈的过程
        for(int i : pushed) {
            //先入栈
            s.push(i);
            //j为指针，指向pushed数组，从头开始，若当前栈的peek==指针指向的元素，则出栈
            //循环此步骤，直到两元素不一样或者栈为空或者j大于pushed的长度
            while(!s.isEmpty() && s.peek() == popped[j] && j < pushed.length) {
                s.pop();
                j++;
            }
        }
        return j == pushed.length;
    }

    /*
    新建stack，依次往里入
    若栈顶元素==popped数组索引元素，出栈，索引右移
    看最后索引是否指向popped的末尾
     */
    public static boolean validateStackSequences2(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num);
            while(i < popped.length && !stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return i == popped.length;
    }
}
