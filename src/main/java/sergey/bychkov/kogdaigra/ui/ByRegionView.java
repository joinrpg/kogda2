/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.ui;

import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import sergey.bychkov.kogdaigra.backend.IDataService;

/**
 *
 * @author serge
 */



public class ByRegionView extends MainView implements HasUrlParameter<String> {

    private static final Logger LOG = Logger.getLogger(ByRegionView.class.getName());

    public ByRegionView(@Autowired IDataService arg0) {
        super(arg0);
    }


    @Override
    public void setParameter(BeforeEvent be, String prefix) {
        LOG.info(prefix);
        
    }
}
