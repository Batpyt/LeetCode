package 动态规划;

/**
 * 求上升子序列和的最大值
 */
import java.util.Scanner;
public class Shangshengzixuliezuidazhi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] a = {3,7,1,5,9,4,8};
        int n = 7;
        int[] sum = new int[n];
        for(int i=0;i<n;i++){
            sum[i]=a[i];
            for(int j=0;j<i;j++){ //从头开始找到i的最大子序列
                if (a[j]<a[i])
                    sum[i]=Math.max(sum[i],sum[j]+a[i]);
            }
        }
        int max_sum=sum[0];
        for(int i=1;i<n;i++){
            if(sum[i]>max_sum) max_sum=sum[i];
        }
        System.out.println(max_sum);
    }
}