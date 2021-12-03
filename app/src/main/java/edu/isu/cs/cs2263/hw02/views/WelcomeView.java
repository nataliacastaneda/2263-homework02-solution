package edu.isu.cs.cs2263.hw02.views;

import edu.isu.cs.cs2263.hw02.App;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import lombok.val;

public class WelcomeView extends AppView {

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
