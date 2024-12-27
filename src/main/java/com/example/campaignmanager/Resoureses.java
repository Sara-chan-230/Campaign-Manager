package com.example.campaignmanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Resoureses {

    @FXML
    private Text need_budget;

    @FXML
    private TextField budget;

    @FXML
    private TableColumn<?, ?> need_number;

    @FXML
    private Spinner<?> number_r;

    @FXML
    private TableColumn<?, ?> resource;

    @FXML
    private TableColumn<?, ?> resource_budget;

    @FXML
    private TextField resource_t;

    @FXML
    private Text total_resources;

    @FXML
    void add_new_reource(ActionEvent event) {

    }

}