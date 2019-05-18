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
public class ByYearView extends MainView implements HasUrlParameter<Integer> {

    private static final Logger LOG = Logger.getLogger(ByYearView.class.getName());

    public ByYearView(@Autowired IDataService arg0) {
        super(arg0);
    }

    @Override
    public void setParameter(BeforeEvent be, Integer prefix) {
        LOG.info(String.valueOf(prefix));

    }
}
