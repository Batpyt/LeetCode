package 面试算法题;

public class Miaoshu {

    public String countAndSay(int n) {
        if(n == 1) return "1";
        String res = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < res.length(); i++) {
            int count = 1;
            while(i < res.length() - 1 && res.charAt(i) == res.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(count);
            sb.append(res.charAt(i));
        }

        return sb.toString();
    }
}
