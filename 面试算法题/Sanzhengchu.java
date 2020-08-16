package 面试算法题;

import java.util.*;

public class Sanzhengchu {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        char[] str = s.toCharArray();
        int[] arr = new int[str.length];
        int res=0;
        int sum=0;
        for(int i=0; i<arr.length; i++){
               arr[i] = str[i]-'0';
            }
          
            for(int i=0; i<arr.length; i++){
                sum += arr[i];
                if(arr[i]%3 == 0){
                    res++;
                    sum = 0;
                    continue;
                }
                if(sum%3 == 0){
                    res++;
                    sum = 0;
                }
            }
            System.out.println(res);
    }

}
