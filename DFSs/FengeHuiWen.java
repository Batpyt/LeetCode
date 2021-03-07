package DFSs;

import netscape.security.UserTarget;

import java.util.*;

public class FengeHuiWen {

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }


    public static List<List<String>> partition(String s) {
        List<String> cur = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        dfs(s, cur, 0, res);
        return res;
    }

    /**
     *
     * @param s 原字符串
     * @param cur 目前记录的字符串链表
     * @param start 该次循环起始字符的节点，字符串开始遍历的索引
     * @param res 结果
     */
    public static void dfs(String s, List<String> cur, int start, List<List<String>> res ) {
        //若起始节点已经大于字符串的长度，说明遍历结束，将该次记录的字符串链表记录至结果
        if(start == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }

        //从当前的起始节点开始
        for(int i = start; i < s.length(); i++) {
            //取start到i的子字符串，并判断是否回文
            String temp = s.substring(start, i + 1);
            //若不是，跳过该循环
            if(!isHuiWen(temp)) {
                continue;
            }
            //若是，记录至目前记录的字符串链表
            cur.add(temp);
            //起始点后移，调用该方法
            //返回后再回溯
            dfs(s, cur, i + 1, res);
            cur.remove(cur.size() - 1);
            /*
            过程可以理解为：
            a(yes), a(yes), b(yes)
            回溯
            a, a
            回溯
            a,
            a, ab(yes)
            */
        }
    }

    public static boolean isHuiWen(String s) {
        if(s == null || s.length() <= 1) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
