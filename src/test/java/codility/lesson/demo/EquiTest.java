package codility.lesson.demo;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link Equi}.
 * @author Felipe Pina (felipe.pina@protonmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class EquiTest {

    @Test
    public void empty() {
        MatcherAssert.assertThat(
            new Equi().solution(new int[0]),
            Matchers.is(-1)
        );
    }

    @Test
    public void none() {
        MatcherAssert.assertThat(
            new Equi().solution(new int[]{-1, 3}),
            Matchers.is(-1)
        );
    }

    @Test
    public void sample() {
        MatcherAssert.assertThat(
            new Equi().solution(new int[]{-1, 3, -4, 5, 1, -6, 2, 1}),
            Matchers.is(1)
        );
    }

    @Test
    public void first() {
        MatcherAssert.assertThat(
            new Equi().solution(new int[]{-1}),
            Matchers.is(0)
        );
    }

    @Test
    public void penultimate() {
        MatcherAssert.assertThat(
            new Equi().solution(new int[]{-1, 3, 4, 5, 6}),
            Matchers.is(3)
        );
    }

    @Test
    public void last() {
        MatcherAssert.assertThat(
            new Equi().solution(new int[]{-1, 3, 4, -6, 0}),
            Matchers.is(4)
        );
    }

}
