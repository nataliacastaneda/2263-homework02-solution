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

@ExtendWith(ApplicationExtension.class)
public class AppTest {
    App testApp;// = mock(App.class);

    Vector<Course> courses;
    AppView currentView;
    Map<String, AppView> views;
    BorderPane mainLayout;
    ChoiceBox<String> depts;
    Scene scene;

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

    @Start
    private void start(Stage stage) throws Exception {
        stage.show();
    }

    @AfterEach
    public void afterEachTest() throws TimeoutException{
        FxToolkit.hideStage();
    }

    @Test
    void getCoursesTest() {
        when(testApp.getCourses()).thenReturn(courses);
        Course course = new Course("Computer Science", "CS", 2263, 3);
        courses.add(course);
        assertEquals(courses, testApp.getCourses());
    }

    @Test
    void setViewTest(){
        testApp.setView("Welcome");
        FxAssert.verifyThat("#welcomeMessage",LabeledMatchers.hasText("Welcome to Course List"));
    }

    @Test
    void showCourseFormTest(FxRobot robot) {
        doAnswer(invocation->{
            robot.clickOn("#newCourseButton");
            return null;
        }).when(testApp).showCourseForm();
        testApp.showCourseForm();
        FxAssert.verifyThat("#Name", LabeledMatchers.hasText("Name:"));
    }

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

    @Test
    void displayButtonTest(){
        FxAssert.verifyThat("#deptDisplayButton", LabeledMatchers.hasText("Display (dept.)"));
    }

    @Test
    void courseButtonTest(){
        FxAssert.verifyThat("#newCourseButton", LabeledMatchers.hasText("New Course"));
    }

    @Test
    void exitButtonTest(){
        FxAssert.verifyThat("#exitButton", LabeledMatchers.hasText("Exit"));
    }

    @Test
    void exitTest(FxRobot robot) {
        robot.clickOn("#exitButton");
        FxAssert.verifyThat("#confirmExit", LabeledMatchers.hasText("OK"));
    }

    @Test
    void showWelcomeTest() {
        testApp.showWelcome();
        FxAssert.verifyThat("#welcomeMessage", LabeledMatchers.hasText("Welcome to Course List"));
    }

    @Test
    void addCourseTest() {
        Course testCourse = new Course("Computer Science", "CS", 2263, 3);
        testApp.addCourse(testCourse);
        assertNotNull(courses);
    }

    @Test
    void initViewWelcomeTest() {//method from WelcomeView.java
        FxAssert.verifyThat("#welcomeMessage", LabeledMatchers.hasText("Welcome to Course List"));
    }

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

    @Test
    void initViewDisplayListTest(FxRobot robot) {//method from CourseFormView.java
        robot.clickOn("#deptDisplayButton");
        FxAssert.verifyThat("#Courses", LabeledMatchers.hasText("Courses"));
    }
}
