package 面试算法题;
import java.util.*;
/*
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
/*
运用hashmap，key为每个字符，value为boolean值，表示的是当前字符是否只出现了一次
 */

public class Zhichuxianyici {
    public static void main(String[] args){
        String s = "abaccdeff";

        System.out.println(firstUniqChar(s));
    }

    public static char firstUniqChar(String s) {
        char[] cs = s.toCharArray();
        HashMap<Character, Boolean> map = new HashMap<>();

        for(char c : cs){
            map.put(c, !map.containsKey(c));  //若字符已经出现过，则!map.containsKey(c)为false。
        }
        for(char c : cs){
            if(map.get(c)){  //将value为true的key输出。
                return c;
            }
        }
        return ' ';
    }
}
