package sergey.bychkov.kogdaigra.ui.widget;

import com.vaadin.flow.component.Component;
import sergey.bychkov.kogdaigra.model.Game;

import java.util.List;

public abstract class IGamesList extends Component {
    abstract void setGames(List<Game> games);

    void setFilter(String value) {

    }
}
