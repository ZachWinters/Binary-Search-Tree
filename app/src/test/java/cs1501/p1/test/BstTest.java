package cs1501.p1.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;

import cs1501.p1.Bst;

public class BstTest {

    Bst<Integer> bst;
    final Integer[] INTKEYS = {5, 1, 10};

    // Time limit per test
    public final int LIMIT = 10;

    @BeforeEach
    void setup() {
        bst = new Bst<>();
        for (int i : INTKEYS) {
            assertTimeoutPreemptively(Duration.ofSeconds(LIMIT), () -> {
                assertTrue(bst.put(i), "put() did not return true when adding");
            }, "Building initial tree did not complete within " + LIMIT + " seconds");
        }

        for (int i : INTKEYS) {
            assertTimeoutPreemptively(Duration.ofSeconds(LIMIT), () -> {
                assertTrue(bst.contains(i), "Cannot check, put/contains not working");
            }, "Checking initial tree did not complete within " + LIMIT + " seconds");
        }
    }

    @Test
    public void dupTest() {
        for (int i : INTKEYS) {
            assertTimeoutPreemptively(Duration.ofSeconds(LIMIT), () -> {
                assertFalse(bst.put(i), "put() did not return false when adding duplicates");
            }, "Building initial tree did not complete within " + LIMIT + " seconds");
        }
    }

    @Test
    public void containsTest() {
        assertTimeoutPreemptively(Duration.ofSeconds(LIMIT), () -> {
            assertTrue(bst.contains(5), "Could not find 5");
        }, "Test did not complete within " + LIMIT + " seconds");
    }

    @Test
    public void deleteTest() {
        assertTimeoutPreemptively(Duration.ofSeconds(LIMIT), () -> {
            bst.delete(1);
            assertFalse(bst.contains(1), "Could not remove 1");
        }, "Test did not complete within " + LIMIT + " seconds");
    }

    @Test
    public void heightTest() {
        assertTimeoutPreemptively(Duration.ofSeconds(LIMIT), () -> {
            assertEquals(2, bst.height(), "Tree with 5, 1, and 10 should be height 2");
        }, "Test did not complete within " + LIMIT + " seconds");
    }

    @Test
    public void balancedTest() {
        assertTimeoutPreemptively(Duration.ofSeconds(LIMIT), () -> {
            assertTrue(bst.isBalanced(), "Tree with 5, 1, then 10 inserted should be balanced");
        }, "Test did not complete within " + LIMIT + " seconds");
    }

    @Test
    public void traverseTest() {
        assertTimeoutPreemptively(Duration.ofSeconds(LIMIT), () -> {
            assertEquals("1-5-10", bst.inOrderTraversal(), "Should produce \"1-5-10\"");
        }, "Test did not complete within " + LIMIT + " seconds");
    }

    @Test
    public void serializeTest() {
        assertTimeoutPreemptively(Duration.ofSeconds(LIMIT), () -> {
            assertEquals("R[5];L[1];L[10]", bst.serialize(), "Should produce \"R[5];L[1];L[10]\"");
        }, "Test did not complete within " + LIMIT + " seconds");
    }

    @Test
    public void reverseTest() {
        assertTimeoutPreemptively(Duration.ofSeconds(LIMIT), () -> {
            Bst<Integer> r = (Bst<Integer>) bst.reverse();
            assertEquals("R[5];L[10];L[1]", r.serialize(), "Should produce \"R[5];L[10];L[1]\"");
        }, "Test did not complete within " + LIMIT + " seconds");
    }

    @Test
    public void submitTest() {
        assertTimeoutPreemptively(Duration.ofSeconds(LIMIT), () -> {
            assertTrue(true, "This test should always pass");
        }, "Test did not complete within " + LIMIT + " seconds");
    }

}

