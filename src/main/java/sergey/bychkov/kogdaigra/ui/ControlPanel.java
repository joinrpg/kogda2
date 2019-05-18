/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.grid.ItemClickEvent;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import sergey.bychkov.kogdaigra.backend.IDataService;
import sergey.bychkov.kogdaigra.model.Game;
import sergey.bychkov.kogdaigra.model.Proposal;

/**
 *
 * @author 16715817
 */
@Secured(value = {"EDIT_GAMES"})
@Route(value = "controlpanel", layout = MainLayout.class)
public class ControlPanel extends VerticalLayout {

    private Grid<Game> grid;

    public ControlPanel(@Autowired IDataService data) {
        grid = new Grid();
        grid.addColumn(new ComponentRenderer<>(game -> {
            Label label;
            if (game.getStatus() != null) {
                label = new Label(game.getStatus().getName());
                statusColor(label, game.getStatus().getName());
            } else {
                label = new Label("");
            }
            return label;
        }));
        grid.addColumn(game -> game.getName()).setHeader("Название");
        grid.addColumn(game -> game.getRegion() == null ? "" : game.getRegion().getName()).setHeader("Регион");
        grid.addColumn(game -> game.getDates()).setHeader("Сроки");
        grid.addColumn(game -> game.getType() == null ? "" : game.getType().getName()).setHeader("Тип игры");
        grid.addColumn(game -> game.getPolygon() == null ? "" : game.getPolygon().getName()).setHeader("Полигон");
        grid.addColumn(game -> game.getQuantity()).setHeader("Игроков");
        grid.addColumn(game -> game.getMg()).setHeader("Мастерская группа");
        grid.addItemClickListener((ItemClickEvent<Game> event) -> getUI().ifPresent((ui) -> {
            ui.navigate("edit/game/" + event.getItem().getId());
        }));
        grid.setThemeName(GridVariant.LUMO_ROW_STRIPES.getVariantName(), true);
        List<Game> unApproved = data.getUnApproved();
        if (unApproved != null) {
            grid.setItems(unApproved);
        }
        add("Неподтвержденные заявки");
        add(grid);
        add("Необработанные анонсы");
        Select<Proposal> select = new Select<>();
        select.setItems(data.getProposals());
        select.setItemLabelGenerator(add -> {
            return add.getUri();
        });
        add(select);
    }

    private void statusColor(Component c, String status) {
        String color;
        switch (status) {
            case "Отложена":
                color = "#00aaaa";
                break;
            case "Отменена":
                color = "#ee1111";
                break;
            case "OK":
                color = "#11ee11";
                break;
            case "Перенесена!":
                color = "#1111ee";
                break;
            case "Прошла":
                color = "#11ee11";
                break;
            default:
                color = "#ccccccc";
                break;
        }
        c.getElement().getStyle().set("color", color);
    }
}
