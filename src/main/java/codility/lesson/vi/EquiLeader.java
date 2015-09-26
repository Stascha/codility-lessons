package codility.lesson.vi;

/**
 * Lesson 6: EquiLeader.
 * https://codility.com/programmers/task/equi_leader
 * @author Felipe Pina (felipe.pina@protonmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class EquiLeader {

    /**
     * Stack count.
     */
    private transient int count;

    /**
     * Stack value.
     */
    private transient int value;

    /**
     * Index of last candidate leader.
     */
    private transient int last;

    /**
     * Solves the lesson.
     * @param A Input array A.
     * @return The number of equileaders of A
     */
    public int solution(final int[] A) {
        final int index = this.leader(A);
        int equi = 0;
        if (index != -1) {
            final int leader = A[index];
            int left = 0;
            if (A[0] == leader) {
                left++;
            }
            int right = 0;
            for (int idx = 1; idx < A.length; ++idx) {
                if (A[idx] == leader) {
                    right++;
                }
            }
            if (right > (A.length - 1) / 2) {
                equi++;
            }
            for (int idx = 1; idx < A.length; ++idx) {
                if (A[idx] == leader) {
                    right--;
                    left++;
                }
                if (left > (idx + 1) / 2 && right > (A.length - idx - 1) / 2) {
                    equi++;
                }
            }
        }
        return equi;
    }

    /**
     * Attempts to find the leader of the given array (if any).
     * @param array Array.
     * @return An index into the array A such that A[index] is the leader, or
     * -1 if no leader exists.
     */
    private int leader(final int[] array) {
        this.count = 0;
        this.value = 0;
        this.last = -1;
        for (int idx = 0; idx < array.length; ++idx) {
            this.push(idx, array[idx]);
        }
        final int index;
        if (this.count > 0) {
            int repetitions = 0;
            for (final int val : array) {
                if (val == this.value) {
                    repetitions++;
                }
            }
            if (repetitions <= array.length / 2 ) {
                index = -1;
            } else {
                index = this.last;
            }
        } else {
            index = -1;
        }
        return index;
    }

    /**
     * Pushes a value to the stack.
     * @param val Value.
     */
    private void push(final int indx, final int val) {
        if (this.count == 0) {
            this.value = val;
            this.count++;
            this.last = indx;
        } else if (this.value == val) {
            this.count++;
        } else {
            this.count--;
        }
    }

}
