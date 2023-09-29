package deque;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
		lld1.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

		lld1.addLast("middle");
		assertEquals(2, lld1.size());

		lld1.addLast("back");
		assertEquals(3, lld1.size());

		System.out.println("Printing out deque: ");
		lld1.printDeque();

    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty
		assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty
		assertFalse("lld1 should contain 1 item", lld1.isEmpty());

		lld1.removeFirst();
		// should be empty
		assertTrue("lld1 should be empty after removal", lld1.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {


        LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());


    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }


    }

    @Test
    public void equal_test() {
        /* Same Object Test. */
        LinkedListDeque<Integer> ANobug = new LinkedListDeque<>();
        ANobug.addFirst(0);
        ANobug.addLast(1);
        ANobug.addLast(2);
        ANobug.addLast(3);
        LinkedListDeque<Integer> copyA = ANobug;
//        System.out.println(ANobug.get(2));
        assertEquals(2, ANobug.get(2).longValue());
        assertEquals(ANobug.equals(copyA), true);

        /* Same contents Test. */
        LinkedListDeque<Integer> BNobug = new LinkedListDeque<>();
        BNobug.addFirst(0);
        BNobug.addLast(1);
        BNobug.addLast(2);
        BNobug.addLast(3);
        assertEquals(true, ANobug.equals(BNobug));

        /* Different size Test. */
        BNobug.addFirst(-1);
        assertEquals(ANobug.equals(BNobug),false);

        /* Same size with different contents Test. */
        BNobug.removeLast();
        assertEquals(ANobug.equals(BNobug),false);

        /* Different objects Test. */
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        lld1.addFirst(0);
        lld1.addLast(1);
        lld1.addLast(2);
        lld1.addLast(3);
        assertEquals(ANobug.equals(lld1),false);

        /* Null Test. */
        assertEquals(ANobug.equals(null),false);
    }

    @Test
    public void iter_test(){
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        for (int i = 0; i < 50; i++) {
            lld1.addLast(i);
        }
        lld1.printDeque();
        Iterator<Integer> aseer = lld1.iterator();
        while (aseer.hasNext()) {
            int j = aseer.next();
            System.out.println(j);
        }
    }

    @Test
    public void getrecursive_test() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        for (int i = 0; i < 50; i++) {
            lld1.addFirst(i);
        }

        assertEquals(0, lld1.getRecursive(0).longValue());
        assertEquals(1, lld1.getRecursive(1).longValue());
        assertEquals(37, lld1.getRecursive(37).longValue());
    }

    @Test
    public void a004_test() {
        LinkedListDeque<Integer> LinkedListDeque = new LinkedListDeque<>();
        LinkedListDeque.isEmpty();
        LinkedListDeque.addLast(1);
        LinkedListDeque.isEmpty();
        LinkedListDeque.removeLast();
        assertEquals(true, LinkedListDeque.isEmpty());
    }

    @Test
    public void a005_test() {
        LinkedListDeque<Integer> LinkedListDeque = new LinkedListDeque<>();
        LinkedListDeque.addLast(0);
        assertEquals(0, LinkedListDeque.removeFirst().longValue());
        LinkedListDeque.addLast(2);
        LinkedListDeque.addLast(3);
        LinkedListDeque.addLast(4);
        assertEquals(false, LinkedListDeque.isEmpty());
        assertEquals(3, LinkedListDeque.size());
    }

    @Test
    public void a006_test_3() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        lld1.addLast(0);
//        assertEquals(0, lld1.removeFirst().longValue());
//        assertEquals(0, lld1.size());
        lld1.addFirst(1);
        assertEquals(0, lld1.removeLast().longValue());
        assertEquals(1, lld1.removeLast().longValue());
        lld1.addFirst(2);
        lld1.addFirst(3);
        assertEquals(2, lld1.removeLast().longValue());
        assertEquals(3, lld1.removeLast().longValue());
    }

    @Test
    public void a006_test_4() {
        LinkedListDeque<Integer> LinkedListDeque = new LinkedListDeque<>();
        LinkedListDeque.addLast(0);
        LinkedListDeque.addFirst(1);
        LinkedListDeque.removeLast();
        LinkedListDeque.removeFirst();
        assertEquals(true, LinkedListDeque.isEmpty());
    }

}

