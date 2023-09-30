package deque;

import edu.princeton.cs.algs4.StdRandom;
import net.sf.saxon.functions.Minimax;
import org.junit.Test;
import deque.ArrayDeque;
import deque.MaxArrayDeque;
import java.util.Comparator;

import static org.junit.Assert.*;


public class MaxArrayDequeTest {
    Comparator<Integer> cmp = new Comparator<>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 > o2) {
                return 1;
            } else if (o1 < o2) {
                return -1;
            } else {
                return 0;
            }
        }
    };

    @Test
    public void maxGivenComparatorTest() {
        MaxArrayDeque<Integer> L = new MaxArrayDeque<Integer>(cmp);
        System.out.println(L.max());
        System.out.println(L.max(cmp));
        int N = 49;
        for (int i = 0; i < N; i += 1) {
            L.addLast(i);
        }
        System.out.println(L.max());
        System.out.println(L.max(cmp));
    }
}
