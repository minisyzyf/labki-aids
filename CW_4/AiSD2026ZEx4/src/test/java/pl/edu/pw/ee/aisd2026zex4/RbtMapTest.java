package pl.edu.pw.ee.aisd2026zex4;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.edu.pw.ee.aisd2026zex4.service.MapInterface;

public class RbtMapTest {

    private MapInterface<Integer, String> students;

    @BeforeEach
    public void setup() {
        students = new RbtMap<>();
    }

    @Test
    public void should_ThrowException_When_PuttingNullKey() {
        // given
        Integer studentId = null;
        String studentFullName = "Miś Uszatek";

        // when
        Throwable thrown = catchThrowable(() -> {
            students.setValue(studentId, studentFullName);
        });

        // then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Params (key, value) cannot be null.");
    }
    
    @Test
    public void should_ThrowException_When_PuttingNullValue() {
        // given
        Integer studentId = 123;
        String studentFullName = null;

        // when
        Throwable thrown = catchThrowable(() -> {
            students.setValue(studentId, studentFullName);
        });

        // then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Params (key, value) cannot be null.");
    }
    
    @Test
    public void should_ThrowException_When_GettingNullKey() {
        // given
        Integer studentId = null;

        // when
        Throwable thrown = catchThrowable(() -> {
            String result = students.getValue(studentId);
        });

        // then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Cannot get value by null key.");
    }
    
    @Test
    public void should_CorrectlySetAndGetValue_When_PuttingCorrectKeyAndValue() {
        // given
        Integer studentId1 = 123;
        String studentFullName1 = "Dawid Pasieka";
        Integer studentId2 = 321;
        String studentFullName2 = "Antonina Szawarnik";

        // when
        students.setValue(studentId1, studentFullName1);
        students.setValue(studentId2, studentFullName2);

        // then
        assertEquals("Dawid Pasieka", students.getValue(studentId1));
        assertEquals("Antonina Szawarnik", students.getValue(studentId2));
    }
}
