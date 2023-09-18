package deque;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void testFourAddFourRemove_and_zeroremove() {
        ArrayDeque<Integer> ANobug = new ArrayDeque<>();
        ANobug.addFirst(4);

        ANobug.addLast(5);

        ANobug.addLast(6);

        ANobug.addLast(7);


        assertEquals(ANobug.size(), 4);
        ANobug.removeLast();
        assertEquals(ANobug.size(), 3);
        ANobug.removeLast();
        assertEquals(ANobug.size(), 2);
        ANobug.removeFirst();
        assertEquals(ANobug.size(), 1);
        ANobug.removeFirst();
        assertEquals(ANobug.size(), 0);

        ANobug.removeFirst();
        assertEquals(ANobug.size(), 0);
        ANobug.removeLast();
        assertEquals(ANobug.size(), 0);
    }

    @Test
    public void test_resize() {
        ArrayDeque<Integer> ANobug = new ArrayDeque<>();

        ANobug.addFirst(0);

        ANobug.addLast(1);

        ANobug.addLast(2);

        ANobug.addLast(3);

        ANobug.addLast(4);

        ANobug.addLast(5);

        ANobug.addLast(6);

        ANobug.addLast(7);

        ANobug.addLast(8);

        assertEquals(ANobug.size(), 9);
        assertEquals(ANobug.getLast().longValue(), 8);
        assertEquals(ANobug.getFirst().longValue(), 0);
        assertEquals(ANobug.get(5).longValue(), 5);
    }

}

