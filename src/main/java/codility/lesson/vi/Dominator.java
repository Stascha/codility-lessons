package codility.lesson.vi;

/**
 * Lesson 6: Dominator.
 * https://codility.com/programmers/task/dominator
 * @author Felipe Pina (felipe.pina@protonmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class Dominator {

    /**
     * Stack count.
     */
    private transient int count;

    /**
     * Stack value.
     */
    private transient int value;

    /**
     * Index of
     */
    private transient int last;

    /**
     * Solves the lesson.
     * @param A Input array A.
     * @return An index into A such that A[index] is the dominator, or -1 if
     * no dominator exists.
     */
    public int solution(final int[] A) {
        this.count = 0;
        this.value = 0;
        this.last = -1;
        for (int idx = 0; idx < A.length; ++idx) {
            this.push(idx, A[idx]);
        }
        final int index;
        if (this.count > 0) {
            int repetitions = 0;
            for (final int val : A) {
                if (val == this.value) {
                    repetitions++;
                }
            }
            if (repetitions <= A.length / 2 ) {
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
