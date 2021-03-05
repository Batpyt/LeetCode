package 哈希;

import java.util.*;

/**
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 示例 2：
 *
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-dna-sequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class RepeatedDNA {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        String s1 = "AAAAAAAAAAA";
        System.out.println(findRepeatedDnaSequences(s1));
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        //将出现过的片段存入map
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        //短于10直接返回
        if(s.length() <= 10) {
            return res;
        }

        int left = 0;
        int right = 10;
        //滑动窗口，维持在10个
        for(right = 10; right < s.length()+1; right++) {
            String temp = s.substring(left, right);
            System.out.println(temp);
            if(!map.containsKey(temp)) {
                map.put(temp, 1);
            }
            else {
                map.put(temp, map.get(temp) + 1);
            }
            left++;
        }
        System.out.println(map);
        //大于一次的输出
        for(String key : map.keySet()) {
            if(map.get(key) > 1) {
                res.add(key);
            }
        }

        return res;
    }
}
