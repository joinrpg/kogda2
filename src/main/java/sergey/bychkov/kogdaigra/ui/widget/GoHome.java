/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.ui.widget;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;

/**
 *
 * @author bychkov-sy
 */
public class GoHome extends Button {

    public GoHome() {
        setIcon(VaadinIcon.HOME.create());
        addClickListener(event -> getUI().ifPresent(ui -> ui.navigate("")));
    }

    public static Button get() {
        return new GoHome();
    }

}
