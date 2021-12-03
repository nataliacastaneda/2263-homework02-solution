package edu.isu.cs.cs2263.hw02.data;
/** Represents a course
 * changes from original hw02 solution are specified.
 */

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Used project lombok Data annotation since this is a data class for Course Object.
 * Getters and setters are automatically generated.
 */
@Data @Log4j2
public class Course {

    private final static Logger LOGGER = LogManager.getLogger(Course.class);

    public static void main(String[] args){
        LOGGER.debug("Debug Message Logged");
        LOGGER.info("Info Message Logged");
        LOGGER.error("Error Message Logged", new NullPointerException("NullError"));
    }


    /**
     * Possible codes and departments
     */
    public static final String[] CODES = { "CS", "CHEM", "PHYS", "MATH", "BTNY", "ZOO" };
    public static final String[] DEPTS = { "Computer Science", "Chemistry", "Physics", "Mathematics", "Botany", "Zoology" };

    private int number;
    private String name;
    private int credits;
    private String code;

    /** Creates course object with details:
     * @param name name of the course (ex: Advanced OOP)
     * @param code code of the course (ex: CS is code for Computer Science)
     * @param number number of the course (ex: 2263)
     * @param credits number of credits for course (ex: 3)
     */
    public Course(String name, String code, int number, int credits) {
        this.name = name;
        this.code = code;
        this.number = number;
        this.credits = credits;
    }

    /**
     * The code below has been commented out because it is not longer needed
     * with the project lombok @Data annotation
     */
/*
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    } */

    /** Creates string of course details
     * @return A string representing a course object
     */
    @Override
    public String toString() {
        return String.format("%s %d %s (%d)", code, number, name, credits);
    }
}
