package edu.isu.cs.cs2263.hw02.views;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.api.FxRobot;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit5.ApplicationExtension;

import static org.mockito.Mockito.mock;

@ExtendWith(ApplicationExtension.class)
public class WelcomeViewTest {
  //  WelcomeView testWelcomeView = mock(WelcomeView.class);

  //  Label message = new Label("Welcome to Course List");
  //  BorderPane bp = new BorderPane();

    @Test
    void initView() {
   //     FxAssert.verifyThat(message, LabeledMatchers.hasText("Welcome to Course List"));

        }

    @Test
    void updateData() {
    }
}

/*
    @Override
    public void initView() {
        Label message = new Label("Welcome to Course List");

        message.setFont(Font.font("Roboto", FontWeight.BOLD, 16));
        message.setTextAlignment(TextAlignment.CENTER);

        BorderPane bp = new BorderPane();
        bp.setCenter(message);
        BorderPane.setAlignment(message, Pos.CENTER);

        view = bp;
    } */