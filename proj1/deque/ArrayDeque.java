package deque;
import java.util.Iterator;


public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Creates an empty list. */   
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    /** Inserts X into the front of the list. */
    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        size = size + 1;
        if (nextFirst == 0) {
            nextFirst = items.length - 1;
        } else {
            nextFirst = nextFirst - 1;
        }
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items,nextFirst + 1,a,0,items.length - nextFirst - 1);
        System.arraycopy(items,0,a,items.length - nextFirst - 1,nextFirst + 1);
        items = a;
        nextFirst = items.length - 1;
        nextLast = items.length / 2;
    }

    /** Inserts X into the back of the list. */
    @Override
    public void addLast(T x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = x;
        size = size + 1;
        if (nextLast == items.length - 1) {
            nextLast = 0;
        } else {
            nextLast = nextLast + 1;
        }
    }

    /** Return if array is empty or not. */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns the number of items in the list. */
    @Override
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last. */
    @Override
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
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T x = getFirst();
        int first_index = first_index_calculate();
        nextFirst = first_index;
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
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T x = getLast();
        int last_index = last_index_calculate();
        nextLast = last_index;
        items[last_index] = null;
        size = size - 1;
        return x;
    }
    
    /** Returns the first index. If nextFirst equal to items' length - 1, first index should be zero. */
    private int first_index_calculate() {
        if (nextFirst == items.length - 1) {
            return 0;
        } else {
            return nextFirst + 1;
        }
    }

    /** Returns the last index. If nextLast equal 0, last index should be items' length - 1. */
    private int last_index_calculate() {
        if (nextLast == 0) {
            return items.length - 1;
        } else {
            return nextLast - 1;
        }
    }

    /** Gets the ith item in the list (0 is the front).*/
    @Override
    public T get(int i) {
        if (i >= size) {
            return null;
        } else {
            int first_index = first_index_calculate();
            if (first_index + i < items.length) {
                return items[first_index + i];
            } else {
                return items[first_index + i - items.length];
            }
        }
    }

    /** Provide this method to return an iterator. */
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {
        private int pos;
        private int count_pos;
        public ArrayIterator() {
            pos = first_index_calculate();
            count_pos = 0;
        }
        @Override
        public boolean hasNext() {
            return count_pos < size;
        }
        public T next() {
            T return_item = items[pos];
            count_pos = count_pos + 1;
            pos = dynamic_first_index_calculate();
            return return_item;
        }
        private int dynamic_first_index_calculate() {
            if (pos == items.length - 1) {
                return 0;
            }
            else {
                return pos + 1;
            }
        }
    }

    /** Returns whether the parameter o is equal to the Deque. */
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
//        if (o.getClass() != this.getClass()) {
//            return false;
//        }
        if (o instanceof ArrayDeque == false) {
            return false;
        }
        ArrayDeque<T> other = (ArrayDeque<T>) o;
        if (other.size() != this.size()) {
            return false;
        }
        for (int i = 0; i < size; i = i + 1) {
            if (! other.get(i).equals(this.get(i))) {
                return false;
            }
        }
        return true;
    }
}

