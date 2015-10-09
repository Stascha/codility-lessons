package codility.lesson.ic;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link TreeHeight}.
 * @author Felipe Pina (felipe.pina@protonmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class TreeHeightTest {

    @Test
    public void empty() {
        MatcherAssert.assertThat(
            new TreeHeight().solution(null),
            Matchers.is(0)
        );
    }

    @Test
    public void single() {
        MatcherAssert.assertThat(
            new TreeHeight().solution(
                new TreeHeight.Tree(0)
            ),
            Matchers.is(0)
        );
    }

    @Test
    public void simple() {
        MatcherAssert.assertThat(
            new TreeHeight().solution(
                new TreeHeight.Tree(5)
                    .withLeft(new TreeHeight.Tree(2))
                    .withRight(
                        new TreeHeight.Tree(4)
                            .withRight(new TreeHeight.Tree(2))
                    )
            ),
            Matchers.is(2)
        );
    }

    @Test
    public void sample() {
        MatcherAssert.assertThat(
            new TreeHeight().solution(
                new TreeHeight.Tree(5)
                    .withLeft(
                        new TreeHeight.Tree(3)
                            .withLeft(new TreeHeight.Tree(20))
                            .withRight(new TreeHeight.Tree(21))
                    )
                    .withRight(
                        new TreeHeight.Tree(10)
                            .withLeft(new TreeHeight.Tree(1))
                    )
            ),
            Matchers.is(2)
        );
    }

    @Test
    public void medium() {
        final int depth = 100;
        MatcherAssert.assertThat(
            new TreeHeight().solution(this.left(depth)),
            Matchers.is(depth)
        );
    }

    @Test
    public void large() {
        final int depth = 500;
        MatcherAssert.assertThat(
            new TreeHeight().solution(this.left(depth)),
            Matchers.is(depth)
        );
    }

    /**
     * Builds a left tree with the give depth.
     * @return Tree.
     */
    private TreeHeight.Tree left(final int depth) {
        final TreeHeight.Tree root = new TreeHeight.Tree(1);
        TreeHeight.Tree tree = root;
        for (int idx = 0; idx < depth; ++idx) {
            tree = tree.withLeft(new TreeHeight.Tree(1)).l;
        }
        return root;
    }

}
