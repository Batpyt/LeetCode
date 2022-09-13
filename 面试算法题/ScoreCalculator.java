package 面试算法题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ScoreCalculator{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.next();
            String[] ss = str.split(",");
            if(str.equals("0000")){
                return;
            }
            if(ss.length == 1) {
                System.out.println(-(ss[0].charAt(0) - '0'));
                continue;
            }
            int count = 1;
            for(int i = 0; i < ss.length - 1; i++) {
                if(ss[i].charAt(0) == ss[i + 1].charAt(0)) {
                    count++;
                }
                else {
                    break;
                }
            }
            if(count == ss.length) {
                int mut = 1;
                for(int i = ss.length; i > 0; i--) {
                    mut *= i;
                }
                System.out.println((ss[0].charAt(0) - '0') * mut);
                continue;
            }
            int[][] arr = new int[ss.length][2];
            int index = 0;
            for(String s : ss) {
                arr[index][0] = s.charAt(0) - '0';
                if(s.charAt(1) == 'S') arr[index][1] = 1;
                if(s.charAt(1) == 'H') arr[index][1] = 2;
                if(s.charAt(1) == 'C') arr[index][1] = 3;
                if(s.charAt(1) == 'D') arr[index][1] = 4;
                index++;
            }
            Arrays.sort(arr ,(e1, e2) -> e1[0] - e2[0]);
            count = 1;
            for (int i = 0; i < arr.length - 1; i++) {
                if(arr[i][0] != arr[i + 1][0] - 1) {
                    System.out.println(arr[i][0] + " " + arr[i+1][0]);
                    break;
                }
                if(arr[i][1] != arr[i + 1][1] - 1) {
                    if(arr[i][1] != 4 && arr[i+1][1] != 1) {
                        System.out.println(arr[i][1] + " " + arr[i+1][1]);
                        break;
                    }
                }
                count++;
            }
            int sum = 0;
            for(int[] i : arr) {
                sum += i[0];
            }
            if(count != arr.length) {
                System.out.println(-sum);
                continue;
            }
            System.out.println(sum);
        }
    }
}
