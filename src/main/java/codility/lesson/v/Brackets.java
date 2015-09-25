package codility.lesson.v;

/**
 * Lesson 5: Brackets.
 * @author Felipe Pina (felipe.pina@protonmail.com)
 * @version $Id$
 * @since 1.0
 */
public final class Brackets {

    /**
     * Stack.
     */
    private final char[] stack = new char[200000];

    /**
     * Stack index.
     */
    private int index = -1;

    /**
     * Solves the lesson.
     * @param S Input string.
     * @return 1 if @ is properly nested, 0 otherwise.
     */
    public int solution(final String S) {
        try {
            for (int idx = 0; idx < S.length(); ++idx) {
                final char current = S.charAt(idx);
                if (current == ')') {
                    if (this.pop() != '(') {
                        return 0;
                    }
                } else if (current == '}') {
                    if (this.pop() != '{') {
                        return 0;
                    }
                } else if (current == ']') {
                    if (this.pop() != '[') {
                        return 0;
                    }
                } else {
                    this.push(current);
                }
            }
            return this.index == -1 ? 1 : 0;
        } catch (final IllegalStateException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }

    /**
     * Pushes a character on to the stack.
     * @param chr Character.
     */
    private void push(final char chr) {
        this.index++;
        this.stack[this.index] = chr;
    }

    /**
     * Pops a character from the stack.
     * @return Element.
     */
    private char pop() {
        if (this.index < 0) {
            throw new IllegalStateException("Empty stack!");
        }
        final char current = this.stack[this.index];
        this.index--;
        return current;
    }

}
