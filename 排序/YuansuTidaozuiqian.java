package 排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
有一种排序算法定义如下，该排序算法每次只能把一个元素提到序列的开头，例如2，1，3，4，只需要一次操作把1提到序列起始位置就可以使得原序列从小到大有序。

现在给你个乱序的1-n的排列，请你计算最少需要多少次操作才可以使得原序列从小到大有序。

 */

public class YuansuTidaozuiqian {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = "";

        while((line = bf.readLine()) != null) {
            int size = Integer.parseInt(line);
            String[] sc = bf.readLine().split(" ");
            int[] num1 = new int[size];
            int[] num2 = new int[size];
            for(int i = 0; i < size; i++) {
                num1[i] = Integer.parseInt(sc[i]);
                num2[i] = num1[i];
                //System.out.println(num1[i] + " "+num2[i]);
            }
            Arrays.sort(num2);

            System.out.println(moveCount(num1, num2));

        }

    }

    public static int moveCount(int[] num1, int[] num2) {
        int res = 0;
        int i = num1.length - 1;
        int j = i - 1;
        while(i >= 0 && j >= 0) {
            if(num1[i] == num2[j]){
                i--;
                j--;
            }
            else{
                i--;
            }
        }
        return j + 1;
    }
}
