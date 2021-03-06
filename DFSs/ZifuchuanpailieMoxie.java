package DFSs;

import java.util.*;

public class ZifuchuanpailieMoxie {
    static List<String> list = new ArrayList<>();
    static char[] c;
    public static void main(String[] args) {
        String s = "abc";
        String[] res = permutation(s);
        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return list.toArray(new String[list.size()]);
    }

    public static void dfs(int x) {
        if(x >= c.length - 1) {
            list.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) {
                continue;
            }
            set.add(c[i]);
            swap(i, x);
            dfs(x + 1);
            swap(i, x);
        }
    }

    public static void swap(int x, int i) {
        char temp = c[i];
        c[i] = c[x];
        c[x] = temp;
    }

}
