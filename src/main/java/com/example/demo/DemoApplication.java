package com.example.demo;

import com.vaadin.flow.data.binder.*;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.TextField;
import java.util.List;

@SpringBootApplication
public class DemoApplication extends UI {
    private static final long serialVersionUID = 1L;
    @Autowired
    private HorsesService service;
    private Horses horses;
    private Binder<Horses> binder = new Binder<>(Horses.class);
    private Grid<Horses> grid = new Grid<>(Horses.class);
    private TextField horseName = new TextField("Horse name");
    private TextField microchip = new TextField("Microchip");
    private TextField dateOfBirth = new TextField("Date Of Birth");
    private Button save = new Button("Horse Added!", e -> saveHorse());

    @Override
    protected void init(VaadinRequest request) {
        updateGrid();
        grid.setColumns("Microchip", "Horse Name", "Date Of Birth");
        grid.addSelectionListener(e -> updateForm());
        binder.bindInstanceFields(this);
        VerticalLayout layout = new VerticalLayout();
        setContent(layout);
        layout.add(grid,microchip, horseName, dateOfBirth);
    }

    private void setContent(VerticalLayout layout) {
    }

    private void updateGrid() {
        List<Horses> horses = service.findAll();
        grid.setItems(horses);
        setFormVisible(false);
    }
    private void updateForm() {
        if (grid.asSingleSelect().isEmpty()) {
            setFormVisible(false);
        } else {
            horses = grid.asSingleSelect().getValue();
            binder.setBean(horses);
            setFormVisible(true);
        }
    }
    private void setFormVisible(boolean visible) {
        horseName.setVisible(visible);
        microchip.setVisible(visible);
        dateOfBirth.setVisible(visible);
        save.setVisible(visible);
    }
    private void saveHorse() {
        service.update(horses);
        updateGrid();
    }
}
