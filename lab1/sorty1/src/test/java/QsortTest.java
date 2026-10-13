import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class QsortTest {

    QuickSort tester = new QuickSort();

    @Test
    void throwExceptionWhenArrayIsNull() {
        assertThrows(NullPointerException.class, () -> tester.qsort(null, 0));
    }

    @Test
    void handleEmptyArray() {
        double[] v ={};
        double[] copy = v.clone();
        tester.qsort(v, 0);
        assertArrayEquals(copy, v);
    }

    @Test
    void returnSortedOptimisticArray() {
        int n = 1000;
        double[] v = new double[n];
        for(int i = 0; i < n; i++) {
            v[i] = i;
        }
        double[] copy = v.clone();
        tester.qsort(v, n);
        assertArrayEquals(copy, v);
    }

    @Test
    void returnSortedPesimisticArray() {
        int n = 1000;
        double[] v = new double[n];
        double[] copy = new double[n];
        for(int i = 0; i < n; i++) {
            v[i] = n - i - 1;
        }
        for(int i = 0; i < n; i++) {
            copy[i] = i;
        }
        tester.qsort(v, n);
        assertArrayEquals(copy, v);
    }

    @Test
    void returnSortedRandomizedArray() {
        int n = 1000;
        double[] v = new double[n];
        long seed = 12345L;
        Random randomizer = new Random(seed);
        for(int i = 0; i < n; i++) {
            v[i] = randomizer.nextDouble() * 2 - 30;
        }

        double[] copy = v.clone();
        Arrays.sort(copy);
        tester.qsort(v, n);
        assertArrayEquals(copy, v);
    }
}
