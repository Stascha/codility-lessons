package codility.lesson.demo;

/**
 * Equi: Find an index in an array such that its prefix sum equals its suffix
 * sum.
 * https://codility.com/demo/take-sample-test/
 * @author Felipe Pina (felipe.pina@protonmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class Equi {

    /**
     * Solves the problem.
     * @param A Input array A.
     * @return Any of its equilibrium indices, or -1 if none exist.
     */
    public int solution(final int[] A) {
        if (A.length == 0) {
            return -1;
        }
        long right = 0L;
        for (int idx = 1; idx < A.length; ++idx) {
            right += A[idx];
        }
        int current = A[0];
        long left = 0L;
        for (int idx = 0; idx < A.length - 1; ++idx) {
            if (left == right) {
                return idx;
            }
            left += (long) current;
            current = A[idx + 1];
            right -= (long) current;
        }
        if (left == right) {
            return A.length - 1;
        } else {
            return -1;
        }
    }

}
