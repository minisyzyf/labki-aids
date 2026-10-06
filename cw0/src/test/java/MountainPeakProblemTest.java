import pl.edu.pw.ee.aisd_ex_0.extratasks.MountainPeakProblem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class MountainPeakProblemTest {
    MountainPeakProblem searcher;

    @BeforeEach
    void setUp() {
        searcher = new MountainPeakProblem();
    }

    @Test
    void returnPeakIndex() {
        int[] arr = {-5, 2, 4, 6, 3, 0, -1};
        assertEquals(3, searcher.peakIndexInMountainArray(arr));
    }

    @Test
    void peakAtFirstElement() {
        int[] arr = {6, 3, 0, -1, -5, -34};
        assertEquals(0, searcher.peakIndexInMountainArray(arr));
    }

    @Test
    void peakAtLastElement() {
        int[] arr = {-5, 2, 4, 6, 10, 50, 73};
        assertEquals(6, searcher.peakIndexInMountainArray(arr));
    }

    @Test
    void handleOneElementArray() {
        int[] arr = {-5};
        assertEquals(0, searcher.peakIndexInMountainArray(arr));
    }

    @Test
    void handleTwoElementsArray() {
        int[] arr = {-5, 0};
        assertEquals(1, searcher.peakIndexInMountainArray(arr));
        int[] arr1 = {0, -5};
        assertEquals(0, searcher.peakIndexInMountainArray(arr1));
    }

    @Test
    void handleEmptyArray() {
        int[] arr = {};
        assertEquals(-1, searcher.peakIndexInMountainArray(arr));
    }

    @Test
    void throwNullPointerException() {
        int[] arr = null;
        assertThrows(NullPointerException.class, () -> searcher.peakIndexInMountainArray(arr));
    }

}