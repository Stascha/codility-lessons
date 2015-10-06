package codility.lesson.xii;

/**
 * Lesson 12: MinMaxDivision.
 * https://codility.com/programmers/task/min_max_division
 * @author Felipe Pina (felipe.pina@protonmail.com)
 * @version $Id$
 * @since 1.0
 */
@SuppressWarnings({"MethodParameterOfConcreteClass", "ObjectAllocationInLoop"})
public final class MinMaxDivision {

    /**
     * Solves the lesson.
     * @param K Number of blocks.
     * @param M Upper limit for array elements.
     * @param A Input array A.
     * @return Maximum sum of any slice of A.
     */
    public int solution(final int K, final int M, final int[] A) {
        final Block[] blocks = new Block[K];
        for (int idx = 0; idx < K; ++idx) {
            blocks[idx] = new Block();
        }
        for (int idx = A.length - 1; idx >= 0; --idx) {
            blocks[0].add(idx, A[idx]);
        }
        int max;
        boolean moved;
        do {
            moved = false;
            for (int idx = K - 1; idx >= 1; --idx) {
                final Block right = blocks[idx];
                final Block left = blocks[idx - 1];
                if (left.length() == 0) {
                    continue;
                }
                boolean move;
                do {
                    final int index = left.last();
                    final int value = A[index];
                    final int current = Math.max(left.sum(), right.sum());
                    final int after = Math.max(
                        left.sum() - value, right.sum() + value
                    );
                    move = after <= current;
                    if (move) {
                        left.remove(value);
                        right.add(index, value);
                        moved = true;
                        /*System.out.println(
                            String.format(
                                "Moved %d (pos %d) from %d to %d",
                                value, index, idx - 1, idx
                            )
                        );*/
                    }
                } while (left.length() > 0 && move);
            }
            max = 0;
            for (final Block block : blocks) {
                max = Math.max(max, block.sum());
            }
            //System.out.println(String.format("Max = %d", max));
        } while (moved);
        return max;
    }

    /**
     * Class.
     */
    private static final class Block {

        /**
         * Index of first element.
         */
        private transient int first;

        /**
         * Length.
         */
        private transient int length;

        /**
         * Sum.
         */
        private transient int sum;

        /**
         * Ctor.
         */
        Block() {
            this.first = 0;
            this.length = 0;
            this.sum = 0;
        }

        /**
         * Adds an element to the start of the block.
         * @param index Element's index.
         * @param value Element's value.
         */
        public void add(final int index, final int value) {
            this.first = index;
            this.length++;
            this.sum += value;
        }

        /**
         * Removes an element from the end of this block.
         * @param value Element's value.
         */
        public void remove(final int value) {
            this.length--;
            this.sum -= value;
        }

        /**
         * Returns this block's length.
         * @return Length.
         */
        public int length() {
            return this.length;
        }

        /**
         * Returns the index of the last element in this block.
         * @return Index of last element.
         */
        public int last() {
            return this.first - 1 + this.length;
        }

        /**
         * Returns this block's sum.
         * @return Sum.
         */
        public int sum() {
            return this.sum;
        }

    }

}
