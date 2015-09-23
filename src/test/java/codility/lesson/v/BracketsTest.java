package codility.lesson.v;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link Brackets}.
 * @author Felipe Pina (felipe.pina@protonmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class BracketsTest {

    @Test
    public void first() {
        MatcherAssert.assertThat(
            new Brackets().solution("{[()()]}"),
            Matchers.is(1)
        );
    }

    @Test
    public void second() {
        MatcherAssert.assertThat(
            new Brackets().solution("([)()]"),
            Matchers.is(0)
        );
    }

}
