package sergey.bychkov.kogdaigra.ui;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the game-card template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("game-card")
@HtmlImport("src/game-card.html")
public class GameCard extends PolymerTemplate<GameCard.GameCardModel> {

    /**
     * Creates a new GameCard.
     */
    public GameCard() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between GameCard and game-card
     */
    public interface GameCardModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
