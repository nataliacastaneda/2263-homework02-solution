package edu.isu.cs.cs2263.hw02.views;

import edu.isu.cs.cs2263.hw02.App;
import edu.isu.cs.cs2263.hw02.data.Course;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

import static org.mockito.Mockito.mock;

@ExtendWith(ApplicationExtension.class)
public class DisplayListViewTest {

    DisplayListView TestDispListView = mock(DisplayListView.class);
    ListView<Course> lstCourses;

    @Test
    void initView() {
        lstCourses = new ListView<>();


    }

    @Test
    void updateData() {
    }
}
/*
    @Override
    public void initView() {
        lstCourses = new ListView<>();

        Label lbl = new Label("Courses");
        lbl.setFont(Font.font("Roboto", FontWeight.BOLD, 18));

        BorderPane bp = new BorderPane();
        bp.setTop(lbl);
        bp.setCenter(lstCourses);
        bp.setPadding(new Insets(10,10,10,10));

        view = bp;
    }

    @Override
    public void updateData() {
        int index = parent.getSelectedDepartment();
        String code = Course.CODES[index];

        lstCourses.getItems().clear();

        for (Course c : parent.getCourses()) {
            if (c.getCode().equals(code))
                lstCourses.getItems().add(c);
        }
    }
} */
