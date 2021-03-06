package pt.isep.nsheets.client.application.menu;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLink;

import gwt.material.design.client.ui.MaterialNavBar;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialSideNavPush;

public class MenuView extends ViewWithUiHandlers<MenuUiHandlers> implements MenuPresenter.MyView {

    interface Binder extends UiBinder<Widget, MenuView> {

    }
    @UiField
    static MaterialPanel panel;
    @UiField
    static MaterialNavBar navBar;
    @UiField
    static MaterialSideNavPush sideNav;
    @UiField
    static MaterialLink username, logout;
    @UiField
    static MaterialImage image;

    @Inject
    MenuView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public static MaterialSideNavPush getSideNav() {
        return sideNav;
    }

    public static MaterialPanel getPanel() {
        return panel;
    }

    public static MaterialNavBar getNavBar() {
        return navBar;
    }

    public static MaterialLink getUsername() {
        return username;
    }

    public static MaterialLink getLogout() {
        return logout;
    }

    public static MaterialImage getImage() {
        return image;
    }
}
