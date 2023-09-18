package deque;

import static org.junit.Assert.assertEquals;

import edu.princeton.cs.algs4.StdRandom;
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


    @Test
    public void random_test() {
        ArrayDeque<Integer> L = new ArrayDeque<>();

        int N = 50;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            }
//            else if (operationNumber == 1 && L.size() > 0) {
//                // size
//                int Last = L.removeLast();
//                System.out.println("removeLast(" + Last + ")");
//            }
            else if (operationNumber == 1 && L.size() > 0) {
                int Last = L.getLast();
                System.out.println("getLast(" + Last + ")");

            }
            else if (operationNumber == 2) {
                int randVal = StdRandom.uniform(0, 100);
                L.addFirst(randVal);
                System.out.println("addFirst(" + randVal + ")");
            }
//            else if (operationNumber == 4 && L.size() > 0) {
//                // size
//                int First = L.removeFirst();
//                System.out.println("removeFirst(" + First + ")");
//            }
            else if (operationNumber == 3 && L.size() > 0) {
                int First = L.getFirst();
                System.out.println("getFirst(" + First + ")");
            }
        }

        L.printDeque();
        System.out.println(L.getFirst());
        System.out.println(L.getLast());


        int randVal = StdRandom.uniform(0, 60);
        System.out.println("randVal 0 is " + randVal);
        System.out.println(L.get(randVal));

        int randVal1 = StdRandom.uniform(0, 60);
        System.out.println("randVal 1 is " + randVal1);
        System.out.println(L.get(randVal1));

        int randVal2 = StdRandom.uniform(0, 60);
        System.out.println("randVal 2 is " + randVal2);
        System.out.println(L.get(randVal2));

        int randVal3 = StdRandom.uniform(0, 60);
        System.out.println("randVal 3 is " + randVal3);
        System.out.println(L.get(randVal3));

        int randVal4 = StdRandom.uniform(0, 60);
        System.out.println("randVal 4 is " + randVal4);
        System.out.println(L.get(randVal4));

        int randVal5 = StdRandom.uniform(0, 60);
        System.out.println("randVal 5 is " + randVal5);
        System.out.println(L.get(randVal5));
    }
}


