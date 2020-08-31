package 队列;


import java.util.LinkedList;
import java.util.Queue;

public class Jioupailie {
    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        int[] res = reOrderArray(array);
        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static int[] reOrderArray (int[] array) {
        Queue<Integer> ji = new LinkedList<>();
        Queue<Integer> ou = new LinkedList<>();

        for(int num : array) {
            if(num % 2 == 0) {
                ou.offer(num);
                //System.out.println("oushu "+ num);
            }
            else {
                ji.offer(num);
                //System.out.println("jishu "+num);
            }
        }

        int[] res = new int[array.length];
        int i = 0;
        while(!ji.isEmpty()) {
            res[i] = ji.poll();
            System.out.println("jishu "+ res[i]);
            i++;
        }
        while(!ou.isEmpty()) {
            res[i] = ou.poll();
            System.out.println("oushu "+res[i]);
            i++;
        }

        return res;

    }
}
