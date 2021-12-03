package edu.isu.cs.cs2263.hw02.data;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseTest {
    Course testCourse = new Course("Computer Science", "CS", 2263, 3);

    @Test
    void getNumber() {
        assertEquals(2263, testCourse.getNumber());
    }

    @Test
    void setNumber() {
        testCourse.setNumber(2235);
        assertEquals(2235, testCourse.getNumber());
    }

    @Test
    void getName() {
        assertEquals("Computer Science", testCourse.getName());
    }

    @Test
    void setName() {
        testCourse.setName("Data Structures");
        assertEquals("Data Structures", testCourse.getName());
    }

    @Test
    void getCredits() {
        assertEquals(3, testCourse.getCredits());
    }

    @Test
    void setCredits() {
        testCourse.setCredits(4);
        assertEquals(4, testCourse.getCredits());
    }

    @Test
    void getCode() {
        assertEquals("CS", testCourse.getCode());
    }

    @Test
    void setCode() {
        testCourse.setCode("MATH");
        assertEquals("MATH", testCourse.getCode());
    }

    @Test
    void testToString() {
        String expected = "CS 2263 Computer Science (3)";
        assertEquals(expected, testCourse.toString());
    }
}
