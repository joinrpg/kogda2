/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.ui;

import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.Route;

/**
 *
 * @author serge
 */
@Route(value="review",layout=MainLayout.class)
public class ReviewView extends FlexLayout {

    public ReviewView() {
        add("Отзывы, рецензии и т.д.");
    }

}
