package edu.isu.cs.cs2263.hw02.views;

import edu.isu.cs.cs2263.hw02.App;
import edu.isu.cs.cs2263.hw02.data.Course;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Log4j2
public class WelcomeView extends AppView {
    private final static Logger LOGGER = LogManager.getLogger(Course.class);

    public static void main(String[] args){
        LOGGER.debug("Debug Message Logged");
        LOGGER.info("Info Message Logged");
        LOGGER.error("Error Message Logged", new NullPointerException("NullError"));
    }

    public WelcomeView(App parent) {
        super(parent);
    }

    /**
     * Changes made from original hw02 solution:
     * added Ids for various labels and buttons for querying during testing
     * implemented 'val' annotation from project lombok for label and button local variables
     */
    @Override
    public void initView() {
        val message = new Label("Welcome to Course List");
        message.setId("welcomeMessage");

        message.setFont(Font.font("Roboto", FontWeight.BOLD, 16));
        message.setTextAlignment(TextAlignment.CENTER);

        val bp = new BorderPane();
        bp.setCenter(message);
        BorderPane.setAlignment(message, Pos.CENTER);

        view = bp;
    }

    @Override
    public void updateData() {

    }
}
