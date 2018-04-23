import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlternateElementIterator {

    static class SecondIterator<T> implements Iterator<T> {
        private Iterator<T> iterator;

        public SecondIterator(Iterator<T> iterator) {
            this.iterator = iterator;
        }

        private volatile boolean skipped = false;

        @Override
        public boolean hasNext() {
            if (!skipped) {
                skipped = true;
                if (iterator.hasNext()) {
                    iterator.next();
                }
            }
            return iterator.hasNext();
        }

        @Override
        public T next() {
            hasNext();
            skipped = false;
            return iterator.next();
        }
    }

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 1; i < 11; i++)
            integerList.add(i);

        SecondIterator<Integer> secondIterator = new SecondIterator<>(integerList.iterator());
        while (secondIterator.hasNext()) {
            System.out.print(secondIterator.next() + " ");
        }
    }
}
