/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.ui.widget;

import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.shared.Registration;
import sergey.bychkov.kogdaigra.backend.IDataService;
import sergey.bychkov.kogdaigra.model.Link;
import sergey.bychkov.kogdaigra.model.LinkType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author bychkov-sy
 */
public class Links extends VerticalLayout implements HasValue {

    private Grid<Link> grid;
    private boolean readOnly = true;
    private DataProvider<Link, Link> provider;
    private ArrayList links;
    private IDataService data;
    private Button bAdd;
    private List<ValueChangeListener> listeners;

    public Links(IDataService data) {

        this.data = data;
        listeners = new ArrayList<>();
        HorizontalLayout header = new HorizontalLayout();

        bAdd = new Button(VaadinIcon.PLUS_CIRCLE.create());
        bAdd.addClickListener(event -> addItem(new Link()));
        bAdd.setVisible(false);

        header.add(new Label("Ссылки"), bAdd);
        header.setAlignSelf(Alignment.END, bAdd);
        header.setWidthFull();

        links = new ArrayList<>();

        provider = DataProvider.ofCollection(links);
        build();
        add(header, grid);
    }

    private void build() {
        grid = new Grid<>();
        grid.setDataProvider(provider);
        grid.setThemeName(GridVariant.LUMO_NO_BORDER.getVariantName());
        grid.addColumn(new ComponentRenderer<>(link -> new TextField("",link.getUrl(),"")));
        grid.setHeightByRows(true);
        if (readOnly) {
            grid.addColumn(new ComponentRenderer<>((Link link) -> {
                Label lLinkType = new Label();
                if (link != null && link.getType() != null) {
                    lLinkType.setText(link.getType().getName());
                }
                return lLinkType;
            }));
        } else {
            grid.addColumn(new ComponentRenderer<>((Link link) -> {
                ComboBox cbLinkType = new ComboBox();
                if (data != null) {
                    cbLinkType.setItems(data.getLinkTypes());
                }
                cbLinkType.setItemLabelGenerator(linkType -> ((LinkType) linkType).getName());
                if (link != null && link.getType() != null) {
                    cbLinkType.addValueChangeListener(event -> link.setType((LinkType) event.getOldValue()));
                    cbLinkType.setValue(link.getType());
                }
                return cbLinkType;
            }));

            grid.addColumn(new ComponentRenderer<>(link -> new Button(VaadinIcon.MINUS_CIRCLE.create(), (event) -> {
                removeItem(link);
            })));
        }
    }

    public Links() {
        this(null);
    }

    public void setValue(Collection<Link> value) {
        this.links = new ArrayList<>((List) value);
        grid.setItems(value);
    }

    @Override
    public Collection<Link> getValue() {
        return links;
    }

    @Override
    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
        bAdd.setVisible(!readOnly);
        build();
    }

    @Override
    public boolean isReadOnly() {
        return readOnly;
    }

    private void addItem(Link item) {
        links.add(item);
        grid.setItems(links);
        listeners.forEach(l -> {
            //TODO valueChangeEvent
        });
    }

    private void removeItem(Link item) {
        links.remove(item);
        grid.setItems(links);
    }

    @Override
    public void setRequiredIndicatorVisible(boolean requiredIndicatorVisible) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isRequiredIndicatorVisible() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setValue(Object value) {
        if (value instanceof List) {
            setValue((List<Link>) value);
        }
    }

    @Override
    public Registration addValueChangeListener(ValueChangeListener listener) {
        listeners.add(listener);
        return new Registration() {
            @Override
            public void remove() {
                listeners.remove(listener);
            }
        };
    }

}
