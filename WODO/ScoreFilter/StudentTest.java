package com.example;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void testHasScoredAbove60InAny_trueCases() {
        Student s1 = new Student("A", 61, 10, 10);
        Student s2 = new Student("B", 10, 62, 10);
        Student s3 = new Student("C", 10, 10, 63);

        assertTrue(s1.hasScoredAbove60InAny());
        assertTrue(s2.hasScoredAbove60InAny());
        assertTrue(s3.hasScoredAbove60InAny());
    }

    @Test
    void testHasScoredAbove60InAny_falseCase() {
        Student s = new Student("D", 60, 60, 59); // exactly 60 is NOT > 60
        assertFalse(s.hasScoredAbove60InAny());
    }

    @Test
    void testCountStudentsAbove60() {
        List<Student> students = Arrays.asList(
                new Student("A", 55, 61, 48),
                new Student("B", 90, 82, 76),
                new Student("C", 45, 30, 60),
                new Student("D", 65, 59, 40)
        );

        long count = students.stream().filter(Student::hasScoredAbove60InAny).count();
        assertEquals(3, count); // A (61), B (90...), D (65)
    }
}
