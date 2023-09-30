package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private ArrayDeque<T> maxArray;
    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        comparator = c;
    }

    public T max() {
        if (this.isEmpty()) {
            return null;
        } else {
            T max_number = this.get(0);
            for (int i = 0; i < this.size(); i = i + 1) {
                if (comparator.compare(max_number, this.get(i)) < 0) {
                    max_number = this.get(i);
                }
            }
            return max_number;
        }
    }

    public T max(Comparator<T> c) {
        return null;
    }

}
