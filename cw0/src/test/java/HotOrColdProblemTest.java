import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import pl.edu.pw.ee.aisd_ex_0.extratasks.HotOrColdProblem;

class HotOrColdProblemTest {

    @Test
    void returnSecretNumberInRangeOfOneHundred() {
         HotOrColdProblem gameTest = new HotOrColdProblem(34);
         assertEquals(34, gameTest.guessNumber(100));
    }

    @Test
    void returnLeftBoundNumber() {
        HotOrColdProblem gameTest = new HotOrColdProblem(1);
        assertEquals(1, gameTest.guessNumber(100));
    }

    @Test
    void returnRightBoundNumber() {
        HotOrColdProblem gameTest = new HotOrColdProblem(100);
        assertEquals(100, gameTest.guessNumber(100));
    }

    @Test
    void returnMinusOneIfOutOfBounds() {
        HotOrColdProblem gameTest = new HotOrColdProblem(0);
        assertEquals(-1, gameTest.guessNumber(100));
    }
}
