package 哈希;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Anagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        //新建哈希图，key为每个字符串排完序之后的字符串
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            //将字符串排序，当作key
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);//只能这样转回string，不知道为什么
            //String key = array.toString();

            //根据key在马匹、中寻找，若找到，list为key对应的列表，若没找到，list为new的列表
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            //再将字符串加入列表中，在加入map
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
