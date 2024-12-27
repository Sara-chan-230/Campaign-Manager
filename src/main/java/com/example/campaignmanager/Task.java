package com.example.campaignmanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Task {

    @FXML
    private ColorPicker task_color;

    @FXML
    private TextField task_text;

    @FXML
    private VBox completedtasks;

    @FXML
    private VBox inProgress_task;

    @FXML
    private Button c_task_title;

    @FXML
    void add_new_task(ActionEvent event) {

    }
    @FXML
    private Button task_title;

    @FXML
    void complete_task(ActionEvent event) {

    }

    @FXML
    void remove_task(ActionEvent event) {

    }


}
