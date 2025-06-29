package com.example.model;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudentTest {

    private Student student;
    private String validName;
    private int validAge;
    private String validEmail;
    private double validGpa;

    @BeforeEach
    void setUp() {
        System.out.println("Setting up Student test data...");
        
        validName = "Rohith Sharma";
        validAge = 21;
        validEmail = "rohith.sharma@university.edu";
        validGpa = 3.5;
        
        student = new Student(validName, validAge, validEmail, validGpa);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Cleaning up Student test data...");
        
        student = null;
        validName = null;
        validAge = 0;
        validEmail = null;
        validGpa = 0.0;
    }
    @Test
    @DisplayName("Should create student with valid constructor parameters")
    void testStudentConstructor_ValidParameters_ShouldCreateStudent() {
        // ARRANGE
        String name = "Test Student";
        int age = 20;
        String email = "test@email.com";
        double gpa = 3.0;

        // ACT
        Student newStudent = new Student(name, age, email, gpa);

        // ASSERT
        assertEquals(name, newStudent.getName());
        assertEquals(age, newStudent.getAge());
        assertEquals(email, newStudent.getEmail());
        assertEquals(gpa, newStudent.getGpa());
    }

    @Test
    @DisplayName("Should set valid name successfully")
    void testSetName_ValidName_ShouldSetSuccessfully() {
        // ARRANGE
        String newName = "New Valid Name";

        // ACT
        student.setName(newName);

        // ASSERT
        assertEquals(newName, student.getName());
    }

    @Test
    @DisplayName("Should throw exception when setting null name")
    void testSetName_NullName_ShouldThrowException() {
        // ARRANGE
        String nullName = null;

        // ACT & ASSERT
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> student.setName(nullName)
        );
        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw exception when setting empty name")
    void testSetName_EmptyName_ShouldThrowException() {
        // ARRANGE
        String emptyName = "   ";

        // ACT & ASSERT
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> student.setName(emptyName)
        );
        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @Test
    @DisplayName("Should set valid age successfully")
    void testSetAge_ValidAge_ShouldSetSuccessfully() {
        // ARRANGE
        int newAge = 25;

        // ACT
        student.setAge(newAge);

        // ASSERT
        assertEquals(newAge, student.getAge());
    }

    @Test
    @DisplayName("Should throw exception when setting negative age")
    void testSetAge_NegativeAge_ShouldThrowException() {
        // ARRANGE
        int negativeAge = -5;

        // ACT & ASSERT
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> student.setAge(negativeAge)
        );
        assertEquals("Age must be between 0 and 150", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw exception when setting age over 150")
    void testSetAge_AgeOver150_ShouldThrowException() {
        // ARRANGE
        int invalidAge = 200;

        // ACT & ASSERT
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> student.setAge(invalidAge)
        );
        assertEquals("Age must be between 0 and 150", exception.getMessage());
    }

    @Test
    @DisplayName("Should set valid email successfully")
    void testSetEmail_ValidEmail_ShouldSetSuccessfully() {
        // ARRANGE
        String newEmail = "newemail@domain.com";

        // ACT
        student.setEmail(newEmail);

        // ASSERT
        assertEquals(newEmail, student.getEmail());
    }

    @Test
    @DisplayName("Should throw exception when setting invalid email format")
    void testSetEmail_InvalidFormat_ShouldThrowException() {
        // ARRANGE
        String invalidEmail = "invalidemail.com";

        // ACT & ASSERT
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> student.setEmail(invalidEmail)
        );
        assertEquals("Invalid email format", exception.getMessage());
    }

    @Test
    @DisplayName("Should set valid GPA successfully")
    void testSetGpa_ValidGpa_ShouldSetSuccessfully() {
        // ARRANGE
        double newGpa = 3.8;

        // ACT
        student.setGpa(newGpa);

        // ASSERT
        assertEquals(newGpa, student.getGpa());
    }

    @Test
    @DisplayName("Should throw exception when setting GPA below 0")
    void testSetGpa_NegativeGpa_ShouldThrowException() {
        // ARRANGE
        double negativeGpa = -1.0;

        // ACT & ASSERT
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> student.setGpa(negativeGpa)
        );
        assertEquals("GPA must be between 0.0 and 4.0", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw exception when setting GPA above 4.0")
    void testSetGpa_GpaAbove4_ShouldThrowException() {
        // ARRANGE
        double invalidGpa = 5.0;

        // ACT & ASSERT
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> student.setGpa(invalidGpa)
        );
        assertEquals("GPA must be between 0.0 and 4.0", exception.getMessage());
    }

    @Test
    @DisplayName("Should return 'Excellent' grade level for GPA 3.5 or higher")
    void testGetGradeLevel_HighGpa_ShouldReturnExcellent() {
        // ARRANGE
        student.setGpa(3.7);

        // ACT
        String gradeLevel = student.getGradeLevel();

        // ASSERT
        assertEquals("Excellent", gradeLevel);
    }

    @Test
    @DisplayName("Should return 'Good' grade level for GPA between 3.0 and 3.4")
    void testGetGradeLevel_GoodGpa_ShouldReturnGood() {
        // ARRANGE
        student.setGpa(3.2);

        // ACT
        String gradeLevel = student.getGradeLevel();

        // ASSERT
        assertEquals("Good", gradeLevel);
    }

    @Test
    @DisplayName("Should return 'Average' grade level for GPA between 2.0 and 2.9")
    void testGetGradeLevel_AverageGpa_ShouldReturnAverage() {
        // ARRANGE
        student.setGpa(2.5);

        // ACT
        String gradeLevel = student.getGradeLevel();

        // ASSERT
        assertEquals("Average", gradeLevel);
    }

    @Test
    @DisplayName("Should return 'Below Average' grade level for GPA below 2.0")
    void testGetGradeLevel_LowGpa_ShouldReturnBelowAverage() {
        // ARRANGE
        student.setGpa(1.5);

        // ACT
        String gradeLevel = student.getGradeLevel();

        // ASSERT
        assertEquals("Below Average", gradeLevel);
    }

    @Test
    @DisplayName("Should return true when student is eligible for honors")
    void testIsEligibleForHonors_HighGpa_ShouldReturnTrue() {
        // ARRANGE
        student.setGpa(3.6);

        // ACT
        boolean isEligible = student.isEligibleForHonors();

        // ASSERT
        assertTrue(isEligible);
    }

    @Test
    @DisplayName("Should return false when student is not eligible for honors")
    void testIsEligibleForHonors_LowGpa_ShouldReturnFalse() {
        // ARRANGE
        student.setGpa(3.2);

        // ACT
        boolean isEligible = student.isEligibleForHonors();

        // ASSERT
        assertFalse(isEligible);
    }

    @Test
    @DisplayName("Should return true when comparing equal students")
    void testEquals_EqualStudents_ShouldReturnTrue() {
        // ARRANGE
        Student otherStudent = new Student(validName, validAge, validEmail, validGpa);

        // ACT
        boolean areEqual = student.equals(otherStudent);

        // ASSERT
        assertTrue(areEqual);
    }

    @Test
    @DisplayName("Should return false when comparing different students")
    void testEquals_DifferentStudents_ShouldReturnFalse() {
        // ARRANGE
        Student differentStudent = new Student("Different Name", validAge, "different@email.com", validGpa);

        // ACT
        boolean areEqual = student.equals(differentStudent);

        // ASSERT
        assertFalse(areEqual);
    }

    @Test
    @DisplayName("Should have same hash code for equal students")
    void testHashCode_EqualStudents_ShouldHaveSameHashCode() {
        // ARRANGE
        Student otherStudent = new Student(validName, validAge, validEmail, validGpa);

        // ACT
        int hash1 = student.hashCode();
        int hash2 = otherStudent.hashCode();

        // ASSERT
        assertEquals(hash1, hash2);
    }

    @Test
    @DisplayName("Should contain all student information in string representation")
    void testToString_ValidStudent_ShouldContainAllInfo() {
        // ARRANGE
        // Student already initialized in setUp

        // ACT
        String studentString = student.toString();

        // ASSERT
        assertTrue(studentString.contains(validName));
        assertTrue(studentString.contains(String.valueOf(validAge)));
        assertTrue(studentString.contains(validEmail));
        assertTrue(studentString.contains(String.valueOf(validGpa)));
    }
}
