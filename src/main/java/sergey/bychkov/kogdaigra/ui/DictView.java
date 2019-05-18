/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.ui;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;

/**
 *
 * @author bychkov-sy
 */
@Route(value="dict",layout=MainLayout.class)
public class DictView extends VerticalLayout {

    public DictView() {
        add(new Text("Здесь будут редактироваться справочники"));
        Tabs tabs = new Tabs();
        add(tabs);

        tabs.add(new Tab("Статус"),
                new Tab("Тип"),
                new Tab("Регион"));
    }

}
