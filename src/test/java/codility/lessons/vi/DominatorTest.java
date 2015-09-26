package codility.lessons.vi;

import codility.lesson.vi.Dominator;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link Dominator}.
 * @author Felipe Pina (felipe.pina@protonmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class DominatorTest {

    /**
     * First test.
     */
    @Test
    public void first() {
        final int[] array = {3, 4, 3, 2, 3, -1, 3, 3};
        MatcherAssert.assertThat(
            array[new Dominator().solution(array)],
            Matchers.is(3)
        );
    }

    /**
     * Tiny test.
     */
    @Test
    public void tiny() {
        final int[] array = {5};
        MatcherAssert.assertThat(
            array[new Dominator().solution(array)],
            Matchers.is(5)
        );
    }

    /**
     * None.
     */
    @Test
    public void none() {
        MatcherAssert.assertThat(
            new Dominator().solution(
                new int[] {5, 4, 3, 2, 1}
            ),
            Matchers.is(-1)
        );
    }

    /**
     * Balanced.
     */
    @Test
    public void balanced() {
        MatcherAssert.assertThat(
            new Dominator().solution(
                new int[] {5, 5, -2, -2}
            ),
            Matchers.is(-1)
        );
    }

}
