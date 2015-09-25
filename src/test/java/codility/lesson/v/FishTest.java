package codility.lesson.v;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link Fish}.
 * @author Felipe Pina (felipe.pina@protonmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class FishTest {

    @Test
    public void first() {
        MatcherAssert.assertThat(
            new Fish().solution(
                new int[] {4, 3, 2, 1, 5},
                new int[] {0, 1, 0, 0, 0}
            ),
            Matchers.is(2)
        );
    }

    @Test
    public void custom() {
        MatcherAssert.assertThat(
            new Fish().solution(
                new int[] {4, 3, 2, 1, 5, 4, 2, 3, 2, 2, 2},
                new int[] {0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1}
            ),
            Matchers.is(7)
        );
    }

    @Test
    public void small() {
        MatcherAssert.assertThat(
            new Fish().solution(
                new int[] {4, 3},
                new int[] {0, 1}
            ),
            Matchers.is(2)
        );
    }

    @Test
    public void single() {
        MatcherAssert.assertThat(
            new Fish().solution(
                new int[] {4},
                new int[] {1}
            ),
            Matchers.is(1)
        );
    }

}
