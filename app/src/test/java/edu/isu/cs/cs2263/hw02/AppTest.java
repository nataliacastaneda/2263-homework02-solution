package edu.isu.cs.cs2263.hw02;

import com.google.common.collect.Maps;
import edu.isu.cs.cs2263.hw02.data.Course;
import edu.isu.cs.cs2263.hw02.views.AppView;
import edu.isu.cs.cs2263.hw02.views.CoursesFormView;
import edu.isu.cs.cs2263.hw02.views.DisplayListView;
import edu.isu.cs.cs2263.hw02.views.WelcomeView;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxAssert;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.matcher.control.LabeledMatchers;
import javafx.stage.Stage;

import java.util.Map;
import java.util.Vector;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * This class tests functionality of the javaFx program represented in the App.java file
 * @author Natalia Castaneda
 */

@ExtendWith(ApplicationExtension.class)
public class AppTest {
    App testApp;

    Vector<Course> courses;
    AppView currentView;
    Map<String, AppView> views;
    BorderPane mainLayout;
    ChoiceBox<String> depts;
    Scene scene;

    /**
     * Initial set up of App launches it so that UI testing can occur.
     * Mockito is used to create a mock App.
     * @throws Exception
     */
    @BeforeEach
    public void setUp() throws Exception{
        testApp = mock(App.class);
        views = Maps.newHashMap();
        views.put("Welcome", new WelcomeView(testApp));
        views.put("DisplayList", new DisplayListView(testApp));
        views.put("CourseForm", new CoursesFormView(testApp));

        currentView = views.get("Welcome");
        courses = new Vector<>();

        ApplicationTest.launch(App.class);
    }

    /**
     * setting the stage for each test
     * @param stage
     * @throws Exception
     */
    @Start
    private void start(Stage stage) throws Exception {
        stage.show();
    }

    /**
     * hiding the stage after each test is completed
     * @throws TimeoutException
     */
    @AfterEach
    public void afterEachTest() throws TimeoutException{
        FxToolkit.hideStage();
    }

    /**
     * A test for the getCourses() method of App.java
     * Uses JUnit assertion assertEquals
     */
    @Test
    void getCoursesTest() {
        when(testApp.getCourses()).thenReturn(courses);
        Course course = new Course("Computer Science", "CS", 2263, 3);
        courses.add(course);
        assertEquals(courses, testApp.getCourses());
    }

    /**
     * A test for the setView() method of App.java
     * Uses testFx's FxAssert to verify that view has been set to Welcome
     */
    @Test
    void setViewTest(){
        testApp.setView("Welcome");
        FxAssert.verifyThat("#welcomeMessage",LabeledMatchers.hasText("Welcome to Course List"));
    }

    /**
     * A test for the showCourseForm() method of App.java
     * The mock is used to confirm that showCourse works the same as pressing the New Course button in the UI
     * Uses testFx's FxAssert to verify that course form is now showing (with request for Name:)
     *
     * @param robot a 'robot' that completes necessary actions to test the UI
     */
    @Test
    void showCourseFormTest(FxRobot robot) {
        doAnswer(invocation->{
            robot.clickOn("#newCourseButton");
            return null;
        }).when(testApp).showCourseForm();
        testApp.showCourseForm();
        FxAssert.verifyThat("#Name", LabeledMatchers.hasText("Name:"));
    }

    /**
     * A test for the displayList() method of App.java
     * the mock is used to confirm that displayList works the same as pressing the Display dept. button in the UI
     * Uses testFx's FxAssert to verify that list of Courses in that department is now showing (with title "Courses")
     *
     * @param robot a 'robot' that completes necessary actions to test the UI
     */
    @Test
    void displayListTest(FxRobot robot) {
        doAnswer(invocation->{
          //  robot.clickOn("#deptsChoiceBox");
            robot.clickOn("#deptDisplayButton");
            return null;
        }).when(testApp).displayList();
        testApp.displayList();
        FxAssert.verifyThat("#Courses", LabeledMatchers.hasText("Courses"));
    }

    /**
     * A test confirming that displayButton is properly labeled.
     */
    @Test
    void displayButtonTest(){
        FxAssert.verifyThat("#deptDisplayButton", LabeledMatchers.hasText("Display (dept.)"));
    }

    /**
     * A test confirming that new course Button is properly labeled.
     */
    @Test
    void courseButtonTest(){
        FxAssert.verifyThat("#newCourseButton", LabeledMatchers.hasText("New Course"));
    }

    /**
     * A test confirming that exit Button is properly labeled.
     */
    @Test
    void exitButtonTest(){
        FxAssert.verifyThat("#exitButton", LabeledMatchers.hasText("Exit"));
    }

    /**
     * A test confirming that the exit button takes us to the proper screen.
     *
     * @param robot  a 'robot' that completes necessary actions to test the UI
     */
    @Test
    void exitTest(FxRobot robot) {
        robot.clickOn("#exitButton");
        FxAssert.verifyThat("#confirmExit", LabeledMatchers.hasText("OK"));
    }

    /**
     * A test confirming that the welcome message appears when showWelcome is called
     */
    @Test
    void showWelcomeTest() {
        testApp.showWelcome();
        FxAssert.verifyThat("#welcomeMessage", LabeledMatchers.hasText("Welcome to Course List"));
    }

    /**
     * A test confirming that courses can be added to the App
     * asserts that courses vector<> is not null after a course is added
     */
    @Test
    void addCourseTest() {
        Course testCourse = new Course("Computer Science", "CS", 2263, 3);
        testApp.addCourse(testCourse);
        assertNotNull(courses);
    }

    /**
     * A test confirming that initView() from WelcomeView.java shows the right message.
     */
    @Test
    void initViewWelcomeTest() {//method from WelcomeView.java
        FxAssert.verifyThat("#welcomeMessage", LabeledMatchers.hasText("Welcome to Course List"));
    }

    /**
     * A test confirming that initView() from CourseFormView.java shows all the proper buttons and labels.
     * @param robot  a 'robot' that completes necessary actions to test the UI
     */
    @Test
    void initViewCourseFormTest(FxRobot robot) {//method from CourseFormView.java
        robot.clickOn("#newCourseButton");
        FxAssert.verifyThat("#Name", LabeledMatchers.hasText("Name:"));
        FxAssert.verifyThat("#lblNumber", LabeledMatchers.hasText("Number:"));
        FxAssert.verifyThat("#lblCredits", LabeledMatchers.hasText("Credits:"));
        FxAssert.verifyThat("#lblHead", LabeledMatchers.hasText("Create a new Course"));
        FxAssert.verifyThat("#btnReset", LabeledMatchers.hasText("Reset"));
        FxAssert.verifyThat("#btnAddCourse", LabeledMatchers.hasText("Add Course"));
    }

    /**
     * A test confirming that initView() from DisplayListView.java shows the proper heading.
     * @param robot  a 'robot' that completes necessary actions to test the UI
     */
    @Test
    void initViewDisplayListTest(FxRobot robot) {//method from CourseFormView.java
        robot.clickOn("#deptDisplayButton");
        FxAssert.verifyThat("#Courses", LabeledMatchers.hasText("Courses"));
    }
}
