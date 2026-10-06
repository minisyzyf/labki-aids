import pl.edu.pw.ee.aisd_ex_0.searcher.binary_search.BinarySearch;
import pl.edu.pw.ee.aisd_ex_0.searcher.service.Searching;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    private Searching searcher;

    @BeforeEach
    void setUp() {
        searcher = new BinarySearch();
    }

    @Test
    void returnIndexWhenElementFound() {
        int[] nums = {-3, -2, 0, 4, 5, 7};
        assertEquals(3, searcher.search(nums, 4));
    }

    @Test
    void returnIndexWhenTwoSameElementsInArray() {
        int[] nums = {-3, 0, 0, 4, 5, 7, 10, 34};
        assertEquals(1, searcher.search(nums, 0));
    }

    @Test
    void returnIndexWhenOnlyOneElementInArray() {
        int[] nums = {-3};
        assertEquals(0, searcher.search(nums, -3));
    }

    @Test
    void returnMinusOneWhenElementNotFound() {
        int[] nums = {-3, 0, -2, 6, 4, 5};
        assertEquals(-1, searcher.search(nums, 18));
    }

    @Test
    void handleEmptyArray() {
        int[] nums = {};
        assertEquals(-1, searcher.search(nums, 4));
    }

    @Test
    void throwExceptionWhenArrayIsNull() {
        assertThrows(NullPointerException.class, () -> searcher.search(null, 4));
    }
}