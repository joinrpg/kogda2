/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.ui.editor;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.ItemClickEvent;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.data.binder.Binder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import sergey.bychkov.kogdaigra.backend.repo.DictRepository;

import java.util.List;

/**
 *
 * @author serge
 * @param <T>
 */
public class Editor<T> extends Tab {

    private final Grid<T> grid;
    private final Div content;
    private Binder<T> binder;
    private final HorizontalLayout buttons;
    //private final DictRepository<T> repo;
    @Autowired
    DictRepository<T> repo;

    public Editor(Class T) {
        grid = new Grid<>(T);
        grid.addItemClickListener(this::select);
        add(grid);
        content = new Div();
        add(content);
        buttons = new HorizontalLayout(
                new Button("Отмена", e -> binder.removeBean()), new Button("Сохранить", e -> save())
        );
        add(buttons);
        grid.setItems(repo.findAll());
    }

    public Editor() {
        //  this.repo = repo;
        grid = new Grid();
        grid.addItemClickListener(this::select);
        add(grid);
        content = new Div();
        add(content);
        buttons = new HorizontalLayout(
                new Button("Отмена", e -> binder.removeBean()), new Button("Сохранить", e -> save())
        );
        add(buttons);
        grid.setItems(repo.findAll());
    }

    public void setData(List<T> list) {
        grid.setItems(list);
    }

    protected void select(ItemClickEvent<T> item) {
        binder.setBean(item.getItem());
    }

    protected void save() {
        repo.save(binder.getBean());
    }

    @Bean
    public Editor<T> get(Class<T> type) {
        return new Editor<>(type);
    }

}
