/*
 * Copyright 2000-2017 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package sergey.bychkov.kogdaigra.ui.widget;

import java.util.List;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.polymertemplate.EventHandler;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.ModelItem;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.templatemodel.Encode;
import com.vaadin.flow.templatemodel.Exclude;
import com.vaadin.flow.templatemodel.TemplateModel;
import java.util.ArrayList;
import java.util.function.Consumer;
import sergey.bychkov.kogdaigra.model.Game;
import sergey.bychkov.kogdaigra.util.DateToStringEncoder;
import sergey.bychkov.kogdaigra.util.LongToStringEncoder;

/**
 * Displays the list of available categories, with a search filter as well as
 * buttons to add a new category or edit existing ones.
 *
 * Implemented using a simple template.
 */
@Tag("game-list")
@HtmlImport("frontend://src/game-list.html")
public class GameList extends PolymerTemplate<GameList.GameListModel> {

    private List<Consumer> searchListeners;

    public void setGames(List<Game> games) {

        getModel().setGames(games);
    }

    public interface GameListModel extends TemplateModel {

        @Encode(value = LongToStringEncoder.class, path = "id")
        @Encode(value = LongToStringEncoder.class, path = "allRpgId")
        @Encode(value = DateToStringEncoder.class, path = "start")
        @Encode(value = DateToStringEncoder.class, path = "end")
        @Encode(value = LongToStringEncoder.class, path = "type.id")
        @Encode(value = LongToStringEncoder.class, path = "status.id")
        @Encode(value = LongToStringEncoder.class, path = "polygon.id")
        @Encode(value = LongToStringEncoder.class, path = "region.id")
        @Exclude(value = {"region.parent", "polygon.region", "links", "comments"})
        void setGames(List<Game> games);
    }

    @Id("search")
    private TextField search;
    @Id("newGame")
    private Button addGame;
    @Id("header")
    private H2 header;

    public GameList() {

        search.setPlaceholder("Поиск игр");
        search.addValueChangeListener(e -> {
            searchListeners.forEach(l -> {
                l.accept(e.getValue());
            });
        });
        search.setValueChangeMode(ValueChangeMode.EAGER);
        search.addFocusShortcut(Key.KEY_F, KeyModifier.CONTROL);

        addGame.addClickListener(e -> UI.getCurrent().navigate("edit/game"));
        /*
            This is a fall-back method:
            '+' is not a event.code (DOM events), so as a fall-back shortcuts
            will perform a character-based comparison. Since Key.ADD changes
            locations frequently based on the keyboard layout's language, we
            opted to use a character instead.
         */
        addGame.addClickShortcut(Key.of("+"));
        searchListeners = new ArrayList();

        getElement().setProperty("addButtonText", "Добавить игру");
        getElement().setProperty("editButtonText", "Редактировать");

    }

    public void addSearchListener(Consumer listener) {
        searchListeners.add(listener);
    }

    /*public void setDataService(IDataService ds) {
        data = ds;
    }*/
    @EventHandler
    private void edit(@ModelItem Game game) {
        UI.getCurrent().navigate("edit/game/" + game.getId());
    }

    @EventHandler
    private void show(@ModelItem Game game) {
        UI.getCurrent().navigate("game/" + game.getId());
    }
}
