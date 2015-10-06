package codility.lesson.xii;

/**
 * Lesson 12: MinMaxDivision.
 * https://codility.com/programmers/task/min_max_division
 * @author Felipe Pina (felipe.pina@protonmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class MinMaxDivision {

    /**
     * Array with values.
     */
    private transient int[] values;

    /**
     * Number of blocks.
     */
    private transient int number;

    /**
     * Solves the lesson.
     * @param K Number of blocks.
     * @param M Upper limit for array elements.
     * @param A Input array A.
     * @return Maximum sum of any slice of A.
     */
    public int solution(final int K, final int M, final int[] A) {
        this.values = A;
        this.number = K;
        int total = 0;
        int max = 0;
        for (final int value : this.values) {
            total += value;
            max = Math.max(max, value);
        }
        int first = max;
        int last = total;
        while (last > first) {
            final int mid = (first + last) / 2;
            //System.out.println(String.format("%d %d %d", first, last, mid));
            if (this.check(mid)) {
                last = mid;
            } else {
                first = mid + 1;
            }
        }
        return last;
    }

    /**
     * Checks if blocks can be formed with the given max.
     * @param max Max.
     * @return True iff it is possible.
     */
    private boolean check(final int max) {
        int count = 1;
        int left = max;
        for (final int value : this.values) {
            if (value > max) {
                return false;
            }
            if (left < value) {
                left = max;
                count++;
            }
            left -= value;
        }
        return count <= this.number;
    }

}
