package codility.lesson.vii;

/**
 * Lesson 7: MaxProfit.
 * https://codility.com/programmers/task/max_profit
 * @author Felipe Pina (felipe.pina@protonmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class MaxProfit {

    /**
     * Solves the lesson.
     * @param A Input array A.
     * @return Maximum possible profit from one transaction during this period.
     */
    public int solution(final int[] A) {
        if (A.length < 2) {
            return 0;
        }
        int buy = A[0];
        int profit = 0;
        for (int idx = 1; idx < A.length; ++idx) {
            final int value = A[idx];
            profit = Math.max(profit, value - buy);
            buy = Math.min(buy, value);
        }
        return profit;
    }

}
