package edu.isu.cs.cs2263.hw02.views;

import edu.isu.cs.cs2263.hw02.App;
import edu.isu.cs.cs2263.hw02.data.Course;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import lombok.val;

public class DisplayListView extends AppView {

    ListView<Course> lstCourses;

    public DisplayListView(App parent) {
        super(parent);
    }

    /**
     * Changes made from original hw02 solution:
     * added Ids for various labels and buttons for querying during testing
     * implemented 'val' annotation from project lombok for label and button local variables
     */
    @Override
    public void initView() {
        lstCourses = new ListView<>();

        val lbl = new Label("Courses");
        lbl.setId("Courses");
        lbl.setFont(Font.font("Roboto", FontWeight.BOLD, 18));

        val bp = new BorderPane();
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
}
