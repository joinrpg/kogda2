/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.ui.widget;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.grid.ItemClickEvent;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.data.provider.CallbackDataProvider;
import com.vaadin.flow.data.provider.ConfigurableFilterDataProvider;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import sergey.bychkov.kogdaigra.model.Game;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author 16715817
 */
public class CalendarGrid extends Grid<Game>  {

    private DataProvider<Game, String> provider;
    private ConfigurableFilterDataProvider<Game, Void, String> wrapper;
    private ArrayList<Game> DATA;

    public CalendarGrid() {
        super();
        this.DATA = new ArrayList<>();

        provider = new CallbackDataProvider<>(
                query -> findFiltred(query.getFilter(),
                        query.getLimit(),
                        query.getOffset()).stream(),
                query -> countFiltred(query.getFilter()));
        //provider=DataProvider.ofCollection(DATA).filteringBySubstring((Game game) -> game.getName());
        wrapper = provider.withConfigurableFilter();
        wrapper.setFilter("");
        setDataProvider(wrapper);
        //addColumn(Game::getStatus).setHeader("Статус");

        addColumn(new ComponentRenderer<>((Game game) -> {
            Label label = new Label(game.getStatus().getName());
            statusColor(label, game.getStatus().getName());
            //  label.setSizeFull();
            return label;
        }));
        addColumn(Game::getName).setHeader("Название");
        addColumn((game) -> game.getRegion().getName()).setHeader("Регион");
        addColumn(Game::getDates).setHeader("Сроки");
        addColumn((game) -> game.getType().getName()).setHeader("Тип игры");
        addColumn((game) -> game.getPolygon().getName()).setHeader("Полигон");
        addColumn(Game::getQuantity).setHeader("Игроков");
        addColumn(Game::getMg).setHeader("Мастерская группа");
        addItemClickListener((ItemClickEvent<Game> event) -> getUI().ifPresent((ui) -> {
            ui.navigate("game/" + event.getItem().getId());
        }));
        setThemeName(GridVariant.LUMO_ROW_STRIPES.getVariantName(), true);
    }


    public void setGames(List<Game> games) {
        DATA = new ArrayList<>(games);
        provider.refreshAll();
    }

    public void setFilter(String value) {
        wrapper.setFilter(value);
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

    private Collection<Game> findFiltred(Optional<String> filterString, long limit, long offset) {
        if (filterString.isPresent()) {
            return filter(filterString).skip(offset).limit(limit).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    private int countFiltred(Optional<String> filterString) {
        if (filterString.isPresent()) {
            return (int) filter(filterString).count();
        }
        return 0;
    }

    private Stream<Game> filter(Optional<String> filterString) {
        return DATA.stream().filter(item -> item.getName().contains(filterString.get()));
    }
}
