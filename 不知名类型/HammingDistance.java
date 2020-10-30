package 不知名类型;

public class HammingDistance {
    public static void main(String[] args) {
        int x = 1, y = 4;
        System.out.println(hammingDistance(x, y));
    }

    public static int hammingDistance(int x, int y) {
        String x2 = toBinary(x);
        String y2 = toBinary(y);

        int sx = x2.length();
        int sy = y2.length();

        StringBuilder sb = new StringBuilder();
        if(sx < sy) {
            for(int i = 0; i < sy - sx; i++) {
                sb.append("0");
            }
            sb.append(x2);
            x2 = sb.toString();
        }
        if(sy < sx) {
            for(int i = 0; i < sx - sy; i++) {
                sb.append("0");
            }
            sb.append(y2);
            y2 = sb.toString();
        }
//        System.out.println(x2);
//        System.out.println(y2);
        int res = 0;
        for(int i = 0; i < x2.length(); i++) {
            if(x2.charAt(i) != y2.charAt(i)) res++;
        }

        return res;
    }
    public static String toBinary(int i) {
        String str = "";
        while(i != 0) {
            str = i%2 + str;
            i = i / 2;
        }
        return str;
    }
}
