/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.ui;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.Version;
import sergey.bychkov.kogdaigra.ui.widget.GoHome;

/**
 *
 * @author bychkov-sy
 */
@Route(value = "about",layout=MainLayout.class)
@PageTitle("About")
public class AboutView extends FlexLayout {

    public static final String VIEW_NAME = "About";

    public AboutView() {
        add(GoHome.get());
        
        add("Здесь будет что-то о проекте");
        add(VaadinIcon.INFO_CIRCLE.create());
        add(new Span(" This application is using Vaadin Flow "
                + Version.getFullVersion() + "."));

        setSizeFull();
        setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        setAlignItems(FlexComponent.Alignment.CENTER);
    }
}

