package 面试算法题;

public class WaitTime {
    public static void main(String[] args) {
        int[][] n = {{1,2},{1,3},{1,7}};
        int[][] n2 = {{1,2}};
        System.out.println(averageWaitingTime(n));
        System.out.println(averageWaitingTime(n2));
    }

    public static double averageWaitingTime (int[][] orders) {
        if(orders.length <= 0) return 0;
        int[] endtime = new int[orders.length];
        endtime[0] = orders[0][0] + orders[0][1];
        int t = endtime[0] - orders[0][0];
        for(int i = 1; i < orders.length; i++) {
            //前面订单的完成时间已经大于当前订单预计开始时间
            if(endtime[i - 1] > orders[i][0]) {
                endtime[i] = endtime[i - 1] + orders[i][1];
                t += endtime[i] - orders[i][0];
            }
            else {
                endtime[i] = orders[i][0] + orders[i][1];
                t += endtime[i] - orders[i][0];
            }
        }

//        int sum = 0;
//        for(int i = 0; i < orders.length; i++) {
//            sum += endtime[i] - orders[i][0];
//        }

        return t / (double) orders.length;
    }

}
