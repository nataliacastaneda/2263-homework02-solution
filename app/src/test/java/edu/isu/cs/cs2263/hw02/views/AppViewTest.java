package edu.isu.cs.cs2263.hw02.views;

import edu.isu.cs.cs2263.hw02.App;
import javafx.scene.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.service.query.NodeQuery;

import static org.mockito.Mockito.*;

@ExtendWith(ApplicationExtension.class)
public class AppViewTest {
    Node view;
    App parent;

    AppView testAppView = mock(AppView.class);

    @Test
    void getView() {
     //   when(testAppView.getView()).thenReturn(view);
     //   FxAssert.verifyThat((NodeQuery) view, LabeledMatchers.hasText(""));
    }
}
