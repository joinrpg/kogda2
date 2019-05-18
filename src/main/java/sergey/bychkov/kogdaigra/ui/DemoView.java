/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.ui;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import sergey.bychkov.kogdaigra.backend.IDataService;
import sergey.bychkov.kogdaigra.model.Game;
import sergey.bychkov.kogdaigra.ui.widget.GameCard;
import sergey.bychkov.kogdaigra.ui.widget.GameList;

/**
 *
 * @author serge
 */
@Route(value = "demo", layout = MainLayout.class)
public class DemoView extends VerticalLayout {

    private final GameList gameList;

    public DemoView(@Autowired IDataService data) {
//        data.getGames(2019).forEach((Game g) -> add(new GameCard((g))));
        gameList = new GameList();
        add(gameList);
        gameList.setGames(data.getGames(2019));
    }
}
