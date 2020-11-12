package 不知名类型;

import java.util.Stack;

/**
 * 给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。
 * 输入："((("
 * 输出：3
 *
 * 输入："()"
 * 输出：0
 *
 * 输入："()))(("
 * 输出：4
 */

public class Minaddkuohao {
    public static void main(String[] args) {
        String s = "(((";
        Minaddkuohao m = new Minaddkuohao();
        System.out.println(m.minAddToMakeValid("()))(("));
    }

    public int minAddToMakeValid(String S) {
        //记录有多少左括号
        int left = 0;

        //多少右括号
        int right = 0;
        int add = 0;
        for(char c : S.toCharArray()) {
            //记录左括号个数
            if(c == '(') left++;
            else {
                //当遍历到右括号且有左括号待匹配时，左括号个数-1
                if(left > 0) left--;
                //若没有待匹配左括号，多余右括号个数+1
                else right++;
            }
        }
        //尚未匹配的左括号个数和多余的右括号个数则为答案
        return right + left;
    }
}
