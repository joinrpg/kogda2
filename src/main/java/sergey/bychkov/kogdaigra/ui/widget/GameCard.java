/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.ui.widget;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import sergey.bychkov.kogdaigra.model.Game;

/**
 *
 * @author bychkov-sy
 */
public class GameCard extends FlexLayout {

    private Game game;

    public GameCard(Game game) {
        add(getLabel("ID", game.getId().toString()),
                getLabel("Название", game.getName()),
                getLabel("Статус", game.getStatus().getName()),
                getLabel("Регион", game.getRegion().getName()),
                getLabel("Тип игры", game.getType().getName()),
                getLabel("Полигон", game.getPolygon().getName()),
                getLabel("Даты", game.getDates()),
                getLabel("Количество игроков", game.getQuantity()!= null ? game.getQuantity().toString():""),
                getLabel("Мастерская группа", game.getMg())
        );

        setWidthFull();
        //getElement().getStyle().set("overflow", "auto");
        getElement().getStyle().set("background-color", "#c6d9ec");
        getElement().getStyle().set("box-shadow", " 0 0 10px rgba(0,0,0,0.5)");
        getElement().getStyle().set("display", "flex");
        getElement().getStyle().set("flex-wrap", "wrap");
        getElement().addEventListener("click", (arg0) -> getUI().ifPresent((ui) -> {
            ui.navigate("game/" + game.getId());
        }));
    }

    private Component getLabel(String title, String text) {

        return getLabel(title, text, null);
    }

    private Component getLabel(String title, String text, String status) {

        Div d1 = new Div();
        Label l1 = new Label(title);
        //l1.getStyle().set("font-weight", "lighter");
        l1.getStyle().set("font-size", "80%");
        l1.getStyle().set("margin", "5");
        l1.getStyle().set("padding", "5");
        d1.add(l1);
        Div d2 = new Div();

        Label l2 = new Label(text);
        l2.getStyle().set("font-weight", "bolder");
        l2.getStyle().set("margin", "5");
        l1.getStyle().set("padding", "5");
        d2.getStyle().set("border-radius", "5px");
        d2.add(l2);
        if (status != null) {
            statusColor(d2, status);
        }
        d1.add(d2);
        // d1.getStyle().set("max-width", "100%");
        // d1.getStyle().set("min-width", "100%");
        d1.getStyle().set("margin", "5");
        d1.getStyle().set("padding", "5");
        d1.getStyle().set("border-radius", "5px");
        d1.getStyle().set("display", "flex");
        d1.getStyle().set("flex-direction", "column");
        d1.getStyle().set("width", "var(--vaadin-text-field-default-width, 12em)");
        return d1;
    }

    private void statusColor(Component c, String status) {
        String color;
        switch (status) {
            case "Отложена":
                color = "#99ccff";
                break;
            case "Отменена":
                color = "#ff9999";
                break;
            case "OK":
                color = "#99ffbb";
                break;
            case "Перенесена!":
                color = "#ffff99";
                break;
            case "Прошла":
                color = "#99ffbb";
                break;
            default:
                color = "#ccccccc";
                break;
        }
        c.getElement().getStyle().set("background-color", color);
    }

}
