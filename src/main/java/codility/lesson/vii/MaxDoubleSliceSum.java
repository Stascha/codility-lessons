package codility.lesson.vii;

/**
 * Lesson 7: MaxDoubleSliceSum.
 * https://codility.com/programmers/task/max_double_slice_sum
 * @author Felipe Pina (felipe.pina@protonmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class MaxDoubleSliceSum {

    /**
     * Solves the lesson.
     * @param A Input array A.
     * @return Maximal sum of any double slice.
     */
    public int solution(final int[] A) {
        final int[] ending = new int[A.length];
        ending[0] = 0;
        for (int idx = 1; idx < A.length; ++idx) {
            ending[idx] = Math.max(0, ending[idx - 1] + A[idx]);
        }
        final int[] starting = new int[A.length];
        starting[A.length - 1] = 0;
        for (int idx = A.length - 2; idx >= 0; --idx) {
            starting[idx] = Math.max(0, starting[idx + 1] + A[idx]);
        }
        int max = 0;
        for (int idx = 1; idx < A.length - 1; ++idx) {
            max = Math.max(max, ending[idx - 1] + starting[idx + 1]);
        }
        return max;
    }

}
