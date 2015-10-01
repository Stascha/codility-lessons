package codility.lesson.vii;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link MaxDoubleSliceSum}.
 * @author Felipe Pina (felipe.pina@protonmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class MaxDoubleSliceSumTest {

    @Test
    public void sample() {
        MatcherAssert.assertThat(
            new MaxDoubleSliceSum().solution(
                new int[] {3, 2, 6, -1, 4, 5, -1, 2}
            ),
            Matchers.is(17)
        );
    }

}
