package 栈;

import java.util.Stack;
/*

给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，
返回 true；否则，返回 false 。

示例 1：
输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
输出：true
解释：我们可以按以下顺序执行：
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1

示例 2：
输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
输出：false
解释：1 不能在 2 之前弹出。
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
}
