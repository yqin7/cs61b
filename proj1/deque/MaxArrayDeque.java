package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        comparator = c;
    }

    public T max() {
        if (this.isEmpty()) {
            return null;
        } else {
            T maxNumber = this.get(0);
            for (int i = 0; i < this.size(); i = i + 1) {
                if (comparator.compare(maxNumber, this.get(i)) < 0) {
                    maxNumber = this.get(i);
                }
            }
            return maxNumber;
        }
    }

    public T max(Comparator<T> c) {
        if (this.isEmpty()) {
            return null;
        } else {
            T maxNumber = this.get(0);
            for (int i = 0; i < this.size(); i = i + 1) {
                if (c.compare(maxNumber, this.get(i)) < 0) {
                    maxNumber = this.get(i);
                }
            }
            return maxNumber;
        }
    }

}
