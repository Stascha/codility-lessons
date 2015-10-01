package codility.lesson.vii;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link MaxSliceSum}.
 * @author Felipe Pina (felipe.pina@protonmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class MaxSliceSumTest {

    @Test
    public void sample() {
        MatcherAssert.assertThat(
            new MaxSliceSum().solution(new int[] {3, 2, -6, 4, 0}),
            Matchers.is(5)
        );
    }

    @Test
    public void single() {
        MatcherAssert.assertThat(
            new MaxSliceSum().solution(new int[] {3}),
            Matchers.is(3)
        );
    }

    @Test
    public void negative() {
        MatcherAssert.assertThat(
            new MaxSliceSum().solution(new int[] {-1, -2}),
            Matchers.is(-1)
        );
    }

}
