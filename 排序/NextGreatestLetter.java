package 排序;

public class NextGreatestLetter {

    public static void main(String[] args) {
        char[] l = {'c', 'f', 'j'};
        System.out.println(nextGreatestLetter(l, 'z'));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        for(char c : letters) {
            if(c > target) return c;
        }
        return letters[0];
    }
}
