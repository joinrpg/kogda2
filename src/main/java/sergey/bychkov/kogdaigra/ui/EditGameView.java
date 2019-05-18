package sergey.bychkov.kogdaigra.ui;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.combobox.GeneratedVaadinComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
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

@Route(value = "edit/game", layout = MainLayout.class)
public class EditGameView extends VerticalLayout implements HasUrlParameter<String> {

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
    public void setParameter(BeforeEvent event, @WildcardParameter String game) {
        updateComboBox();
        bindForm(game.split("/")[0]);
    }

    public EditGameView() {
        removeAll();
        binder = new Binder<>(Game.class);
        buildUi();
    }

    private void bindForm(String gameId) {
        Game game = data.getGame(gameId);
        binder.setBean(game);
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

    private void buildUi() {

        FlexLayout sendNew = new FlexLayout();
        TextField announceUrl = new TextField("Анонс игры");
        Button bSend = new Button("Отправить", (event) -> {

            Proposal newGame = new Proposal(announceUrl.getValue(), null, false);
            data.saveProposal(newGame);
            go();
        });
        sendNew.add(announceUrl, bSend);

        FormLayout form = new FormLayout();
        TextField tfId = new TextField("ID");
        tfId.setEnabled(false);
        TextField tfName = new TextField("Название");
        cbStatus = new ComboBox<>("Статус");
        cbStatus.setItemLabelGenerator(GameStatus::getName);
        cbRegion = new ComboBox<>("Регион");
        cbRegion.addCustomValueSetListener((GeneratedVaadinComboBox.CustomValueSetEvent<ComboBox<Region>> event) -> {
            GeneratedVaadinComboBox.CustomValueSetEvent<ComboBox<Region>> e = event;
            String detail = e.getDetail();

        });
        cbRegion.addValueChangeListener((e) -> {
            Region value = e.getValue();
            cbPolygon.setItems(data.getPolygons(value));
        });
        cbRegion.setItemLabelGenerator(Region::getName);
        cbType = new ComboBox<>("Тип игры");
        cbType.setItemLabelGenerator(GameType::getName);
        cbPolygon = new ComboBox<>("Полигон");
        cbPolygon.setItemLabelGenerator(Polygon::getName);
        cbPolygon.setAllowCustomValue(true);
        DatePicker dpStartDate = new DatePicker("Дата начала");
        DatePicker dpEndDate = new DatePicker("Дата окончания");
        TextField tfQuantity = new TextField("Количество игроков");
        TextField tfEmail = new TextField("E-Mail");
        TextArea taMg = new TextArea("Мастерская группа");

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
        form.add(tfId, tfName, tfEmail, cbType, cbStatus, cbRegion, cbPolygon, tfQuantity,
                taMg, dpStartDate, dpEndDate);

        ListBox<Comment> lbComments = new ListBox<>();

        buttons = new HorizontalLayout();
        buttons.setVisible(false);
        buttons.add(new Button("Очистить", event -> binder.removeBean()));
        buttons.add(new Button("Сохранить", event -> {
            data.saveGame(binder.getBean());
            go();
        }));

        links = new Links(data);
        binder.bind(links, game -> game.getLinks(), (game, list) -> game.setLinks(list));

        add(GoHome.get(),
                sendNew,
                form,
                links,
                new VerticalLayout(new Text("Комментарии"), lbComments),
                buttons);
    }
}
