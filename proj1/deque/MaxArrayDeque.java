package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private ArrayDeque<T> maxArray;
    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        comparator = c;
    }

    public T max() {
        if (maxArray.isEmpty()) {
            return null;
        } else {
            return null;
        }
    }

    public T max(Comparator<T> c) {
        return null;
    }

}
