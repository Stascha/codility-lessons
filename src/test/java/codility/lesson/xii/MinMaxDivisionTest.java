package codility.lesson.xii;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link MinMaxDivision}.
 * @author Felipe Pina (felipe.pina@protonmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class MinMaxDivisionTest {

    @Test
    public void sample() {
        MatcherAssert.assertThat(
            new MinMaxDivision()
                .solution(3, 5, new int[]{2, 1, 5, 1, 2, 2, 2}),
            Matchers.is(6)
        );
    }

    @Test
    public void single() {
        MatcherAssert.assertThat(
            new MinMaxDivision().solution(1, 10, new int[] {3}),
            Matchers.is(3)
        );
    }

    @Test
    public void twoElements() {
        MatcherAssert.assertThat(
            new MinMaxDivision().solution(2, 10, new int[] {3, 5, 8}),
            Matchers.is(8)
        );
    }

}
