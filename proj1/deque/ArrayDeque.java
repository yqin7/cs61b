package deque;

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int next_first;
    private int next_last;

    /** Creates an empty list. */   
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        next_first = 4;
        next_last = 5;
    }

    /** Inserts X into the front of the list. */
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[next_first] = item;
        size = size + 1;
        if (next_first == 0) {
            next_first = items.length - 1;
        } else {
            next_first = next_first - 1;
        }
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, next_first + 1, a, 0, items.length - next_first - 1);
        System.arraycopy(items,0, a,items.length - next_first - 1, next_first + 1);
        items = a;
        next_first = items.length - 1;
        next_last = items.length / 2;
    }

    /** Inserts X into the back of the list. */
    public void addLast(T x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[next_last] = x;
        size = size + 1;
        if (next_last == items.length - 1) {
            next_last = 0;
        } else {
            next_last = next_last + 1;
        }
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last. 尚不清楚遇到null的空链 */
    public void printDeque() {
        int first_index = first_index_calculate();
        for (int i = 0; i < size; i++ ) {
            if (i + first_index < items.length) {
                System.out.print(items[i + first_index] + " ");
            } else {
                System.out.print(items[i + first_index - items.length] + " ");
            }
        }
        System.out.println();
    }

    /** Returns the item from the front of the list. */
    public T getFirst() {
        int first_index = first_index_calculate();
        return items[first_index];
    }

    /** Deletes item from front of the list and
     * returns deleted item. */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T x = getFirst();
        int first_index = first_index_calculate();
        next_first = first_index;
        items[first_index] = null;
        size = size - 1;
        return x;
    }

    /** Returns the item from the back of the list. */
    public T getLast() {
        int last_index = last_index_calculate();
        return items[last_index];
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T x = getLast();
        int last_index = last_index_calculate();
        next_last = last_index;
        items[last_index] = null;
        size = size - 1;
        return x;
    }
    
    /** Returns the first index. If next_first equal to items' length - 1, first index should be zero. */
    private int first_index_calculate() {
        if (next_first == items.length - 1) {
            return 0;
        } else {
            return next_first + 1;
        }
    }

    /** Returns the last index. If next_last equal 0, last index should be items' length - 1. */
    private int last_index_calculate() {
        if (next_last == 0) {
            return items.length - 1;
        } else {
            return next_last - 1;
        }
    }

    /** Gets the ith item in the list (0 is the front).*/
    public T get(int i) {
        if (i >= size) {
            return null;
        } else {
            int first_index = first_index_calculate();
            if (first_index + i <= size) {
                return items[first_index + i];
            } else {
                return items[first_index + i - items.length];
            }
        }
    }
}

