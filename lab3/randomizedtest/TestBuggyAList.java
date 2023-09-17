package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> ANobug = new AListNoResizing<>();
        BuggyAList<Integer> Bhasbug = new BuggyAList<>();
        ANobug.addLast(4);
        Bhasbug.addLast(4);
        ANobug.addLast(5);
        Bhasbug.addLast(5);
        ANobug.addLast(6);
        Bhasbug.addLast(6);


        assertEquals(ANobug.size(), Bhasbug.size());
        assertEquals(ANobug.removeLast(), Bhasbug.removeLast());
        assertEquals(ANobug.removeLast(), Bhasbug.removeLast());
        assertEquals(ANobug.removeLast(), Bhasbug.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
                System.out.println("addLastB(" + randVal + ")");
            } else if (operationNumber == 1 && L.size() > 0 && B.size() > 0) {
                // size
                int Last = L.removeLast();
                int LastB = B.removeLast();
                System.out.println("removeLast(" + Last + ")");
                System.out.println("removeLastB(" + LastB + ")");
            } else if (operationNumber == 2 && L.size() > 0 && B.size() > 0) {
                int Last = L.getLast();
                int LastB = B.getLast();
                System.out.println("getLast(" + Last + ")");
                System.out.println("getLastB(" + LastB + ")");
            }
        }
    }
}

