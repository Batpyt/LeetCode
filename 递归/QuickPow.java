package 递归;

public class QuickPow {
    public static void main(String[] args) {
        QuickPow p = new QuickPow();
        System.out.println(p.myPow(2,2));

    }

    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        if(n < 0) return 1 / myPow(x, -n);
        double res = myPow(x, n / 2);
        if(n % 2 == 0) {
            return res * res;
        }
        else {
            return res * res * x;
        }
    }

}
