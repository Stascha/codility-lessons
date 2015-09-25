package codility.lesson.v;

/**
 * Lesson 5: Fish.
 * https://codility.com/programmers/task/fish
 * @author Felipe Pina (felipe.pina@protonmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class Fish {

    /**
     * N.
     */
    private static final int N = 100000;

    /**
     * Upstream direction.
     */
    private static final int UPSTREAM = 0;

    /**
     * Downstream direction.
     */
    private static final int DOWNSTREAM = 1;

    /**
     * Stack of fish that are currently alive and moving downstream.
     */
    @SuppressWarnings("CheckForOutOfMemoryOnLargeArrayAllocation")
    private final transient int[] downstream = new int[Fish.N];

    /**
     * Next stack index (-1 iff empty);
     */
    private transient int index;

    /**
     * Fish sizes.
     */
    private transient int[] sizes;

    /**
     * Solves the lesson.
     * @param A Input array A.
     * @param B Input array A.
     * @return Number of fish alive at the end of the feast.
     */
    public int solution(final int[] A, final int[] B) {
        this.sizes = A;
        final int total = A.length;
        this.index = -1;
        int left = 0;
        int alive = 0;
        while (left < total && B[left] == Fish.UPSTREAM) {
            left++;
            alive++;
        }
        int right = total - 1;
        while (right >= 0 && B[right] == Fish.DOWNSTREAM) {
            right--;
            alive++;
        }
        for (int idx = left; idx <= right; ++idx) {
            if (B[idx] == Fish.DOWNSTREAM) {
                this.index++;
                this.downstream[this.index] = idx;
            } else if (this.lunchtime(A[idx])) {
                alive ++;
            }
        }
        return alive + this.index + 1;
    }

    /**
     * Lets all necessary eating take place when a new upstream fish encounters
     * the current stack of downstream fish.
     * @param size Size of the upstream fish.
     * @return Did the upstream fish survive (by eating all of the downstream
     * fish)?
     */
    private boolean lunchtime(final int size) {
        while (this.index >= 0) {
            if (size > this.sizes[this.downstream[this.index]]) {
                this.index--;
            } else {
                return false;
            }
        }
        return true;
    }

}
