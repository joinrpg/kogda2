/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.ui;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.converter.LocalDateToDateConverter;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.data.converter.StringToLongConverter;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.WildcardParameter;
import org.springframework.beans.factory.annotation.Autowired;
import sergey.bychkov.kogdaigra.backend.IDataService;
import sergey.bychkov.kogdaigra.model.*;
import sergey.bychkov.kogdaigra.ui.widget.GoHome;
import sergey.bychkov.kogdaigra.ui.widget.Links;

import java.util.ArrayList;

/**
 * @author bychkov-sy
 */
@Route(value = "game",layout = MainLayout.class)
public class GameView extends VerticalLayout implements HasUrlParameter<String> {

    private HorizontalLayout buttons;
    private final Binder<Game> binder;
    private boolean readOnly = true;
    @Autowired
    private IDataService data;
    private Links links;
    private ComboBox<GameType> cbType;
    private ComboBox<Polygon> cbPolygon;
    private ComboBox<Region> cbRegion;
    private ComboBox<GameStatus> cbStatus;

    @Override
    public void setParameter(BeforeEvent be, @WildcardParameter String game) {
        setReadOnly(!game.endsWith("/edt"));
        updateComboBox();
        bindForm(game.split("/")[0]);
    }

    public GameView() {
        removeAll();
        binder = new Binder<>(Game.class);
        buildUi();
    }

    private void buildUi() {

        FormLayout form = new FormLayout();
        TextField tfId = new TextField("ID");
        tfId.setEnabled(false);
        TextField tfName = new TextField("Название");
        cbStatus = new ComboBox<>("Статус");
        cbStatus.setItemLabelGenerator(GameStatus::getName);
        cbRegion = new ComboBox<>("Регион");
        cbRegion.setItemLabelGenerator(Region::getName);
        cbType = new ComboBox<>("Тип игры");
        cbType.setItemLabelGenerator(GameType::getName);
        cbPolygon = new ComboBox<>("Полигон");
        cbPolygon.setItemLabelGenerator(Polygon::getName);
        DatePicker dpStartDate = new DatePicker("Дата начала");
        DatePicker dpEndDate = new DatePicker("Дата окончания");
        TextField tfQuantity = new TextField("Количество игроков");
        TextField tfEmail = new TextField("E-Mail");
        TextArea taMg = new TextArea("Мастерская группа");
        links=new Links(data);
        ListBox<String> lbComments = new ListBox<>();
        binder.forField(tfId).withConverter(new StringToLongConverter("Должно быть числом")).withNullRepresentation(0L).bind("id");
        binder.bind(tfName, "name");
        binder.bind(tfEmail, "email");
        binder.forField(cbStatus).bind(Game::getStatus, Game::setStatus);
        binder.bind(cbRegion, Game::getRegion, Game::setRegion);
        binder.bind(cbType, Game::getType, Game::setType);
        binder.bind(cbPolygon, Game::getPolygon, Game::setPolygon);
        binder.forField(dpStartDate).withConverter(new LocalDateToDateConverter()).bind("start");
        binder.forField(dpEndDate).withConverter(new LocalDateToDateConverter()).bind("end");
        binder.forField(tfQuantity).withConverter(new StringToIntegerConverter("Должно быть числом")).withNullRepresentation(0).bind(Game::getQuantity, Game::setQuantity);
        binder.bind(taMg, "mg");
        binder.forField(links).withNullRepresentation(new ArrayList<>()).bind("links");
        //binder.forField(lbComments).withNullRepresentation("").bind("comments");
        form.add(tfId, tfName, tfEmail, cbType, cbStatus, cbRegion, cbPolygon, tfQuantity,
                taMg, dpStartDate, dpEndDate);
        


        buttons = new HorizontalLayout();
        buttons.setVisible(false);
        buttons.add(new Button("Очистить", event -> binder.removeBean()));
        buttons.add(new Button("Сохранить", event -> {
            data.saveGame(binder.getBean());
            go();
        }));

        links = new Links(data);
        links.setReadOnly(readOnly);
        binder.bind(links, game -> game.getLinks(), (game, list) -> game.setLinks(list));
        add(GoHome.get(), form, links,lbComments);
    }

    private void bindForm(String game) {
        binder.setBean(data.getGame(game));
        binder.setReadOnly(isReadOnly());

    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
        if (!readOnly && buttons != null) {
            buttons.setVisible(true);
        }
    }

    private void updateComboBox() {
        cbType.setItems(data.getTypes());
        cbStatus.setItems(data.getStatuses());
        cbRegion.setItems(data.getRegions());
        cbPolygon.setItems(data.getPolygons());
    }

    private void go() {
        UI.getCurrent().navigate("");
    }
}
