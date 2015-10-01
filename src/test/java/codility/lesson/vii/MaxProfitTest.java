package codility.lesson.vii;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link MaxProfit}.
 * @author Felipe Pina (felipe.pina@protonmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class MaxProfitTest {

    @Test
    public void sample() {
        MatcherAssert.assertThat(
            new MaxProfit().solution(
                new int[] {
                    23171,
                    21011,
                    21123,
                    21366,
                    21013,
                    21367
                }
            ),
            Matchers.is(356)
        );
    }

    @Test
    public void simple() {
        MatcherAssert.assertThat(
            new MaxProfit().solution(
                new int[] {0, 5000}
            ),
            Matchers.is(5000)
        );
    }

    @Test
    public void noProft() {
        MatcherAssert.assertThat(
            new MaxProfit().solution(
                new int[] {10, 10, 10, 10}
            ),
            Matchers.is(0)
        );
    }

    @Test
    public void empty() {
        MatcherAssert.assertThat(
            new MaxProfit().solution(new int[0]),
            Matchers.is(0)
        );
    }

}
