package sergey.bychkov.kogdaigra.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import sergey.bychkov.kogdaigra.backend.IDataService;

import java.util.Objects;
import java.util.logging.Logger;
import sergey.bychkov.kogdaigra.ui.widget.GameList;

import static sergey.bychkov.kogdaigra.util.Util.getCurrentYear;

/**
 * The main view contains a button and a click listener.
 */
@Route(value = "", layout = MainLayout.class)
public class MainView extends VerticalLayout  {

    private Div header;
    protected GameList gameList;
    private final IDataService data;
    private Tabs yearTabs;
    private static final Logger LOG = Logger.getLogger(MainView.class.getName());

    public MainView(@Autowired IDataService data) {

        this.data = data;
        add(header());
        add(getGrid(getCurrentYear()));
        setSizeFull();
    }

    

    private Component header() {
        header = new Div();

        yearTabs = new Tabs();

        data.getYears().stream().filter(Objects::nonNull).sorted().forEach(y -> {
            Tab tab = new Tab(y.toString());
            yearTabs.add(tab);
            if (Objects.equals(y, getCurrentYear())) {
                yearTabs.setSelectedTab(tab);
            }
        });
        yearTabs.addSelectedChangeListener(event -> setYear(Integer.parseInt(yearTabs.getSelectedTab().getLabel())));
        header.add(yearTabs);
        header.setWidthFull();
        return header;
    }

    private Component getGrid(Integer year) {

        gameList = new GameList();
        gameList.addSearchListener(text -> {
            if (text != null && text.toString().length() > 2) {
                gameList.setGames(data.getGamesNameLike(text.toString()));
            } else {
                setYear(Integer.parseInt(yearTabs.getSelectedTab().getLabel()));
            }
        });
        setYear(year);
        return gameList;
    }

    private void setYear(Integer year) {

        gameList.setGames(data.getGames(year));
    }

    
}
