package 牛客机试;

import java.util.*;

/**
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是0。
 * 输入描述:
 * 输入一个int型整数
 *
 * 输出描述:
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 *
 * 示例1
 * 输入
 * 复制
 * 9876673
 * 输出
 * 复制
 * 37689
 */

public class GetNums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        String[] ss = str.split("");
        StringBuilder sb = new StringBuilder();
        //从后往前
        for(int i = ss.length - 1; i >= 0; i--) {
            //用map判断是否出现过
            if(map.containsKey(Integer.parseInt(ss[i]))) {
                continue;
            }
            else {
                sb.append(ss[i]);
                map.put(Integer.parseInt(ss[i]), 1);
            }
        }
        System.out.println(sb.toString());
    }
}
