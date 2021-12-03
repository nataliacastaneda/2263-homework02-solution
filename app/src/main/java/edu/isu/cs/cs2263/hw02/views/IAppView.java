package edu.isu.cs.cs2263.hw02.views;

import javafx.scene.Node;

/**Interface for some view related methods
 * No changes from hw02 solution
 */
public interface IAppView {

    Node getView();

    void initView();

    void updateData();
}
