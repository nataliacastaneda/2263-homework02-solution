package edu.isu.cs.cs2263.hw02.views;

import edu.isu.cs.cs2263.hw02.App;
import javafx.scene.Node;
import lombok.extern.log4j.Log4j2;

@Log4j2
public abstract class AppView implements IAppView {
    /**
     * No changes from hw02 solution
     */

    protected Node view;
    protected App parent;

    public AppView(App parent) {
        this.parent = parent;
        initView();
    }

    public Node getView() {
        return view;
    }
}
