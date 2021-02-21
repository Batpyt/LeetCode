package 牛客机试;

import java.util.*;
public class CountChar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine().toLowerCase();
        char cs[] = scan.nextLine().toLowerCase().toCharArray();
        char target = cs[0];
        int count = 0;
        for(char c : str.toCharArray()) {
            if(c == target) count++;
        }
        System.out.println(count);
    }
}
