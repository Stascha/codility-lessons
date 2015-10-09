package codility.lesson.ic;

/**
 * Lesson 99: MinMaxDivision.
 * https://codility.com/programmers/task/tree_height
 * @author Felipe Pina (felipe.pina@protonmail.com)
 * @version $Id$
 * @since 1.0
 */
@SuppressWarnings("MethodParameterOfConcreteClass")
public final class TreeHeight {

    @SuppressWarnings("InstanceVariableOfConcreteClass")
    public static final class Tree {

        /**
         * Root node.
         */
        public int x;

        /**
         * Left subtree.
         */
        public TreeHeight.Tree l;

        /**
         * Right subtree.
         */
        public TreeHeight.Tree r;

        /**
         * Ctor.
         * @param root Root node.
         */
        public Tree(final int root) {
            this.x = root;
        }

        /**
         * Sets the left subtree.
         * @param left Left subtree.
         * @return The tree itself.
         */
        public TreeHeight.Tree withLeft(final TreeHeight.Tree left) {
            this.l = left;
            return this;
        }

        /**
         * Sets the right subtree.
         * @param right Right subtree.
         * @return The tree itself.
         */
        public TreeHeight.Tree withRight(final TreeHeight.Tree right) {
            this.r = right;
            return this;
        }

    }

    /**
     * Solves the lesson.
     * @param tree Tree.
     * @return Tree height.
     */
    public int solution(final TreeHeight.Tree tree) {
        if (tree == null) {
            return 0;
        }
        return this.height(tree) - 1;
    }

    /**
     * Calculates this tree's height.
     * @return Height.
     */
    @SuppressWarnings("ConditionalExpression")
    private int height(final TreeHeight.Tree tree) {
        final int left = tree.l == null ? 0 : this.height(tree.l);
        final int right = tree.r == null ? 0 : this.height(tree.r);
        return 1 + Math.max(left, right);
    }

}
