package 牛客机试;

import java.util.*;

/**
 * 定义一个单词的“兄弟单词”为：交换该单词字母顺序，而不添加、删除、修改原有的字母就能生成的单词。
 * 兄弟单词要求和原来的单词不同。例如：ab和ba是兄弟单词。ab和ab则不是兄弟单词。
 * 现在给定你n个单词，另外再给你一个单词str，让你寻找str的兄弟单词里，字典序第k大的那个单词是什么？
 * 注意：字典中可能有重复单词。本题含有多组输入数据。
 * 输入描述:
 * 先输入单词的个数n，再输入n个单词。
 * 再输入一个单词，为待查找的单词x
 * 最后输入数字k
 * 输出描述:
 * 输出查找到x的兄弟单词的个数m
 * 然后输出查找到的按照字典顺序排序后的第k个兄弟单词，没有符合第k个的话则不用输出。
 * 示例1
 * 输入
 * 复制
 * 3 abc bca cab abc 1
 * 输出
 * 复制
 * 2
 * bca
 */

public class FindWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] ss = str.split(" ");
        int size = Integer.parseInt(ss[0]);
        int k = Integer.parseInt(ss[ss.length - 1]);
        String target = ss[ss.length - 2];

        List<String> list = new ArrayList<>();
        int count = 0;
        for(int i = 1; i <= size; i++) {
            count += checkisBro(target, ss[i]);
            if(checkisBro(target, ss[i]) == 1) {
                list.add(ss[i]);
            }
        }
        String[] sarray = new String[list.size()];
        for(int i = 0; i < sarray.length; i++) {
            sarray[i] = list.get(i);
        }
        Arrays.sort(sarray);
//        for(String s : sarray) {
//            System.out.println(s+" ppp");
//        }
        String res = "";
        if(sarray.length >= k) {
            res = sarray[k - 1];
        }
        System.out.println(count);
        System.out.println(res);
    }

    public static int checkisBro(String target, String s) {
        if(s.length() != target.length() || s.equals(target)) {
            return 0;
        }
        char[] ch1 = target.toCharArray();
        char[] ch2 = s.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        if(Arrays.equals(ch1, ch2)) {
            System.out.println(target + " "+ s);
            return 1;
        }
        return 0;
    }
}
