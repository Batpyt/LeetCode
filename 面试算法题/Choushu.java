package 面试算法题;

public class Choushu {
    public static void main(String[] args) {
        int num = 1352;
        System.out.println(nthUglyNumber(num));
        //System.out.println(isUgly(2));
    }

    public static int nthUglyNumber(int n) {
        int count = 1;
        int i = 1;
        while(true){
            if(isUgly(i)){
                if(count == n){
                    return i;
                }
                //System.out.println(i+ " "+ count);
                i++;
                count++;
            }
            else{
                i++;
            }
        }
    }

    public static boolean isUgly(int num) {
        while(num % 2 == 0) {
            num = num / 2;
        }
        while(num % 3 == 0) {
            num = num / 3;
        }
        while(num % 5 == 0) {
            num = num / 5;
        }

        return num == 1;
    }
}
