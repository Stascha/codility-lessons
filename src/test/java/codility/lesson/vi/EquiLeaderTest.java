package codility.lesson.vi;

import codility.lesson.vi.EquiLeader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link EquiLeader}.
 * @author Felipe Pina (felipe.pina@protonmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class EquiLeaderTest {

    @Test
    public void singleton() {
        MatcherAssert.assertThat(
            new EquiLeader().solution(new int[] {5}),
            Matchers.is(0)
        );
    }

    @Test
    public void doubled() {
        MatcherAssert.assertThat(
            new EquiLeader().solution(new int[] {5, 5}),
            Matchers.is(1)
        );
    }

    @Test
    public void sample() {
        MatcherAssert.assertThat(
            new EquiLeader().solution(new int[] {4, 3, 4, 4, 4, 2}),
            Matchers.is(2)
        );
    }

}
