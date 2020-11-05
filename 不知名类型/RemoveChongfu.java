package 不知名类型;

/*
字符串去重
 */
public class RemoveChongfu {
    public static void main(String[] args) {
        String s = "qwewewqweqsdgdwgsafasdwqeqeqeqweqwwwwwww";
        System.out.println(Remove(s, 0));
    }

    public static String Remove(String s, int index) {
        char[] c = s.toCharArray();
        int count = 0;
        for(int i = index; i < c.length; i++) {
            if(c[i] == c[index]){
                count++;
                if(count > 1) {
                    c[i] = ' ';
                }
            }
        }
        String res = String.valueOf(c).replace(" ", "");
        //String res = c.toString().replace(" ", "");
        if(index >= s.length() - 1) {
            return res;
        }
        return Remove(res, index + 1);
    }
}
