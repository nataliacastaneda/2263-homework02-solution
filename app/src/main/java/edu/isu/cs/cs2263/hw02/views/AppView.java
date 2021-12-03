package edu.isu.cs.cs2263.hw02.views;

import edu.isu.cs.cs2263.hw02.App;
import edu.isu.cs.cs2263.hw02.data.Course;
import javafx.scene.Node;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Log4j2
public abstract class AppView implements IAppView {
    private final static Logger LOGGER = LogManager.getLogger(Course.class);

    public static void main(String[] args){
        LOGGER.debug("Debug Message Logged");
        LOGGER.info("Info Message Logged");
        LOGGER.error("Error Message Logged", new NullPointerException("NullError"));
    }

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
