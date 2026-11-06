package pl.edu.pw.ee.aisd2026zex4;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import pl.edu.pw.ee.aisd2026zex4.exception.NotYetImplementedException;

public class RedBlackTreeTest {

    @Test
    void should_ReturnNull_When_GettingFromEmptyTree() {
        // given
        RedBlackTree<Integer, String> tree = new RedBlackTree<>();

        // when
        String result = tree.get(1);

        // then
        assertNull(result);
    }

    @Test
    void should_ReturnNull_When_KeyDoesNotExistInTree() {
        // given
        RedBlackTree<Integer, String> tree = new RedBlackTree<>();
        tree.put(2, "two");

        // when
        String result = tree.get(1);

        // then
        assertNull(result);
    }

    @Test
    void should_ThrowException_When_GettingNullKey() {
        // given
        RedBlackTree<Integer, String> tree = new RedBlackTree<>();

        // when & then
        assertThrows(IllegalArgumentException.class, () -> tree.get(null));
    }

    @Test
    void should_ThrowException_When_PuttingNullKey() {
        // given
        RedBlackTree<Integer, String> tree = new RedBlackTree<>();

        // when
        Throwable thrown = catchThrowable(() -> {
            tree.put(null, "one");
        });
        
        // then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Input params (key, value) cannot be null.");
    }

    @Test
    void should_ThrowException_When_PuttingNullValue() {
        // given
        RedBlackTree<Integer, String> tree = new RedBlackTree<>();

        // when
        Throwable thrown = catchThrowable(() -> {
            tree.put(1, null);
        });
        
        // then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Input params (key, value) cannot be null.");
    }

    @Test
    void should_StoreAndRetrieveValues_When_KeysAreUnique() {
        // given
        RedBlackTree<Integer, String> tree = new RedBlackTree<>();

        // when
        tree.put(2, "two");
        tree.put(1, "one");

        // then
        assertEquals("one", tree.get(1));
        assertEquals("two", tree.get(2));
    }

    @Test
    void should_UpdateExistingValue_When_KeyAlreadyExists() {
        // given
        RedBlackTree<Integer, String> tree = new RedBlackTree<>();
        tree.put(2, "old value");

        // when
        tree.put(2, "new value");

        // then
        assertEquals("new value", tree.get(2));
    }

    @Test
    void should_DoNothing_When_DeletingMinFromEmptyTree() {
        // given
        RedBlackTree<Integer, String> tree = new RedBlackTree<>();

        // when
        tree.deleteMin(); 

        // then
        assertNull(tree.get(1));
    }
    
    @Test
    void should_ThrowException_When_TryingToDeleteMinWithValidArgument() {
        // given
        RedBlackTree<Integer, String> tree = new RedBlackTree<>();
        tree.put(1, "cant delete yet");
        
        // when
        Throwable thrown = catchThrowable(() -> {
            tree.deleteMin();
        }); 

        // then
        assertThat(thrown)
                .isInstanceOf(NotYetImplementedException.class)
                .hasMessage("This method is not yet implemented. This is a task for you.");
    }
    
    @Test
    void should_TriggerRotateLeft_When_RightChildIsRed() {
        // given
        RedBlackTree<Integer, String> tree = new RedBlackTree<>();

        // when
        tree.put(1, "one");
        tree.put(2, "two"); 

        // then
        assertEquals("one", tree.get(1));
        assertEquals("two", tree.get(2));
    }

    @Test
    void should_TriggerRotateRight_When_TwoLeftChildrenAreRed() {
        // given
        RedBlackTree<Integer, String> tree = new RedBlackTree<>();

        // when
        tree.put(3, "three");
        tree.put(2, "two");
        tree.put(1, "one"); 

        // then
        assertEquals("one", tree.get(1));
        assertEquals("two", tree.get(2));
        assertEquals("three", tree.get(3));
    }

    @Test
    void should_TriggerColorChange_When_BothChildrenAreRed() {
        // given
        RedBlackTree<Integer, String> tree = new RedBlackTree<>();

        // when
        tree.put(2, "two");
        tree.put(1, "one");
        tree.put(3, "three");

        // then
        assertEquals("one", tree.get(1));
        assertEquals("two", tree.get(2));
        assertEquals("three", tree.get(3));
    }
}