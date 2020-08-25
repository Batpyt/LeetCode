package 动态规划;
import java.lang.*;

public class Zuichangbuchongfu {
    public static void main(String[] args){
        String s = " ";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.equals("")) return 0;
        int res = 1;
        for(int i = 0; i < s.length() - 1; i++){
            char c = s.charAt(i);
            String temp = "";
            temp = temp + s.charAt(i);
            int j = i + 1;
            int count = 1;
            //System.out.println(j);
            while(j < s.length()){
                if(temp.indexOf(s.charAt(j)) != -1){
                    break;
                }
                temp = temp + s.charAt(j);
                //System.out.println(temp + " " + s.charAt(j));
                count++;
                j++;
            }
            if(count > res){
                res = count;
            }
        }
        return res;
    }
}
