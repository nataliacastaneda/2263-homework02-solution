package edu.isu.cs.cs2263.hw02.views;

import edu.isu.cs.cs2263.hw02.App;
import edu.isu.cs.cs2263.hw02.data.Course;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignP;
import org.kordamp.ikonli.materialdesign2.MaterialDesignR;

@Log4j2
public class CoursesFormView extends AppView {
    private final static Logger LOGGER = LogManager.getLogger(Course.class);

    public static void main(String[] args){
        LOGGER.debug("Debug Message Logged");
        LOGGER.info("Info Message Logged");
        LOGGER.error("Error Message Logged", new NullPointerException("NullError"));
    }

    private TextField tfName;
    private Spinner<Integer> spnNumber;
    private Spinner<Integer> spnCredits;
    private Label lblMessage;
    private String code;

    public CoursesFormView(App parent) {
        super(parent);
    }

    /**
     * Changes made from original hw02 solution:
     * added Ids for various labels and buttons for querying during testing
     * implemented 'val' annotation from project lombok for label and button local variables
     */
    @Override
    public void initView() {
        lblMessage = new Label("");

        tfName = new TextField();
        tfName.setPromptText("Enter a course name...");
        tfName.setMinWidth(400);

        val lblName = new Label("Name:");
        lblName.setId("Name");
        lblName.setTextAlignment(TextAlignment.RIGHT);
        lblName.setLabelFor(tfName);

        spnNumber = new Spinner<>(100, 900, 100, 1);
        spnNumber.setEditable(true);

        val lblNumber = new Label("Number:");
        lblNumber.setId("lblNumber");
        lblNumber.setTextAlignment(TextAlignment.RIGHT);
        lblNumber.setLabelFor(spnNumber);

        spnCredits = new Spinner<>(0, 10, 1, 1);
        spnCredits.setEditable(true);

        val lblCredits = new Label("Credits:");
        lblCredits.setId("lblCredits");
        lblCredits.setTextAlignment(TextAlignment.RIGHT);
        lblCredits.setLabelFor(spnCredits);

        val gpForm = new GridPane();
        gpForm.add(lblName, 0, 0, 1, 1);
        gpForm.add(lblNumber, 0, 1, 1, 1);
        gpForm.add(lblCredits, 0, 2, 1, 1);
        gpForm.add(tfName, 1, 0, 3, 1);
        gpForm.add(spnNumber, 1, 1, 1, 1);
        gpForm.add(spnCredits, 1, 2, 1, 1);
        gpForm.setHgap(5);
        gpForm.setVgap(5);

        val lblHead = new Label("Create a new Course");
        lblHead.setId("lblHead");
        lblHead.setFont(Font.font("Roboto", FontWeight.BOLD, 18));

        val vbxTop = new VBox();
        vbxTop.getChildren().add(lblHead);
        vbxTop.getChildren().add(lblMessage);
        vbxTop.setSpacing(5);

        val btnReset = new Button("Reset");
        btnReset.setId("btnReset");
        btnReset.setOnAction(event -> {
            reset();
        });
        btnReset.setGraphic(FontIcon.of(MaterialDesignR.REFRESH, 20));

        val btnAddCourse = new Button("Add Course");
        btnAddCourse.setId("btnAddCourse");
        btnAddCourse.setOnAction(event -> {
            validateAndAdd();
        });
        btnAddCourse.setGraphic(FontIcon.of(MaterialDesignP.PLUS, 20));
        btnAddCourse.setDefaultButton(true);

        val fpButtons = new FlowPane();
        fpButtons.getChildren().add(btnReset);
        fpButtons.getChildren().add(btnAddCourse);
        fpButtons.setHgap(5);

        val main = new BorderPane();
        main.setCenter(gpForm);
        main.setTop(vbxTop);
        main.setBottom(fpButtons);
        main.setPadding(new Insets(10,10,10,10));

        view = main;
    }

    private void validateAndAdd() {
        if (tfName.getText().isBlank()) {
            lblMessage.setText("Error: Name cannot be empty!");
            lblMessage.setTextFill(Color.RED);
        } else {
            lblMessage.setText("");

            Course c = new Course(tfName.getText(), code, spnNumber.getValue(), spnCredits.getValue());
            parent.addCourse(c);

            parent.showWelcome();
        }
    }

    private void reset() {
        lblMessage.setText("");
        tfName.setText("");
        spnCredits.decrement(spnCredits.getValue());
        spnNumber.decrement(spnNumber.getValue() - 100);
    }

    @Override
    public void updateData() {
        code = Course.CODES[parent.getSelectedDepartment()];
        reset();
    }
}
