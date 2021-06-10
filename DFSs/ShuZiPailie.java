package DFSs;

import 链表.ListNode;

import java.util.*;

public class ShuZiPailie {
    public static void main(String[] args) {
        int[][] res = promotions(4,3);
        for(int[] i : res) {
            for(int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

//        List<List<Integer>> res = promotions(4,3);
//        System.out.println(res);
    }

    public static int[][] promotions (int n, int k) {
        int[] c = new int[n];
        for(int i = 1; i <= n; i++) {
            c[i-1] = i;
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(c, 0, new ArrayList<>(), res, k);
        int[][] re = new int[res.size()][k];
        for(int i = 0; i < re.length; i++) {
            for(int j = 0; j < re[0].length; j++) {
                re[i][j] = res.get(i).get(j);
            }
        }
        Arrays.sort(re,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for(int i = 0; i < re[0].length; i++) {
                    if(o1[i] < o2[i]) return -1;
                    else if(o1[i] > o2[i]) return 1;
                    else continue;
                }
                return 0;
            }
        });
        return re;
        //return res;
    }

    public static void dfs(int[] c, int x, List<Integer> temp, List<List<Integer>> res, int k) {
        if(x >= k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue;
            swap(c, i, x);
            temp.add(c[x]);
            dfs(c, x+1, temp, res, k);
            temp.remove(temp.size() - 1);
            set.add(c[i]);
        }
    }

    public static void swap(int[] c, int i, int j) {
        int temp = c[i];
        c[i] = c[j];
        c[j] = temp;
        String s = "qwe";

        if(s.contains("A")) {

        }
    }
}
