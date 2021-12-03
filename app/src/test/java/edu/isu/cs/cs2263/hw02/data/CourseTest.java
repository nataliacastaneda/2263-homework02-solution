package edu.isu.cs.cs2263.hw02.data;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


/** Tests the course class
 * @author Natalia Castaneda
 */
public class CourseTest {
    Course testCourse = new Course("Computer Science", "CS", 2263, 3);

    /**
     * The tests below test the getter and setter functionality of the Course object.
     * All tests use JUnit assertions, specifically assertEquals.
     */
    @Test
    void getNumberTest() {
        assertEquals(2263, testCourse.getNumber());
    }

    @Test
    void setNumberTest() {
        testCourse.setNumber(2235);
        assertEquals(2235, testCourse.getNumber());
    }

    @Test
    void getNameTest() {
        assertEquals("Computer Science", testCourse.getName());
    }

    @Test
    void setNameTest() {
        testCourse.setName("Data Structures");
        assertEquals("Data Structures", testCourse.getName());
    }

    @Test
    void getCreditsTest() {
        assertEquals(3, testCourse.getCredits());
    }

    @Test
    void setCreditsTest() {
        testCourse.setCredits(4);
        assertEquals(4, testCourse.getCredits());
    }

    @Test
    void getCodeTest() {
        assertEquals("CS", testCourse.getCode());
    }

    @Test
    void setCodeTest() {
        testCourse.setCode("MATH");
        assertEquals("MATH", testCourse.getCode());
    }

    /**
     * The test below tests the ability to create a string for a course in the specified format
     */
    @Test
    void testToString() {
        String expected = "CS 2263 Computer Science (3)";
        assertEquals(expected, testCourse.toString());
    }
}
