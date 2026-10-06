import pl.edu.pw.ee.aisd_ex_0.searcher.linear_search.LinearSearch;
import pl.edu.pw.ee.aisd_ex_0.searcher.service.Searching;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class LinearSearchTest {
    private Searching searcher;

    @BeforeEach
    void setUp() {
        searcher = new LinearSearch();
    }

    @Test
    void returnIndexWhenElementFound() {
        int[] nums = {-3, 0, -2, 6, 4, 5};
        assertEquals(4, searcher.search(nums, 4));
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