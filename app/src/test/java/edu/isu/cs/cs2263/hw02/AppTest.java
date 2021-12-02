package edu.isu.cs.cs2263.hw02;

import com.google.common.collect.Maps;
import edu.isu.cs.cs2263.hw02.data.Course;
import edu.isu.cs.cs2263.hw02.views.AppView;
import edu.isu.cs.cs2263.hw02.views.CoursesFormView;
import edu.isu.cs.cs2263.hw02.views.DisplayListView;
import edu.isu.cs.cs2263.hw02.views.WelcomeView;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignF;
import org.kordamp.ikonli.materialdesign2.MaterialDesignP;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.testfx.api.FxAssert;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.assertions.api.Assertions;
import org.testfx.assertions.api.WindowAssert;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.matcher.control.LabeledMatchers;
import javafx.stage.Stage;

import java.util.Map;
import java.util.Optional;
import java.util.Vector;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testfx.api.FxToolkit.registerPrimaryStage;
import static org.testfx.api.FxToolkit.setupApplication;

//I could not find good documentation on how to operate TestFx. I understand how it should work with the FxRobot selecting buttons and such and working through the program to confirm
//functionality, but I do not know how to set up the classes so that they can be tested.

@ExtendWith(ApplicationExtension.class)
public class AppTest {
/*
    @BeforeAll
    public static void setupSpec() throws Exception{
        //set up javafx system
        if (Boolean.getBoolean("headless")){
            System.setProperty("testfx.robot", "glass");
            System.setProperty("testfx.headless", "true");
            System.setProperty("prism.order", "sw");
            System.setProperty("prism.text", "t2k");
            System.setProperty("java.awt.headless", "true");
        }
        registerPrimaryStage();
    }
 */
    App testApp = mock(App.class);

    Vector<Course> courses;
    AppView currentView;
    Map<String, AppView> views;
    BorderPane mainLayout;
    ChoiceBox<String> depts;
    Scene scene;

    @BeforeEach
    public void setUp() throws Exception{
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
    void getCourses() {
    }

    @Test
    void setView(){
     //   when().thenReturn();

    }

    @Test
    void showCourseForm(FxRobot robot) {
   //     when().thenReturn()
        //FxAssert.verifyThat();
    }

    @Test
    void displayList(FxRobot robot) {
        robot.clickOn("#deptsChoiceBox");
        robot.clickOn(".deptDisplayButton");


        //when().thenReturn();
       // FxAssert.verifyThat("#deptDisplayButton", LabeledMatchers.hasText("Display (dept.)"));
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
    void exit(FxRobot robot) {
        robot.clickOn("#exitButton");
        FxAssert.verifyThat("#confirmExit", LabeledMatchers.hasText("OK"));
    }

    @Test
    void getSelectedDepartment(FxRobot robot) {
       // when().then();
    }

    @Test
    void showWelcome(FxRobot robot) {
       // FxAssert.verifyThat();
        //when().then();
    }

    @Test
    void addCourse() {
        Course testCourse = new Course("Computer Science", "CS", 2263, 3);
        courses.add(testCourse);
        assertNotNull(courses);
    }

}
