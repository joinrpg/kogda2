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
@Route(value="photo", layout=MainLayout.class)
public class PhotoView extends FlexLayout{

    public PhotoView() {
        add("Здесь будут фото");
    }
    
    
}
