package codility.lesson.vii;

/**
 * Lesson 7: MaxSliceSum.
 * https://codility.com/programmers/task/max_slice_sum
 * @author Felipe Pina (felipe.pina@protonmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class MaxSliceSum {

    /**
     * Solves the lesson.
     * @param A Input array A.
     * @return Maximum sum of any slice of A.
     */
    public int solution(final int[] A) {
        int end = A[0];
        int max = end;
        for (int idx = 1; idx < A.length; ++idx) {
            final int value = A[idx];
            end = Math.max(value, end + value);
            max = Math.max(max, end);
        }
        return max;
    }

}
