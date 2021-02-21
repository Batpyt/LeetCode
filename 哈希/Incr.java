package 哈希;

import java.util.*;

public class Incr {
    private Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Incr incr = new Incr();
        System.out.println(incr.Incr("a"));
        System.out.println(incr.Incr("a"));
        System.out.println(incr.Incr("c"));
    }

    public int Incr(String str) {
        synchronized (this) {
            try {
                if(map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                    return map.get(str);
                }
                else {
                    map.put(str, 1);
                    return 1;
                }
            } catch (Exception e) {
                return -1;
            }
        }


    }
}
