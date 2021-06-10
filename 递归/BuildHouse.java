package 递归;

import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 * 假设在一条无限长的道路上盖房子，第一个月在某个点盖一个红房子，之后每个月，
 * 都会在上一次盖的新房子的左边盖一个绿房子，
 * 右边盖一个红房子。（假设两个房子之间的空间无限大，可以一直在中间盖房子）
 *
 * 用字符'R'表示红房子，用字符'G'表示绿房子。
 * 输入一个n(1≤n≤12)，表示过了n个月，打印出当前道路上房子从左到右的排列。
 *
 * 要求：
 * 1.    当输入非数字,输出：N
 * 2.    当输入数字超出限制时，输出O
 *
 * 样例：
 * 输入1
 * 输出 R
 * 输入2
 * 输出 GRR
 * 输入3
 * 输出 GGRRGRR
 * 输入5
 *
 * 输出 GGRGGRRGGGRRGRRRGGRGGRRRGGRRGRR
 */

public class BuildHouse {
    public static void main(String[] args) {
        String s = "13131231231123";
        System.out.println(buildHouse(s));
    }

    public static String buildHouse(String n) {
        String ss = null;
        if(n.equals(ss)) return "N";
        if(n.isEmpty()) return "N";
        for(Character c : n.toCharArray()) {
            if(!Character.isDigit(c)) return "N";
        }
        long temp = Long.parseLong(n);
        if(temp >= Integer.MAX_VALUE) return "O";
        int num = Integer.parseInt(n);
        if(num > 12 || num < 1) return "O";
        if(num == 1) return "R";

        List<Integer> list = new ArrayList<>();
        list.add(0);
        return build("R", list, num - 1);
    }

    public static String build(String res, List<Integer> index, int num) {
        if(num == 0) return res;
        List<Integer> newindex = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < res.length(); i++) {
            if(index.contains(i)) {
                sb.append("G");
                newindex.add(sb.length() - 1);
                sb.append(res.charAt(i));
                sb.append("R");
                newindex.add(sb.length() - 1);
            }
            else {
                sb.append(res.charAt(i));
            }
        }
        return build(sb.toString(), newindex, num - 1);
    }
}
