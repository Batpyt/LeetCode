package 双指针和滑动窗口;

import java.util.Arrays;

/**
 * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
 *
 * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
 *
 * 你的点数就是你拿到手中的所有卡牌的点数之和。
 *
 * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：cardPoints = [1,2,3,4,5,6,1], k = 3
 * 输出：12
 * 解释：第一次行动，不管拿哪张牌，你的点数总是 1 。但是，先拿最右边的卡牌将会最大化你的可获得点数。最优策略是拿右边的三张牌，最终点数为 1 + 6 + 5 = 12 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MaxPointFromTwoSides {
    public static void main(String[] args) {
        int[] cards = {1,2,3,4,5,6,1};
        System.out.println(maxScore(cards, 3));
    }

    /*
    滑动窗口，length-k大小的窗口的最小值
     */
    public static int maxScore(int[] cardPoints, int k) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int len = cardPoints.length - k;
        int left = 0, right = 0;
        for(right = 0; right < cardPoints.length; right++) {
            if(right - left + 1 < len) {
                sum += cardPoints[right];
                //System.out.println(sum+" "+cardPoints[right]);
            }
            if(right - left + 1 == len) {
                sum += cardPoints[right];
                min = Math.min(min, sum);
                sum -= cardPoints[left];
                left++;
//                System.out.println("left "+left+" right "+right);
//                System.out.println(sum+" "+min);
            }
        }
        return Arrays.stream(cardPoints).sum() - min;
    }
}
